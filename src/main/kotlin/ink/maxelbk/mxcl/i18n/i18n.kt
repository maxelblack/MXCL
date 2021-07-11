package ink.maxelbk.mxcl.i18n

import java.io.Reader
import java.util.*

private val languageMap = linkedMapOf<String, Language>()

private var defaultTag = Locale.getDefault().toLanguageTag()
private var fallbackTag = Locale.ENGLISH.toLanguageTag()

fun loadFiles(vararg readers: Reader) {
	for (reader in readers) {
		val properties = Properties()
		properties.load(reader)
		val tag = Locale((properties["language"] ?: continue) as String).toLanguageTag()
		properties.remove("language")
		val lang = languageMap[tag] ?: Language(tag, hashMapOf())
		languageMap[tag] = lang
		properties.forEach { (k, v) -> lang.i18nMap[k.toString()] = v.toString() }
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

	val fuckingKotlinA = languageMap
	val fuckingKotlinB = defaultTag
	val fuckingKotlinC = fallbackTag
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
