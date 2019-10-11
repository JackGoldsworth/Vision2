package me.jackgoldsworth.vision

import me.jackgoldsworth.vision.commands.CommandHandler
import me.jackgoldsworth.vision.handlers.SpotifyHandler

object Vision {

    private val spotify = SpotifyHandler()
    private lateinit var commandHandler: CommandHandler

    @JvmStatic
    fun main(args: Array<String>) {
        spotify.connect()
        commandHandler = CommandHandler(spotify.spotifyApi)
        commandHandler.registerCommands()
    }
}