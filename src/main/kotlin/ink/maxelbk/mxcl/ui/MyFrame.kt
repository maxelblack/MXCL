package ink.maxelbk.mxcl.ui

import javax.swing.JFrame

open class MyFrame(key: String, vararg args: Any) : JFrame(i18n(key, args)), MyTextComponent {
	override val i18nArgs = args

	override val i18nKey = key

	override var componentText: String
		get() = title
		set(value) {title = value}

	init {
		addComponent(this)
	}
}
