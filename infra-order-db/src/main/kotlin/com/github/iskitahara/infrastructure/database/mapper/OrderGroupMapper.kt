/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.github.iskitahara.infrastructure.database.mapper

import com.github.iskitahara.infrastructure.database.record.OrderGroupRecord
import org.apache.ibatis.annotations.DeleteProvider
import org.apache.ibatis.annotations.InsertProvider
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.annotations.UpdateProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter

@Mapper
interface OrderGroupMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    fun count(selectStatement: SelectStatementProvider): Long

    @DeleteProvider(type=SqlProviderAdapter::class, method="delete")
    fun delete(deleteStatement: DeleteStatementProvider): Int

    @InsertProvider(type=SqlProviderAdapter::class, method="insert")
    fun insert(insertStatement: InsertStatementProvider<OrderGroupRecord>): Int

    @InsertProvider(type=SqlProviderAdapter::class, method="insertMultiple")
    fun insertMultiple(multipleInsertStatement: MultiRowInsertStatementProvider<OrderGroupRecord>): Int

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("OrderGroupRecordResult")
    fun selectOne(selectStatement: SelectStatementProvider): OrderGroupRecord?

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="OrderGroupRecordResult", value = [
        Result(column="customer_id", property="customerId", jdbcType=JdbcType.BIGINT, id=true),
        Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
        Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<OrderGroupRecord>

    @UpdateProvider(type=SqlProviderAdapter::class, method="update")
    fun update(updateStatement: UpdateStatementProvider): Int
}