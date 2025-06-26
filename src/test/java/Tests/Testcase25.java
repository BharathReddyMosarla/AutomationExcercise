package Tests;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import Pages.HomePage;
import utilities.BaseClass;

public class Testcase25 extends BaseClass
{
	@Test
	public void scrollUpArrow()
	{
		try
		{
			test=extent.createTest("Scroll Up using Arrow Button").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");

			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
		
			AssertJUnit.assertEquals("Automation Exercise", driver.getTitle());
			test.log(Status.PASS, "Home Page is Displayed");	
			
			
			hover(homepageobject.copyright);
			AssertJUnit.assertEquals(true, homepageobject.SubscribeText.isDisplayed());
			test.log(Status.PASS, "SUBSCRIPTION Text is Displayed");
			
			
			//--- ad is itrupted to click on scrolu arrow button
			click(homepageobject.ScrollUpArrow);
			test.log(Status.INFO, "Scroll up to Top of a page");

			AssertJUnit.assertEquals(true, homepageobject.HeaderScrollText.isDisplayed());
			test.log(Status.PASS, "Full-Fledged practice website for Automation Engineers Text is Displayed");
			
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			
			screenshot("testcase25");
		}

	}
}