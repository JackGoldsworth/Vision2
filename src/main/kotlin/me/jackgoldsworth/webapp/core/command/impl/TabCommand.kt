package me.jackgoldsworth.webapp.core.command.impl

import me.jackgoldsworth.webapp.core.command.Command
import me.jackgoldsworth.webapp.core.processor.RegisterCommand

@RegisterCommand
class TabCommand : Command() {

    override fun runCommand(args: List<String>, extras: Map<String, String>) {
        this.args = args
        this.extras = extras
        this.run()
    }

    override fun init() {
        this.commandName = "Open Tab"
    }

    override fun getCommandPrefix(): String {
        return "search"
    }

    override fun run() {
        if (args != null && extras != null) {
            val search = StringBuilder()
            for (i in 1 until args!!.size) {
                search.append(args!![i], " ")
            }
            val builder = ProcessBuilder(
                "cmd.exe", "/c", "start", "firefox $search"
            )
            builder.redirectErrorStream(true)
            builder.start()
        }
    }
}