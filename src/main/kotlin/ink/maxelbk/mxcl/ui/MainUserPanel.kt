package ink.maxelbk.mxcl.ui

import ink.maxelbk.mxcl.core.Default
import ink.maxelbk.mxcl.util.scaleIcon
import java.awt.BorderLayout
import java.awt.Image
import javax.swing.*

object MainUserPanel : JPanel(BorderLayout()) {
	val buttonChangeUser = MyButton("mxcl/ui.main.button.change-user")

	val labelUserName = JLabel("Username")
	val labelUserAccount = JLabel("username@account.com")
	val labelUserHeadIcon = JLabel(scaleIcon(ImageIcon(
		javaClass.getResource("/res/drawable/pic_head_steve.jpeg")),
		80, Image.SCALE_FAST))

	init {
		background = Default.ui.colorPanelBackground
		val mainBox = Box.createVerticalBox()
		add(mainBox)

		labelUserName.font = labelUserName.font.deriveFont(24f)
		labelUserName.alignmentX = Box.CENTER_ALIGNMENT
		labelUserAccount.font = labelUserAccount.font.deriveFont(15f)
		labelUserAccount.alignmentX = Box.CENTER_ALIGNMENT
		labelUserHeadIcon.alignmentX = Box.CENTER_ALIGNMENT
		buttonChangeUser.alignmentX = Box.CENTER_ALIGNMENT

		mainBox.add(Box.createVerticalStrut(36))
		mainBox.add(labelUserName)
		mainBox.add(labelUserAccount)
		mainBox.add(Box.createVerticalGlue())
		mainBox.add(labelUserHeadIcon)
		mainBox.add(Box.createVerticalGlue())
		mainBox.add(buttonChangeUser)
		mainBox.add(Box.createVerticalStrut(50))

	}
}
