package me.jackgoldsworth.vision.commands.spotify

import me.jackgoldsworth.vision.api.Command

class TrackCommand : Command() {

    init {
        this.name = "Track"
        this.description = "Does different functions with Spotify tracks."
        this.usage = "track <play <name>> <stop | pause>"
    }

    override fun execute(args: Array<String>) {
        TODO("not implemented")
    }
}