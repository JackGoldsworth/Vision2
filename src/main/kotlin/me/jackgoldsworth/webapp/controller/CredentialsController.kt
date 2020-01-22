package me.jackgoldsworth.webapp.controller

import io.ktor.application.call
import io.ktor.http.content.defaultResource
import io.ktor.http.content.static
import io.ktor.request.*
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import org.apache.http.HttpHeaders
import org.apache.http.client.methods.RequestBuilder
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

fun Route.enterCredentials() {
    get("credentials") {
        call.respondText(javaClass.classLoader.getResource("settings.json")!!.readText())
    }
}