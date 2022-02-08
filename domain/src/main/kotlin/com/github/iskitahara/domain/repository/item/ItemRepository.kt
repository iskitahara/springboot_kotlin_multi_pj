package com.github.iskitahara.domain.repository.item

import com.github.iskitahara.domain.model.item.Item

interface ItemRepository {
    fun getItemDetail(id: String): Item
}