package ink.maxelbk.mxcl.ui

import javax.swing.JLabel

class MyLabel(key: String, vararg args: Any) : JLabel(i18n(key, args)), MyTextComponent {
	override val i18nKey = key

	override val i18nArgs = args

	override var componentText: String
		get() = text
		set(value) {text = value}

	init {
		addComponent(this)
	}
}
