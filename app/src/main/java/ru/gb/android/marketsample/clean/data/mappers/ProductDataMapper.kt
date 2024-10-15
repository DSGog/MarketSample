package ru.gb.android.marketsample.clean.data.mappers

import ru.gb.android.marketsample.clean.data.models.ProductDto
import ru.gb.android.marketsample.clean.data.models.ProductEntity

class ProductDataMapper {
    fun toEntity(productDto: ProductDto): ProductEntity {
        return ProductEntity(
            id = productDto.id,
            name = productDto.name,
            image = productDto.image,
            price = productDto.price
        )
    }

    fun fromEntity(productEntity: ProductEntity): ProductDto {
        return ProductDto(
            id = productEntity.id,
            name = productEntity.name,
            image = productEntity.image,
            price = productEntity.price
        )
    }
}