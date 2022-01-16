package dev.s7a.sushi.properties

import dev.s7a.sushi.copyFromResource
import java.io.File
import java.util.Properties

/**
 * [Properties] を簡単に操作する
 */
open class PropertiesFile(fileName: String) {
    private val file = File(fileName)
    private var properties: Properties

    init {
        if (file.exists().not()) {
            file.createNewFile()
            file.copyFromResource(fileName)
        }
        properties = Properties().apply { load(file.inputStream()) }
    }

    /**
     * 委譲を使ったデータ定義
     *
     * @param key value key
     */
    fun string(key: String) = PropertiesValue(properties, key)
}
