package me.jackgoldsworth.webapp.core.command.impl

import me.jackgoldsworth.webapp.core.command.Command
import me.jackgoldsworth.webapp.core.command.CommandParser
import me.jackgoldsworth.webapp.core.processor.RegisterCommand

@RegisterCommand
class ListCommand: Command() {

    override fun runCommand(args: List<String>, extras: Map<String, String>) {
        this.args = args
        this.extras = extras
        this.run()
    }

    override fun init() {
        this.commandName = "List Commands"
    }

    override fun getCommandPrefix(): String {
        return "list commands"
    }

    override fun run() {
        var str = ""
        CommandParser.commands.forEach { (t, u) ->
            str += "${u.commandName}, Prefix: $t , "
        }
        this.response = str
    }
}