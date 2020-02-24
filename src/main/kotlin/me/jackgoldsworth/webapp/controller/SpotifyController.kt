package me.jackgoldsworth.webapp.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/spotify")
class SpotifyController {

    @GetMapping("/volume")
    fun changeVolume(@RequestParam("volume") volume: Int) {

    }

    @GetMapping("/track")
    fun playTrack(@RequestParam("id") id: String) {

    }
}