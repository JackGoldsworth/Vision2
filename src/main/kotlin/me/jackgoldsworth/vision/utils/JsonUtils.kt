package me.jackgoldsworth.vision.utils

import com.google.gson.JsonParser
import java.io.File
import java.net.URL

object JsonUtils {

    private val credentials = mutableMapOf<String, String>()
    private const val fileName = "credentials.json"

    /**
     * Loads the credentials from the credentials.json file
     * in the resources directory.
     * @return Map containing credentials.
     */
    @JvmStatic
    fun loadCredentials(): Map<String, String> {
        val content: URL? = JsonUtils::class.java.classLoader.getResource(fileName)
        val json = JsonParser().parse(content?.readText())
        credentials["client"] = json.asJsonObject["client"].asString
        credentials["secret"] = json.asJsonObject["secret"].asString
        credentials["redirect"] = json.asJsonObject["redirect"].asString

        val refreshToken = json.asJsonObject["refresh"].asString
        if (!refreshToken.isBlank()) {
            credentials["refresh"] = refreshToken
        }
        return credentials
    }

    /**
     * Writes the refresh token to the credentials file,
     * and then adds them to the credentials map.
     * @param token authorization token.
     */
    @JvmStatic
    fun addRefreshToken(token: String) {
        val content: URL? = JsonUtils::class.java.classLoader.getResource(fileName)
        val json = JsonParser().parse(content?.readText()).asJsonObject
        json.addProperty("refresh", token)
        println(json.toString())
        File(content?.toURI()!!).writeText(json.toString())
        credentials["refresh"] = token
    }
}