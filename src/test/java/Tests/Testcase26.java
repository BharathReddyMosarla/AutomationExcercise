package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import utilities.BaseClass;

public class Testcase26 extends BaseClass
{
	@Test
	public void scrollUp()
	{
		try 
		{
			test=extent.createTest("Scroll Up without using Arrow Button").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");

			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
		
			AssertJUnit.assertEquals("Automation Exercise", driver.getTitle());
			test.log(Status.PASS, "Home Page is Displayed");
			
			action.sendKeys(Keys.PAGE_DOWN).perform();
			AssertJUnit.assertEquals(true, homepageobject.copyright.isDisplayed());
			test.log(Status.PASS, "copyright Text is Displayed");	
					
			action.sendKeys(Keys.PAGE_UP).perform();
			AssertJUnit.assertEquals(true, homepageobject.HeaderScrollText.isDisplayed());
			test.log(Status.PASS, "Full-Fledged practice website for Automation Engineers Text is Displayed");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("testcase26");
		}
	}
}