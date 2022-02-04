package com.qa.opencart.Factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
private Properties prop;
private FirefoxOptions fo;
private ChromeOptions co;
public OptionsManager(Properties prop)
{
	this.prop=prop;
}
public ChromeOptions chromeoptions()
{
	co=new ChromeOptions();
	if(Boolean.parseBoolean(prop.getProperty("headless")))
	{
		co.addArguments("--headless");
	}
	if(Boolean.parseBoolean(prop.getProperty("incognito")))
	{
		co.addArguments("--incognito");
	}
	return co;
}
public FirefoxOptions FirefoxOptions()
{
	fo=new FirefoxOptions();
	if(Boolean.parseBoolean(prop.getProperty("headless")))
	{
		fo.addArguments("--headless");
	}
	if(Boolean.parseBoolean(prop.getProperty("incognito")))
	{
		fo.addArguments("--incognito");
	}
	return fo;
}
}
