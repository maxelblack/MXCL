package ink.maxelbk.mxcl.ui

import javax.swing.JButton

open class MyButton(key: String, vararg args: Any) : JButton(i18n(key, args)), MyTextComponent {
	override val i18nArgs = args

	override val i18nKey = key

	override var componentText: String
		get() = text
		set(value) {text = value}

	init {
		addComponent(this)
	}
}
