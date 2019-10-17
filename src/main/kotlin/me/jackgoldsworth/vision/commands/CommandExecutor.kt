package me.jackgoldsworth.vision.commands

/**
 * This class is responsible for executing commands.
 * @param commandHandler command handler to start commands.
 */
class CommandExecutor(private val commandHandler: CommandHandler) {

    private var commandType = CommandType.CONSOLE

    /**
     * Enters a permanent loop that listens for text via
     * Voice and console input.
     */
    fun listen() {
        while(true) {
            // TODO: Voice
            if(commandType == CommandType.CONSOLE) {
                println("Listening...")
                commandHandler.startCommand(readLine())
            }
        }
    }

    /**
     * The listening types.
     */
    enum class CommandType {
        CONSOLE, VOICE
    }
}