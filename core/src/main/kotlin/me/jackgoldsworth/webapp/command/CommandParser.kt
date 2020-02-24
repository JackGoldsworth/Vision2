package me.jackgoldsworth.webapp.command

import me.jackgoldsworth.webapp.api.Inject

class CommandParser(val command: String, val auth: String?) {

    @Inject("Jack")
    val test = ""

    companion object {
        private val commands = HashMap<String, Command>()

        fun registerCommand(key: String, cmd: Command) {
            commands[key] = cmd
        }
    }

    fun parse(): Command? {
        return null
    }
}