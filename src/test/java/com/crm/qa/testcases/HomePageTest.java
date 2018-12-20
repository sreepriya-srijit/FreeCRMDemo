
package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.contactPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		invokeBrowser();

		loginPage = new LoginPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateTittleTest() {
		String tittle = homepage.validateTittle();
		Assert.assertEquals(tittle, "CRMPRO");
		
	}
	
	@Test(priority=3)
	public void validateHeaderText() {
		TestUtil.switchToFrame();
		Assert.assertTrue(homepage.validateHeaderText());
	}
	
	@Test(priority=2)
	public void ContactLinkClick() {
		TestUtil.switchToFrame();
		contactPage contactPage = homepage.contactLinkClick();
	}
	
	
	@AfterMethod
	public void exit() {
		driver.quit();
	}

}
