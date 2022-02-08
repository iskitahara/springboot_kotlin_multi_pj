package com.github.iskitahara.infrastructure.item.repository

import com.github.iskitahara.domain.model.item.Item
import com.github.iskitahara.domain.repository.item.ItemRepository
import org.springframework.stereotype.Component
import org.springframework.boot.web.client.RestTemplateBuilder

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Component
class ItemRepositoryImpl(
        private val restTemplateBuilder: RestTemplateBuilder
) : ItemRepository {
    override fun getItemDetail(id: String): Item {
        var title = invokeApi()
        return Item(id, title)
    }
    fun invokeApi(): String {
        // 特に意味はないですが、外部のURLから取ってくるような雰囲気のコード
        val uri: String = "http://localhost:8080/cache/get"
        var ret: String? = restTemplateBuilder.build().getForObject(uri, String::class.java)
        if (ret.isNullOrEmpty()) {
            return "null str"
        }
//        ret.let{
//            return "null str"
//        }
        return ret
    }
}
