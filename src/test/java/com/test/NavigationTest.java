package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;

public class NavigationTest extends BaseTest{
	
	@BeforeEach
	public void setUp() throws Exception {	
		getDriver().get("http://antoniotrindade.com.br/treinoautomacao/index.html");		
	}

	@Test
	public void testNavigationTabs() {
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		WebElement linkDragAndDrop = getDriver().findElement(By.linkText("Drag and Drop"));
		linkDragAndDrop.click();
		
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs.get(1));
		
		assertEquals("Mootools Drag and Drop Example", getDriver().getTitle());
		
		getDriver().switchTo().window(tabs.get(0));
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		WebElement linkGerador = getDriver().findElement(By.linkText("Gerador de CPF"));
		linkGerador.click();
		
		tabs = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs.get(2));
		
		assertEquals("Gerador de CPF", getDriver().getTitle());
		
		getDriver().switchTo().window(tabs.get(1));
		assertEquals("Mootools Drag and Drop Example", getDriver().getTitle());
		
		getDriver().switchTo().window(tabs.get(0));
		assertEquals("Treino Automação de Testes", getDriver().getTitle());		
	}

}
