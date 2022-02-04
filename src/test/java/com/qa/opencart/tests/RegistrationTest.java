package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.util.ExcelUtil;
import com.qa.opencart.util.constants;

public class RegistrationTest extends BaseTest {
	@BeforeClass
	public void RegisterSetUp()
	{
	register=login.gotoRegisterpage();
	}
	@DataProvider
	public Object[][] getRegisterData()
	{
		return ExcelUtil.getTestData(constants.Register_sheet_name);
	}
 @Test(dataProvider="getRegisterData")
 public void RegistrationPageTest(String Fname, String Lname, String Email,String Tele,String Password,String Subscriber)
 {
Assert.assertTrue( register.verifyRegisterDetails(Fname,Lname,Email,Tele,Password,Subscriber));
 }
}
