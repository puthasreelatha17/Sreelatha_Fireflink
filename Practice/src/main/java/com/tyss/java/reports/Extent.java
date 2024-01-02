package com.tyss.java.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tyss.java.baseUtil.BaseTest;
import com.tyss.java.commonutils.FileVariables;

public class Extent {
	
	private static ExtentTest extentTest;
	private static ExtentReports extentReports;
	FileVariables fileVariables = new FileVariables();

	public static ExtentTest createTest(String name) {
		extentTest = extentReports.createTest(name);
		return extentTest;
	}

	public static ExtentReports getExtent() {
		return extentReports;
	}

	public ExtentReports getExtent(String filepath) {
		if (extentReports == null) {
			try {
				extentReports = new ExtentReports();
				extentReports.attachReporter(getHtmlReporter(filepath + "/AutomationReport.html"));
				return extentReports;
			} catch (Exception e) {
				BaseTest.logger.info("Exception while creating report html file");
			}
		}
		return extentReports;
	}

	public void initReport(String filepath) {
		extentReports = getExtent(filepath);
		BaseTest.logger.info("Report Initiated");
	}
	
	private static ExtentHtmlReporter getHtmlReporter(String filePath) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "./config\\extent-config.xml");
		return htmlReporter;
	}

}
