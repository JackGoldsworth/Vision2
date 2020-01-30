package me.jackgoldsworth.webapp.command.impl

import me.jackgoldsworth.webapp.SpotifyRequests
import me.jackgoldsworth.webapp.command.Command
import me.jackgoldsworth.webapp.command.CommandParser
import me.jackgoldsworth.webapp.command.ImageProvider

@Command.Register("Play Song", "Plays a song")
class PlaySongCommand(parser: CommandParser) : Command(parser), ImageProvider {

    lateinit var img: String
    private val args = parser.command.split(" ")

    override fun run() {
        val songName = StringBuilder()
        for (i in 2 until args.size) {
            songName.append(args[i], " ")
        }
        SpotifyRequests.setTrack(songName.toString(),parser.auth ?: error("Auth was null"))
    }

    override fun getImage(): String {
        return img
    }
}