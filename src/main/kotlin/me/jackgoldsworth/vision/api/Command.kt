package me.jackgoldsworth.vision.api

abstract class Command {

    lateinit var name: String
    lateinit var description: String

    abstract fun execute()
}