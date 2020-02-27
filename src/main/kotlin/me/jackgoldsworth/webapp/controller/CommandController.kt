package me.jackgoldsworth.webapp.controller

import me.jackgoldsworth.core.command.Command
import me.jackgoldsworth.webapp.Application
import me.jackgoldsworth.core.command.CommandParser
import me.jackgoldsworth.core.task.TaskHandler
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1")
class CommandController {

    private val logger = LoggerFactory.getLogger(CommandController::class.java)
    private var currentCommand: Command? = null

    @PostMapping("/command")
    fun sendCommand(@RequestBody command: String): ResponseEntity<String> {
        currentCommand = CommandParser(command, Application.authToken).parse()
        if (currentCommand != null) {
            currentCommand!!.runCommand(command.split(" "), mapOf("auth" to Application.authToken!!))
            TaskHandler.currentTask = currentCommand!!
            return ResponseEntity.ok("")
        }
        logger.info("Command: $command not found.")
        return ResponseEntity.badRequest().body("Command not found.")
    }

    @GetMapping("/command/response")
    fun getCommandResponse(): ResponseEntity<String> {
        if(currentCommand == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Current command is null.")
        }
        if(currentCommand?.response != null) {
            val response = currentCommand?.response!!
            // Now that the command is over, get rid of the current command.
            currentCommand = null
            return ResponseEntity.ok(response)
        }
        return ResponseEntity.ok("")
    }
}