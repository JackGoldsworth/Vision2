package me.jackgoldsworth.vision.commands

import com.wrapper.spotify.SpotifyApi
import me.jackgoldsworth.vision.api.Command
import me.jackgoldsworth.vision.commands.spotify.TrackCommand
import me.jackgoldsworth.vision.commands.system.ListCommand

/**
 * This class handles all of the commands, whether
 * they're being registered, or needing to be executed.
 */
class CommandHandler(spotify: SpotifyApi) {

    companion object {
        val commands = mutableMapOf<String, Command>()
    }

    private val list = ListCommand()
    private val track = TrackCommand(spotify)

    /**
     * Register commands
     */
    fun registerCommands() {
        commands[list.name] = list
        commands[track.name] = track
    }

    /**
     * Finds the right command to execute.
     * @return if the command was found.
     */
    fun startCommand(command: String?): Boolean {
        for((key, value) in commands) {
            //TODO: What if command has many parts (ex. Track <Play> or Track <Pause>)
            val splitString = command?.split(" ") ?: error("Command was null")
            if(splitString[0] == value.prefix) {
                value.execute(splitString.toTypedArray())
                return true;
            }
        }
        return false
    }
}