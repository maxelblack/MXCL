package ink.maxelbk.mxcl

import ink.maxelbk.mxcl.ui.MainFrame
import javax.swing.UIManager

object Main {

	// Main function
	@JvmStatic
	fun main(args: Array<String>) {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel")

		MainFrame.isVisible = true
	}
}
