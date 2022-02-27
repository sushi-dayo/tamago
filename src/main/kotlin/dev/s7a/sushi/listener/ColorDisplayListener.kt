package dev.s7a.sushi.listener

import dev.s7a.sushi.replyEmbed
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color

/**
 * カラーコードを送信したときの処理
 */
object ColorDisplayListener : ListenerAdapter() {
    private val colorCodeRegex = "#[0-9a-fA-F]{6}".toRegex()

    override fun onMessageReceived(event: MessageReceivedEvent) {
        val message = event.message
        val content = message.contentRaw
        if (content.matches(colorCodeRegex)) {
            message.replyEmbed {
                val url = "https://www.color-hex.com/color/" + content.drop(1)
                setTitle(content.uppercase(), url)
                setColor(Color.decode(content))
            }.mentionRepliedUser(false).queue()
        }
    }
}
