package dev.s7a.sushi.listener

import dev.s7a.sushi.Config
import dev.s7a.sushi.bot
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

/**
 * ルールが書かれているメッセージにリアクションをつけた時の処理
 */
object RuleAcceptListener : ListenerAdapter() {
    private val ruleMessageId = Config.ruleMessageId
    private val memberRole by lazy {
        Config.memberRoleId?.let(bot::getRoleById) ?: error("MemberRoleId: ロールの取得に失敗しました")
    }

    override fun onMessageReactionAdd(event: MessageReactionAddEvent) {
        if (event.messageId == ruleMessageId) {
            memberRole.guild.addRoleToMember(event.userId, memberRole).queue()
        }
    }

    override fun onMessageReactionRemove(event: MessageReactionRemoveEvent) {
        if (event.messageId == ruleMessageId) {
            memberRole.guild.removeRoleFromMember(event.userId, memberRole).queue()
        }
    }
}
