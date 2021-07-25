package ink.maxelbk.mxcl.core

import cc.sukazyo.restools.ResourcesPackage
import ink.maxelbk.mxcl.handler.Handlers
import ink.maxelbk.mxcl.ui.MainFrame
import ink.maxelbk.mxcl.ui.i18n
import ink.maxelbk.mxcl.ui.loadFiles
import java.awt.Font
import java.awt.GraphicsConfiguration
import java.awt.GraphicsEnvironment
import java.io.File
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.nio.file.Paths
import java.util.*
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.UIManager
import javax.swing.plaf.FontUIResource


object Main {
	val mainJarPath = this.javaClass.protectionDomain.codeSource.location
	val mainJarResources = ResourcesPackage(this.javaClass, "res")
	val configDirectory = getConfigDir()
	private lateinit var configuration: Config

	val config get() = configuration

	// Main function
	@JvmStatic
	fun main(args: Array<String>) {
		val startTime = System.currentTimeMillis()

		// 语言和国际化
		Handlers.log.debug("Default locale = ${Locale.getDefault()}")
		loadLanguage()

		//加载配置
		Handlers.log.debug("Config directory = ${configDirectory.path}")
		val configFilepath = configDirectory.resolve("config.json").canonicalPath
		configuration = Config(configFilepath)
		Handlers.log.info("Finish loading configuration")

		// 配置外观
		config.ui.imageBackground = ImageIcon(
			javaClass.getResource("/res/drawable/pic_background.jpg")).image
		configureSwing()

		//加载插件
		loadPlugins()
		//加载游戏版本
		loadGameVersions()

		//显示主窗口
		MainFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
		MainFrame.isVisible = true
		Handlers.log.debug("Main frame: isVisible = TRUE")
		Handlers.log.info(
			"MXCL started in ${(System.currentTimeMillis() - startTime) / 1000.0}s")
	}

	private fun loadLanguage() {
		//内置文件
		val jarDir = mainJarResources.getResDir("i18n")
		jarDir.listFiles().forEach {
			loadFiles(InputStreamReader(it.read(), StandardCharsets.UTF_8))
		}

		//外部文件
		val outDir = Paths.get(mainJarPath.toURI()).parent.resolve("i18n").toFile()
		outDir.listFiles()?.forEach {
			if (!it.isDirectory) loadFiles(it.reader(StandardCharsets.UTF_8))
		}
	}

	private fun configureSwing() {
		//加载主题风格
		Handlers.log.info("Configure look and feel...")
		val clazz = config.ui.classLookAndFeel
		UIManager.setLookAndFeel(clazz)
		Handlers.log.debug("Set LookAndFeel class: $clazz")

		//配置字体（若界面为英语则跳过）
		if (i18n("test") != "A") {
			val fontFamily = defaultFont
			val keys = UIManager.getDefaults().keys()
			while (keys.hasMoreElements()) {
				val key = keys.nextElement()
				val value = UIManager.get(key)
				if (value is FontUIResource) UIManager.put(
					key, FontUIResource(Font(fontFamily, value.style, value.size)))
			}
			Handlers.log.debug("Default font = $fontFamily")
		} else
			Handlers.log.debug("Default font not changed")
	}

	private fun loadGameVersions() {
	}

	private fun loadPlugins() {
	}

	val defaultFont: String get() {
		val availableFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().allFonts
		val fontNameSet = mutableSetOf<String>()
		availableFonts.forEach { fontNameSet.add(it.getFontName(Locale.US)) }

		val fallback = arrayOf(
			"Noto Sans CJK SC", "Source Han Sans SC", "PingFang SC", "Noto Sans CJK TC",
			"Source Han Sans TC", "PingFang TC", "Microsoft YaHei UI", "Microsoft YaHei",
			"Noto Sans", "Roboto SC")
		fallback.forEach {
			if (fontNameSet.contains(it) &&
				Font(it, 0, 0).canDisplay(i18n("test")[0])) return it
		}

		availableFonts.forEach { if (it.canDisplay(i18n("test")[0])) return it.fontName }

		return "Default"
	}

	private fun getConfigDir(): File {
		val os = System.getProperty("os.name").lowercase(Locale.US)
		return if (os.contains("windows")) {
			// Windows 系
			val dataDir = System.getenv("APPDATA")
			File(dataDir).resolve("MX Craft Launcher")
		} else if (os.contains("linux") || os.contains("solaris") || os.contains("bsd")) {
			// Unix 系
			val homeDir = System.getenv("HOME")
			File(homeDir).resolve(".config/mxcl")
		} else {
			//其他
			File(mainJarPath.toURI()).parentFile.resolve("MXCL")
		}
	}
}
