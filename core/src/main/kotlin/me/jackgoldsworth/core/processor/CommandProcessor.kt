package me.jackgoldsworth.core.processor

import me.jackgoldsworth.core.command.Command
import me.jackgoldsworth.core.command.CommandParser
import org.reflections.Reflections

class CommandProcessor {

    fun run() {
        val reflections = Reflections("me.jackgoldsworth.core.command.impl")
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