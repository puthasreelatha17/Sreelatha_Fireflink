package com.tyss.java.util;

import static org.testng.Assert.fail;

import java.io.File;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tyss.java.baseUtil.BaseTest;

public class WebActionUtil {
	public WebDriverWait wait;
	public static JavascriptExecutor jsExecutor;
	/**
	 * Description: Method for fetching Current Date Time
	 * 
	 * @author Sreelatha
	 */
	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}
	
	/**
	 * Description: Method for fetching Current Date Time
	 * 
	 * @author Sreelatha
	 */

	public static String getCurrentDateTime1() {
		DateFormat customFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}
	
	/**
	 * Description:: Method to delete folder directory for time period above 30days
	 * 
	 * @author Sajal
	 * @param folderToDelete
	 */
	public static synchronized void deleteDirectory(String folderToDelete) {
		try {
			File dir = new File(folderToDelete);
			File[] files = dir.listFiles();
			if (files.length > 1) {
				for (File file : files) {
					String name = file.getName();
					if (name.toLowerCase().contains("automation")) {
						String[] dateTime = name.split("- ");
						if (calculateDateDifference(dateTime[1]) > 30) {
							String tempXLFile = new StringBuffer(folderToDelete).append(File.separator).append(name)
									.toString();
							deleteDir(tempXLFile);
						}
					}
				}
			}
		} catch (Exception e) {
			error("Unable to delete the directory");
			fail("Unable to delete the directory");
		}
	}
	/**
	 * 
	 * Description: Method for the Error updation in Log file,TestNG Report
	 * 
	 * @author vikas, sajal
	 * @param message
	 */
	public static synchronized void error(String message) {
		BaseTest.logger.error(message);
	}

	/**
	 * Description: Method to delete the directory
	 * 
	 * @author Sajal
	 * @param pathToDeleteFolder
	 */
	public static synchronized void deleteDir(String pathToDeleteFolder) {
		File extefolder = new File(pathToDeleteFolder);
		if ((extefolder.exists())) {
			deleteFolderDir(extefolder);
		}
	}

	/**
	 * Description:: Method to find difference between current date and
	 * mentioned date
	 * 
	 * @author Sajal
	 * @param actualDateTime
	 * @return days_difference
	 */
	public static synchronized long calculateDateDifference(String actualDateTime) {
		/* Create an instance of the SimpleDateFormat class */
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		long days_difference = 0;
		String currentDateTime = getCurrentDateTime();
		try {
			/* Use parse method to get date object of both dates */
			Date date1 = customFormat.parse(actualDateTime);
			Date date2 = customFormat.parse(currentDateTime);
			/* Calculate time difference in milliseconds */
			long time_difference = date2.getTime() - date1.getTime();
			/* Calculate time difference in days using TimeUnit class */
			days_difference = TimeUnit.MILLISECONDS.toDays(time_difference) % 365;
		} catch (Exception e) {
			error("Unable to calculate Date difference");
			fail("Unable to calculate Date difference");
		}
		return days_difference;
	}

	/**
	 * Description: Method to delete folder directory
	 * 
	 * @author Sajal
	 * @param folderToDelete
	 */
	public static void deleteFolderDir(File folderToDelete) {
		File[] folderContents = folderToDelete.listFiles();
		if (folderContents != null) {
			for (File folderfile : folderContents) {
				if (!Files.isSymbolicLink(folderfile.toPath())) {
					deleteFolderDir(folderfile);
				}
			}
		}
		folderToDelete.delete();
	}
	public static void info(String message) {
		BaseTest.logger.info(message);
	}
	
	public void scrollToElement(WebElement element, String elementName) {
		info("Scroll till the " + elementName);

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
			info("Scroll till the " + elementName + " completed");
		} catch (Exception e) {
			error("Scroll till the " + elementName + " failed");
			Assert.fail("Scroll till the " + elementName + " failed");
		}
	}
}
