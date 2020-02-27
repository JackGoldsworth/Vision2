package me.jackgoldsworth.core.command.impl

import me.jackgoldsworth.core.SpotifyRequests
import me.jackgoldsworth.core.command.Command
import me.jackgoldsworth.core.processor.RegisterCommand

@RegisterCommand
class VolumeCommand: Command() {

    override fun runCommand(args: List<String>, extras: Map<String, String>) {
        this.args = args
        this.extras = extras
        this.run()
    }

    override fun init() {
        this.commandName = "Change Volume"
    }

    override fun getCommandPrefix(): String {
        return "Spotify set volume to"
    }

    override fun run() {
        if(args != null && extras != null) {
            SpotifyRequests.setVolume(args!![4].toInt(), extras!!["auth"] ?: error("Auth was null"))
        }
    }
}