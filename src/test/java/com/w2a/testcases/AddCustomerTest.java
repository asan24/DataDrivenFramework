package com.w2a.testcases;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.w2a.utilities.*;
import com.w2a.base.TestBase;
public class AddCustomerTest extends TestBase{

	
	@Test(dataProvider="test1Data",dataProviderClass = ExcelDataProvider.class)
	public void addCustomer(String firstName, String lastName, String postCode, String alertText) {
		
		
		driver.findElement(By.cssSelector(or.getProperty("addCustBtn"))).click();
		driver.findElement(By.cssSelector(or.getProperty("firstName"))).sendKeys(firstName);
		driver.findElement(By.cssSelector(or.getProperty("lastName"))).sendKeys(lastName);
		driver.findElement(By.cssSelector(or.getProperty("postalCode"))).sendKeys(postCode);
		driver.findElement(By.cssSelector(or.getProperty("addCustomer"))).click();
		logger.info("Customer added");
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		Assert.assertTrue(alert.getText().contains(alertText));
		alert.accept();
		Reporter.log("New Customer Added Successfully");
		
		
	}
	
	
	
	
}//class
