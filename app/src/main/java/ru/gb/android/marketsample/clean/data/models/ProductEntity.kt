package ru.gb.android.marketsample.clean.data.models

import kotlinx.serialization.Serializable

@Serializable
class ProductEntity (
    val id: String,
    val name: String,
    val image: String,
    val price: Double,
)