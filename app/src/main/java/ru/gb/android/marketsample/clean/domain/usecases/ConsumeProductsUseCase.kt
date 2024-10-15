package ru.gb.android.marketsample.clean.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.gb.android.marketsample.clean.domain.models.Product
import ru.gb.android.marketsample.clean.data.repositories.ProductRepository
import ru.gb.android.marketsample.clean.domain.mappers.ProductDomainMapper


class ConsumeProductsUseCase(
    private val productRepository: ProductRepository,
    private val productDomainMapper: ProductDomainMapper,
) {
    operator fun invoke(): Flow<List<Product>> {
        return productRepository.consumeProducts()
            .map { products -> products.map(productDomainMapper::fromEntity) }
    }
}