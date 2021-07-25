package ink.maxelbk.mxcl.handler

import java.io.PrintStream
import java.util.*

open class LogHandler(
	var debug: PrintStream = System.out,
	var info: PrintStream = System.out,
	var error: PrintStream = System.err
) {

	open fun debug(message: String) {
		debug.println("[$date][D] $message")
	}

	open fun info(message: String) {
		info.println("[$date][I] $message")
	}

	open fun warn(message: String) {
		info.println("[$date][W] $message")
	}

	open fun error(message: String) {
		error.println("[$date][E] $message")
	}

	private val date: String get() {
		val d = Date()
		return String.format("%tF %tT.%tL", d, d, d)
	}
}
