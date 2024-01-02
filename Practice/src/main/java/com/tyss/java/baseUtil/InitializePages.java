package com.tyss.java.baseUtil;

import org.openqa.selenium.WebDriver;

import com.tyss.java.pages.Flipkart_Login_Page;
import com.tyss.java.pages.PepperFry_Login_Page;

public class InitializePages {
	public Flipkart_Login_Page flipkart_login_page;
	public PepperFry_Login_Page pepperFry_login_page;
	
	public InitializePages(WebDriver driver, long ETO){
		flipkart_login_page=new Flipkart_Login_Page(driver,ETO);
		pepperFry_login_page=new PepperFry_Login_Page(driver,ETO);
	}
}
