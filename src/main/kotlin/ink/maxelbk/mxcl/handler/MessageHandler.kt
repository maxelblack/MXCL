package ink.maxelbk.mxcl.handler

import ink.maxelbk.mxcl.ui.i18n
import java.awt.Window

open class MessageHandler {
	open fun showMessage(
		message: String = i18n("mxcl/ui.default.dialog-text"),
		title: String = i18n("mxcl/ui.default.dialog-title"),
		isModel: Boolean = true,
		parent: Window? = null
	) {
		TODO()
	}
}
