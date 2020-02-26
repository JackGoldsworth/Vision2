package me.jackgoldsworth.webapp.command

import me.jackgoldsworth.webapp.command.impl.PlaySongCommand
import me.jackgoldsworth.webapp.command.impl.VolumeCommand

class CommandParser(val command: String, val auth: String?) {

    private val splitCommand = command.split(" ")

    companion object {
        val commands = HashMap<String, Command>()
    }

    fun parse(): Command? {
        if (splitCommand[0] == "spotify") {
            if (splitCommand[1] == "play") {
                return PlaySongCommand()
            } else if (splitCommand[1] == "volume") {
                return VolumeCommand()
            }
        }
        return null
    }
}