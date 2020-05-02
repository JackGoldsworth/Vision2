package me.jackgoldsworth.webapp.core.utils

import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.io.File
import java.io.FileWriter


/**
 * General file utils that will be used
 * throughout the project.
 * @author Jack Goldsworth
 * @since v0.1
 */
object FileUtils {

    fun createAuthFile() {
        val file = File("auth.json")
        if (!file.exists()) {
            file.createNewFile()
            val json = JsonObject()
            json.addProperty("spotify", "")
            FileWriter(file).use { writer ->
                GsonBuilder().create().toJson(json, writer)
            }
        }
    }

    fun loadSpotifyAuth(): String? {
        val file = File("auth.json")
        val json = JsonParser().parse(file.readText())
        return json.asJsonObject.get("spotify").asString
    }

    fun saveAuthToken(tokenName: String, auth: String) {
        val file = File("auth.json")
        if (file.exists()) {
            val json = JsonParser().parse(file.readText())
            json.asJsonObject.addProperty(tokenName, auth)
            FileWriter(file).use { writer ->
                GsonBuilder().create().toJson(json, writer)
            }
        }
    }
}