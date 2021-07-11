package ink.maxelbk.mxcl.i18n

import java.io.Reader
import java.util.Locale

private val languageMap = linkedMapOf<String, Language>()
private var defaultTag = Locale.getDefault().toLanguageTag()

fun loadFile(reader: Reader) {
	TODO()
}

fun removeLanguage(tag: String): Language? {
	return languageMap.remove(tag)
}

fun setDefault(tag: String) {
	Locale.setDefault(Locale(tag))
	defaultTag = tag
}

fun getAll(): List<Language> {
	return languageMap.values.toList()
}

fun i18n(key: String, args: Any): String {
	val string = languageMap[defaultTag]!!.i18nMap[key] ?: return key
	return String.format(string, args)
}
