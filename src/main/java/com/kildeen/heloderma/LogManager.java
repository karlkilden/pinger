package com.kildeen.heloderma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Static helper for getting a slf4j logger. This is is adapted from the log4j2 source code.
 *
 * @author: Karl Kilden
 *
 *
 */
public class LogManager {

	private LogManager() {
	}

	public static Logger getLogger() {
		return LoggerFactory.getLogger(new Throwable().getStackTrace()[1].getClassName());
	}

}
