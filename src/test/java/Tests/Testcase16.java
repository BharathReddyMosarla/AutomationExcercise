package Tests;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.PaymentDetailsPage;
import Pages.ProductsPage;
import Pages.SignupLoginPage;
import utilities.BaseClass;

public class Testcase16 extends BaseClass
{
	@Test
	public void loginBeforeCheckout()
	{
		try 
		{
			test=extent.createTest("Login Before Checkout").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			
			// before login to the user we need to register a user
			
			register();  // "testcasesample@gmail.com"   is registered email address 
			
			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			ProductsPage productspageobject=PageFactory.initElements(driver,ProductsPage.class);
			PaymentDetailsPage paymentdetailspageobject=PageFactory.initElements(driver,PaymentDetailsPage.class);
			CartPage cartpageobject = PageFactory.initElements(driver, CartPage.class);
			SignupLoginPage signuploginpageobject=PageFactory.initElements(driver,SignupLoginPage.class);
			CheckoutPage checkoutpageobject =PageFactory.initElements(driver,CheckoutPage.class);
			
			AssertJUnit.assertEquals("Automation Exercise", driver.getTitle());
			test.log(Status.PASS, "Home Page is Displayed");
			
			click(homepageobject.Signup_Login);
			test.log(Status.INFO, "Navigate to Signup Page");
			
			AssertJUnit.assertEquals(true, signuploginpageobject.LoginText.isDisplayed());
			test.log(Status.PASS, "Login to your account Text is Displayed");
			
			enterData(signuploginpageobject.LoginEmail,"testcasesample@gmail.com");
			enterData(signuploginpageobject.LoginPassword,"testcasesample@gmail.com");
			test.log(Status.INFO, "Entered Valid email address and password");
			
			click(signuploginpageobject.LoginButton);
			test.log(Status.INFO, "Navigate to Home Page and Login as "+config.getProperty("Name"));
			
			AssertJUnit.assertEquals(true, signuploginpageobject.UserName.isDisplayed());
			test.log(Status.PASS, "Username "+config.getProperty("Name")+" is Displayed");
			
			hover(productspageobject.AddtoCartButtonAll.get(4));
			
			hover(productspageobject.AddtoCartButtonAll.get(0));
			click(productspageobject.AddtoCartButtonAll.get(0));
			test.log(Status.INFO, "First Product is added to cart");
			
			click(productspageobject.ContinueShoppingButton);
			test.log(Status.INFO, "Products are displayed for adding to cart");
			
			hover(productspageobject.AddtoCartButtonAll.get(1));
			click(productspageobject.AddtoCartButtonAll.get(1));
			test.log(Status.INFO, "Second Product is added to cart");
			
			click(productspageobject.ViewCartLink);
			test.log(Status.INFO, "Navigate to Cart Page");
	
			AssertJUnit.assertEquals("Automation Exercise - Checkout", driver.getTitle());
			test.log(Status.PASS, "Checkout Page is Displayed");
			
			click(cartpageobject.ProceedToCheckout);
			test.log(Status.INFO, "Navigate to Checkout Page");
			
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
			
			enterData(checkoutpageobject.OrderDescription,"first test");
			test.log(Status.INFO, "Entered Order Description");
			click(checkoutpageobject.PlaceOrderButton);
			test.log(Status.INFO, "Navigate to Payment Page");
			
			enterData(paymentdetailspageobject.NameOnCard,config.getProperty("NameonCard"));
			enterData(paymentdetailspageobject.CardNumber,config.getProperty("CardNumber"));
			enterData(paymentdetailspageobject.CVC,config.getProperty("CVC"));
			enterData(paymentdetailspageobject.ExpiryMonth,config.getProperty("ExpiryMonth"));
			enterData(paymentdetailspageobject.ExpiryYear,config.getProperty("ExpiryYear"));
			test.log(Status.INFO, "Entered all Payment details");
			click(paymentdetailspageobject.PayandConfirmOrderButton);
			test.log(Status.INFO, "Navigate to Next Page");
			
			AssertJUnit.assertEquals(true, paymentdetailspageobject.OrderConfirmMessage.isDisplayed());
			test.log(Status.PASS, "Order Confirmation Message is Verified");
			
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
			screenshot("testcase16");
		}
	}
}