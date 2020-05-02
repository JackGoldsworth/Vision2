package me.jackgoldsworth.webapp.core.command.impl

import me.jackgoldsworth.webapp.core.command.Command
import me.jackgoldsworth.webapp.core.processor.RegisterCommand
import me.jackgoldsworth.webapp.core.utils.SpeechUtils

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