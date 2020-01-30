package me.jackgoldsworth.webapp.command

class CommandParser(val command: String, val auth: String?) {

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