package ru.gb.android.marketsample.clean.data

import retrofit2.http.GET
import ru.gb.android.marketsample.clean.data.models.ProductDto

interface ProductApiService {
    @GET("test_api_products.json")
    suspend fun getProducts(): List<ProductDto>
}