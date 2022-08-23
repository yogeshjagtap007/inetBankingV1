package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		logger.info("Providing customer details");
		
		addcust.custName("Yogesh");
		addcust.custgender("Male");
		addcust.custdob("12","10","1998");
	
		addcust.custaddress("India");

		addcust.custcity("Baramati");

		addcust.custstate("Maharashtra");
	
		addcust.custpinno("413102");

		addcust.custtelephoneno("7350146905");


		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcedd");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		logger.info("Validation is started");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test case is passed");
		}
		else
		{
			logger.info("Test case is failed");
			captureScreen(driver,"addNewCustomer");
			Assert.assertFalse(false);
			
		}
		
	}
	
}
