package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage  extends TestBase {
		
	@FindBy(xpath="//td[contains(text(), 'Naveen k')]")
	WebElement headerText;
	
	@FindBy(xpath="//a[contains(text(), 'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//a[contains(text(), 'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateTittle() {
		return driver.getTitle();
	}
	
	public boolean validateHeaderText() {
		return headerText.isDisplayed();
	}
	
	public contactPage contactLinkClick() {
		contactLink.click();
		return new contactPage();
	}
	
	public DealsPage dealsLinkClick() {
		contactLink.click();
		return new DealsPage();
	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactLink).build().perform();
		newContactLink.click();
	}
}
