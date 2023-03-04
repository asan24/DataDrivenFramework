package com.w2a.rough;

import java.io.FileInputStream;
import java.util.Properties;

public class TestProperties {

	public static void main(String [] args ) throws Throwable {
		
		
		//read Config.properties file
		Properties config = new Properties();
		Properties or = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		System.out.println(config.getProperty("browser"));
		
		//read OR.properties config file
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		or.load(fis);
		//driver.findElement(By.ccsSelector(or.getProperty("bmlBtn"))).click();
		System.out.println(or.getProperty("bmlBtn"));
		
	}
	
}
