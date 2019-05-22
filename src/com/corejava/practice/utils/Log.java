package com.corejava.practice.utils;

import java.text.MessageFormat;
import java.util.logging.Logger;

import com.corejava.practice.exceptions.InvalidOperationException;

public final class Log {

	private static final Logger logger = Logger.getLogger(Log.class.getSimpleName());
	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%4$s: %5$s %n");
	}
	private Log() {
		throw new InvalidOperationException("Object creation is not allowed.");
	}
	public static void logInfo(String pattern, Object...arguments) {

		MessageFormat format = new MessageFormat(pattern);
		String message = format.format(arguments);
		logger.info(message);
	}
	public static void logInfo(String message) {
		logger.info(message);
	}
}
