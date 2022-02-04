package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.open.TestListeners.AllureReportListener;
@Listeners(AllureReportListener.class)

public class ProductInfoPageTest extends BaseTest{
@BeforeClass
public void productpageSetup()
{
	Account=login.DoLogin(prop.getProperty("username"),prop.getProperty("password"));

}
@Test(priority=1)
public void productHeaderTest()
{ searchpage=Account.dosearchtheproduct("MacBook");
   product=searchpage.verifyProductavailable("MacBook Pro");
	Assert.assertEquals(product.verifyProductHeader(),"MacBook Pro");
}
@Test(priority=2)
public void productImagesTest()
{searchpage=Account.dosearchtheproduct("MacBook");
product=searchpage.verifyProductavailable("MacBook Pro");
	Assert.assertEquals(product.verifyImagesList(),4);
}
@Test(priority=3)
public void productInfoTest()
{searchpage=Account.dosearchtheproduct("MacBook");
product=searchpage.verifyProductavailable("MacBook Pro");
Map<String,String>actproductInfo=product.productInformation();
actproductInfo.forEach((k,v)->System.out.println(k+":"+v));
softassert.assertEquals(actproductInfo.get("Brand"),"Apple" );
softassert.assertEquals(actproductInfo.get("name"),"MacBook Pro");
softassert.assertAll();
	
}
}
