package ink.maxelbk.mxcl.handler

import ink.maxelbk.mxcl.i18n.i18n
import java.awt.Window

open class DialogHandler {
	open fun showMessageDialog(
		message: String = i18n("mxcl/ui.default.dialog-text"),
		title: String = i18n("mxcl/ui.default.dialog-title"),
		isModel: Boolean = true,
		parent: Window? = null
	) {
		TODO()
	}
}
