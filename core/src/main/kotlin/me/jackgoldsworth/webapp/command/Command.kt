package me.jackgoldsworth.webapp.command

abstract class Command(val parser: CommandParser) : Runnable