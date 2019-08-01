package me.jackgoldsworth.vision.commands

class CommandExecutor {

    var commandType = CommandType.CONSOLE

    fun listen() {
        //TODO: Console vs Voice commands.
    }

    enum class CommandType {
        CONSOLE, VOICE
    }
}