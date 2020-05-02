package me.jackgoldsworth.webapp.controller

import me.jackgoldsworth.webapp.Application
import me.jackgoldsworth.webapp.core.command.CommandParser
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/v1")
class CommandController(private var simpMessagingTemplate: SimpMessagingTemplate) {

    private val logger = LoggerFactory.getLogger(CommandController::class.java)

    @PostMapping("/command")
    fun sendCommand(@RequestBody command: String): ResponseEntity<String> {
        CommandParser(command, Application.authToken).parse()
        val currentCommand = CommandParser.currentCommand
        if (currentCommand != null) {
            currentCommand.runCommand(command.split(" "), mapOf("auth" to Application.authToken!!))
            if (currentCommand.taskInfo != null) {
                simpMessagingTemplate.convertAndSend("/results", ResponseEntity.ok(currentCommand.taskInfo!!))
            }
            return ResponseEntity.ok("")
        }
        logger.info("Command: $command not found.")
        return ResponseEntity.badRequest().body("Command not found.")
    }

    @GetMapping("/command/response")
    fun getCommandResponse(): ResponseEntity<String> {
        val currentCommand = CommandParser.currentCommand
            ?: return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Current command is null.")
        if (currentCommand.response != null) {
            return ResponseEntity.ok(currentCommand.response!!)
        }
        return ResponseEntity.ok("")
    }
}