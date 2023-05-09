package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		login.inputPassword("mudarsenha");
		
		MainPage main = login.access();
		
		main.clickAvatar();
		
		assertEquals("Aluno 01 (aluno01)", main.getTextAvatar());		
	}

}
