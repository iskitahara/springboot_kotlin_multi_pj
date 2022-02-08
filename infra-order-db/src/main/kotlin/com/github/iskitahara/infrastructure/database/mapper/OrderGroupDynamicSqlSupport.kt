/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.github.iskitahara.infrastructure.database.mapper

import java.sql.JDBCType
import java.time.LocalDate
import org.mybatis.dynamic.sql.SqlTable

object OrderGroupDynamicSqlSupport {
    object OrderGroup : SqlTable("order_group") {
        val customerId = column<Long>("customer_id", JDBCType.BIGINT)

        val id = column<Long>("id", JDBCType.BIGINT)

        val createDate = column<LocalDate>("create_date", JDBCType.DATE)
    }
}