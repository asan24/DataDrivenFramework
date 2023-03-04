package com.w2a.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.w2a.utilities.ExcelDataProvider;

public class TestBase {
	/*
	 * WebDrivers -- done
	 * Properties -- done
	 * Logs --log4J, .log(Application.log) and log4J.properties
	 * OFF
	 * ExtentReport
	 * DB
	 * Excel
	 * Mail
	 * ReportNg, ExtentReports
	 * Jenkins
	 */

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static WebDriverWait wait;
	public Logger logger  = LogManager.getLogger(TestBase.class);
	
	@BeforeSuite
	public void setUp() {

		if (driver == null) {
			// read Config.properties file
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				config.load(fis);
				logger.info("Config File loaded!!!");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			

			// read OR.properties config file
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
				logger.info("Or file loaded!!!");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				or.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}

			
			if (config.getProperty("browser").equals("firefox")) {
				driver = new FirefoxDriver();
			} 
			else if (config.getProperty("browser").equals("chrome")) {
				driver = new ChromeDriver();
			}
			
			driver.get(config.getProperty("testsiteurl"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
			driver.manage().window().maximize();
			logger.info("WebPage opened!!!");
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			
		}

	}// setup method

	
	
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}
		catch(NoSuchElementException e) {
			return false;
		}
		
	}
	
	
	
	
	
	@AfterSuite
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
		
	}

}//class
