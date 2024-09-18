package com.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.enums.ConfigProperties;
import com.utils.PropertiesReader;

public final class Driver {

	private Driver() {
	}

	public static WebDriver initDriver(String browser) {

		System.out.println("Launching browser ::::  " + browser);

		if (Objects.isNull(DriverManager.getDriver())) {
			switch (browser) {
			case "chrome":
				DriverManager.setDriver(new ChromeDriver());
				break;
			case "edge":
				DriverManager.setDriver(new EdgeDriver());
				break;
			case "firefox":
				DriverManager.setDriver(new FirefoxDriver());
				break;

			default:
				System.out.println("Please enter a valid browser name ::: " + browser);
				break;
			}
		}

		DriverManager.getDriver().get(PropertiesReader.get(ConfigProperties.URL));
		DriverManager.getDriver().manage().window().maximize();
		//DriverManager.getDriver().manage().deleteAllCookies();

		return DriverManager.getDriver();
	}

	public void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
