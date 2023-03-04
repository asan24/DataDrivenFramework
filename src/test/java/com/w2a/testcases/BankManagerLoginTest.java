package com.w2a.testcases;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.w2a.base.TestBase;


public class BankManagerLoginTest extends TestBase{

	


	@Test
	public void loginAsBankManager()   {
		logger.info("Inside Login Test");
		driver.findElement(By.cssSelector(or.getProperty("bmlBtn"))).click();
		Assert.assertTrue(isElementPresent(By.cssSelector(or.getProperty("addCustBtn"))),"Login not successful");
		logger.info("Login successfully executed");
		Reporter.log("Login successfully executed");
	}
	
	
	
}
