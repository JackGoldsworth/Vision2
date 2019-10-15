package me.jackgoldsworth.vision

import me.jackgoldsworth.vision.commands.CommandExecutor
import me.jackgoldsworth.vision.commands.CommandHandler
import me.jackgoldsworth.vision.handlers.SpotifyHandler

object Vision {

    private val spotify = SpotifyHandler()
    private lateinit var commandHandler: CommandHandler
    private lateinit var commandExecutor: CommandExecutor

    @JvmStatic
    fun main(args: Array<String>) {
        spotify.connect()
        commandHandler = CommandHandler(spotify.spotifyApi)
        commandHandler.registerCommands()
        commandExecutor = CommandExecutor(commandHandler)
        commandExecutor.listen()
    }
}