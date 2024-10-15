package ru.gb.android.marketsample.clean.data

import ru.gb.android.marketsample.clean.data.models.ProductDto

class ProductRemoteDataSource(
    private val productApiService: ProductApiService,
) {
    suspend fun getProducts(): List<ProductDto> {
        return productApiService.getProducts()
    }
}
