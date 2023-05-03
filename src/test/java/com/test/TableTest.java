package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableTest {
	
	private WebDriver driver;
	
	@BeforeEach
	public void before() {
		System.setProperty("webdriver.chrome.driver", 
				"/home/atrindade/Dev/drivers/chromedriver");	
		driver = new ChromeDriver();
		driver.get("https://antoniotrindade.com.br/treinoautomacao/localizandovalorestable.html");
	}

	@AfterEach
	public void after() throws InterruptedException {
		driver.quit();
	}
	
	@Test
	public void testFindNameByEmail() {
		String email = "mail2@";
		
		//irmão
		WebElement linha = driver.findElement(By.xpath("//td[contains(text(),'"+ email +"')]/preceding-sibling::td"));		
		
		assertEquals("Fulano da Silva", linha.getText());
		
		//pai
		WebElement linha2 = driver.findElement(By.xpath("//td[contains(text(),'mail3@')]/../td[1]"));
		
		assertEquals("João Pedro Nascimento", linha2.getText());
	}
}
