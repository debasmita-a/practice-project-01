package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.enums.WaitStrategy;
import com.utils.ElementUtil;

public final class HomePage {

	WebDriver driver;
	ElementUtil util;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}
	
	private static By dashborad_headerTxt = By.xpath("//h6");
	
	public String isDashboardTextAvailable() {
		return util.getElementText(dashborad_headerTxt, WaitStrategy.PRESENCE);
	}
}
