package ink.maxelbk.mxcl.ui

import ink.maxelbk.mxcl.Default
import ink.maxelbk.mxcl.MXCL_VERSION_NAME
import ink.maxelbk.mxcl.i18n.i18n
import ink.maxelbk.mxcl.util.getCentralPoint
import java.awt.*
import javax.swing.JFrame

object MainFrame : JFrame() {
	init {
		title = i18n("mxcl/ui.main.title") + " [PRE VER $MXCL_VERSION_NAME]"
		bounds = getCentralPoint(840, 480)
		minimumSize = Dimension(790, 460)

		val container = contentPane
		container.layout = GridBagLayout()
		container.background = Default.ui.colorBackground

		MainCorePanel.background = Color(0, true)
		val constraintsCorePanel = GridBagConstraints()
		constraintsCorePanel.insets = Insets(12, 12, 12, 6)
		constraintsCorePanel.gridx = 0
		constraintsCorePanel.gridy = 0
		constraintsCorePanel.weightx = 20.0
		constraintsCorePanel.weighty = 100.0
		constraintsCorePanel.fill = GridBagConstraints.BOTH
		container.add(MainCorePanel, constraintsCorePanel)

		val constraintsUserPanel = GridBagConstraints()
		constraintsUserPanel.insets = Insets(12, 6, 12, 12)
		constraintsUserPanel.gridx = 1
		constraintsUserPanel.gridy = 0
		constraintsUserPanel.fill = GridBagConstraints.BOTH
		constraintsUserPanel.weightx = 20.0
		constraintsUserPanel.anchor = GridBagConstraints.EAST
		container.add(MainUserPanel, constraintsUserPanel)
	}
}
