package me.jackgoldsworth.webapp.controller

import io.ktor.application.call
import io.ktor.request.receiveText
import io.ktor.routing.Route
import io.ktor.routing.post
import me.jackgoldsworth.webapp.Main
import me.jackgoldsworth.webapp.command.CommandParser
import me.jackgoldsworth.webapp.task.TaskHandler

fun Route.command() {

    post("command") {
        val command = call.receiveText()
        val parsedCommand = CommandParser(command, Main.authToken).parse()
        parsedCommand?.run()
        TaskHandler.currentTask = parsedCommand ?: error("Command was found null when trying to set the current task.")
    }
}