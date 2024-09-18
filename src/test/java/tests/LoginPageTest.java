package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public final class LoginPageTest extends BaseTest{

	private LoginPageTest() {}
	
	@Test
	public void getFooterTextTest() {
		Assert.assertTrue(loginPage.getFooterText().contains("OrangeHRM OS 5.7"));
	}
	
	@Test
	public void getTitleTest() {
		Assert.assertEquals(loginPage.getPageTitle(), "OrangeHRM");
	}
	
	@Test
	public void doLoginTest(){
		homePage = loginPage.enterUsername("Admin").enterPassword("admin123").clickLoginBtn();
		Assert.assertEquals(homePage.isDashboardTextAvailable(), "Dashboard");
	}
}
