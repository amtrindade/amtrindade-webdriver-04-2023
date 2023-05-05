package com.core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		if (driver == null) {
			
			String browser = "chrome-headless";
			
			if (browser.equals("chrome")) {					
				System.setProperty("webdriver.chrome.driver", "/home/atrindade/Dev/drivers/chromedriver");
				driver = new ChromeDriver();				
			}
			
			else if (browser.equals("chrome-headless")){
				System.setProperty("webdriver.chrome.driver", "/home/atrindade/Dev/drivers/chromedriver");
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				options.addArguments("window-size=1200x960");
				
				driver = new ChromeDriver(options);
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
