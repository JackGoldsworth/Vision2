package me.jackgoldsworth.webapp.command.impl

import me.jackgoldsworth.webapp.SpotifyRequests
import me.jackgoldsworth.webapp.command.Command

class PlaySongCommand(args: List<String>, private val auth: String) : Command("Play Song", "Plays a song", args) {

    override fun run() {
        val songName = args[2] + " " + args[3] // temp solution
        SpotifyRequests.setTrack(songName, auth)
    }
}