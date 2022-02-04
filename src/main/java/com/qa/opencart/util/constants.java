package com.qa.opencart.util;

import java.util.ArrayList;

public class constants {
	//if it is static and final, you can call by using constants.login_page_titile
	//Excel sheet data is for to change the data again and again
	//In Excel sheet we store only the test data
public static final String Login_page_Title="Account Login";
public static final String Url="account/login";
public static final String HomepageLogo="Your Store";
public static final int Default_time=50;
public static  ArrayList<String> AccountSectionHeaders()
{
	ArrayList<String> AccountsectionHeaders=new ArrayList<String>();
	AccountsectionHeaders.add("My Account");
	AccountsectionHeaders.add("My Orders");
	AccountsectionHeaders.add("My Affiliate Account");
	AccountsectionHeaders.add("Newsletter");
	return AccountsectionHeaders;
}
public static final String Registrationmessage="Your Account Has Been Created!";
public static final String Register_sheet_name="registration";
		
}
