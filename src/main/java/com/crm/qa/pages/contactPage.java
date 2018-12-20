package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class contactPage extends TestBase{
	
	@FindBy(name="title")
	WebElement tittle;
	
	@FindBy(id="first_name")
	WebElement fname;
	
	@FindBy(id="surname")
	WebElement surname;
	

	@FindBy(name="client_lookup")
	WebElement company;

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	

	@FindBy(xpath="//input[@type='submit and @value='Save']")
	WebElement saveBtn;
	
	// Initializing the Page Objects:
		public contactPage() {
			PageFactory.initElements(driver, this);
		}
		
		
		public boolean verifyContactsLabel(){
			return contactsLabel.isDisplayed();
		}
		
		
		public void selectContactsByName(String name){
			driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
					+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		}
	
	public void createNewContacts(String tit,String name, String lastname, String cmp) {
		Select selct = new Select(tittle);
		selct.selectByVisibleText(tit);
		
		fname.sendKeys(name);
		surname.sendKeys(lastname);
		company.sendKeys(cmp);
		
		saveBtn.click();
	}
	
	
	
	

}
