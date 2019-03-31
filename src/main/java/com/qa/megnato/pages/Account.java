package com.qa.megnato.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.megnato.base.BasePage;

public class Account extends BasePage{

	public Account(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
}
