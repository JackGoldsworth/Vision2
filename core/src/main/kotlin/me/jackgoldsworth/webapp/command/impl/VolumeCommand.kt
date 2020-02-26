package me.jackgoldsworth.webapp.command.impl

import me.jackgoldsworth.webapp.SpotifyRequests
import me.jackgoldsworth.webapp.command.Command
import me.jackgoldsworth.webapp.processor.RegisterCommand

@RegisterCommand
class VolumeCommand: Command() {

    var args: List<String>? = null
    var extras: Map<String, String>? = null

    override fun runCommand(args: List<String>, extras: Map<String, String>) {
        this.args = args
        this.extras = extras
        this.run()
    }

    override fun getCommandPrefix(): String {
        return "Spotify set volume to"
    }

    override fun run() {
        if(args != null && extras != null) {
            SpotifyRequests.setVolume(args!![2].toInt(), extras!!["auth"] ?: error("Auth was null"))
        }
    }
}