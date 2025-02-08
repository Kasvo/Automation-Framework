package com.test.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.test.actiondrivers.BrowserAction;
import com.test.base.BaseClass;

public class Log {

	// Initialize Log4j logs
	public static Logger Log = LogManager.getLogger("Logs");

	public static void startTestCase(String sTestCaseName) {
		Log.info("=====================================" + sTestCaseName
				+ " TEST START=========================================");
	}

	public static void endTestCase(String sTestCaseName) {
		Log.info("=====================================" + sTestCaseName
				+ " TEST END=========================================");
	}

	// Need to create below methods, so that they can be called

	public static void info(String message) {

		Log.info(message);
		ExtentManager.test.log(Status.INFO, message);

	}
	
	public static void info(String message , WebDriver driver) {
		BrowserAction ba = new BrowserAction();
		Log.info(message);
		String imgPath = ba.screenShot(driver, "ScreenShot");
		ExtentManager.test.log(Status.INFO,message,MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());

	}

	public static void warn(String message) {

		Log.warn(message);
		ExtentManager.test.log(Status.WARNING, message);

	}

	public static void error(String message) {

		Log.error(message);
		ExtentManager.test.log(Status.WARNING, message);

	}

	public static void fatal(String message) {
	
		Log.fatal(message);
		ExtentManager.test.log(Status.FAIL, message);

	}

	public static void debug(String message) {

		Log.debug(message);
		ExtentManager.test.log(Status.INFO, message);
		

	}

}
