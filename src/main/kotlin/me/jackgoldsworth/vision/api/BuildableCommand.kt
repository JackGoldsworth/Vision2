package me.jackgoldsworth.vision.api

class BuildableCommand(commandName: String, commandDesc: String?, function: Runnable?) : Command {

    override val run = function
    override val name = commandName
    override val description = commandDesc

    data class Builder(var name: String, var description: String? = null, var function: Runnable? = null) {
        fun description(description: String) = apply { this.description = description }
        fun function(function: Runnable) = apply { this.function = function }
        fun build() = BuildableCommand(name, description, function)
    }
}