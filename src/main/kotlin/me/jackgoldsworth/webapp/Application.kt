package me.jackgoldsworth.webapp

import me.jackgoldsworth.core.processor.CommandProcessor
import me.jackgoldsworth.core.utils.FileUtils
import me.jackgoldsworth.core.utils.SpeechUtils
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
open class Application {

    companion object {
        var authToken: String? = null

        @JvmStatic
        fun main(args: Array<String>) {
            FileUtils.createAuthFile()
            authToken = FileUtils.loadSpotifyAuth()
            SpeechUtils.runSpeech()
            CommandProcessor().run()
            SpringApplication.run(Application::class.java)
        }
    }
}