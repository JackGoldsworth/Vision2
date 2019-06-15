package me.jackgoldsworth.vision.commands.system

import me.jackgoldsworth.vision.api.Command
import me.jackgoldsworth.vision.commands.CommandHandler

class ListCommand : Command {

    override val name = "list commands"
    override val description = "Lists all of the commands and their descriptions."
    override val run = Runnable {
        CommandHandler.commands.forEach {
            val value = it.value
            println(value.name)
            println("${value.description}\n")
        }
    }
}