package me.jackgoldsworth.webapp.command.impl

import me.jackgoldsworth.webapp.SpotifyRequests
import me.jackgoldsworth.webapp.command.Command

class PlaySongCommand(args: List<String>, private val auth: String) : Command("Play Song", "Plays a song", args) {

    override fun run() {
        val songName = StringBuilder()
        for (i in 2 until args.size) {
            songName.append(args[i], " ")
        }
        SpotifyRequests.setTrack(songName.toString(), auth)
    }
}