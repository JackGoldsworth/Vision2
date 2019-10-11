package me.jackgoldsworth.vision.commands

import com.wrapper.spotify.SpotifyApi
import me.jackgoldsworth.vision.api.Command
import me.jackgoldsworth.vision.commands.spotify.TrackCommand
import me.jackgoldsworth.vision.commands.system.ListCommand

class CommandHandler(spotify: SpotifyApi) {

    companion object {
        val commands = mutableMapOf<String, Command>()
    }

    private val list = ListCommand()
    private val track = TrackCommand(spotify)

    fun registerCommands() {
        commands[list.name] = list
        commands[track.name] = track
    }
}