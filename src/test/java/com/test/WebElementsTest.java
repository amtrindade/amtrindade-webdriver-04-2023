package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
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
		
		assertEquals(10, selectSingle.getOptions().size());
		
		selectSingle.selectByIndex(3);		
		selectSingle.selectByValue("item5");		
		selectSingle.selectByVisibleText("Item 7");
		
		assertEquals("Item 7", selectSingle.getFirstSelectedOption().getText());		
	}
	
	@Test
	public void testSelectMultiple() {
		WebElement elementMulti = driver.findElement(By.name("multiselectdropdown"));
		Select selectMulti = new Select(elementMulti);
		
		selectMulti.selectByVisibleText("Item 5");
		selectMulti.selectByVisibleText("Item 8");
		selectMulti.selectByVisibleText("Item 9");
		
		List<WebElement> selectAll = selectMulti.getAllSelectedOptions();
		assertEquals(3, selectAll.size());
		
		assertEquals("Item 5", selectAll.get(0).getText());
		assertEquals("Item 8", selectAll.get(1).getText());
		assertEquals("Item 9", selectAll.get(2).getText());	
	}
	
	@Test
	public void testIframe() {
		//Entra no iframe
		driver.switchTo().frame(0);
				
		//identifica o elemento
		WebElement tfIframe = driver.findElement(By.id("tfiframe"));
		
		//Faz a iteração com o elemento
		tfIframe.sendKeys("Teste do iframe");
		
		//Validando o resultado
		assertEquals("Teste do iframe", tfIframe.getAttribute("value"));
		
		//Retorna o foco do driver para o default
		driver.switchTo().defaultContent();
		
		WebElement btnAlert = driver.findElement(By.name("alertbtn"));
		btnAlert.click();		
	}
	
	@Test 
	public void testAlert() {
		WebElement btnAlert = driver.findElement(By.name("alertbtn"));
		btnAlert.click();
		
		Alert alertInfo = driver.switchTo().alert();			
		
		assertEquals("Eu sou um alerta!", alertInfo.getText());
		
		alertInfo.accept();
		
		WebElement btnConfirm = driver.findElement(By.name("confirmbtn"));
		btnConfirm.click();
		
	}
}
