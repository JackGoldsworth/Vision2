package me.jackgoldsworth.core.command.impl

import me.jackgoldsworth.core.command.Command
import me.jackgoldsworth.core.processor.RegisterCommand
import me.jackgoldsworth.core.utils.SpeechUtils

@RegisterCommand
class SpeechCommand : Command() {

    override fun runCommand(args: List<String>, extras: Map<String, String>) {
        this.args = args
        this.extras = extras
        this.run()
    }

    override fun init() {
        this.commandName = "Speech Enable"
    }

    override fun getCommandPrefix(): String {
        return "speech on"
    }

    override fun run() {
        SpeechUtils.runSpeech()
    }
}