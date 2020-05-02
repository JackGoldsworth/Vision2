package me.jackgoldsworth.webapp.core.command.impl

import me.jackgoldsworth.webapp.core.SpotifyRequests
import me.jackgoldsworth.webapp.core.command.Command
import me.jackgoldsworth.webapp.core.processor.RegisterCommand
import me.jackgoldsworth.webapp.model.TaskInfo

@RegisterCommand
class PlaySongCommand: Command() {

    override fun runCommand(args: List<String>, extras: Map<String, String>) {
        this.args = args
        this.extras = extras
        this.run()
    }

    override fun init() {
        this.commandName = "Play Song"
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
            val track = SpotifyRequests.setTrack(songName.toString(), extras!!["auth"] ?: error("Auth was null"))
            val map = HashMap<String, String>()
            map["name"] = track.name
            map["artist"] = track.artist
            map["image"] = track.imageUrl
            this.taskInfo = TaskInfo("Play Song Command", map)
        }
    }
}