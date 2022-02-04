package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.Factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.Loginpage;
import com.qa.opencart.pages.ProductInfopage;
import com.qa.opencart.pages.Registerpage;
import com.qa.opencart.pages.SearchResultPage;

public class BaseTest {
	//to get properties from basepage you need to initialize driver
	//All page references are maintained in BaseTest class
DriverFactory df;
Properties prop;
WebDriver driver;
Loginpage login;
AccountPage Account;
SearchResultPage searchpage;
ProductInfopage product;
SoftAssert softassert;
Registerpage register;

	@BeforeTest
	public void setUp()
	{ df=new DriverFactory();
	prop=	df.init_prop();
	driver=	df.init_driver(prop);
	login=new Loginpage(driver);
	Account=new AccountPage(driver);
	searchpage=new SearchResultPage(driver);
	product=new ProductInfopage(driver);
	searchpage=new SearchResultPage(driver);
	softassert=new SoftAssert();
	register=new Registerpage(driver);
		
	}
	@AfterTest
	public void TearDown()
	{
		driver.quit();
		
	}

}
