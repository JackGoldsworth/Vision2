package me.jackgoldsworth.webapp.controller

import me.jackgoldsworth.webapp.core.command.CommandParser
import me.jackgoldsworth.webapp.model.TaskInfo
import org.springframework.http.ResponseEntity
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class WebSocketController {

    @MessageMapping("/info")
    @SendTo("/results")
    fun getInfo(): ResponseEntity<TaskInfo>? {
        val info = CommandParser.currentCommand?.taskInfo
        if (info != null) {
            return ResponseEntity.ok(info)
        }
        return ResponseEntity.noContent().build()
    }
}