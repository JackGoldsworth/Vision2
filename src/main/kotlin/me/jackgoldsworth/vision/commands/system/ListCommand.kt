package me.jackgoldsworth.vision.commands.system

import me.jackgoldsworth.vision.api.Command
import me.jackgoldsworth.vision.commands.CommandHandler

class ListCommand : Command() {

    init {
        this.name = "List"
        this.description = "List all of the commands"
    }

    override fun execute() {
        CommandHandler.commands.forEach {
            val value = it.value
            println(value.name)
            println("${value.description}\n")
        }
    }
}