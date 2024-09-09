package com.pages;

import org.openqa.selenium.WebDriver;

import com.utils.ElementUtil;

public final class HomePage {

	WebDriver driver;
	ElementUtil util;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}
}
