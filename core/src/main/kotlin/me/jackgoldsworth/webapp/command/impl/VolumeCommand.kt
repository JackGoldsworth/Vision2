package me.jackgoldsworth.webapp.command.impl

import me.jackgoldsworth.webapp.SpotifyRequests
import me.jackgoldsworth.webapp.command.Command

class VolumeCommand(args: List<String>, private val auth: String) : Command("Play Song", "Plays a song", args) {

    override fun run() {
        SpotifyRequests.setVolume(args[2].toInt(), auth)
    }
}