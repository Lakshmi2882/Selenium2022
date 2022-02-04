package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.ElementUtil;
import com.qa.opencart.util.constants;

public class Loginpage {
private WebDriver driver;//here driver is null, so we need to create constructor to initialize driver
//private variables and private methods can not be overriden and can not be used out side the class
private ElementUtil util;
public Loginpage(WebDriver driver)
{
	this.driver=driver;
	util=new ElementUtil(driver);
	
}//encapsulation: make methods and variables private, you can access them by using public
private  By emailId=By.name("email");
private By password=By.name("password");
private By loginbutton=By.xpath("//input[@value='Login']");
private By forgotlink=By.linkText("Forgotten Password");
private By registerlink=By.linkText("Register");

public String verifyLoginpageTitle()
{
	return driver.getTitle();
}
public boolean verifyForgotlink()
{
	return util.doIsDisplayed(forgotlink);
}
public boolean verifyurl()
{
	return util.waitForURLToBe(constants.Url, 50);
}
public boolean verifyregisterlink()
{
	return util.doIsDisplayed(registerlink);
}
public AccountPage DoLogin(String un,String pwd)
{
	util.getElement(emailId).sendKeys(un);
util.getElement(password).sendKeys(pwd);
util.doActionClick(loginbutton);
return new AccountPage(driver);//page chaining,TDD

}
public Registerpage gotoRegisterpage()
{
	util.doClick(registerlink);
	return new Registerpage(driver);
}

}
