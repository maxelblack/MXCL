package ink.maxelbk.mxcl.core

import cc.sukazyo.restools.ResourcesPackage
import ink.maxelbk.mxcl.handler.Handlers
import ink.maxelbk.mxcl.ui.MainFrame
import ink.maxelbk.mxcl.ui.i18n
import ink.maxelbk.mxcl.ui.loadFiles
import java.awt.Font
import java.awt.GraphicsEnvironment
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

	// Main function
	@JvmStatic
	fun main(args: Array<String>) {
		val startTime = System.currentTimeMillis()

		// 语言和国际化
		Handlers.log.info("Default Locale = ${Locale.getDefault()}")
		loadLanguage()

		// 配置外观
		Default.ui.imageBackground = ImageIcon(
			javaClass.getResource("/res/drawable/pic_background.jpg")).image
		configureSwing()

		//加载游戏版本
		loadGameVersions()

		//显示主窗口
		MainFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
		MainFrame.isVisible = true
		Handlers.log.info("Main frame: isVisible = TRUE")
		Handlers.log.info(
			"MXCL started in ${(System.currentTimeMillis() - startTime) / 1000.0}s")
	}

	private fun loadLanguage() {
		val jarDir = mainJarResources.getResDir("i18n")
		jarDir.listFiles().forEach {
			loadFiles(InputStreamReader(it.read(), StandardCharsets.UTF_8))
		}

		val outDir = Paths.get(mainJarPath.toURI()).parent.resolve("i18n").toFile()
		outDir.listFiles()?.forEach {
			if (!it.isDirectory) loadFiles(it.reader(StandardCharsets.UTF_8))
		}
	}

	private fun configureSwing() {
		// Load look and feel
		Handlers.log.info("Configure look and feel...")
		val clazz = Default.ui.classLookAndFeel
		UIManager.setLookAndFeel(clazz)
		Handlers.log.info("Set LookAndFeel class: $clazz")

		// Configure font
		if (i18n("test") != "A") {
			val fontFamily = defaultFont
			val keys = UIManager.getDefaults().keys()
			while (keys.hasMoreElements()) {
				val key = keys.nextElement()
				val value = UIManager.get(key)
				if (value is FontUIResource) UIManager.put(
					key, FontUIResource(Font(fontFamily, value.style, value.size)))
			}
			Handlers.log.info("Default font = $fontFamily")
		} else
			Handlers.log.info("Default font not changed")
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
}
