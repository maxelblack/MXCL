package ink.maxelbk.mxcl.core

import java.awt.Color
import java.awt.Image

object Default {
	const val UI_BGMODE_FILL = 0
	const val UI_BGMODE_SCALE = 1

	object ui {
		var classLookAndFeel = "mdlaf.MaterialLookAndFeel"
		var imageBackground: Image? = null
		var imageBackgroundMode = UI_BGMODE_FILL

		var colorBackground = Color(0xB4, 0xFF, 0xFF, 0xFF)
		var colorPanelBackground = Color(255, 255, 255, 0xAF)

		var showInfoPanel = false
	}
}
