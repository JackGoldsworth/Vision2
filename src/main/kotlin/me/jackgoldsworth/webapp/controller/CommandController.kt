package me.jackgoldsworth.webapp.controller

import io.ktor.application.call
import io.ktor.request.receiveText
import io.ktor.routing.Route
import io.ktor.routing.post
import me.jackgoldsworth.webapp.Main
import me.jackgoldsworth.webapp.command.CommandParser

fun Route.command() {

    post("command") {
        val command = call.receiveText()
        CommandParser(command, Main.authToken).parse()?.run()
    }
}