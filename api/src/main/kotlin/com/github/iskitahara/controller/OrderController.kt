package com.github.iskitahara.controller

import com.github.iskitahara.application.service.OrderService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("orders")
class OrderController (
    private val orderService: OrderService
){
    @GetMapping("/{id}")
    fun getOrder(@PathVariable("id") id: Long): String? {
        var order = orderService.getDetail(id)
        return order.toString()
    }

    @GetMapping("/list")
    fun list(): String? {
        val orderList = orderService.getList()
        return orderList.toString()
    }
}