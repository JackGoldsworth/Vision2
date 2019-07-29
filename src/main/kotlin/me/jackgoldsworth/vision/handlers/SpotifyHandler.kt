package me.jackgoldsworth.vision.handlers

import com.wrapper.spotify.SpotifyApi
import me.jackgoldsworth.vision.utils.JsonUtils
import java.net.URI

class SpotifyHandler {

    private lateinit var spotifyApi: SpotifyApi

    fun connect() {
        val credMap = JsonUtils.loadCredentials("credentials.json")
        spotifyApi = SpotifyApi.builder()
            .setClientId(credMap["client"])
            .setClientSecret(credMap["secret"])
            .setRedirectUri(URI(credMap["redirect"] ?: error("There was an issue with the redirect link")))
            .build()
        spotifyApi.accessToken = ""
        playTrack("Ballin")
    }

    fun playTrack(songName: String) {
        val track = spotifyApi.searchTracks(songName).build()
        var request = track.execute()
        print(request.items)
    }
}