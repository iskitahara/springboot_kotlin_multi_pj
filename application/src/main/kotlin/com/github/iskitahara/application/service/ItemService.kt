package com.github.iskitahara.application.service

import com.github.iskitahara.domain.model.item.Item
import com.github.iskitahara.domain.repository.item.ItemRepository
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val itemRepository: ItemRepository
) {
    fun getItemDetail(id: String): Item {
        return itemRepository.getItemDetail(id)
    }
}