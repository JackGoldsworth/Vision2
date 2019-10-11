package me.jackgoldsworth.vision.commands.spotify

import com.wrapper.spotify.SpotifyApi
import me.jackgoldsworth.vision.api.Command

class TrackCommand(api: SpotifyApi) : Command() {

    init {
        this.name = "Track"
        this.description = "Does different functions with Spotify tracks."
        this.usage = "track <play <name>> <stop | pause>"
    }

    override fun execute(args: Array<String>) {
        TODO("not implemented")
    }
}