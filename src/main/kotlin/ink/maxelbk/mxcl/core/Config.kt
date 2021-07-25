package ink.maxelbk.mxcl.core

import com.google.gson.Gson
import java.io.*

class Config(private val filepath: String) {
	lateinit var ui: ConfigData.UIData

	private val gson = Gson()

	init {
		val file = File(filepath)
		if (file.isFile) load()
		else {
			configure(ConfigData())
		}
	}

	fun load() {
		val reader = InputStreamReader(FileInputStream(filepath), Charsets.UTF_8)
		val config: ConfigData = gson.fromJson(reader, ConfigData::class.java)
		configure(config)
	}

	fun save() {
		val json = gson.toJson(ConfigData(ui))
		val writer = File(filepath).bufferedWriter(Charsets.UTF_8)
		writer.append(json)
		writer.flush()
		writer.close()
	}

	private fun configure(config: ConfigData) {
		ui = config.ui
		//TODO More config value
	}
}
