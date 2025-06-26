package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;


import Pages.HomePage;
import Pages.SignupLoginPage;
import utilities.BaseClass;

public class Testcase04 extends BaseClass
{
	
	@Test
	public void logoutUser()
	{
		try 
		{
			test=extent.createTest("Logout a User").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			
			// before login to the user we need to create a user
			register();
			
			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			SignupLoginPage signuploginpageobject=PageFactory.initElements(driver,SignupLoginPage.class);
				
			AssertJUnit.assertEquals("Automation Exercise", driver.getTitle());
			test.log(Status.PASS, "Home Page is Displayed");
	
			click(homepageobject.Signup_Login);
			test.log(Status.INFO, "Navigate to Login Page");
			
			AssertJUnit.assertEquals(true, signuploginpageobject.LoginText.isDisplayed());
			test.log(Status.PASS, "Login to your account text is Displayed");
			
			enterData(signuploginpageobject.LoginEmail,"testcasesample@gmail.com");
			enterData(signuploginpageobject.LoginPassword,"testcasesample@gmail.com");
			test.log(Status.INFO, "Entered Valid login details");
			
			click(signuploginpageobject.LoginButton);
			test.log(Status.INFO, "Navigate to Home Page as Login Username");
			
			AssertJUnit.assertEquals(true, signuploginpageobject.UserName.isDisplayed());
			test.log(Status.PASS, "Login Username is Displayed");
		
			click(signuploginpageobject.Logout);
			test.log(Status.INFO, "Logout Successfull and Navigate to Home Page");
			
			AssertJUnit.assertEquals(true, signuploginpageobject.LoginText.isDisplayed());
			test.log(Status.PASS, "Home page is Displayed without Login");
						
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
			screenshot("testcase04");
		}
		
	}
	

}
