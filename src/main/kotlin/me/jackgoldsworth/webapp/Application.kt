package me.jackgoldsworth.webapp

import me.jackgoldsworth.webapp.utils.FileUtils
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class Application {

    companion object {
        var authToken: String? = null

        @JvmStatic
        fun main(args: Array<String>) {
            FileUtils.createAuthFile()
            authToken = FileUtils.loadSpotifyAuth()
            runApplication<Application>(*args)
        }
    }
}