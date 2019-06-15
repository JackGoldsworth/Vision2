package me.jackgoldsworth.vision.commands

import me.jackgoldsworth.vision.api.BuildableCommand
import me.jackgoldsworth.vision.api.Command
import me.jackgoldsworth.vision.commands.system.ListCommand

class CommandHandler {

    companion object {
        val commands = mutableMapOf<String, Command>()
    }

    fun registerCommands() {
        val command = BuildableCommand.Builder("Nothing")
            .description("This Command literally prints hello")
            .function(Runnable { print("Hello") })
            .build()
        val list = ListCommand()
        commands[command.name] = command
        commands[list.name] = list
        list.run.run()
    }
}