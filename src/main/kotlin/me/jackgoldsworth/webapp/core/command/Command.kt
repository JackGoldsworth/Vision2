package me.jackgoldsworth.webapp.core.command

abstract class Command : Runnable {

    protected var args: List<String>? = null
    protected var extras: Map<String, String>? = null
    var commandName: String? = null
    var response: String? = null

    abstract fun runCommand(args: List<String>, extras: Map<String, String>)

    abstract fun init()

    abstract fun getCommandPrefix(): String
}