package me.jackgoldsworth.webapp.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/auth")
class AuthController {

    @GetMapping("/credentials")
    fun spotifyLogin(): String {
        return javaClass.classLoader.getResource("settings.json")!!.readText()
    }
}