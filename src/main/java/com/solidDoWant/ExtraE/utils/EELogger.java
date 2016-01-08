package com.solidDoWant.ExtraE.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solidDoWant.ExtraE.ExtraECore;

public class EELogger {
	private static Logger logger = LogManager.getLogger(ExtraECore.MODID);

	public static void log(Level level, String msg)
	{
		logger.log(level, msg);
	}

	public static void logInfo(String msg)
	{
		logger.info(msg);
	}

	public static void logWarn(String msg)
	{
		logger.warn(msg);
	}

	public static void logFatal(String msg)
	{
		logger.fatal(msg);
	}
}
