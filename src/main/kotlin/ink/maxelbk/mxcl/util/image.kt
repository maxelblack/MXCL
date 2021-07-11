package ink.maxelbk.mxcl.util

import java.awt.Image
import javax.swing.ImageIcon

fun scaleIcon(icon: ImageIcon, size: Int, mode: Int = Image.SCALE_SMOOTH): ImageIcon {
	val image = icon.image
	val result = image.getScaledInstance(size, size, mode)
	return ImageIcon(result)
}