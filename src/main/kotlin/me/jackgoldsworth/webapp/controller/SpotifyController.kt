package me.jackgoldsworth.webapp.controller

import io.ktor.application.call
import io.ktor.routing.Route
import io.ktor.routing.get
import me.jackgoldsworth.webapp.Main
import me.jackgoldsworth.webapp.SpotifyRequests

fun Route.spotify() {
    get("spotify/volume") {
        val volume =
            call.request.queryParameters["volume"]?.toInt() ?: throw IllegalArgumentException("Volume query not found")
        val response = SpotifyRequests.setVolume(
            volume,
            Main.authToken ?: throw IllegalStateException("Can't use a spotify command without logging in.")
        )
        call.application.environment.log.info("Changing the volume returned a status of: $response")
    }
    get("spotify/track") {
        val track = call.request.queryParameters["track"] ?: throw IllegalArgumentException("Track query not found")
        val response = SpotifyRequests.setTrack(
            track,
            Main.authToken ?: throw IllegalStateException("Can't use a spotify command without logging in.")
        )
        call.application.environment.log.info("Playing a track returned a status of: $response")
    }
}