package me.jackgoldsworth.vision.api

interface Command {

    val name: String
    val description: String?
    val run: Runnable?
}