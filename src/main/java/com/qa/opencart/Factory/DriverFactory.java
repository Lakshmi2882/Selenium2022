package com.qa.opencart.Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public static String highlight;
	public WebDriver driver;
	//to initialize webDriver
	public Properties prop;
	public OptionsManager optionsmanager;
	public static ThreadLocal<WebDriver> tl_driver=new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver(Properties prop)
	{  
		String browsername=prop.getProperty("browser");
		System.out.println("enter browsername "+ browsername);
		highlight=prop.getProperty("highlight");
		optionsmanager=new OptionsManager(prop);
		if(browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver(optionsmanager.chromeoptions());
			tl_driver.set(new ChromeDriver(optionsmanager.chromeoptions()));
		}
		else
			if(browsername.equalsIgnoreCase("Firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				//driver=new FirefoxDriver(optionsmanager.FirefoxOptions());
				tl_driver.set(new FirefoxDriver(optionsmanager.FirefoxOptions()));
			}
			else
				if(browsername.equalsIgnoreCase("safari"))
				{
				//	driver=new SafariDriver();
					tl_driver.set(new SafariDriver());
					
				}
				else
				{
					System.out.println("enter correct browser name:"+browsername);
				}
		getDriver().manage().window().fullscreen();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}
	//getdriver() will return a thread local copy of the webDriver
	//synchronized key word is synchronization between driver
public static synchronized WebDriver getDriver()
{
	return tl_driver.get();
}
	//to handle exceptions we use try catch block
	public Properties init_prop()
	{
		prop=new Properties();
		FileInputStream ip=null;
		String envName=System.getProperty("env");
		if(envName==null)
		{try {
			ip=new FileInputStream("C:\\Users\\eddan\\eclipse-workspace\\2022MavenProject\\src\\TestResources\\configProperties\\configfile");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		}
		else
		{
			System.out.println("Running on environment:"+envName);
		try
		{
		switch(envName.toLowerCase())
		{
		case "qa":
			ip=new FileInputStream("C:\\Users\\eddan\\eclipse-workspace\\2022MavenProject\\src\\TestResources\\configProperties\\qa.config.properties");
           break;
		case "Dev":
			ip=new FileInputStream("C:\\Users\\eddan\\eclipse-workspace\\2022MavenProject\\src\\TestResources\\configProperties\\Dev.config.properties");
           break;
		case "stage":
			ip=new FileInputStream("C:\\Users\\eddan\\eclipse-workspace\\2022MavenProject\\src\\TestResources\\configProperties\\stage.config.properties");
            break;
		case "UAT":
			ip=new FileInputStream("C:\\Users\\eddan\\eclipse-workspace\\2022MavenProject\\src\\TestResources\\configProperties\\UAT.config.properties");
           break;
           default:
        	   System.out.println("enter correct environment");
        	   break;
		}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		}
	try {
		prop.load(ip);
		
	}
	catch(IOException e)
	{ e.printStackTrace();
	}
		return prop;
	}
	public String getScreenshot()
	{
	File src=	((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
	String path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
	File dest=new File(path);
	try {
		FileUtils.copyDirectory(src, dest);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return path;
	}

}
