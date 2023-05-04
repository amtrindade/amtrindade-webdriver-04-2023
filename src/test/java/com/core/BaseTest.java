package com.core;

import static com.core.DriverFactory.getDriver;
import static com.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
	
	@AfterEach
	public void tearDown(TestInfo testInfo) throws IOException {
		File screen = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen , 
				new File("target"+ File.separator + testInfo.getDisplayName() +".png"));	
		killDriver();
	}
}
