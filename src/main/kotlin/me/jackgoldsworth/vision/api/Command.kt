package me.jackgoldsworth.vision.api

/**
 * This is the abstract class containing the basic
 * functionality that should be provided with a command.
 * This includes things like initial logic for the command
 * as well as the name, description, and usage.
 */
abstract class Command {

    lateinit var name: String
    lateinit var description: String
    lateinit var usage: String

    /**
     * Called when the command is executed.
     */
    abstract fun execute(args: Array<String>)
}