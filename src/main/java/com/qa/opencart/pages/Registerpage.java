package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.ElementUtil;
import com.qa.opencart.util.constants;

public class Registerpage {
private WebDriver driver;
private ElementUtil util;
public Registerpage(WebDriver driver)
{
	this.driver=driver;
	util=new ElementUtil(driver);
}
private By Registerlogo=By.xpath("//div//h1[text()='Register Account']");
private By loginpagelink=By.linkText("login page");
private By firstname=By.id("input-firstname");
private By lastname=By.id("input-lastname");
private By email=By.id("input-email");
private By telephone=By.id("input-telephone");
private By password=By.id("input-password");
private By confirmpassword=By.id("input-confirm");
private By subscribeyes=By.xpath("//label[@class='radio-inline']//input[@type='radio'and @value='1']");
private By subscribeno=By.xpath("//label[@class='radio-inline']//input[@type='radio'  and @value='0']");
private By agreebutton=By.xpath("//input[@type='checkbox' and @value='1']");
private By continuebutton=By.xpath("//input[@type='submit' and @value='Continue']");
private By successmess=By.cssSelector("div#content h1");
private By registerlink=By.linkText("Register");
private By logoutbutton=By.linkText("Logout");

public boolean verifyRegisterlogo()
{
	return util.doIsDisplayed(Registerlogo);
}
public boolean verifyloginpagelink()
{
	return util.doIsDisplayed(loginpagelink);
}
public boolean verifyRegisterDetails(String Fname,String Lname,String Email,String Tele,String Password,String Subscribe)
{
	util.doSendKeys(firstname,Fname);
	util.doSendKeys(lastname, Lname);
	util.doSendKeys(email, Email);
	util.doSendKeys(telephone, Tele);
	util.doSendKeys(password, Password);
	util.doSendKeys(confirmpassword,Password);
	if(Subscribe.equalsIgnoreCase("yes"))
	{
		util.doClick(subscribeyes);
	}
	else
	{
		util.doClick(subscribeno);
	}
	
	util.doClick(agreebutton);
	util.doClick(continuebutton);
	String successmessage=util.doGetText(successmess);
	if(successmessage.contains(constants.Registrationmessage))
	{ util.doClick(logoutbutton);
	util.doClick(registerlink);
return true;
	}
	return false;
}
}
