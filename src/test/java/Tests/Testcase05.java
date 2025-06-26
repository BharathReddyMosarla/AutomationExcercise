package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Pages.HomePage;
import Pages.SignupLoginPage;
import utilities.BaseClass;

public class Testcase05 extends BaseClass
{
	@Test
	public void registerUserNon()
	{
		try 
		{
			test=extent.createTest("Register  User - Existing Data").assignCategory("Negative Testing").assignAuthor("Bharath Reddy");
			
			// before login to the user we need to Register a user
			register();
			
			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			SignupLoginPage signuploginpageobject=PageFactory.initElements(driver,SignupLoginPage.class);
				
			AssertJUnit.assertEquals("Automation Exercise", driver.getTitle());
			test.log(Status.PASS, "Home Page is Displayed");
	
			click(homepageobject.Signup_Login);
			test.log(Status.INFO, "Navigate to Signup Page");
			
			AssertJUnit.assertEquals("New User Signup!", signuploginpageobject.SignupText.getText());
			test.log(Status.PASS, "New User Signup! text is Displayed");
			
			enterData(signuploginpageobject.SignupName,config.getProperty("Name"));
			enterData(signuploginpageobject.SignupEmail,"testcasesample@gmail.com");
			test.log(Status.INFO, "Entered Existing signup details data");
			
			click(signuploginpageobject.SignupButton);
			test.log(Status.INFO, "verify the entered details and  still in Signup Page");
			
			AssertJUnit.assertEquals(true, signuploginpageobject.ErrorSignupText.isDisplayed());
			test.log(Status.PASS, "Email Address already exist!' Error Message is Displayed");
			
			// optional for future test cases delete registered user
			click(homepageobject.Signup_Login);
			enterData(signuploginpageobject.LoginEmail,"testcasesample@gmail.com");
			enterData(signuploginpageobject.LoginPassword,"testcasesample@gmail.com");
			click(signuploginpageobject.LoginButton);
			click(signuploginpageobject.DeleteAccount);				
			click(signuploginpageobject.ContinueButton);
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong: "+e.getMessage());
			screenshot("testcase05");
		}

	}
}
