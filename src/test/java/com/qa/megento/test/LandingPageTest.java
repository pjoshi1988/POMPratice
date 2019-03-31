package com.qa.megento.test;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.megnato.base.BasePage;
import com.qa.megnato.pages.LandingPage;
import com.qa.megento.constants.Constnats;

public class LandingPageTest {

	public BasePage BasePage;
	public WebDriver driver;
	public Properties prop;
	public LandingPage LandingPage;
	
	@BeforeMethod
	public void set_up() {
		 BasePage=new BasePage();
		 prop=BasePage.initialize_properties();
		 driver=BasePage.intialize_driver();
		 driver.get(prop.getProperty("url"));
		 LandingPage=new LandingPage(driver);
				 }
	@Test(priority=1)
	public void VerifyPageTile() {
		String title=LandingPage.getPageTitle();
		System.out.println("Landing Page title is:"+ title);
		Assert.assertEquals(title,Constnats.HOME_PAGE_TITLE);
			
	}
	
	@Test(priority=2)
	public void Logo() {
		Assert.assertTrue(LandingPage.VerifyLogoDisplay(),"Logo not Properly");
	}
	
	@Test(priority=3)
	public void doRegistration() {
		LandingPage.navigatToRegistration();
	}
	
	@AfterMethod
	
	public void tear_down() {
		driver.quit();
	}
}
