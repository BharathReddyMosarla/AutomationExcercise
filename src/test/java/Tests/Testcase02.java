package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;



import Pages.HomePage;
import Pages.SignupLoginPage;
import utilities.BaseClass;

public class Testcase02 extends BaseClass
{
	@Test
	public void loginUser()
	{
		try 
		{
			test=extent.createTest("Login User - Valid Data").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			
			
			// before login to the user we need to register a user
			
			register();  // "testcasesample@gmail.com"   is registered email address 
			
			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			SignupLoginPage signuploginpageobject=PageFactory.initElements(driver,SignupLoginPage.class);
				
			AssertJUnit.assertEquals("Automation Exercise", driver.getTitle());
			test.log(Status.PASS, "Home Page is Displayed");
			
			click(homepageobject.Signup_Login);
			test.log(Status.INFO, "Navigate to Login Page");
			
			// -- login the user
			AssertJUnit.assertEquals(true, signuploginpageobject.LoginText.isDisplayed());
			test.log(Status.PASS, "Login to your account Text is Displayed");
			
			enterData(signuploginpageobject.LoginEmail,"testcasesample@gmail.com");
			enterData(signuploginpageobject.LoginPassword,"testcasesample@gmail.com");
			test.log(Status.INFO, "Entered Valid email address and password");
			
			click(signuploginpageobject.LoginButton);
			test.log(Status.INFO, "Navigate to Home Page and Login as Entered Login User Name ");
			
			AssertJUnit.assertEquals(true, signuploginpageobject.UserName.isDisplayed());
			test.log(Status.PASS, "Username is Displayed");
			
			click(signuploginpageobject.DeleteAccount);
			test.log(Status.INFO, "Navigate to Delete Account Confirmation Page");
			
			AssertJUnit.assertEquals(true,signuploginpageobject.Text.isDisplayed());
			test.log(Status.PASS, "ACCOUNT DELETED! Text is Displayed");
			
			// optional action for future test cases
			click(signuploginpageobject.ContinueButton);
			test.log(Status.INFO, "Navigate to Home Page ");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong: "+e.getMessage());
			screenshot("testcase02");
		}
	}
}