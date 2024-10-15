package ru.gb.android.marketsample.clean.domain.mappers

import ru.gb.android.marketsample.clean.data.models.ProductEntity
import ru.gb.android.marketsample.clean.domain.models.Product

class ProductDomainMapper {
    fun fromEntity(productEntity: ProductEntity): Product {
        return Product(
            id = productEntity.id,
            name = productEntity.name,
            image = productEntity.image,
            price = productEntity.price,
        )
    }

    fun toEntity(product: Product): ProductEntity {
        return ProductEntity(
            id = product.id,
            name = product.name,
            image = product.image,
            price = product.price,
        )
    }
}