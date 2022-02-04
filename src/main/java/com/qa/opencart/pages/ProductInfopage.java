package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.ElementUtil;

public class ProductInfopage {
	private WebDriver driver;
	private ElementUtil util;
	public ProductInfopage(WebDriver driver)
	{
		this.driver=driver;
		util=new ElementUtil(driver);
		
	}

	private By productHeader=By.cssSelector("div#content h1");
	private By imageslist=By.cssSelector("div#content img");
	private By productmetadata=By.cssSelector("div#content .list-unstyled:nth-of-type(1) li");
	private By productpricedata=By.cssSelector("div#content .list-unstyled:nth-of-type(2) li");
	private By Qty=By.name("quantity");
	private By Addtocart=By.id("button-cart");
	private HashMap<String,String> productInfo;
	public String verifyProductHeader()
	{
	return	util.doGetText(productHeader);
	}
	public int verifyImagesList()
	{
	int listofelements=	util.waitForElementsToBeVisible(imageslist, 10).size();
	return listofelements;
	}
	public Map<String, String> productInformation()
	{
		productInfo=new LinkedHashMap<String,String>();//LinkedHashMap maintains an order
		//HashMap does not maintain an order
		verifyproductmetadata();//encapsulation:private methods are called by public layer
		verifyproductprice();
		return productInfo;
	}
	private void verifyproductmetadata()
	{
		List<WebElement>metaDatalist=util.getElements(productmetadata);
		for(WebElement e:metaDatalist)
		{
		String text=e.getText();
		String meta[]=text.split(":");
		String metakey=meta[0].trim();
		String metavalue=meta[1].trim();
		productInfo.put(metakey, metavalue);
		}
	}
	private void verifyproductprice()
	{
		List<WebElement>metaPriceList=util.getElements(productpricedata);
		String price=metaPriceList.get(0).getText().trim();
		String exprice=metaPriceList.get(1).getText().trim();
		productInfo.put("price", price);
		productInfo.put("exprice", exprice);
	}
}
