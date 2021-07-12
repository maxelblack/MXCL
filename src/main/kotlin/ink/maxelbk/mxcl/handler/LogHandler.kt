package ink.maxelbk.mxcl.handler

import java.io.PrintStream
import java.util.*

open class LogHandler(
	var info: PrintStream = System.out,
	var warn: PrintStream = System.out,
	var error: PrintStream = System.err
) {

	open fun info(message: String) {
		info.println("[$date][I] $message")
	}

	open fun warn(message: String) {
		warn.println("[$date][W] $message")
	}

	open fun error(message: String) {
		error.println("[$date][E] $message")
	}

	private val date: String get() {
		val d = Date()
		return String.format("%tF %tT.%tL", d, d, d)
	}
}
