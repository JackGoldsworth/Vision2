package me.jackgoldsworth.webapp.controller

import me.jackgoldsworth.webapp.Application
import me.jackgoldsworth.webapp.command.CommandParser
import me.jackgoldsworth.webapp.task.TaskHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class CommandController {

    @PostMapping("/command")
    fun sendCommand(@RequestBody command: String) {
        val parsedCommand = CommandParser(command, Application.authToken).parse()
        parsedCommand?.run()
        TaskHandler.currentTask = parsedCommand ?: error("Command was found null when trying to set the current task.")
    }
}