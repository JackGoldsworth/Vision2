package me.jackgoldsworth.webapp

import me.jackgoldsworth.core.processor.CommandProcessor
import me.jackgoldsworth.core.utils.FileUtils
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
            CommandProcessor().run()
            runApplication<Application>(*args)
        }
    }
}