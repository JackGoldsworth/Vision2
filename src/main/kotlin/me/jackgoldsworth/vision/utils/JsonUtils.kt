package me.jackgoldsworth.vision.utils

import com.google.gson.JsonParser
import java.net.URL

object JsonUtils {

    @JvmStatic
    fun loadCredentials(fileName: String): Map<String, String> {
        val map = mutableMapOf<String, String>()
        val content: URL? = JsonUtils::class.java.classLoader.getResource(fileName)
        val json = JsonParser().parse(content?.readText())
        map["client"] = json.asJsonObject["client"].asString
        map["secret"] = json.asJsonObject["secret"].asString
        map["redirect"] = json.asJsonObject["redirect"].asString
        return map
    }
}