package me.jackgoldsworth.webapp.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/auth")
class AuthController {

    private val logger = LoggerFactory.getLogger(AuthController::class.java)

    @GetMapping("/credentials")
    fun spotifyLogin(): String {
        logger.info("Loading spotify settings.")
        return javaClass.classLoader.getResource("settings.json")!!.readText()
    }
}