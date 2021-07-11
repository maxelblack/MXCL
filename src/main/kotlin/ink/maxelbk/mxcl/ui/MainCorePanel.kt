package ink.maxelbk.mxcl.ui

import ink.maxelbk.mxcl.Default
import ink.maxelbk.mxcl.i18n.i18n
import ink.maxelbk.mxcl.util.scaleIcon
import java.awt.*
import javax.swing.ImageIcon
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel

object MainCorePanel : JPanel() {
	val buttonLaunch = JButton(" ${i18n("mxcl/ui.main.button.launch")}")
	val buttonMenu = JButton(i18n("mxcl/ui.main.button.menu"))
	val buttonDownload = JButton(i18n("mxcl/ui.main.button.download"))

	val labelVersionName = JLabel("VERSION")

	init {
		layout = GridBagLayout()
		val constraints: GridBagConstraints?

		val panelMenuBar = JPanel(GridLayout(1, 4))
		panelMenuBar.background = Color(0, true)
		constraints = GridBagConstraints(
			0, 0, 1, 1,
			1.0, 20.0,
			GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
			Insets(0, 0, 6, 0),
			0, 0
		)
		add(panelMenuBar, constraints)

		buttonMenu.icon = scaleIcon(ImageIcon(
			javaClass.getResource("/res/drawable/ic_menu_48px.png")),
			buttonMenu.font.size)
		panelMenuBar.add(buttonMenu)
		buttonDownload.icon = scaleIcon(ImageIcon(
			javaClass.getResource("/res/drawable/ic_download_32px.png")),
			buttonDownload.font.size)
		panelMenuBar.add(buttonDownload)

		constraints.gridy = 1; constraints.anchor = GridBagConstraints.CENTER
		constraints.weighty = -1.0; constraints.fill = GridBagConstraints.BOTH
		constraints.insets = Insets(6, 0, 6, 0)
		add(GameInfoPanel, constraints)

		constraints.gridy = 2; constraints.anchor = GridBagConstraints.SOUTH
		constraints.weighty = 2.0; constraints.fill = GridBagConstraints.BOTH
		constraints.insets = Insets(6, 0, 0, 0)
		buttonLaunch.font = buttonLaunch.font.deriveFont(16f)
		buttonLaunch.icon = scaleIcon(ImageIcon(
				javaClass.getResource("/res/drawable/ic_mcpickaxe_96px.png")),
			buttonLaunch.font.size * 2, Image.SCALE_REPLICATE)
		add(buttonLaunch, constraints)
	}

	object GameInfoPanel : JPanel(GridBagLayout()) {
		init {
			background = Default.ui.colorPanelBackground
			labelVersionName.font = labelVersionName.font.deriveFont(20f)
			add(labelVersionName)
			//TODO 添加 GridBag 规则
		}
	}
}
