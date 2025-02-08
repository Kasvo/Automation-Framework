package com.test.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
 
public class ExtentManager {
	
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() {
		
		htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/Report/ExtentReport/"+"MyReport.html");
		
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("Simple Test");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "ShopHighLine");
		extent.setSystemInfo("OS", "Win11");

	}
	public static void endReport() {
		extent.flush();
	}
}
