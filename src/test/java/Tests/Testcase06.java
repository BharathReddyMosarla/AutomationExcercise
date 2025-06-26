package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Pages.ContactusPage;
import Pages.HomePage;
import utilities.BaseClass;

public class Testcase06 extends BaseClass
{
	
	@Test
	public void contactForm()
	{
		try 
		{
			test=extent.createTest("Contact Form").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		
			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			ContactusPage contactuspageobject = PageFactory.initElements(driver,ContactusPage.class);
				
			AssertJUnit.assertEquals("Automation Exercise", driver.getTitle());
			test.log(Status.PASS, "Home Page is Displayed");
	
			click(homepageobject.Contactus);
			test.log(Status.INFO, "Navigate to Contact Us Page");
			
			AssertJUnit.assertEquals(true, contactuspageobject.ContactusText.isDisplayed());
			test.log(Status.PASS, "GET IN TOUCH text is Displayed");
			
			enterData(contactuspageobject.Name,config.getProperty("Name"));
			enterData(contactuspageobject.Email,config.getProperty("Email"));
			enterData(contactuspageobject.Subject,config.getProperty("Subject"));
			enterData(contactuspageobject.Message,config.getProperty("Message"));
			enterData(contactuspageobject.FileUpload,System.getProperty("user.dir")+config.getProperty("SampleFile"));
			test.log(Status.INFO, "Enter all Fields data");
			
			click(contactuspageobject.SubmitButton);
			test.log(Status.INFO, "Confirmation Pop-up Box is displayed");
			
			switchToAlertAccept();
			test.log(Status.INFO, "Accept the Submission from Pop-up Box");
		
			AssertJUnit.assertEquals(true, contactuspageobject.SucessMessage.isDisplayed());
			test.log(Status.PASS, "Success! Your details have been submitted successfully text is Displayed");
			
			click(contactuspageobject.HomeButton);
			test.log(Status.INFO, "Navigate to Home Page");
			
			AssertJUnit.assertEquals("Automation Exercise",driver.getTitle());
			test.log(Status.PASS, "Home Page is Displayed");
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("testcase06");
		}
	}
	

}
