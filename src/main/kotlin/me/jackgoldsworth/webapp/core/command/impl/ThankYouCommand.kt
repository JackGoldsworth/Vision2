package me.jackgoldsworth.webapp.core.command.impl

import me.jackgoldsworth.webapp.core.command.Command
import me.jackgoldsworth.webapp.core.processor.RegisterCommand

@RegisterCommand
class ThankYouCommand : Command() {

    override fun runCommand(args: List<String>, extras: Map<String, String>) {
        this.args = args
        this.extras = extras
        this.run()
    }

    override fun init() {
        this.commandName = "Thank You"
    }

    override fun getCommandPrefix(): String {
        return "Thank You"
    }

    override fun run() {
        println("You're Welcome")
    }
}