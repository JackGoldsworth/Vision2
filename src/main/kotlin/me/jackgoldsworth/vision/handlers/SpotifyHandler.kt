package me.jackgoldsworth.vision.handlers

import com.wrapper.spotify.SpotifyApi
import me.jackgoldsworth.vision.utils.JsonUtils
import java.net.URI

class SpotifyHandler {

    private lateinit var spotifyApi: SpotifyApi

    /**
     * Connects to Spotify with the credentials provided.
     */
    fun connect() {
        val credMap = JsonUtils.loadCredentials()
        spotifyApi = SpotifyApi.builder()
            .setClientId(credMap["client"])
            .setClientSecret(credMap["secret"])
            .setRedirectUri(URI(credMap["redirect"] ?: error("There was an issue with the redirect link")))
            .build()
        val refreshToken = credMap["refresh"]
        if (refreshToken.isNullOrBlank()) {
            val authCode = requestAuthCode()
            JsonUtils.addRefreshToken(authCode)
        } else {
            spotifyApi.refreshToken = refreshToken
        }
    }

    /**
     * Requests an authorization code, and then uses that code
     * to update the access and refresh tokens.
     * @return the authorization code.
     */
    private fun requestAuthCode(): String {
        val request = spotifyApi.authorizationCodeUri().build().execute()
        println("Please click the link and put in the code parameter below: $request")
        val authCode = readLine()!!
        val authorizationCodeRequest = spotifyApi.authorizationCode(authCode).build()
        val authorizationCodeCredentials = authorizationCodeRequest.execute()
        spotifyApi.accessToken = authorizationCodeCredentials.accessToken
        spotifyApi.refreshToken = authorizationCodeCredentials.refreshToken
        return authCode
    }
}