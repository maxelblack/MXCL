package ink.maxelbk.mxcl.util

import java.awt.GraphicsEnvironment
import java.awt.Rectangle
import java.awt.Window

fun getCentralPoint(width: Int, height: Int, parent: Window? = null): Rectangle {
	if (parent == null) {
		val mode = GraphicsEnvironment.getLocalGraphicsEnvironment()
			.defaultScreenDevice.displayMode
		return Rectangle(
			mode.width / 2 - width / 2,
			mode.height / 2 - height / 2,
			width, height
		)
	} else {
		return Rectangle(
			parent.x + parent.width / 2 - width / 2,
			parent.y + parent.height / 2 - height / 2,
			width, height
		)
	}
}