package me.jackgoldsworth.webapp.processor

import com.google.auto.service.AutoService
import me.jackgoldsworth.webapp.command.Command
import me.jackgoldsworth.webapp.command.CommandParser
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.ElementKind
import javax.lang.model.element.TypeElement

@AutoService(Processor::class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
class CommandProcessor : AbstractProcessor() {

    override fun process(annotations: MutableSet<out TypeElement>?, roundEnv: RoundEnvironment?): Boolean {
        roundEnv?.getElementsAnnotatedWith(Command.Register::class.java)?.forEach {
            if(it.kind == ElementKind.CLASS) {
                CommandParser.registerCommand("", it.enclosingElement::class.java.newInstance() as Command)
            }
        }
        return true
    }
}