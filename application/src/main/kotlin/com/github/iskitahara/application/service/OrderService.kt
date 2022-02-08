package com.github.iskitahara.application.service

import com.github.iskitahara.domain.repository.order.OrderRepository
import com.github.iskitahara.domain.model.order.Order
import org.springframework.stereotype.Service
@Service
class OrderService(
    private val orderRepository: OrderRepository
) {
    fun getList(): List<Order> {
        return orderRepository.findAll()
    }

    fun getDetail(orderId: Long): Order {
        return orderRepository.find(orderId) ?: throw IllegalArgumentException("存在しないOrderID: $orderId")
    }
}