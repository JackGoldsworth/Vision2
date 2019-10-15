package me.jackgoldsworth.vision.commands.system

import me.jackgoldsworth.vision.api.Command
import me.jackgoldsworth.vision.commands.CommandHandler

class ListCommand : Command() {

    init {
        this.name = "List"
        this.description = "List all of the commands"
        this.usage = "list"
        this.prefix = "List"
    }

    override fun execute(args: Array<String>) {
        CommandHandler.commands.forEach {
            val value = it.value
            print(value.name + ": ")
            println(value.description)
        }
    }
}