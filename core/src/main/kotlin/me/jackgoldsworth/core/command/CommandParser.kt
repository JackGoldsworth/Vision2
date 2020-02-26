package me.jackgoldsworth.core.command

class CommandParser(val command: String, val auth: String?) {

    companion object {
        val commands = HashMap<String, Command>()
    }

    fun parse(): Command? {
        commands.keys.forEach {
            if (command.toLowerCase().startsWith(it.toLowerCase())) {
                return commands[it]
            }
        }
        return null
    }
}