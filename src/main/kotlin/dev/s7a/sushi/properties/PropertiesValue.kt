package dev.s7a.sushi.properties

import java.util.Properties
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * [Properties] から値を取り出す
 *
 * @see PropertiesFile.string
 */
class PropertiesValue(private val properties: Properties, private val key: String) : ReadWriteProperty<Any?, String?> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): String? {
        return properties.getProperty(key).ifBlank { null } ?: System.getenv("Tamago$key")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) {
        if (value.isNullOrEmpty()) {
            properties.remove(key)
        } else {
            properties.setProperty(key, value)
        }
    }
}
