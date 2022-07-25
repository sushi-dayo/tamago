@file:JvmName("Main")

package dev.s7a.sushi

import dev.s7a.sushi.listener.ColorDisplayListener
import dev.s7a.sushi.listener.MessagePreviewListener
import dev.s7a.sushi.listener.RuleAcceptListener
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.requests.GatewayIntent
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
    bot = JDABuilder.create(Config.botToken, GatewayIntent.GUILD_MESSAGES).apply {
        addEventListeners(ColorDisplayListener)
        addEventListeners(RuleAcceptListener)
        addEventListeners(MessagePreviewListener)
    }.build()
}
