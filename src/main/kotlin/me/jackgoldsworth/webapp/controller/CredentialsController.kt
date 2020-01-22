package me.jackgoldsworth.webapp.controller

import io.ktor.application.call
import io.ktor.http.content.defaultResource
import io.ktor.http.content.static
import io.ktor.request.*
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import org.apache.http.HttpHeaders
import org.apache.http.client.methods.RequestBuilder
import org.apache.http.impl.client.HttpClients

fun Route.enterCredentials() {
    static("/credentials") {
        defaultResource("credentials.html", "web")
    }
    get("cred") {
        call.respondText(javaClass.classLoader.getResource("settings.json")!!.readText())
    }
    get("code") {
        // TODO: FIX
        val uri = call.request.uri
        val auth = uri.substring(uri.indexOf("access_token="), uri.indexOf("&token_type"))
        val client = HttpClients.createDefault()
        val request = RequestBuilder.get()
            .setUri("https://api.spotify.com/v1/me/player/devices")
            .setHeader(HttpHeaders.AUTHORIZATION, "Bearer $auth")
            .build()
        val response = client.execute(request)
        println(response.entity)
    }
}