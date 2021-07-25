package ink.maxelbk.mxcl.core

import java.awt.Color
import java.awt.Image

data class ConfigData(
	val ui: UIData = UIData()
) {
	data class UIData(
		var classLookAndFeel: String = "mdlaf.MaterialLookAndFeel",
		var imageBackground: Image? = null,
		var imageBackgroundMode: Int = UI_BGMODE_FILL,

		var colorBackground: Color = Color(0xB4, 0xFF, 0xFF, 0xFF),
		var colorPanelBackground: Color = Color(255, 255, 255, 0xAF),

		var showInfoPanel: Boolean = false,
	)

	//TODO CoreDefault class

	companion object {
		val UI_BGMODE_FILL = 0
		val UI_BGMODE_SCALE = 1
	}
}
