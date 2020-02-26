package me.jackgoldsworth.webapp.processor

import me.jackgoldsworth.webapp.command.Command
import me.jackgoldsworth.webapp.command.CommandParser
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.ElementKind
import javax.lang.model.element.TypeElement

@SupportedSourceVersion(SourceVersion.RELEASE_8)
class CommandProcessor : AbstractProcessor() {

    override fun process(annotations: MutableSet<out TypeElement>?, roundEnv: RoundEnvironment?): Boolean {
        roundEnv?.getElementsAnnotatedWith(RegisterCommand::class.java)?.forEach {
            if (it.kind == ElementKind.CLASS) {
                val className = it.simpleName
                val packageName = processingEnv.elementUtils.getPackageOf(it).toString()
                var commandClass = Class.forName(packageName + className).newInstance()
                if (commandClass is Command) {
                    CommandParser.commands[commandClass.getCommandPrefix()] = commandClass
                }
            }
        }
        return true
    }
}