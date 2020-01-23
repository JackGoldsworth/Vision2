package me.jackgoldsworth.webapp.controller

import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get

fun Route.enterCredentials() {

    get("credentials") {
        call.respondText(javaClass.classLoader.getResource("settings.json")!!.readText())
    }
}