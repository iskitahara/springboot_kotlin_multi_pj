/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.github.iskitahara.infrastructure.database.mapper

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object OrderItemDynamicSqlSupport {
    object OrderItem : SqlTable("order_item") {
        val id = column<Long>("id", JDBCType.BIGINT)

        val orderGroupId = column<Long>("order_group_id", JDBCType.BIGINT)

        val itemId = column<String>("item_id", JDBCType.VARCHAR)

        val itemCount = column<Long>("item_count", JDBCType.BIGINT)
    }
}