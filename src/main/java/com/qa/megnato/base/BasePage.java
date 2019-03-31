package com.qa.megnato.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	
	public WebDriver intialize_driver() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pratik\\Desktop\\NL\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;		
	}
	
	public Properties initialize_properties() {
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\Pratik\\eclipse-workspace\\Megento\\src\\main\\java\\com\\qa\\megento\\config\\config.properties");
		    try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return prop;
	}
}
