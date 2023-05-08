package com.test;

import org.junit.jupiter.api.Test;

import com.core.BaseTest;
import com.page.LoginPage;
import com.page.MainPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void testLoginComSucesso() {
		LoginPage login = new LoginPage(); 
		
		login.open();
		login.inputEnvironment("trindade");
		login.inputUser("aluno01");
		
		MainPage main = login.access();
	}

}
