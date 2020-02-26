package me.jackgoldsworth.core.processor

import me.jackgoldsworth.core.command.Command
import me.jackgoldsworth.core.command.CommandParser
import org.reflections.Reflections

class CommandProcessor {

    fun run() {
        val reflections = Reflections("me.jackgoldsworth.core.command.impl")
        reflections.getSubTypesOf(Command::class.java).forEach {
            val clazz = it.newInstance()
            CommandParser.commands[clazz.getCommandPrefix()] = clazz
        }
    }
}