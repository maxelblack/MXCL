package ink.maxelbk.mxcl.ui

import ink.maxelbk.mxcl.account.Account
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.GridBagLayout
import javax.swing.Box
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JSeparator

object UserDialog : MyDialog(MainFrame, key = "mxcl/ui.user.title") {
	private val mainBox = Box.createVerticalBox()

	private val userMap = linkedMapOf<String, AccountPanel>()

	init {
		minimumSize = Dimension(520, 280)
		val scrollPane = JScrollPane(mainBox)
		contentPane.add(scrollPane, BorderLayout.CENTER)
		scrollPane.horizontalScrollBarPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
		scrollPane.verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
	}

	fun addAccount(account: Account) {
		val accountPanel = AccountPanel(account)
		if (userMap.isNotEmpty()) mainBox.add(JSeparator(JSeparator.VERTICAL))
		mainBox.add(accountPanel.panel)
	}

	class AccountPanel(val account: Account) {
		val panel: JPanel get() {
			val tmp = JPanel(GridBagLayout())
			//TODO 组件创建和布局调整
			return tmp
		}
	}
}
