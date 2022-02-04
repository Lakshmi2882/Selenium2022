package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.ElementUtil;

public class AccountPage {
	private WebDriver driver;
	private ElementUtil util;
	private By Homepagelogo=By.xpath("//div[@id='logo']");
	private By Accountpagesections=By.cssSelector("div#content h2");
	private By search=By.name("search");
	private By searchbutton=By.cssSelector("div#search button");
	private By logoutbutton=By.linkText("Logout");
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		util=new ElementUtil(driver);
	}
	public String verifyHomepageLogo()
	{
		return util.doGetText(Homepagelogo);
	}
	public boolean verifyLogoutButton()
	{
		return util.doIsDisplayed(logoutbutton);
	}
	public void isLogoutButtonClickable()
	{
		if(verifyLogoutButton())
		{
			util.doClick(logoutbutton);
		}
	}
	public List<String> verifyAccountSection()
	{//To get list of webelements
	//store list in ArrayList
		
		List<WebElement> AccountsectionList=util.waitForElementsToBeVisible(Accountpagesections,10);
		List<String>Accountlist=new ArrayList<String>();
		for(WebElement e:AccountsectionList)
		{
			Accountlist.add(e.getText());
		}
		return Accountlist;
	}
	public SearchResultPage dosearchtheproduct(String productname)
		{ util.doClear(search);
		util.doSendKeys(search, productname);
		util.doClick(searchbutton);
		return new SearchResultPage(driver);//page chaining,TDD approach
			
		}
		
		
		
		
		
		
		
		
		
		
		
}

	

