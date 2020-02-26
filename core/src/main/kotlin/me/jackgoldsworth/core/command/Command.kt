package me.jackgoldsworth.core.command

abstract class Command : Runnable {

    protected var args: List<String>? = null
    protected var extras: Map<String, String>? = null

    abstract fun runCommand(args: List<String>, extras: Map<String, String>)

    abstract fun getCommandPrefix(): String
}