package com.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.FrameworkConstants;
import com.enums.WaitStrategy;

public final class ElementUtil {

	public WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageURL() {
		return driver.getCurrentUrl();
	}
	
	public boolean isElementAvailable(By locator) {
		return explicitlyWaitPresence(locator).isDisplayed();
	}

	public void elementClick(By locator, WaitStrategy waitStrategy) {
		if (waitStrategy == WaitStrategy.CLICKABLE) {
			explicitlyWaitClickable(locator).click();
		} else if (waitStrategy == WaitStrategy.PRESENCE) {
			explicitlyWaitPresence(locator).click();
		} else {
			driver.findElement(locator).click();
		}

	}

	public void elementSendKeys(By locator, String value, WaitStrategy waitStrategy) {
		if (waitStrategy == WaitStrategy.PRESENCE) {
			explicitlyWaitPresence(locator).sendKeys(value);
		} else if (waitStrategy == WaitStrategy.VISIBLE) {
			explicitlyWaitVisible(locator).sendKeys(value);
		} else {
			driver.findElement(locator).sendKeys(value);
		}
	}

	public String getElementText(By locator, WaitStrategy waitStrategy) {
		if (waitStrategy == WaitStrategy.PRESENCE) {
			return explicitlyWaitPresence(locator).getText();
		}else {
			return driver.findElement(locator).getText();
		}
		
	}

	public String getElementAttributeValue(By locator, String attribute) {
		return driver.findElement(locator).getAttribute(attribute);
	}

	private WebElement explicitlyWaitClickable(By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.getExplicitwaitLong()))
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
	
	public void doActionClick(By locator) {
		Actions action = new Actions(driver);
		action.pause(Duration.ofSeconds(10));
		action.moveToElement(driver.findElement(locator)).click().build().perform();
	}
	
	public void doMoveToElement(By locator) {
		
	}

}
