package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPaage;
	
	
	public LoginPageTest() {
		super();
		
	}	
	
	@BeforeMethod
	private void setup() {
		invokeBrowser();
		loginPaage= new LoginPage();
	}
	
	@Test(priority=1)
	private void validateLoginPageTittleTest() {
		String tittle = loginPaage.validateLoginPageTittle();
		Assert.assertEquals(tittle, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	private void validateImageTest() {
		boolean val = loginPaage.validateImage();
		Assert.assertTrue(val);
	}
	
	@Test(priority=3)
	private void loginTest() {
		HomePage homePage = loginPaage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	private void closeBrowser() {
		driver.quit();
	}

}
