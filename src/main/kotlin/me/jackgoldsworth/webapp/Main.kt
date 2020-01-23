package me.jackgoldsworth.webapp

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.features.DefaultHeaders
import io.ktor.http.content.defaultResource
import io.ktor.http.content.static
import io.ktor.request.receiveText
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import me.jackgoldsworth.webapp.Main.authToken
import me.jackgoldsworth.webapp.controller.enterCredentials
import me.jackgoldsworth.webapp.controller.spotify

object Main {
    var authToken: String? = null
}

fun main(args: Array<String>) {
    embeddedServer(Netty, port = 8080, module = Application::mainModule).start(wait = true)
}

fun Application.mainModule() {
    routing {
        enterCredentials()
        spotify()
        static("/") {
            defaultResource("index.html", "web")
        }
        post {
            // TODO: Eventually switch this to ktor http calls.
            val uri = call.receiveText()
            authToken = uri.substring(uri.indexOf("access_token=") + 13, uri.indexOf("&token_type"))
        }
    }
}


