package me.jackgoldsworth.vision.api

/**
 * This is the abstract class containing the basic
 * functionality that should be provided with a command.
 * This includes things like initial logic for the command
 * as well as the name, description, and usage.
 * @author Jack Goldsworth
 * @since 0.1
 */
abstract class Command {

    /**
     * Name of the command.
     */
    lateinit var name: String
    /**
     * Description of the command.
     */
    lateinit var description: String
    /**
     * Helpful usage to show user if needed.
     */
    lateinit var usage: String
    /**
     * Prefix to look for when voicing or typing commands.
     */
    lateinit var prefix: String

    /**
     * Called when the command is executed.
     */
    abstract fun execute(args: Array<String>)
}