package me.jackgoldsworth.webapp.controller

import me.jackgoldsworth.webapp.Application
import me.jackgoldsworth.webapp.core.SpotifyRequests
import me.jackgoldsworth.webapp.core.SpotifyTrack
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/spotify")
class SpotifyController {

    private val logger = LoggerFactory.getLogger(
        SpotifyController::class.java)

    @GetMapping("/volume")
    fun changeVolume(@RequestParam("volume") volume: String): ResponseEntity<String> {
        if (!volume.isBlank()) {
            SpotifyRequests.setVolume(
                volume.toInt(),
                Application.authToken ?: throw IllegalStateException("Can't use a spotify command without logging in.")
            )
            logger.info("Changed the spotify volume to $volume")
            return ResponseEntity.ok("")
        }
        return ResponseEntity.badRequest().body("Invalid Query Parameters.")
    }

    @GetMapping("/track")
    fun playTrack(@RequestParam("track") track: String): ResponseEntity<String> {
        if (!track.isBlank()) {
            SpotifyRequests.setTrack(
                track,
                Application.authToken ?: throw IllegalStateException("Can't use a spotify command without logging in.")
            ).imageUrl
            logger.debug("Switching the track to: $track")
            return ResponseEntity.ok("")
        }
        return ResponseEntity.badRequest().body("Invalid Query Parameters.")
    }

    @GetMapping("/info")
    fun getTrackInfo(): ResponseEntity<SpotifyTrack> {
        val track = SpotifyRequests.currentTrack
        if (track != null) {
            logger.info("Switching the track to: ${track.name}")
            return ResponseEntity.ok(track)
        }
        return ResponseEntity.badRequest().build()
    }
}