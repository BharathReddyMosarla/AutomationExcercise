package Tests;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.ProductsPage;
import Pages.SignupLoginPage;
import utilities.BaseClass;

public class Testcase23 extends BaseClass
{
	@Test
	public void VerifyAddressCheckout()
	{
		try 
		{
			test=extent.createTest("Verify address details in checkout page").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");

			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			ProductsPage productspageobject=PageFactory.initElements(driver,ProductsPage.class);
			CartPage cartpageobject = PageFactory.initElements(driver, CartPage.class);
			SignupLoginPage signuploginpageobject=PageFactory.initElements(driver,SignupLoginPage.class);
			CheckoutPage checkoutpageobject =PageFactory.initElements(driver,CheckoutPage.class);
			
			AssertJUnit.assertEquals("Automation Exercise", driver.getTitle());
			test.log(Status.PASS, "Home Page is Displayed");
			
			click(homepageobject.Signup_Login);
			test.log(Status.INFO, "Navigate to Signup Page");
			
			AssertJUnit.assertEquals("New User Signup!", signuploginpageobject.SignupText.getText());
			test.log(Status.PASS, "New User Signup! Text is Displayed");
			
			enterData(signuploginpageobject.SignupName,config.getProperty("Name"));
			enterData(signuploginpageobject.SignupEmail,"testcase23@gmail.com");
			test.log(Status.INFO, "Entered  Signup details");
			
			click(signuploginpageobject.SignupButton);
			test.log(Status.INFO, "Navigate to Signup Page");
			
			
		
			AssertJUnit.assertEquals(true, signuploginpageobject.accinfotext.isDisplayed());
			test.log(Status.PASS, "ENTER ACCOUNT INFORMATION Text is Displayed");
			
			click(signuploginpageobject.MaleRadio);
	//		signuploginpageobject.Name.clear();
	//		enterData(signuploginpageobject.Name,config.getProperty("Name"));
			enterData(signuploginpageobject.Password,"testcase23@gmail.com");
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
			
			
			hover(productspageobject.AddtoCartButtonAll.get(4));
			
			hover(productspageobject.AddtoCartButtonAll.get(0));
			click(productspageobject.AddtoCartButtonAll.get(0));
			test.log(Status.INFO, " Product is added to cart");
			
			click(productspageobject.ViewCartLink);
			test.log(Status.INFO, "Navigate to Cart Page");
			
			AssertJUnit.assertEquals("Automation Exercise - Checkout", driver.getTitle());
			test.log(Status.PASS, "Cart Page is Displayed");
			
			click(cartpageobject.ProceedToCheckout);
			test.log(Status.INFO, "Navigate to Checkout Page");
			
			
			// ------delivery address
			AssertJUnit.assertEquals("Mr. "+config.getProperty("fname")+" "+config.getProperty("lname"), checkoutpageobject.DFullName.getText());
			test.log(Status.PASS, "User Name is Verified");
			AssertJUnit.assertEquals(config.getProperty("company"), checkoutpageobject.DCompany.getText());
			test.log(Status.PASS, "Company Name is Verified");
			AssertJUnit.assertEquals(config.getProperty("address1"), checkoutpageobject.DAddress1.getText());
			test.log(Status.PASS, "Address1 is Verified");
			AssertJUnit.assertEquals(config.getProperty("address2"), checkoutpageobject.DAddress2.getText());
			test.log(Status.PASS, "Address2 is Verified");
			AssertJUnit.assertEquals(config.getProperty("state")+" "+config.getProperty("city")+" "+config.getProperty("zipcode"), checkoutpageobject.DSCZDetails.getText());
			test.log(Status.PASS, "State,City,Zipcode are Verified");
			AssertJUnit.assertEquals(config.getProperty("country"), checkoutpageobject.DCountry.getText());
			test.log(Status.PASS, "Country Name is Verified");
			AssertJUnit.assertEquals(config.getProperty("mobilenumber"), checkoutpageobject.DMobileNumber.getText());
			test.log(Status.PASS, "Mobile Number is Verified");
			
			// ------BILLING  address
			AssertJUnit.assertEquals("Mr. "+config.getProperty("fname")+" "+config.getProperty("lname"), checkoutpageobject.BFullName.getText());
			test.log(Status.PASS, "User Name is Verified");
			AssertJUnit.assertEquals(config.getProperty("company"), checkoutpageobject.BCompany.getText());
			test.log(Status.PASS, "Company Name is Verified");
			AssertJUnit.assertEquals(config.getProperty("address1"), checkoutpageobject.BAddress1.getText());
			test.log(Status.PASS, "Address1 is Verified");
			AssertJUnit.assertEquals(config.getProperty("address2"), checkoutpageobject.BAddress2.getText());
			test.log(Status.PASS, "Address2 is Verified");
			AssertJUnit.assertEquals(config.getProperty("state")+" "+config.getProperty("city")+" "+config.getProperty("zipcode"), checkoutpageobject.BSCZDetails.getText());
			test.log(Status.PASS, "State,City,Zipcode are Verified");
			AssertJUnit.assertEquals(config.getProperty("country"), checkoutpageobject.BCountry.getText());
			test.log(Status.PASS, "Country Name is Verified");
			AssertJUnit.assertEquals(config.getProperty("mobilenumber"), checkoutpageobject.BMobileNumber.getText());
			test.log(Status.PASS, "Mobile Number is Verified");
			
			click(signuploginpageobject.DeleteAccount);
			test.log(Status.INFO, "Navigate to Delete Account Confirmation Page");
			
			AssertJUnit.assertEquals(true,signuploginpageobject.Text.isDisplayed());
			test.log(Status.PASS, "ACCOUNT DELETED! Text is Displayed");
			
			click(signuploginpageobject.ContinueButton);
			test.log(Status.INFO, "Navigate to Home Page ");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("testcase23");
		}
	}

}
