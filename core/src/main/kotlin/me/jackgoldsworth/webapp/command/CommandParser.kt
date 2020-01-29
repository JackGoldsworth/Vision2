package me.jackgoldsworth.webapp.command

import me.jackgoldsworth.webapp.command.impl.PlaySongCommand
import me.jackgoldsworth.webapp.command.impl.VolumeCommand
import me.jackgoldsworth.webapp.processor.CommandProcessor
import me.jackgoldsworth.webapp.utils.StringUtils

class CommandParser(private val command: String, private val auth: String?) {

    private val splitCommand = command.split(" ")

    companion object {
        private val commands = HashMap<String, Command>()

        fun registerCommand(key: String, cmd: Command) {
            commands[key] = cmd
        }
    }

    fun init() {
        CommandProcessor()
    }

    fun parse(): Command? {
        if (StringUtils.equals(splitCommand[0], "spotify")) {
            if (StringUtils.equals(splitCommand[1], "play")) {
                return PlaySongCommand(splitCommand, auth ?: throw IllegalStateException("Auth token was null"))
            } else if (StringUtils.equals(splitCommand[1], "volume")) {
                return VolumeCommand(splitCommand, auth ?: throw IllegalStateException("Auth token was null"))
            }
        }
        return null
    }
}