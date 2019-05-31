package me.jackgoldsworth.vision

import me.jackgoldsworth.vision.handlers.SpotifyHandler

object Vision {

    private val spotify = SpotifyHandler()

    @JvmStatic
    fun main(args: Array<String>)
    {
        spotify.connect()
    }
}