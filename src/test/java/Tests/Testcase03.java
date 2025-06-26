
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

public class Testcase03 extends BaseClass
{
	@Test
	public void loginUserNon()
	{
		try 
		{
			test=extent.createTest("Login User - Invalid Data").assignCategory("Negative Testing").assignAuthor("Bharath Reddy");
			
			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			SignupLoginPage signuploginpageobject=PageFactory.initElements(driver,SignupLoginPage.class);
				
			AssertJUnit.assertEquals("Automation Exercise", driver.getTitle());
			test.log(Status.PASS, "Home Page is Displayed");
	
			click(homepageobject.Signup_Login);
			test.log(Status.INFO, "Navigate to Login Pge");
				
			AssertJUnit.assertEquals(true, signuploginpageobject.LoginText.isDisplayed());
			test.log(Status.PASS, "Login to your account Text is Displayed");
			
			enterData(signuploginpageobject.LoginEmail,config.getProperty("InvalidEmail"));
			enterData(signuploginpageobject.LoginPassword,config.getProperty("InvalidPassword"));
			test.log(Status.INFO, "Entered Invalid data");
			
			click(signuploginpageobject.LoginButton);
			test.log(Status.INFO, "verify the login details and Still in Login Pge");
			
			AssertJUnit.assertEquals(true, signuploginpageobject.ErrorLoginText.isDisplayed());
			test.log(Status.PASS, "Your email or password is incorrect! Error Message is Displayed");
					
			click(homepageobject.Home);
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong: "+e.getMessage());
			screenshot("testcase03");
		}
	}

}
