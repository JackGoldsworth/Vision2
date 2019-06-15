package me.jackgoldsworth.vision.commands

class CommandExecutor {

    var commandType = CommandType.CONSOLE

    fun listen() {
        if (commandType === CommandType.CONSOLE) {

        } else {

        }
    }

    enum class CommandType {
        CONSOLE, VOICE
    }
}