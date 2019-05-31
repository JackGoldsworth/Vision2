package me.jackgoldsworth.vision.utils

import com.google.gson.JsonParser
import java.io.File

object JsonUtils {

    fun loadCredentials(fileName: String): Map<String, String>
    {
        val map: MutableMap<String, String> = mutableMapOf()
        val json = JsonParser().parse(File(fileName).readText())
        map["client"] = json.asJsonObject["client"].asString
        map["secret"] = json.asJsonObject["secret"].asString
        map["redirect"] = json.asJsonObject["redirect"].asString
        return map
    }
}