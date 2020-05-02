package me.jackgoldsworth.webapp.core.utils

/**
 * @author Jack Goldsworth
 * @since v0.1
 */
object SpeechUtils {

    val path = ClassLoader.getSystemResource("speech.py").path.substring(1)

    /**
     * Runs the python file to recognize speech
     * and send it as a command.
     */
    fun runSpeech() {
        val builder = ProcessBuilder(
            "cmd.exe", "/c", "python $path"
        )
        builder.redirectErrorStream(true)
        builder.start()
    }
}