package me.jackgoldsworth.core.utils

/**
 * @author Jack Goldsworth
 * @since v0.1
 */
object StringUtils {

    /**
     * Checks if two strings are equals with using ignore
     * case always true.
     * @return equals with ignore case.
     */
    fun equals(str1: String, str2: String): Boolean {
        return str1.equals(str2, ignoreCase = true)
    }
}