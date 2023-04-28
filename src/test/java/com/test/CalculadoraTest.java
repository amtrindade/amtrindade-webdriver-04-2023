package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculadoraTest {
	
	private WebDriver driver;
	
	@BeforeEach
	public void before() {
		System.setProperty("webdriver.chrome.driver", 
				"/home/atrindade/Dev/drivers/chromedriver");	
		driver = new ChromeDriver();
		//wait implicity
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");
	}

	@AfterEach
	public void after() throws InterruptedException {				
		driver.quit();
	}
	
	@Test
	public void testSum() throws InterruptedException {
		WebElement tfNumber1 = driver.findElement(By.id("number1"));
		tfNumber1.sendKeys("45");
		
		WebElement tfNumber2 = driver.findElement(By.id("number2"));
		tfNumber2.sendKeys("23");
		
		WebElement btnSomar = driver.findElement(By.id("somar"));
		btnSomar.click();
		
		WebElement tfTotal = driver.findElement(By.id("total"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementValue(tfTotal, "68"));
				
		assertEquals("68", tfTotal.getAttribute("value"));
	
	}
}
