/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.github.iskitahara.infrastructure.database.mapper

import com.github.iskitahara.infrastructure.database.mapper.OrderItemDynamicSqlSupport.OrderItem
import com.github.iskitahara.infrastructure.database.mapper.OrderItemDynamicSqlSupport.OrderItem.id
import com.github.iskitahara.infrastructure.database.mapper.OrderItemDynamicSqlSupport.OrderItem.itemCount
import com.github.iskitahara.infrastructure.database.mapper.OrderItemDynamicSqlSupport.OrderItem.itemId
import com.github.iskitahara.infrastructure.database.mapper.OrderItemDynamicSqlSupport.OrderItem.orderGroupId
import com.github.iskitahara.infrastructure.database.record.OrderItemRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun OrderItemMapper.count(completer: CountCompleter) =
    countFrom(this::count, OrderItem, completer)

fun OrderItemMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, OrderItem, completer)

fun OrderItemMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun OrderItemMapper.insert(record: OrderItemRecord) =
    insert(this::insert, record, OrderItem) {
        map(id).toProperty("id")
        map(orderGroupId).toProperty("orderGroupId")
        map(itemId).toProperty("itemId")
        map(itemCount).toProperty("itemCount")
    }

fun OrderItemMapper.insertMultiple(records: Collection<OrderItemRecord>) =
    insertMultiple(this::insertMultiple, records, OrderItem) {
        map(id).toProperty("id")
        map(orderGroupId).toProperty("orderGroupId")
        map(itemId).toProperty("itemId")
        map(itemCount).toProperty("itemCount")
    }

fun OrderItemMapper.insertMultiple(vararg records: OrderItemRecord) =
    insertMultiple(records.toList())

fun OrderItemMapper.insertSelective(record: OrderItemRecord) =
    insert(this::insert, record, OrderItem) {
        map(id).toPropertyWhenPresent("id", record::id)
        map(orderGroupId).toPropertyWhenPresent("orderGroupId", record::orderGroupId)
        map(itemId).toPropertyWhenPresent("itemId", record::itemId)
        map(itemCount).toPropertyWhenPresent("itemCount", record::itemCount)
    }

private val columnList = listOf(id, orderGroupId, itemId, itemCount)

fun OrderItemMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, OrderItem, completer)

fun OrderItemMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, OrderItem, completer)

fun OrderItemMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, OrderItem, completer)

fun OrderItemMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun OrderItemMapper.update(completer: UpdateCompleter) =
    update(this::update, OrderItem, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: OrderItemRecord) =
    apply {
        set(id).equalTo(record::id)
        set(orderGroupId).equalTo(record::orderGroupId)
        set(itemId).equalTo(record::itemId)
        set(itemCount).equalTo(record::itemCount)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: OrderItemRecord) =
    apply {
        set(id).equalToWhenPresent(record::id)
        set(orderGroupId).equalToWhenPresent(record::orderGroupId)
        set(itemId).equalToWhenPresent(record::itemId)
        set(itemCount).equalToWhenPresent(record::itemCount)
    }

fun OrderItemMapper.updateByPrimaryKey(record: OrderItemRecord) =
    update {
        set(orderGroupId).equalTo(record::orderGroupId)
        set(itemId).equalTo(record::itemId)
        set(itemCount).equalTo(record::itemCount)
        where(id, isEqualTo(record::id))
    }

fun OrderItemMapper.updateByPrimaryKeySelective(record: OrderItemRecord) =
    update {
        set(orderGroupId).equalToWhenPresent(record::orderGroupId)
        set(itemId).equalToWhenPresent(record::itemId)
        set(itemCount).equalToWhenPresent(record::itemCount)
        where(id, isEqualTo(record::id))
    }