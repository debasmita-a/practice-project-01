package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.enums.WaitStrategy;
import com.utils.ElementUtil;

public class LoginPage {

	ElementUtil util;
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}
	
	private static By text_username = By.name("username");
	private static By text_password = By.name("password");
	private static By btn_login = By.xpath("//button[@type='submit']");
	private static By footerText = By.xpath("//div[@class='orangehrm-copyright-wrapper']");
	private static By link_forgottenPass = By.xpath("//div[@class='orangehrm-login-forgot']/p");
	
	public String getFooterText() {
		System.out.println(util.getElementText(footerText, WaitStrategy.PRESENCE));
		return util.getElementText(footerText, WaitStrategy.PRESENCE);
	}
	
	public boolean isForgottenPassLinkAvailable() {
		return util.isElementAvailable(link_forgottenPass);
	}
	
	public String getPageTitle() {
		return util.getPageTitle();
	}
	
	public LoginPage enterUsername(String un) {
		util.elementSendKeys(text_username, un, WaitStrategy.PRESENCE);		
		return this;
	}
	
	public LoginPage enterPassword(String pass) {
		util.elementSendKeys(text_password, pass, WaitStrategy.PRESENCE);
		return this;
	}
	
	public HomePage clickLoginBtn(){
		util.elementClick(btn_login, WaitStrategy.PRESENCE);
		return new HomePage(driver);
	}
}
