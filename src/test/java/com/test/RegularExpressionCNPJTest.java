package com.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

public class RegularExpressionCNPJTest {
	
	private WebDriver driver;
	
	@BeforeEach
	public void before() {
		System.setProperty("webdriver.chrome.driver", 
				"/home/atrindade/Dev/drivers/chromedriver");	
		driver = new ChromeDriver();
		//wait implicity
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.4devs.com.br/gerador_de_cnpj");
	}

	@AfterEach
	public void after() throws InterruptedException {		
		driver.quit();
	}
	
	@Test
	public void testValidationCNPJ() throws InterruptedException {
		WebElement cbSim = driver.findElement(By.id("pontuacao_sim"));
		cbSim.click();
		
		WebElement btnGerar = driver.findElement(By.id("bt_gerar_cnpj"));
		btnGerar.click();
		
		WebElement divCNPJ = driver.findElement(By.id("texto_cnpj"));
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.invisibilityOfElementWithText(By.id("texto_cnpj"), "Gerando..."));
				
		
		System.out.println(divCNPJ.getText());
		
		assertTrue(divCNPJ.getText()
				.matches("^[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}/[0-9]{4}-[0-9]{2}$"));
		
	}


}
