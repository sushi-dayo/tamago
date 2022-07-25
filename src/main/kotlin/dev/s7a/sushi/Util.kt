package dev.s7a.sushi

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.requests.restaction.MessageAction
import java.io.File

/**
 * resources/[fileName] からファイルをコピーする
 */
fun File.copyFromResource(fileName: String): Boolean {
    return ClassLoader.getSystemResourceAsStream(fileName)?.use {
        outputStream().use { output ->
            it.copyTo(output)
            output.flush()
        }
    } != null
}

/**
 * [EmbedBuilder] を使ってメッセージの返信をする
 */
inline fun Message.replyEmbed(action: EmbedBuilder.() -> Unit): MessageAction {
    return replyEmbeds(EmbedBuilder().apply(action).build())
}
