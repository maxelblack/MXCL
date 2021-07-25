package ink.maxelbk.mxcl.ui

import java.awt.Window
import javax.swing.JDialog

open class MyDialog(owner: Window? = null, modal: Boolean = true, key: String, vararg args: Any) : JDialog(owner, i18n(key, args)), MyTextComponent {
	init {
		isModal = modal
	}

	override val i18nArgs = args

	override val i18nKey = key

	override var componentText: String
		get() = title
		set(value) {title = value}

	init {
		addComponent(this)
	}
}
