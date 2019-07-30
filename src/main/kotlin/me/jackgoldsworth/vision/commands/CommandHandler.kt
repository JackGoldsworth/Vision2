package me.jackgoldsworth.vision.commands

import me.jackgoldsworth.vision.api.Command
import me.jackgoldsworth.vision.commands.system.ListCommand

class CommandHandler {

    companion object {
        val commands = mutableMapOf<String, Command>()
    }

    fun registerCommands() {
        val list = ListCommand()
        commands[list.name] = list
        list.execute()
    }
}