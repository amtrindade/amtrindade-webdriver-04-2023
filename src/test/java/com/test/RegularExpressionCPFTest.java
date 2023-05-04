package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;

public class RegularExpressionCPFTest extends BaseTest{
	
	
	@BeforeEach
	public void before() {	
		getDriver().get("https://www.geradordecpf.org/");
	}
		
	@Test
	public void testGenerateCPFWithDot() {
		WebElement cbPontos = getDriver().findElement(By.id("cbPontos"));
		cbPontos.click();
		
		WebElement btnGerar = getDriver().findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		WebElement tfCPF = getDriver().findElement(By.id("numero"));		
		String cpfGerado = tfCPF.getAttribute("value");
		
		System.out.println(cpfGerado);
		
		assertTrue(cpfGerado.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$"));	
	}
	
	@Test
	public void testGenerateCPFWithoutDot() {
		WebElement btnGerar = getDriver().findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		WebElement tfCPF = getDriver().findElement(By.id("numero"));		
		String cpfGerado = tfCPF.getAttribute("value");
		
		System.out.println(cpfGerado);
		
		assertTrue(cpfGerado.matches("^[0-9]{11}$"));
	}


}
