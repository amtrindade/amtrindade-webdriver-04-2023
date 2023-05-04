package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.BaseTest;

public class RegularExpressionCNPJTest extends BaseTest{
	
	
	@BeforeEach
	public void before() {
		getDriver().get("https://www.4devs.com.br/gerador_de_cnpj");
	}
	
	@Test
	public void testValidationCNPJ() throws InterruptedException {
		WebElement cbSim = getDriver().findElement(By.id("pontuacao_sim"));
		cbSim.click();
		
		WebElement btnGerar = getDriver().findElement(By.id("bt_gerar_cnpj"));
		btnGerar.click();
		
		WebElement divCNPJ = getDriver().findElement(By.id("texto_cnpj"));
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.invisibilityOfElementWithText(By.id("texto_cnpj"), "Gerando..."));
				
		
		System.out.println(divCNPJ.getText());
		
		assertTrue(divCNPJ.getText()
				.matches("^[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}/[0-9]{4}-[0-9]{2}$"));
		
	}


}
