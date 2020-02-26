package me.jackgoldsworth.webapp.command.impl

import me.jackgoldsworth.webapp.SpotifyRequests
import me.jackgoldsworth.webapp.command.Command
import me.jackgoldsworth.webapp.command.CommandParser

class VolumeCommand(parser: CommandParser) : Command(parser) {

    private val args = parser.command.split(" ")

    override fun run() {
        SpotifyRequests.setVolume(args[2].toInt(), parser.auth ?: error("Auth was null"))
    }
}