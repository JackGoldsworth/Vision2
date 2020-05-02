package me.jackgoldsworth.webapp.core.processor

import me.jackgoldsworth.webapp.core.command.Command
import me.jackgoldsworth.webapp.core.command.CommandParser
import org.reflections.Reflections

class CommandProcessor {

    fun run() {
        val reflections = Reflections("me.jackgoldsworth.webapp.core.command.impl")
        reflections.getSubTypesOf(Command::class.java).forEach {
            if(it.isAnnotationPresent(RegisterCommand::class.java)) {
                println("Registering Command: ${it.simpleName}")
                val clazz = it.newInstance()
                clazz.init()
                CommandParser.commands[clazz.getCommandPrefix()] = clazz
            }
        }
    }
}