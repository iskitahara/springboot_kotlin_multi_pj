/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.github.iskitahara.infrastructure.database.mapper

import com.github.iskitahara.infrastructure.database.mapper.OrderGroupDynamicSqlSupport.OrderGroup
import com.github.iskitahara.infrastructure.database.mapper.OrderGroupDynamicSqlSupport.OrderGroup.createDate
import com.github.iskitahara.infrastructure.database.mapper.OrderGroupDynamicSqlSupport.OrderGroup.customerId
import com.github.iskitahara.infrastructure.database.mapper.OrderGroupDynamicSqlSupport.OrderGroup.id
import com.github.iskitahara.infrastructure.database.record.OrderGroupRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun OrderGroupMapper.count(completer: CountCompleter) =
    countFrom(this::count, OrderGroup, completer)

fun OrderGroupMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, OrderGroup, completer)

fun OrderGroupMapper.deleteByPrimaryKey(customerId_: Long) =
    delete {
        where(customerId, isEqualTo(customerId_))
    }

fun OrderGroupMapper.insert(record: OrderGroupRecord) =
    insert(this::insert, record, OrderGroup) {
        map(customerId).toProperty("customerId")
        map(id).toProperty("id")
        map(createDate).toProperty("createDate")
    }

fun OrderGroupMapper.insertMultiple(records: Collection<OrderGroupRecord>) =
    insertMultiple(this::insertMultiple, records, OrderGroup) {
        map(customerId).toProperty("customerId")
        map(id).toProperty("id")
        map(createDate).toProperty("createDate")
    }

fun OrderGroupMapper.insertMultiple(vararg records: OrderGroupRecord) =
    insertMultiple(records.toList())

fun OrderGroupMapper.insertSelective(record: OrderGroupRecord) =
    insert(this::insert, record, OrderGroup) {
        map(customerId).toPropertyWhenPresent("customerId", record::customerId)
        map(id).toPropertyWhenPresent("id", record::id)
        map(createDate).toPropertyWhenPresent("createDate", record::createDate)
    }

private val columnList = listOf(customerId, id, createDate)

fun OrderGroupMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, OrderGroup, completer)

fun OrderGroupMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, OrderGroup, completer)

fun OrderGroupMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, OrderGroup, completer)

fun OrderGroupMapper.selectByPrimaryKey(customerId_: Long) =
    selectOne {
        where(customerId, isEqualTo(customerId_))
    }

fun OrderGroupMapper.update(completer: UpdateCompleter) =
    update(this::update, OrderGroup, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: OrderGroupRecord) =
    apply {
        set(customerId).equalTo(record::customerId)
        set(id).equalTo(record::id)
        set(createDate).equalTo(record::createDate)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: OrderGroupRecord) =
    apply {
        set(customerId).equalToWhenPresent(record::customerId)
        set(id).equalToWhenPresent(record::id)
        set(createDate).equalToWhenPresent(record::createDate)
    }

fun OrderGroupMapper.updateByPrimaryKey(record: OrderGroupRecord) =
    update {
        set(id).equalTo(record::id)
        set(createDate).equalTo(record::createDate)
        where(customerId, isEqualTo(record::customerId))
    }

fun OrderGroupMapper.updateByPrimaryKeySelective(record: OrderGroupRecord) =
    update {
        set(id).equalToWhenPresent(record::id)
        set(createDate).equalToWhenPresent(record::createDate)
        where(customerId, isEqualTo(record::customerId))
    }