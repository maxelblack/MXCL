package ink.maxelbk.mxcl.account

interface Account {
	val name: String
	val displayName: String
	val avatar: Avatar

	val typeName: String
	fun onAdd(): Boolean
	fun onDelete(): Boolean
	fun onLoginIn(): Boolean
	fun onLoginOut(): Boolean
}
