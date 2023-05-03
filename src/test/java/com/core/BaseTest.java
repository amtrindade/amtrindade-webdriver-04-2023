package com.core;

import static com.core.DriverFactory.killDriver;

import org.junit.jupiter.api.AfterEach;

public class BaseTest {
	
	@AfterEach
	public void tearDown() {
		killDriver();
	}

}
