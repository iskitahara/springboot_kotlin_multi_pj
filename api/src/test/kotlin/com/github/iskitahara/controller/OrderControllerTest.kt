package com.github.iskitahara.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import com.github.iskitahara.application.service.OrderService
import com.github.iskitahara.domain.model.order.Order
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.NestedTestConfiguration
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.nio.charset.StandardCharsets

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@NestedTestConfiguration(NestedTestConfiguration.EnclosingConfiguration.OVERRIDE)
class OrderControllerTest {

    private val orderService = mock<OrderService>()
    private val orderController = OrderController(orderService)

    @Nested
    @DisplayName("orderテスト")
    inner class LoadOrderApiTest {

        @Test
        fun `getOrder is success`() {
            val orderId = 1L
            val resultStr = Order(1, "title", 1, "2021-01-01")
            whenever(orderService.getDetail(orderId)).thenReturn(resultStr)

            // TODO　レスポンスをjsonにしないと意味ないけどひとまず。
            val expected = Order(1, "title", 1, "2021-01-01").toString()
//            val expected = ObjectMapper().registerKotlinModule().writeValueAsString(expectedOrder)
            val mockMvc = MockMvcBuilders.standaloneSetup(orderController).build()
            val resultResponse = mockMvc.perform(get("/orders/1")).andExpect(status().isOk).andReturn().response
            val result = resultResponse.getContentAsString(StandardCharsets.UTF_8)

            Assertions.assertThat(expected).isEqualTo(result)
        }

        @Test
        fun `getOrder 不一致の動作確認用`() {
            val orderId = 0L
            val resultOrder = Order(0, "title", 0, "2021-01-01")

            whenever(orderService.getDetail(orderId)).thenReturn(resultOrder)

            val expectedOrder = Order(1, "title", 1, "2021-01-01")
            val expected = ObjectMapper().registerKotlinModule().writeValueAsString(expectedOrder)
            val mockMvc = MockMvcBuilders.standaloneSetup(orderController).build()
            val resultResponse = mockMvc.perform(get("/orders/0")).andExpect(status().isOk).andReturn().response
            val result = resultResponse.getContentAsString(StandardCharsets.UTF_8)

//            Assertions.assertThat(expected).isNotEqualTo(result)
            Assertions.assertThat(expected).isEqualTo(result)
        }
    }
}