package com.github.iskitahara.controller

import com.github.iskitahara.application.service.ItemService
import org.springframework.web.bind.annotation.*
import org.springframework.data.redis.core.StringRedisTemplate

@RestController
@RequestMapping("items")
class ItemController (
    private val itemService: ItemService,
    private val redisTemplate: StringRedisTemplate
){

    @GetMapping("/{id}")
    fun getItemDetail(@PathVariable("id") id: String, @RequestParam(value = "cache", defaultValue = "allow") cache: String): String? {
        // APIでできない相関バリデーションとか
        if(cache != "disallow"){
            var cacheObj = redisTemplate.opsForValue().get("key")
            print(String.format("cache:", cacheObj))
            return cacheObj
        }
        val item = itemService.getItemDetail(id)
        return item.toString()
    }
}