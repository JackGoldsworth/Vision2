package me.jackgoldsworth.webapp.controller

import me.jackgoldsworth.webapp.Application
import me.jackgoldsworth.webapp.command.CommandParser
import me.jackgoldsworth.webapp.task.TaskHandler
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class CommandController {

    private val logger = LoggerFactory.getLogger(CommandController::class.java)

    @PostMapping("/command")
    fun sendCommand(@RequestBody command: String): ResponseEntity<String> {
        val parsedCommand = CommandParser(command, Application.authToken).parse()
        if (parsedCommand != null) {
            parsedCommand.run()
            TaskHandler.currentTask = parsedCommand
            return ResponseEntity.ok("")
        }
        logger.info("Command: $command not found.")
        return ResponseEntity.badRequest().body("Command not found.")
    }
}