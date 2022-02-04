package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.open.TestListeners.AllureReportListener;
import com.qa.opencart.util.constants;
@Listeners(AllureReportListener.class)
public class LoginPageTest extends BaseTest {
	@BeforeMethod
	@Test(priority=1)
	public void loginpageTitleTest()
	{
		String actTitle=login.verifyLoginpageTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, constants.Login_page_Title);
	}
@Test(priority=2,enabled=false)
public void loginpageUrlTest()
{
	Assert.assertTrue(login.verifyurl());
}
@Test(priority=3)
public void verifylogin()
{
	login.DoLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
}


}
