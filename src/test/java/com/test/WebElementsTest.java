package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.core.BaseTest;

public class WebElementsTest extends BaseTest{
	
	@BeforeEach
	public void setUp() {
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/elementsweb.html");		
	}	
	
	@Test
	public void testValidaNome() throws InterruptedException {
		//identifica o elemento
		WebElement tfName = getDriver().findElement(By.xpath("//input[@name='txtbox1']"));
		
		//faz a ação no elemento
		tfName.sendKeys("Hello World");
				
		//realiza a validação
		assertEquals("Hello World", tfName.getAttribute("value"));		
	}	
	
	@Test
	public void testTextFieldHabilitados() {
		//identifica os elementos
		WebElement tfbox1 = getDriver().findElement(By.name("txtbox1"));
		WebElement tfbox2 = getDriver().findElement(By.name("txtbox2"));
				
		//realiza a validação
		assertTrue(tfbox1.isEnabled());
		assertFalse(tfbox2.isEnabled());		
	}
	
	@Test
	public void testRadioButton() {
		//identificar os elementos 
		List<WebElement> listRadio = getDriver().findElements(By.name("radioGroup1"));
		
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
		List<WebElement> listCheckBoxes = getDriver().findElements(By.name("chkbox"));	
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
		WebElement elementSingle = getDriver().findElement(By.name("dropdownlist"));
		Select selectSingle = new Select(elementSingle);
		
		assertEquals(10, selectSingle.getOptions().size());
		
		selectSingle.selectByIndex(3);		
		selectSingle.selectByValue("item5");		
		selectSingle.selectByVisibleText("Item 7");
		
		assertEquals("Item 7", selectSingle.getFirstSelectedOption().getText());		
	}
	
	@Test
	public void testSelectMultiple() {
		WebElement elementMulti = getDriver().findElement(By.name("multiselectdropdown"));
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
		getDriver().switchTo().frame(0);
				
		//identifica o elemento
		WebElement tfIframe = getDriver().findElement(By.id("tfiframe"));
		
		//Faz a iteração com o elemento
		tfIframe.sendKeys("Teste do iframe");
		
		//Validando o resultado
		assertEquals("Teste do iframe", tfIframe.getAttribute("value"));
		
		//Retorna o foco do driver para o default
		getDriver().switchTo().defaultContent();
		
		WebElement btnAlert = getDriver().findElement(By.name("alertbtn"));
		btnAlert.click();		
	}
	
	@Test 
	public void testAlert() {
		WebElement btnAlert = getDriver().findElement(By.name("alertbtn"));
		btnAlert.click();
		
		Alert alertInfo = getDriver().switchTo().alert();			
		
		assertEquals("Eu sou um alerta!", alertInfo.getText());		
		alertInfo.accept();
		
		WebElement btnConfirm = getDriver().findElement(By.name("confirmbtn"));
		btnConfirm.click();
		
	}
}
