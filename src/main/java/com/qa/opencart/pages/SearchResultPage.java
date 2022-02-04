package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.ElementUtil;

public class SearchResultPage {
private WebDriver driver;
private ElementUtil util;
public SearchResultPage(WebDriver driver)
{
	this.driver=driver;
	util=new ElementUtil(driver);
}
private By productlist=By.cssSelector("div.caption a");
public int verifyProductSize()
{
	int productsize=util.waitForElementsToBeVisible(productlist, 10, 2000).size();
	System.out.println(productsize);
	return productsize;
}
public ProductInfopage verifyProductavailable(String productname)
{
	List<WebElement> productnames=util.waitForElementsToBeVisible(productlist, 10, 2000);
	for(WebElement e:productnames)
	{
		String text=e.getText();
		if(text.equalsIgnoreCase(productname))
		{
			e.click();
			break;
		}
	}
	return new ProductInfopage(driver);//page chaining because connecting to next page and Tdd approach,
	//because you are writing a code for testcase and refasctor your code until testcase is passed
}
}
