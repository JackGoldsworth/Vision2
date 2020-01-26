package me.jackgoldsworth.webapp.command

import me.jackgoldsworth.webapp.command.impl.PlaySongCommand
import me.jackgoldsworth.webapp.command.impl.VolumeCommand

class CommandParser(private val command: String, private val auth: String?) {

    private val splitCommand = command.split(" ")

    fun parse(): Command? {
        if (splitCommand[0].equals("spotify", ignoreCase = true)) {
            if (splitCommand[1].equals("play", ignoreCase = true)) {
                return PlaySongCommand(splitCommand, auth ?: throw IllegalStateException("Auth token was null"))
            } else if (splitCommand[1].equals("volume", ignoreCase = true)) {
                return VolumeCommand(splitCommand, auth ?: throw IllegalStateException("Auth token was null"))
            }
        }
        return null
    }
}