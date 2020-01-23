package me.jackgoldsworth.webapp.command

abstract class Command(val name: String, val description: String, val args: List<String>) : Runnable