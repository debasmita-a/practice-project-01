package com.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.FrameworkConstants;
import com.driver.DriverManager;
import com.enums.WaitStrategy;

public final class ElementUtil {

	private WebDriver driver;

	private ElementUtil() {
		this.driver = DriverManager.getDriver();
	}

	protected String getPageTitle() {
		return driver.getTitle();
	}

	protected String getPageURL() {
		return driver.getCurrentUrl();
	}

	protected void elementClick(By locator, WaitStrategy waitStrategy) {
		if (waitStrategy == WaitStrategy.CLICKABLE) {
			explicitlyWaitClickable(locator).click();
		} else if (waitStrategy == WaitStrategy.PRESENCE) {
			explicitlyWaitPresence(locator).click();
		} else {
			driver.findElement(locator).click();
		}

	}

	protected void elementSendKeys(By locator, String value, WaitStrategy waitStrategy) {
		if (waitStrategy == WaitStrategy.PRESENCE) {
			explicitlyWaitPresence(locator).sendKeys(value);
		} else if (waitStrategy == WaitStrategy.VISIBLE) {
			explicitlyWaitVisible(locator).sendKeys(value);
		} else {
			driver.findElement(locator).sendKeys(value);
		}
	}

	protected String getElementText(By locator) {
		return driver.findElement(locator).getText();
	}

	protected String getElementAttributeValue(By locator, String sttribute) {
		return driver.findElement(locator).getAttribute(sttribute);
	}

	private WebElement explicitlyWaitClickable(By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.getExplicitwaitShort()))
				.until(ExpectedConditions.elementToBeClickable(locator));
	}

	private WebElement explicitlyWaitVisible(By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.getExplicitwaitShort()))
				.until(ExpectedConditions.elementToBeClickable(locator));
	}

	private WebElement explicitlyWaitPresence(By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.getExplicitwaitShort()))
				.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
