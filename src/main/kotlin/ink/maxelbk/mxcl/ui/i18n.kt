package ink.maxelbk.mxcl.ui

import ink.maxelbk.mxcl.handler.Handlers
import java.io.Reader
import java.util.*

private val languageMap = linkedMapOf<String, Language>()

private var defaultTag = Locale.getDefault().toString()
private var fallbackTag = Locale.ENGLISH.toString()

fun loadFiles(vararg readers: Reader) {
	for (reader in readers) {
		val properties = Properties()
		properties.load(reader)
		val tmpTag = (properties["language"] ?: continue) as String
		val locale = Locale.forLanguageTag(tmpTag)
		val tag = locale.toString()
		properties.remove("language")
		val lang = languageMap[tag] ?: Language(tag, hashMapOf())
		languageMap[tag] = lang
		properties.forEach { (k, v) -> lang.i18nMap[k.toString()] = v.toString() }
		Handlers.log.info("+Language: $tmpTag -> $tag")
	}
}

fun removeLanguage(tag: String): Language? {
	return languageMap.remove(tag)
}

fun setDefault(tag: String) {
	val locale = Locale(tag)
	Locale.setDefault(locale)
	defaultTag = locale.toLanguageTag()
}

fun setFallback(tag: String) {
	fallbackTag = Locale(tag).toLanguageTag()
}

fun getAll(): List<Language> {
	return languageMap.values.toList()
}

fun i18n(key: String, vararg args: Any): String {
	var isFallback = false

	val tmp = languageMap[defaultTag]
	val language = if (tmp == null) {
		isFallback = true
		languageMap[fallbackTag]!!
	} else tmp

	val string = language.i18nMap[key]
		?: if (isFallback) return key
		else languageMap[fallbackTag]!!.i18nMap[key]
			?: return key
	return String.format(string, args)
}
