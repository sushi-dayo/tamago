package dev.s7a.sushi.listener

import dev.s7a.sushi.replyEmbed
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color

/**
 * メッセージリンクの内容を表示する
 */
object MessagePreviewListener : ListenerAdapter() {
    private val discordUrlRegex = "https://(ptb.|canary.)?discord(app)?.com/channels/(\\d+)/(\\d+)/(\\d+).*".toRegex()

    override fun onMessageReceived(event: MessageReceivedEvent) {
        val message = event.message
        val result = discordUrlRegex.find(message.contentRaw)
        if (result != null) {
            val groups = result.groupValues
            val guildId = groups[3]
            val channelId = groups[4]
            val messageId = groups[5]
            if (event.guild.id != guildId) return
            message.replyPreview(channelId, messageId)
        }
    }

    private fun Message.replyPreview(channelId: String, messageId: String) {
        val channel = guild.getTextChannelById(channelId) ?: return
        channel.retrieveMessageById(messageId).queue {
            val content = it.contentDisplay
            val author = it.author
            val jumpUrl = it.jumpUrl
            val imageUrl = it.attachments.firstOrNull()?.url
            val channelName = it.channel.name
            val timeCreated = it.timeCreated
            replyEmbed {
                setDescription(content)
                setColor(Color.LIGHT_GRAY)
                setAuthor(author.name, jumpUrl, author.avatarUrl)
                setImage(imageUrl)
                setFooter("#$channelName")
                setTimestamp(timeCreated)
            }.mentionRepliedUser(false).queue()
        }
    }
}
