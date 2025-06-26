package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import utilities.BaseClass;

public class Testcase11  extends BaseClass
{
	@Test
	public void subCart()
	{
		try 
		{
			test=extent.createTest("Verify Subscription in Cart Page").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			

			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
		
			AssertJUnit.assertEquals("Automation Exercise", driver.getTitle());
			test.log(Status.PASS, "Home Page is Displayed");
	
			click(homepageobject.Cart);
			test.log(Status.INFO, "Navigate to Cart Page");
			
			hover(homepageobject.copyright);
			AssertJUnit.assertEquals("SUBSCRIPTION", homepageobject.SubscribeText.getText());
			test.log(Status.PASS, "Subscription Text is Displayed");
			
			enterData(homepageobject.subscribe_email,config.getProperty("Email"));
			test.log(Status.INFO, "subscription Valid Email is entered");
			
			click(homepageobject.subscribeButton);
			test.log(Status.INFO, "Verify subscription email and Submited");
			
			
			AssertJUnit.assertEquals(true, homepageobject.SubMessage.isDisplayed());
			test.log(Status.PASS, "You have been successfully subscribed! Message is Displayed");
			
			click(homepageobject.Home);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("testcase11");
		}

	}

}
