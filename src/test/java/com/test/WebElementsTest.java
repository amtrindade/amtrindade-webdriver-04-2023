package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebElementsTest {
	private WebDriver driver;
	
	@BeforeEach
	public void before() {
		System.setProperty("webdriver.chrome.driver", 
				"/home/atrindade/Dev/drivers/chromedriver");	
		driver = new ChromeDriver();
		driver.get("http://antoniotrindade.com.br/treinoautomacao/elementsweb.html");
	}

	@AfterEach
	public void after() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test
	public void testValidaNome() throws InterruptedException {
		//identifica o elemento
		WebElement tfName = driver.findElement(By.name("txtbox1"));
		
		//faz a ação no elemento
		tfName.sendKeys("Hello World");
				
		//realiza a validação
		assertEquals("Hello World", tfName.getAttribute("value"));		
	}	
	
	@Test
	public void testTextFieldHabilitados() {
		//identifica os elementos
		WebElement tfbox1 = driver.findElement(By.name("txtbox1"));
		WebElement tfbox2 = driver.findElement(By.name("txtbox2"));
				
		//realiza a validação
		assertTrue(tfbox1.isEnabled());
		assertFalse(tfbox2.isEnabled());		
	}
	
	@Test
	public void testRadioButton() {
		//identificar os elementos 
		List<WebElement> listRadio = driver.findElements(By.name("radioGroup1"));
		
		assertEquals(4, listRadio.size());
		
		for (WebElement e: listRadio) {
			System.out.println(e.getAttribute("value"));				
			if (e.getAttribute("value").equals("Radio 3")) {
				e.click();
			}					
		}	
		//listRadio.get(2).click();
		
		assertFalse(listRadio.get(0).isSelected());
		assertFalse(listRadio.get(1).isSelected());		
		assertTrue(listRadio.get(2).isSelected());		
		assertFalse(listRadio.get(3).isSelected());
	}
	
	@Test
	public void testCheckBoxes() {
		//identificar os elementos
		List<WebElement> listCheckBoxes = driver.findElements(By.name("chkbox"));	
		assertEquals(4, listCheckBoxes.size());
		
		for (WebElement chk : listCheckBoxes) {
			System.out.println(chk.getAttribute("value"));
			
			if ((chk.getAttribute("value").equals("Check 3")) 
					|| (chk.getAttribute("value").equals("Check 4"))) {
				chk.click();
			}			
		}
		
		assertTrue(listCheckBoxes.get(2).isSelected());
		assertTrue(listCheckBoxes.get(3).isSelected());		
	}
	
	@Test
	public void testSelectSingle() {
		WebElement elementSingle = driver.findElement(By.name("dropdownlist"));
		Select selectSingle = new Select(elementSingle);
		
		selectSingle.selectByIndex(3);		
		selectSingle.selectByValue("item5");		
		selectSingle.selectByVisibleText("Item 7");
		
		assertEquals("Item 7", selectSingle.getFirstSelectedOption().getText());	
	
	}
}
