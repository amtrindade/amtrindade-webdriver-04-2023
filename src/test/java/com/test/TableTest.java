package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;

public class TableTest extends BaseTest{
	
	
	
	@BeforeEach
	public void before() {
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/localizandovalorestable.html");
	}

	@Test
	public void testFindNameByEmail() {
		String email = "mail2@";
		
		//irmão
		WebElement linha = getDriver().findElement(By.xpath("//td[contains(text(),'"+ email +"')]/preceding-sibling::td"));		
		
		assertEquals("Fulano da Silva", linha.getText());
		
		//pai
		WebElement linha2 = getDriver().findElement(By.xpath("//td[contains(text(),'mail3@')]/../td[1]"));
		
		assertEquals("João Pedro Nascimento", linha2.getText());
	}
}
