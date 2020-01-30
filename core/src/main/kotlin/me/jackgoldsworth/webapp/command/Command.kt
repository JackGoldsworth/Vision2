package me.jackgoldsworth.webapp.command

abstract class Command(val parser: CommandParser) : Runnable {

    annotation class Register(val name: String, val description: String)
}