package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage  extends TestBase{
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")	
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")	
	WebElement logoImage;
	
	//initialize page objects/Object rep.
	public LoginPage()
	{
		// all the declared element should intialize with driver
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTittle() {
		String tittle = driver.getTitle();
		return tittle;		
	}
	
	public boolean validateImage() {
		return logoImage.isDisplayed();
	}
	
	public HomePage login(String un, String pswd) {
		username.sendKeys(un);
		password.sendKeys(pswd);
		loginBtn.click();
		return new HomePage();
	}
	
	
	
}
		