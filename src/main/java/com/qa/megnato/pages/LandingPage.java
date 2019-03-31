package com.qa.megnato.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.megnato.base.BasePage;

public class LandingPage extends BasePage {

	@FindBy(xpath="//img[@class='large']")
	WebElement logo;
	
	@FindBy(xpath="//a[@class='skip-link skip-account']")
	WebElement account;
	
	@FindBy(xpath="//a[@class='skip-link skip-cart  no-count']")
	WebElement cart;
	
	@FindBy(linkText="Register")
	WebElement Register;
	
     public LandingPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
     
     public String getPageTitle() {
    	 return driver.getTitle();
     }
     
     public boolean VerifyLogoDisplay() {
    	return logo.isDisplayed();
     }
     
     public RegistrationPage navigatToRegistration() {
    	 WebDriverWait wait=new WebDriverWait(driver, 20);
    	 wait.until(ExpectedConditions.visibilityOf(account));
    	 account.click();
    	 Register.click();
    	 return new RegistrationPage(driver);
     }
     
     public boolean CheckCartLink() {
    	 return cart.isDisplayed();
     }

	

	
     
     
     
}
