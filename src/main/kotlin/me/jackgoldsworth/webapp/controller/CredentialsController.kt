package me.jackgoldsworth.webapp.controller

import io.ktor.http.content.defaultResource
import io.ktor.http.content.static
import io.ktor.routing.Route
import io.ktor.routing.post

fun Route.enterCredentials() {
    static("/credentials") {
        defaultResource("credentials.html", "web")
    }
    post {

    }
}