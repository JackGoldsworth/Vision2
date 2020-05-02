package me.jackgoldsworth.webapp.controller

import me.jackgoldsworth.webapp.model.TaskInfo
import org.springframework.http.ResponseEntity
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class WebSocketController {

    @MessageMapping("/info")
    @SendTo("/results")
    fun getInfo(username: String?): ResponseEntity<TaskInfo>? {
        return null
    }
}