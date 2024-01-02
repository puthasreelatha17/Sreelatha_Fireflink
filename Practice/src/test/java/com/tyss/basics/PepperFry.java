package com.tyss.basics;

import org.testng.annotations.Test;

import com.tyss.java.baseUtil.BaseTest;

public class PepperFry extends BaseTest {
	@Test
	public void TC_PepperFry_01() throws InterruptedException {
		
		pages.pepperFry_login_page.CloseFrame();
		pages.pepperFry_login_page.mouseHoverFurniture();
		pages.pepperFry_login_page.getTextFurniture();
		pages.pepperFry_login_page.mouseHoverLamps();
		pages.pepperFry_login_page.getTextLamps();
		
	}

}
