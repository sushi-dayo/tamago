package dev.s7a.sushi

import dev.s7a.sushi.properties.PropertiesFile

/**
 * コンフィグ
 */
object Config : PropertiesFile("config.properties") {
    /**
     * 表示する
     */
    fun printAll() {
        logger.debug("BotToken: ${if (botToken != null) "*****" else ""}")
        logger.debug("RuleMessageId: $ruleMessageId")
        logger.debug("MemberRoleId: $memberRoleId")
    }

    /**
     * Discord Bot のトークン
     */
    val botToken by string("BotToken")

    /**
     * ルールが書かれているメッセージのID
     */
    val ruleMessageId by string("RuleMessageId")

    /**
     * メンバーのロールID
     */
    val memberRoleId by string("MemberRoleId")
}
