package me.jackgoldsworth.webapp.command

import me.jackgoldsworth.webapp.command.impl.PlaySongCommand
import me.jackgoldsworth.webapp.command.impl.VolumeCommand

class CommandParser(val command: String, val auth: String?) {

    val splitCommand = command.split(" ")

    companion object {
        private val commands = HashMap<String, Command>()

        fun registerCommand(key: String, cmd: Command) {
            commands[key] = cmd
        }
    }

    fun parse(): Command? {
        if (splitCommand[0] == "spotify") {
            if (splitCommand[1] == "play") {
                return PlaySongCommand(this)
            } else if (splitCommand[1] == "volume") {
                return VolumeCommand(this)
            }
        }
        return null
    }
}