package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import Pages.HomePage;
import Pages.SignupLoginPage;
import utilities.BaseClass;

public class Testcase01 extends BaseClass
{

	@Test
	public void registerUser()
	{
		try 
		{
		
			test=extent.createTest("Register User - Valid Data").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			
//			driver.get(config.getProperty("URL"));
//			test.log(Status.INFO, "Navigate to Application");
			
			
			
			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			SignupLoginPage signuploginpageobject=PageFactory.initElements(driver,SignupLoginPage.class);
				
			AssertJUnit.assertEquals("Automation Exercise", driver.getTitle());
			test.log(Status.PASS, "Home Page is Displayed");
			
			click(homepageobject.Signup_Login);
			test.log(Status.INFO, "Navigate to Signup Page");
			
			AssertJUnit.assertEquals("New User Signup!", signuploginpageobject.SignupText.getText());
			test.log(Status.PASS, "New User Signup! Text is Displayed");
			
			enterData(signuploginpageobject.SignupName,config.getProperty("Name"));
			enterData(signuploginpageobject.SignupEmail,"testcase01@gmail.com");
			test.log(Status.INFO, "Entered  Signup details");
			
			click(signuploginpageobject.SignupButton);
			test.log(Status.INFO, "Navigate to Signup Page");
			
			AssertJUnit.assertEquals(true, signuploginpageobject.accinfotext.isDisplayed());
			test.log(Status.PASS, "ENTER ACCOUNT INFORMATION Text is Displayed");
			
			click(signuploginpageobject.MaleRadio);
	//		signuploginpageobject.Name.clear();
	//		enterData(signuploginpageobject.Name,config.getProperty("Name"));
			enterData(signuploginpageobject.Password,config.getProperty("Password"));
			selectByValue(signuploginpageobject.DaysDropdown,config.getProperty("Day"));
			selectByValue(signuploginpageobject.MonthsDropdown,config.getProperty("Month"));
			selectByVisualText(signuploginpageobject.YearsDropdown,config.getProperty("Year"));
			
			click(signuploginpageobject.NewsletterCheckbox);
			test.log(Status.INFO, "Selected checkbox 'Sign up for our newsletter!");
			
			action.sendKeys(Keys.PAGE_DOWN).perform();
			click(signuploginpageobject.OptinCheckbox);
			test.log(Status.INFO, "Selected checkbox 'Receive special offers from our partners!");
			
			enterData(signuploginpageobject.FirstName,config.getProperty("fname"));
			enterData(signuploginpageobject.LastName,config.getProperty("lname"));
			enterData(signuploginpageobject.Company,config.getProperty("company"));
			enterData(signuploginpageobject.Address1,config.getProperty("address1"));
			enterData(signuploginpageobject.Address2,config.getProperty("address2"));
			selectByValue(signuploginpageobject.CountryDropdown,config.getProperty("country"));
			enterData(signuploginpageobject.State,config.getProperty("state"));
			enterData(signuploginpageobject.City,config.getProperty("city"));
			click(signuploginpageobject.OptinCheckbox);
			enterData(signuploginpageobject.Zipcode,config.getProperty("zipcode"));
			enterData(signuploginpageobject.MobileNumber,config.getProperty("mobilenumber"));
			test.log(Status.INFO, "Entered  all register user details");
			
			click(signuploginpageobject.CreateAccountButton);
			test.log(Status.INFO, "Navigate to  Account create Confirmation Page");
			
			AssertJUnit.assertEquals(true,signuploginpageobject.Text.isDisplayed());
			test.log(Status.PASS, "ACCOUNT CREATED! Text is Displayed");
			
			click(signuploginpageobject.ContinueButton);
			test.log(Status.INFO, "Navigate to Home Page and Login as "+config.getProperty("Name"));
			
			AssertJUnit.assertEquals(true, signuploginpageobject.UserName.isDisplayed());
			test.log(Status.PASS, "Username "+config.getProperty("Name")+" is Displayed");
			
			// deleting the current user acount
			click(signuploginpageobject.DeleteAccount);
			test.log(Status.INFO, "Navigate to Delete Account Confirmation Page");
			
			AssertJUnit.assertEquals(true,signuploginpageobject.Text.isDisplayed());
			test.log(Status.PASS, "ACCOUNT DELETED! Text is Displayed");
			
			click(signuploginpageobject.ContinueButton);
			test.log(Status.INFO, "Navigate to Home Page ");
			
		}
		
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong: "+e.getMessage());
			screenshot("testcase01");
		}
	}
}
