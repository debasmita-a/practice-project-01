package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	private static By footerText = By.xpath("//h5");
	private static By link_forgottenPass = By.xpath("");
	
	public String getFooterText() {
		return util.getElementText(footerText);
	}
	
	public boolean isForgottenPassLinkAvailable() {
		return util.isElementAvailable(link_forgottenPass);
	}
	
	public String getPageTitle() {
		return util.getPageTitle();
	}
	
	public LoginPage enterUsername(String un) {
		util.elementSendKeys(text_username, un, WaitStrategy.NONE);		
		return this;
	}
	
	public LoginPage enterPassword(String pass) {
		util.elementSendKeys(text_password, pass, WaitStrategy.NONE);
		return this;
	}
	
	public LoginPage clickLoginBtn() {
		util.elementClick(btn_login, WaitStrategy.CLICKABLE);
		return this;
	}
	
	public HomePage doLogin() {
		
		return new HomePage(driver);
	}
}
