package me.jackgoldsworth.webapp.core.command

import me.jackgoldsworth.webapp.model.TaskInfo

abstract class Command : Runnable {

    protected var args: List<String>? = null
    protected var extras: Map<String, String>? = null
    var commandName: String? = null
    var response: String? = null
    var taskInfo: TaskInfo? = null

    abstract fun runCommand(args: List<String>, extras: Map<String, String>)

    abstract fun init()

    abstract fun getCommandPrefix(): String
}