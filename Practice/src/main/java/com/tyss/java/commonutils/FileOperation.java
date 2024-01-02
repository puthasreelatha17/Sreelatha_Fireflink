package com.tyss.java.commonutils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tyss.java.baseUtil.BaseTest;
import com.tyss.java.reports.ExtentManager;
import com.tyss.java.util.WebActionUtil;

public class FileOperation {
	
	FileVariables fileVariables=new FileVariables();
	
	public void createFiles() {
		fileVariables.setDate(new Date());
		fileVariables.setSdf(new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss"));
		fileVariables.setsStartTime(fileVariables.getsDate() );
		fileVariables.setsDate(fileVariables.getSdf().format(fileVariables.getDate()));
		fileVariables.setExtentReportFolderPath(System.getProperty("user.dir")+"/reports");
		fileVariables.setExtentDir(fileVariables.getExtentReportFolderPath()+"/AutomationReport- "+WebActionUtil.getCurrentDateTime());
		BaseTest.currentDateAndTime=WebActionUtil.getCurrentDateTime();
		BaseTest.currentDateAndTimeNewFormat=WebActionUtil.getCurrentDateTime1();
		fileVariables.setScreenshotPath(fileVariables.getExtentDir() + "/Screenshots/");
		BaseTest.logger.info("ExtentDir:-" + fileVariables.getExtentDir());
		
		/* delete extent folder if it exists before running suite */
		WebActionUtil.deleteDirectory(fileVariables.getExtentReportFolderPath());

		/* Setting Extent Report Location */
	try {
		File file = new File(fileVariables.getExtentDir());
		if (!(file.exists())) {
			boolean extentFolderStatus = file.mkdirs();
			if (extentFolderStatus == true) {
				new ExtentManager().initReport(fileVariables.getExtentDir());

			}
			else
				BaseTest.logger.info("--> Extent Folder not Created");
		}

	} catch (Exception e) {
		BaseTest.logger.info("Inside on start catch block" + e.getMessage());
		e.printStackTrace();
	}
	
	/* Setting ScreenShot Report Location */
	try {
		File screenShot = new File(FileVariables.getScreenshotPath());
		if (!(screenShot.exists())) {
			boolean screenshotFolderStatus = screenShot.mkdirs();
			if (screenshotFolderStatus == true)
				BaseTest.logger.info("Screenshot Folder Created");

			else
				BaseTest.logger.info("Screenshot Folder Not Created");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

}

}
