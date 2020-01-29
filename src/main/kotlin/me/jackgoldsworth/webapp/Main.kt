package me.jackgoldsworth.webapp

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.content.defaultResource
import io.ktor.http.content.static
import io.ktor.request.receiveText
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import me.jackgoldsworth.webapp.Main.authToken
import me.jackgoldsworth.webapp.controller.command
import me.jackgoldsworth.webapp.controller.enterCredentials
import me.jackgoldsworth.webapp.controller.spotify
import me.jackgoldsworth.webapp.controller.task
import me.jackgoldsworth.webapp.utils.FileUtils

object Main {
    var authToken: String? = null
}

fun main(args: Array<String>) {
    FileUtils.createAuthFile()
    authToken = FileUtils.loadSpotifyAuth()
    embeddedServer(Netty, port = 8080, module = Application::mainModule).start(wait = true)
}

fun Application.mainModule() {
    routing {
        enterCredentials()
        spotify()
        command()
        task()
        static("/") {
            defaultResource("index.html", "web")
        }
        post {
            val uri = call.receiveText()
            authToken = uri.substring(uri.indexOf("access_token=") + 13, uri.indexOf("&token_type"))
            FileUtils.saveAuthToken("spotify", authToken!!)
        }
    }
}


