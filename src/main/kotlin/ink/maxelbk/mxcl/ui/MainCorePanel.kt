package ink.maxelbk.mxcl.ui

import ink.maxelbk.mxcl.core.Default
import ink.maxelbk.mxcl.util.scaleIcon
import java.awt.*
import javax.swing.*

object MainCorePanel : JPanel() {
	val buttonLaunch = MyButton("mxcl/ui.main.button.launch")
	val buttonMenu = MyButton("mxcl/ui.main.button.menu")
	val buttonDownload = MyButton("mxcl/ui.main.button.download")
	val buttonSettings = MyButton("mxcl/ui.main.button.settings")

	val labelVersionName = JLabel("VERSION")
	val labelVersionDescription = JLabel("This is description text.")

	init {
		layout = GridBagLayout()
		val constraints: GridBagConstraints?

		val panelMenuBar = JPanel(GridLayout(1, 4))
		panelMenuBar.background = Color(0, true)
		constraints = GridBagConstraints(
			0, 0, 1, 1,
			1.0, 16.0,
			GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
			Insets(0, 0, 6, 0),
			0, 0
		)
		add(panelMenuBar, constraints)

		buttonMenu.icon = scaleIcon(ImageIcon(
			javaClass.getResource("/res/drawable/ic_menu_48px.png")),
			buttonMenu.font.size + 1)
		panelMenuBar.add(buttonMenu)
		buttonDownload.icon = scaleIcon(ImageIcon(
			javaClass.getResource("/res/drawable/ic_download_32px.png")),
			buttonDownload.font.size + 1)
		panelMenuBar.add(buttonDownload)
		buttonSettings.icon = scaleIcon(
			ImageIcon(
			javaClass.getResource("/res/drawable/ic_settings_48px.png")),
			buttonSettings.font.size + 1)
		panelMenuBar.add(buttonSettings)

		constraints.gridy = 1; constraints.anchor = GridBagConstraints.CENTER
		constraints.weighty = -1.0; constraints.fill = GridBagConstraints.BOTH
		constraints.insets = Insets(6, 0, 6, 0)
		add(GameInfoPanel, constraints)

		constraints.gridy = 2; constraints.anchor = GridBagConstraints.SOUTH
		constraints.weighty = 0.6; constraints.fill = GridBagConstraints.BOTH
		constraints.insets = Insets(6, 0, 0, 0)
		buttonLaunch.font = buttonLaunch.font.deriveFont(16f)
		buttonLaunch.icon = scaleIcon(ImageIcon(
				javaClass.getResource("/res/drawable/ic_mcpickaxe_96px.png")),
			buttonLaunch.font.size * 2, Image.SCALE_REPLICATE)
		add(buttonLaunch, constraints)
	}

	object GameInfoPanel : JPanel() {
		init {
			val mainBox = Box.createVerticalBox()
			background = Default.ui.colorPanelBackground
			add(mainBox)

			labelVersionName.font = labelVersionName.font.deriveFont(20f)
			labelVersionName.horizontalAlignment = JLabel.CENTER
			labelVersionName.alignmentX = 0.5f
			mainBox.add(labelVersionName)

			labelVersionDescription.font = labelVersionDescription.font.deriveFont(13f)
			labelVersionDescription.horizontalAlignment = JLabel.CENTER
			labelVersionDescription.alignmentX = 0.5f
			mainBox.add(labelVersionDescription)
		}
	}
}
