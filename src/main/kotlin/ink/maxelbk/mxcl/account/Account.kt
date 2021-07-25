package ink.maxelbk.mxcl.account

import javax.swing.ImageIcon

interface Account {
	val name: String
	var displayName: String
	var avatar: Avatar

	val typeI18nKey: String
	val typeIcon: ImageIcon
	val avatarChangeable: Boolean

	fun onAdd(): Boolean
	fun onDelete(): Boolean
	fun onActivate(): Boolean
	fun onDeactivate(): Boolean
}
