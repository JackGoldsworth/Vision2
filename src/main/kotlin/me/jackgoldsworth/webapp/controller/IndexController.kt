package me.jackgoldsworth.webapp.controller

import me.jackgoldsworth.webapp.Application.Companion.authToken
import me.jackgoldsworth.webapp.utils.FileUtils
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController {

    private val logger = LoggerFactory.getLogger(IndexController::class.java)

    @RequestMapping("/")
    fun index(): String {
        return "index.html";
    }

    @PostMapping("/")
    fun loadSpotifyToken(@RequestBody uri: String) {
        logger.debug("Retrieving Spotify Token.")
        authToken = uri.substring(uri.indexOf("access_token=") + 13, uri.indexOf("&token_type"))
        FileUtils.saveAuthToken("spotify", authToken!!)
    }
}