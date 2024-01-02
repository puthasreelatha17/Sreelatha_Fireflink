package com.tyss.java.baseUtil;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDriver {
	private static CreateDriver instance = null;
	private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	
	/* constructor */
	private CreateDriver() {
	}
	
	public static CreateDriver getInstance() {
		if (instance == null) {
			instance = new CreateDriver();
		}
		return instance;
	}
	
	public static void setDriverExecutables(String browserName) {
		try {
			killBrowserTask(browserName);
			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().forceDownload().cachePath(BaseTest.driverPath).avoidOutputTree()
						.setup();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().forceDownload().cachePath(BaseTest.driverPath).avoidOutputTree()
						.setup();
			} else if (browserName.equalsIgnoreCase("safari")) {
				WebDriverManager.safaridriver().clearDriverCache().forceDownload().cachePath(BaseTest.driverPath)
						.avoidOutputTree().setup();
			}
		} catch (Exception e) {
			BaseTest.logger.error("Unable to download " + browserName + " driver executable file");
		}
	}
	
	public static void killBrowserTask(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			} else if (browserName.equalsIgnoreCase("firefox")) {
				Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
			} else if (browserName.equalsIgnoreCase("edge")) {
				Runtime.getRuntime().exec("taskkill /F /IM msedgedriver.exe");
			} else {
				BaseTest.logger.error("Browser name not specified properly to kill the task");
			}
		} catch (Exception e) {
			BaseTest.logger.error("Unable to kill the " + browserName + " browser task");
		}
	}
}
