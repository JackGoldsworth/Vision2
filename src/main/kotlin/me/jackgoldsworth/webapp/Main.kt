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
import me.jackgoldsworth.webapp.controller.enterCredentials
import org.apache.http.HttpHeaders
import org.apache.http.client.methods.RequestBuilder
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

fun main(args: Array<String>) {
    embeddedServer(Netty, port = 8080, module = Application::mainModule).start(wait = true)
}

fun Application.mainModule() {
    install(DefaultHeaders)
    install(Authentication)
    routing {
        enterCredentials()
        static("/") {
            defaultResource("index.html", "web")
        }
        post {
            // TODO: Eventually switch this to ktor http calls.
            val uri = call.receiveText()
            val auth = uri.substring(uri.indexOf("access_token=") + 13, uri.indexOf("&token_type"))
            val client = HttpClients.createDefault()
            val request = RequestBuilder.get()
                .setUri("https://api.spotify.com/v1/me/player/devices")
                .setHeader(HttpHeaders.AUTHORIZATION, "Bearer $auth")
                .build()
            val response = client.execute(request)
            val responseString = EntityUtils.toString(response.entity)
        }
    }
}


