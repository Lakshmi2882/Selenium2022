package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.open.TestListeners.AllureReportListener;
import com.qa.opencart.util.constants;
@Listeners(AllureReportListener.class)

public class AccountpageTest extends BaseTest{
	//Page chaining:loginpage responsibility to give you the object of the Accountpage
	
	@BeforeClass
	public void AccountPageSetUp()
	{
	Account=login.DoLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test(priority=1)
	public void HomepageLogoTest()
	{
	Assert.assertEquals(Account.verifyHomepageLogo(),constants.HomepageLogo);
	}
	@Test(priority=2)
	public void AccountSectionTest()
	{
	List<String> Accountpagesections=	Account.verifyAccountSection();
	Assert.assertEquals(Accountpagesections, constants.AccountSectionHeaders());
	}
	@DataProvider
	public Object[][] productData()
	{
		return new Object[][]{{"MacBook"},
				{"Apple"},
		{"Samsung"}};
	}
		
	@Test(priority=3,dataProvider="productData")
	public void DoSearchTest(String productname)
	{
	searchpage=	Account.dosearchtheproduct(productname);
	Assert.assertTrue(searchpage.verifyProductSize()>0);
	}
	@DataProvider
	public Object[][] products()
	{
		return new Object[][] {{"MacBook","MacBook Pro"},{"iMac","iMac"},{"Samsung","Samsung Sync"},{"Apple","Apple Cinema 30"}};
	}
	@Test(priority=4,dataProvider= "products")
	public void selectproductTest(String productname,String mainproductname)
	{
	searchpage=	Account.dosearchtheproduct(productname);
	product=searchpage.verifyProductavailable(mainproductname);
	Assert.assertEquals(product.verifyProductHeader(),mainproductname);
	}

}
