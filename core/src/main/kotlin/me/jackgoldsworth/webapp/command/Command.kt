package me.jackgoldsworth.webapp.command

abstract class Command : Runnable {

    abstract fun runCommand(args: List<String>, extras: Map<String, String>)

    abstract fun getCommandPrefix(): String
}