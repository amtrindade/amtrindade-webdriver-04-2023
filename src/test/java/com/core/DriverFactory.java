package com.core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		if (driver == null) {
			
			String browser = "chrome";
			
			if (browser.equals("chrome")) {					
				System.setProperty("webdriver.chrome.driver", "/home/atrindade/Dev/drivers/chromedriver");
				driver = new ChromeDriver();				
			}
			
			else {
				System.setProperty("webdriver.geckodriver.driver", "/home/atrindade/Dev/drivers/geckodriver");
				driver = new FirefoxDriver();
			}			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}					
		return driver;
	}
	
	public static void killDriver() {		
		if (driver != null) {
			driver.quit();
			driver = null;
		}		
	}
}
