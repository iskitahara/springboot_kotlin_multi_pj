package com.github.iskitahara.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.data.redis.core.StringRedisTemplate

@RestController
@RequestMapping("cache")
class CacheController (
    private val redisTemplate: StringRedisTemplate
){
    private val defaultKey = "key"

    @GetMapping("/")
    fun index(): String {
        redisTemplate.opsForValue().set(defaultKey, "default")
        return bindTemplate(redisTemplate.opsForValue().get(defaultKey))
    }

    @GetMapping("/set")
    fun set(@RequestParam(value = "key", defaultValue = "key") key: String,
        @RequestParam(value = "value", defaultValue = "cache value") value: String): String {
        redisTemplate.opsForValue().set(key, value)
        return bindTemplate(redisTemplate.opsForValue().get(key))
    }

    @GetMapping("/get")
    fun get(@RequestParam(value = "key", defaultValue = "key") key: String): String {
        return bindTemplate(redisTemplate.opsForValue().get(key))
    }

    companion object {
        private const val template = "Cache: %s!"
        fun bindTemplate(name: String?): String{
            return String.format(template, name)
        }
    }

    @GetMapping("/init")
    fun init(): String {
        redisTemplate.opsForValue().set("item_1", "item_1")
        redisTemplate.opsForValue().set("item_2", "item_2")
        redisTemplate.opsForValue().set("item_3", "item_3")
        redisTemplate.opsForValue().set("item_4", "item_4")
        return "init path"
    }


}