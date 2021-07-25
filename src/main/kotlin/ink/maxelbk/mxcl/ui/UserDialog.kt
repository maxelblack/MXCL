package ink.maxelbk.mxcl.ui

import ink.maxelbk.mxcl.account.Account
import javax.swing.Box
import javax.swing.JScrollPane
import javax.swing.JSeparator

object UserDialog : MyDialog(MainFrame, key = "mxcl/ui.user.title") {
	private val mainBox = Box.createVerticalBox()

	private val userMap = linkedMapOf<String, AccountBox>()

	init {
		val scrollPane = JScrollPane(mainBox)
		contentPane.add(scrollPane)
		scrollPane.horizontalScrollBarPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
		scrollPane.verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
	}

	fun addAccount(account: Account) {
		val accountBox = AccountBox(account)
		if (userMap.isNotEmpty()) mainBox.add(JSeparator(JSeparator.VERTICAL))
		mainBox.add(accountBox.box)
	}

	class AccountBox(val account: Account) {
		val box: Box? get() {
			return if (account.onLoginIn()) {
				val tmpBox = Box.createHorizontalBox()

				tmpBox
			} else null
		}
	}
}
