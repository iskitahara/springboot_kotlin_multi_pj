package com.github.iskitahara.infrastructure.database.repository

import com.github.iskitahara.domain.model.order.Order
import com.github.iskitahara.domain.repository.order.OrderRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class OrderRepositoryImpl(
//    private val bookWithRentalMapper: OrderWithRentalMapper,
//    private val orderMapper: CartMapper
) : OrderRepository {
    override fun findAll(): List<Order> {
        return listOf<Order>(Order(1, "title", 1,"2021-01-01"))
//        return orderMapper.select().map { toModel(it) }
    }

    override fun find(id: Long): Order? {
//        return orderMapper.selectByPrimaryKey(id)?.let { toModel(it) }
        return Order(1, "title", 1,"2021-01-01")
    }

//    override fun register(order: Order) {
//        orderMapper.insert(toRecord(book))
//    }
//
//    override fun update(id: Long, itemId: String?, price: Long?, releaseDate: LocalDate?) {
//    override fun update(id: Long, title: String?, author: String?, releaseDate: LocalDate?) {
//        bookMapper.updateByPrimaryKeySelective(BookRecord(id, title, author, releaseDate))
//    }
//
//    override fun delete(id: Long) {
//        orderMapper.deleteByPrimaryKey(id)
//    }
//
//    private fun toModel(record: CartRecord): Order {
//        val book = Book(
//            record.id!!,
//            record.title!!,
//            record.author!!,
//            record.releaseDate!!
//        )
//        val rental = record.userId?.let {
//            Rental(
//                record.id!!,
//                record.userId!!,
//                record.rentalDatetime!!,
//                record.returnDeadline!!
//            )
//        }
//        return BookWithRental(book, rental)
//        return Order(record.customerId!!, "title", 1, "2021-01-01")
//    }
//
//    private fun toRecord(model: Book): BookRecord {
//        return BookRecord(model.id, model.title, model.author, model.releaseDate)
//    }
}