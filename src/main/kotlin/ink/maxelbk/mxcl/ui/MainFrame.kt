package ink.maxelbk.mxcl.ui

import ink.maxelbk.mxcl.core.ConfigData
import ink.maxelbk.mxcl.MXCL_VERSION_NAME
import ink.maxelbk.mxcl.core.Main
import ink.maxelbk.mxcl.util.getCentralPoint
import java.awt.*
import javax.swing.ImageIcon
import javax.swing.JPanel
import kotlin.math.ceil

object MainFrame : MyFrame("mxcl/ui.main.title") {
	init {
		title = "$title [PRE VER $MXCL_VERSION_NAME]"
		bounds = getCentralPoint(840, 480)
		minimumSize = Dimension(790, 460)

		val container = MainPanel
		container.background = Main.config.ui.colorBackground
		contentPane.add(container)

		MainCorePanel.background = Color(0, true)
		val constraintsCorePanel = GridBagConstraints()
		constraintsCorePanel.insets = Insets(12, 12, 12, 6)
		constraintsCorePanel.gridx = 0
		constraintsCorePanel.gridy = 0
		constraintsCorePanel.weightx = 20.0
		constraintsCorePanel.weighty = 1.0
		constraintsCorePanel.fill = GridBagConstraints.BOTH
		container.add(MainCorePanel, constraintsCorePanel)

		val constraintsUserPanel = GridBagConstraints()
		constraintsUserPanel.insets = Insets(12, 6, 12, 12)
		constraintsUserPanel.gridx = 1
		constraintsUserPanel.gridy = 0
		constraintsUserPanel.fill = GridBagConstraints.BOTH
		constraintsUserPanel.weightx = 12.0
		constraintsUserPanel.anchor = GridBagConstraints.EAST
		container.add(MainUserPanel, constraintsUserPanel)
	}

	object MainPanel: JPanel(GridBagLayout()) {
		override fun paintComponent(g: Graphics?) {
			super.paintComponent(g)
			val image = Main.config.ui.imageBackground

			if (image != null) when(Main.config.ui.imageBackgroundMode) {
				ConfigData.UI_BGMODE_SCALE -> {
					val scaled = image.getScaledInstance(MainPanel.width, MainPanel.height, Image.SCALE_SMOOTH)
					g?.drawImage(scaled, 0, 0, ImageIcon(scaled).imageObserver)
				}
				ConfigData.UI_BGMODE_FILL -> {
					val imageIcon = ImageIcon(image)
					var widthOut = false

					var width = width
					var height = ceil(imageIcon.iconHeight.toDouble() / imageIcon.iconWidth * width).toInt()

					if (height < MainPanel.height) {
						widthOut = true
						height = MainPanel.height
						width = ceil(imageIcon.iconWidth.toDouble() / imageIcon.iconHeight * height).toInt()
					}

					val scaled = imageIcon.image.getScaledInstance(width, height, Image.SCALE_SMOOTH)
					if (widthOut) {
						val dx = (width - MainPanel.width) / 2
						g?.drawImage(scaled, -dx, 0, ImageIcon(scaled).imageObserver)
					} else {
						val dy = (height - MainPanel.height) / 2
						g?.drawImage(scaled, 0, -dy, ImageIcon(scaled).imageObserver)
					}
				}
			}
		}
	}
}
