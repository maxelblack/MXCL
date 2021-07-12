package ink.maxelbk.mxcl.ui

private val textComponents = arrayListOf<MyTextComponent>()

fun flushText() {
	textComponents.forEach { flushText(it) }
}

fun flushText(component: MyTextComponent) {
	component.componentText = i18n(component.i18nKey, component.i18nArgs)
}

fun addComponent(component: MyTextComponent) {
	textComponents.add(component)
}
