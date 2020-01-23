package me.jackgoldsworth.webapp.command

import me.jackgoldsworth.webapp.command.impl.PlaySongCommand

class CommandParser(private val command: String, private val auth: String?) {

    private val splitCommand = command.split(" ")

    fun parse(): Command? {
        if (splitCommand[0] == "Spotify") {
            if (splitCommand[1] == "play") {
                return PlaySongCommand(splitCommand, auth ?: throw IllegalStateException("Auth token was null"))
            }
        }
        return null
    }
}