package dev.s7a.sushi

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
