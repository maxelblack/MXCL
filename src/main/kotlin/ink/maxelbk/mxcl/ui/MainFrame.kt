package ink.maxelbk.mxcl.ui

import ink.maxelbk.mxcl.MXCL_VERSION
import ink.maxelbk.mxcl.i18n.i18n
import java.awt.Dimension
import javax.swing.JButton
import javax.swing.JFrame

object MainFrame : JFrame() {
	init {
//		title = i18n("mxcl.ui.main.title", MXCL_VERSION)
		title = "MXCL DEV-0.0.0"
		size = Dimension(700, 400)
		add(JButton("Click me"))
	}
}
