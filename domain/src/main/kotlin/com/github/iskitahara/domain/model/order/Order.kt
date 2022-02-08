package com.github.iskitahara.domain.model.order

data class Order(
    val id: Long,
    val itemId: String,
    val price: Long,
    val releaseDate: String
)