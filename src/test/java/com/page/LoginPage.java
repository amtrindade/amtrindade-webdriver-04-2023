package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public LoginPage open() {
		getDriver().get("https://center.umov.me/");
		return this;
	}
	
	public LoginPage inputEnvironment(String workspace) {
		WebElement tfEnvironment = getDriver().findElement(By.id("workspace"));
		tfEnvironment.sendKeys(workspace);
		return this;
	}
	
	public LoginPage inputUser(String username) {
		WebElement tfUser = getDriver().findElement(By.id("username"));
		tfUser.sendKeys(username);		
		return this;
	}
	
	public LoginPage inputPassword(String pass) {
		WebElement tfPass = getDriver().findElement(By.id("password"));
		tfPass.sendKeys(pass);
		return this;
	}
	
	public MainPage access() {
		WebElement btnAccess = getDriver().findElement(By.id("submit_button"));
		btnAccess.click();
		
		return new MainPage();
	}

	public String accessValidation() {
		WebElement btnAccess = getDriver().findElement(By.id("submit_button"));
		btnAccess.click();
		
		WebElement errorMessage = getDriver().findElement(By.xpath("//li[@class='nm-li nm-message-error']"));		
		return errorMessage.getText();
	}

}
