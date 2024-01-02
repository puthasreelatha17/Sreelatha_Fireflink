package com.tyss.basics;

import org.testng.annotations.Test;
import com.tyss.java.baseUtil.BaseTest;

public class TC_FK_Basic001 extends BaseTest {
	@Test
	public void TC_FK_Basic01() {
		pages.flipkart_login_page.validateLoginPage();
		pages.flipkart_login_page.waitForElement();
		pages.flipkart_login_page.clkCloseicn();
	}
}
