package com.qa.megento.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.megento.constants.Constnats;
import com.qa.megnato.base.BasePage;
import com.qa.megnato.pages.Account;
import com.qa.megnato.pages.LandingPage;
import com.qa.megnato.pages.RegistrationPage;
import com.qa.megneto.util.TestUtility;

public class RegistrationPageTest {

	public BasePage BasePage;
	public LandingPage LandingPage;
	public RegistrationPage RegistrationPage;
	public WebDriver driver;
	public Properties prop;
	public Account Account;
	@BeforeMethod
	public void set_up() {
		BasePage=new BasePage();
		prop=BasePage.initialize_properties();
		driver=BasePage.intialize_driver();
		driver.get(prop.getProperty("url"));
		LandingPage=new LandingPage(driver);
		RegistrationPage=LandingPage.navigatToRegistration();
		
		}
	
	@Test
	public void VerifyRegistrationLabel() {
		String alable=RegistrationPage.VerifyCerateAccount();
		System.out.println(alable);
		Assert.assertEquals(alable, Constnats.CREATE_ACCOUNT_LABEL, "Create Account Label not display");
	}
	@DataProvider(name="getRegistrationData")
	public Object[][] getRegistrationData() {
		Object[][] regdata=TestUtility.getCreateAcoountRecord(Constnats.REGISTRATION_SHEET_NAME);
		return regdata;
	}
	@Test(dataProvider="getRegistrationData")
	public void CompleteRegistration(String fn,String ln,String eid,String pd,String cpd) {
		RegistrationPage.completeRegistration(fn, ln, eid, pd, cpd);
	}
		
	@AfterMethod
	public void tear_down() {
		driver.quit();
	}
}
