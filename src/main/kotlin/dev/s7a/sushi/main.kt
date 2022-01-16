@file:JvmName("Main")

package dev.s7a.sushi

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder

/**
 * Bot クライアント
 */
lateinit var bot: JDA
    private set

fun main() {
    bot = JDABuilder.createLight(Config.botToken).build()
}
