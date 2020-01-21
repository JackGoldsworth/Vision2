package me.jackgoldsworth.webapp

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.features.DefaultHeaders
import io.ktor.http.content.defaultResource
import io.ktor.http.content.static
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import me.jackgoldsworth.webapp.controller.enterCredentials

fun main(args: Array<String>) {
    embeddedServer(Netty, port = 8080, module = Application::mainModule).start(wait = true)
}

fun Application.mainModule() {
    install(DefaultHeaders)
    install(Authentication)
    routing {
        static("/") {
            defaultResource("index.html", "web")
        }
        enterCredentials()
    }
}


