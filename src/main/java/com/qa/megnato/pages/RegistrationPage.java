package com.qa.megnato.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.megnato.base.BasePage;

public class RegistrationPage extends BasePage{
	
	@FindBy(xpath="//h1[text()='Create an Account']")
	WebElement createAccounrLabel;
	
	@FindBy(id="firstname")
	WebElement firstname;
	
	@FindBy(id="lastname")
	WebElement lastname;
	
	@FindBy(id="email_address")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="confirmation")
	WebElement confirmPassword;
	
	@FindBy(xpath="//button[@type='submit' and @title='Register']")
	WebElement RegisterBtn;

  public RegistrationPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
  
  public String VerifyCerateAccount() {
	  WebDriverWait wait1=new WebDriverWait(driver, 10);
	  wait1.until(ExpectedConditions.visibilityOf(createAccounrLabel));
	  return createAccounrLabel.getText();
  }
  
      
  public void completeRegistration(String fname,String lname,String emailid,String pwd,String cpwd) {
	  
	  WebDriverWait wait=new WebDriverWait(driver, 20);
	  
	  wait.until(ExpectedConditions.elementToBeClickable(firstname));	  
	  firstname.sendKeys(fname);
	  
	  wait.until(ExpectedConditions.elementToBeClickable(lastname));	  
	  lastname.sendKeys(lname);
	  
	  wait.until(ExpectedConditions.elementToBeClickable(email));	  
	  email.sendKeys(emailid);
	  
	  wait.until(ExpectedConditions.elementToBeClickable(password));	  
	  password.sendKeys(pwd);
	  
	  wait.until(ExpectedConditions.elementToBeClickable(confirmPassword));	  
	  confirmPassword.sendKeys(cpwd);
	  
	  wait.until(ExpectedConditions.elementToBeClickable(RegisterBtn));
	  RegisterBtn.click();
	  	     
	    }

}
