package ru.gb.android.marketsample.clean.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.gb.android.marketsample.databinding.FragmentProductsBinding
import ru.gb.android.marketsample.clean.presentation.viewmodels.ProductsViewModel
import ru.gb.android.marketsample.clean.presentation.adapter.ProductsAdapter

class ProductsFragment : Fragment() {

    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!

    private val adapter = ProductsAdapter()
    private val viewModel: ProductsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        subscribeUI()

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.refresh()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun subscribeUI() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.items.collect { items ->
                        adapter.submitList(items)
                    }
                }

                launch {
                    viewModel.isError.collect { isError ->
                        if (isError) Toast.makeText(requireContext(), "Ошибка загрузки данных", Toast.LENGTH_SHORT).show()
                    }
                }

                launch {
                    viewModel.isLoading.collect { isLoading ->
                        if (isLoading) showLoading() else showList()
                    }
                }
            }
        }
    }

    private fun showLoading() {
        hideAll()
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun showList() {
        hideAll()
        binding.recyclerView.visibility = View.VISIBLE
    }

    private fun hideAll() {
        binding.recyclerView.visibility = View.GONE
        binding.progressBar.visibility = View.GONE
    }
}