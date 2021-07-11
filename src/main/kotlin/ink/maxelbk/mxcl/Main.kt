package ink.maxelbk.mxcl

import cc.sukazyo.restools.ResourcesPackage
import ink.maxelbk.mxcl.i18n.loadFiles
import ink.maxelbk.mxcl.ui.MainFrame
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.nio.file.Paths
import javax.swing.JFrame
import javax.swing.UIManager

object Main {
	val mainJarPath = this.javaClass.protectionDomain.codeSource.location
	val mainJarResources = ResourcesPackage(this.javaClass, "res")

	// Main function
	@JvmStatic
	fun main(args: Array<String>) {

		loadLanguage()

		// 配置和打开窗口
		UIManager.setLookAndFeel(Default.ui.classLookAndFeel)

//		setDefault(Locale.SIMPLIFIED_CHINESE.toLanguageTag())

		MainFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
		MainFrame.isVisible = true
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

	private fun loadPlugins() {
	}
}
