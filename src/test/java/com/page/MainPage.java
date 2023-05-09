package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {
	
	public MainPage clickAvatar() {
		WebElement imgAvatar = getDriver().findElement(By.xpath("//div[@class='topbar-widget profile-widget']/img"));
		imgAvatar.click();
		return this;
	}
	
	public String getTextAvatar() {
		WebElement divAvatar = getDriver().findElement(By.xpath("//span[@class='text-login']/.."));
		return divAvatar.getText();	
	}

}
