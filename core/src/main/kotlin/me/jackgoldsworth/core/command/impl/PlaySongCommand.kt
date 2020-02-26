package me.jackgoldsworth.core.command.impl

import me.jackgoldsworth.core.SpotifyRequests
import me.jackgoldsworth.core.command.Command

class PlaySongCommand: Command() {

    var args: List<String>? = null
    var extras: Map<String, String>? = null

    override fun runCommand(args: List<String>, extras: Map<String, String>) {
        this.args = args
        this.extras = extras
        this.run()
    }

    override fun getCommandPrefix(): String {
        return "Spotify play"
    }

    override fun run() {
        if(args != null && extras != null) {
            val songName = StringBuilder()
            for (i in 2 until args!!.size) {
                songName.append(args!![i], " ")
            }
            SpotifyRequests.setTrack(songName.toString(), extras!!["key"] ?: error("Auth was null"))
        }
    }
}