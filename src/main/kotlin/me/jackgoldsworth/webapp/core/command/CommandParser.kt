package me.jackgoldsworth.webapp.core.command

class CommandParser(val command: String, val auth: String?) {

    companion object {
        val commands = HashMap<String, Command>()
        var currentCommand: Command? = null
    }

    fun parse(): Command? {
        commands.keys.forEach {
            if (command.toLowerCase().startsWith(it.toLowerCase())) {
                currentCommand = commands[it]
                return commands[it]
            }
        }
        return null
    }
}