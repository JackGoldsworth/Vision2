package me.jackgoldsworth.vision.utils

import com.google.gson.JsonParser

object JsonUtils {

    fun loadCredentials(fileName: String): Map<String, String>
    {
        val map: MutableMap<String, String> = mutableMapOf()
        val content = JsonUtils::class.java.getResource(fileName)
        val json = JsonParser().parse(content.readText())
        map["client"] = json.asJsonObject["client"].asString
        map["secret"] = json.asJsonObject["secret"].asString
        map["redirect"] = json.asJsonObject["redirect"].asString
        return map
    }
}