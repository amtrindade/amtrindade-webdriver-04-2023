package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.BaseTest;

public class CalculadoraTest extends BaseTest{
	
	@BeforeEach
	public void before() {
		getDriver().get("http://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");
	}
	
	@Test
	public void testSum() throws InterruptedException {
		WebElement tfNumber1 = getDriver().findElement(By.id("number1"));
		tfNumber1.sendKeys("45");
		
		WebElement tfNumber2 = getDriver().findElement(By.id("number2"));
		tfNumber2.sendKeys("23");
		
		WebElement btnSomar = getDriver().findElement(By.id("somar"));
		btnSomar.click();
		
		WebElement tfTotal = getDriver().findElement(By.id("total"));
		
		//Espera explícita
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementValue(tfTotal, "68"));
				
		assertEquals("68", tfTotal.getAttribute("value"));
	
	}
}
