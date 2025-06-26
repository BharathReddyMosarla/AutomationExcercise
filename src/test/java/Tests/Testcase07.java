package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import utilities.BaseClass;

public class Testcase07 extends BaseClass
{
	@Test
	public void testcasepage()
	{
		try 
		{
			test=extent.createTest("TestCase Page").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");

			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			
			AssertJUnit.assertEquals("Automation Exercise", driver.getTitle());
			test.log(Status.PASS, "Home Page is Displayed");
	
			
			click(homepageobject.TestCases);
			test.log(Status.INFO, "Navigate to Testcase Page");
		
			AssertJUnit.assertEquals("Automation Practice Website for UI Testing - Test Cases", driver.getTitle());
			test.log(Status.PASS, "TestCase Page is Displayed");
			
			click(homepageobject.Home);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("testcase07");
		}
	}

}
