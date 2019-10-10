package me.jackgoldsworth.vision.utils

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.io.File
import java.io.FileWriter
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
        if (content == null) {
            createCredentialsFile()
        }
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

    /**
     * Creates a credentials file with the required fields.
     * @return if the file was created successfully or not.
     */
    private fun createCredentialsFile(): Boolean {
        val file = File(System.getProperty("user.dir") + "\\src\\main\\resources\\" + fileName)
        val created = file.createNewFile()
        val emptyObject = JsonObject()
        emptyObject.addProperty("client", "")
        emptyObject.addProperty("secret", "")
        emptyObject.addProperty("redirect", "")
        emptyObject.addProperty("refresh", "")
        // TODO: Write isn't working.
        Gson().toJson(emptyObject, FileWriter(file))
        println(
            if (created) {
                "The credentials file was created"
            } else {
                "The credentials file was not created"
            }
        )
        return created
    }
}