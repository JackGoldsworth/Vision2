package me.jackgoldsworth.webapp.controller

import io.ktor.application.call
import io.ktor.locations.put
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.put
import me.jackgoldsworth.webapp.Main
import me.jackgoldsworth.webapp.SpotifyRequests
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

fun Route.spotify() {
    get("spotify/volume") {
        val volume = call.request.queryParameters["volume"]?.toInt() ?: throw IllegalArgumentException("Volume query not found")
        SpotifyRequests.setVolume(volume, Main.authToken ?: throw IllegalStateException("Can't use a spotify command without logging in."))
    }
    get("spotify/track") {
        val track = call.request.queryParameters["track"] ?: throw IllegalArgumentException("Track query not found")
        SpotifyRequests.setTrack(track, Main.authToken ?: throw IllegalStateException("Can't use a spotify command without logging in."))
    }
}