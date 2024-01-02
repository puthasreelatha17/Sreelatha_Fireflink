package com.tyss.java.commonutils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileVariables {
	private static String screenshotPath;
	private static String sStartTime;
	private static Date date;
	private static String sDate;
	private static SimpleDateFormat sdf;
	private String extentReportFolderPath;
	private static String extentDir;

	public static String getScreenshotPath() {
		return screenshotPath;
	}

	public static void setScreenshotPath(String screenshotPath) {
		FileVariables.screenshotPath = screenshotPath;
	}

	public static String getsStartTime() {
		return sStartTime;
	}

	public static void setsStartTime(String sStartTime) {
		FileVariables.sStartTime = sStartTime;
	}

	public static Date getDate() {
		return date;
	}

	public static void setDate(Date date) {
		FileVariables.date = date;
	}

	public static String getsDate() {
		return sDate;
	}

	public static void setsDate(String sDate) {
		FileVariables.sDate = sDate;
	}

	public static SimpleDateFormat getSdf() {
		return sdf;
	}

	public static void setSdf(SimpleDateFormat sdf) {
		FileVariables.sdf = sdf;
	}

	public String getExtentReportFolderPath() {
		return extentReportFolderPath;
	}

	public void setExtentReportFolderPath(String extentReportFolderPath) {
		this.extentReportFolderPath = extentReportFolderPath;
	}

	public static String getExtentDir() {
		return extentDir;
	}

	public static void setExtentDir(String extentDir) {
		FileVariables.extentDir = extentDir;
	}
	
	

}
