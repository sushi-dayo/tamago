@file:JvmName("Main")

package dev.s7a.sushi

import dev.s7a.sushi.listener.ColorDisplayListener
import dev.s7a.sushi.listener.RuleAcceptListener
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Bot クライアント
 */
lateinit var bot: JDA
    private set

/**
 * ロガー
 */
val logger: Logger = LoggerFactory.getLogger("Tamago")

fun main() {
    Config.printAll()
    bot = JDABuilder.createLight(Config.botToken).apply {
        addEventListeners(ColorDisplayListener)
        addEventListeners(RuleAcceptListener)
    }.build()
}
