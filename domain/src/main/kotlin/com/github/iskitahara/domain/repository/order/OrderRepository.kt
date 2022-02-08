package com.github.iskitahara.domain.repository.order

import com.github.iskitahara.domain.model.order.Order
import java.time.LocalDate

interface OrderRepository {
    fun findAll(): List<Order>
    fun find(id: Long): Order?
//    fun register(order: Order)
//    fun update(id: Long, itemId: String?, price: Long?, releaseDate: LocalDate?)
//    fun delete(id: Long)
}