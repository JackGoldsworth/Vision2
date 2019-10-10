package me.jackgoldsworth.vision

import me.jackgoldsworth.vision.commands.CommandHandler
import me.jackgoldsworth.vision.handlers.SpotifyHandler

object Vision {

    private val spotify = SpotifyHandler()
    private val commandHandler = CommandHandler()

    @JvmStatic
    fun main(args: Array<String>) {
        println(System.getProperty("user.dir"))
        commandHandler.registerCommands()
        spotify.connect()
    }
}