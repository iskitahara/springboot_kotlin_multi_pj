package com.github.iskitahara.application.service

import com.github.iskitahara.domain.model.order.Order
import com.github.iskitahara.domain.repository.order.OrderRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.NestedTestConfiguration

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@NestedTestConfiguration(NestedTestConfiguration.EnclosingConfiguration.OVERRIDE)
internal class OrderServiceTest {
    private val orderRepository = mock<OrderRepository>()

    private val orderService = OrderService(orderRepository)

    @Nested
    @DisplayName("order serviceテスト")
    inner class LoadOrderApiTest {
        @Test
        fun `getList when book list is exist then return list`() {
            val order = Order(1, "title", 1,"2021-01-01")
            val expected = order

            whenever(orderRepository.find(1L)).thenReturn(expected)

            val result = orderService.getDetail(1L)
            Assertions.assertThat(expected).isEqualTo(result)
        }
    }
}