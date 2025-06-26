package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Arrays;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductsPage;
import Pages.SignupLoginPage;
import utilities.BaseClass;

public class Testcase20 extends BaseClass
{
	@Test
	public void searchAddCartAfterLogin() throws Exception
	{
		try 
		{
			test=extent.createTest("Search Products and Verify Cart After Login").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");

			// before login to the user we need to register a user
			
			register();  // "testcasesample@gmail.com"   is registered email address 
			
			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			ProductsPage productspageobject=PageFactory.initElements(driver,ProductsPage.class);
			CartPage cartpageobject = PageFactory.initElements(driver, CartPage.class);
			SignupLoginPage signuploginpageobject=PageFactory.initElements(driver,SignupLoginPage.class);
			
			click(homepageobject.Products);
			test.log(Status.INFO, "Navigate to Products Page");
			
			AssertJUnit.assertEquals(true, productspageobject.AllProductsText.isDisplayed());
			test.log(Status.PASS, "ALL PRODUCTS text is Displayed");
			
			enterData(productspageobject.SearchBox,"tops");
			click(productspageobject.SearchIconButton);
			test.log(Status.INFO, "Searched products are displayed");
			
			AssertJUnit.assertEquals(true, productspageobject.SearchProductText.isDisplayed());
			test.log(Status.PASS, "SEARCHED PRODUCTS text is Displayed");
			
			int size=productspageobject.AllProductNames.size();
			
			for(int i=0;i<size;i++)
			{
				AssertJUnit.assertEquals(true, productspageobject.AllProductNames.get(i).isDisplayed());
				test.log(Status.PASS, "Product is Displayed");
			}
			// adding products to cart
			for(int i=0;i<size;i++)
			{
				hover(homepageobject.subscribe_email);
				click(productspageobject.AddtoCartButtonAll.get(i));
				test.log(Status.INFO, "Product is added Cart ");
				
				click(productspageobject.ContinueShoppingButton);
				test.log(Status.INFO, "Products are displayed for adding to cart");
			}
			String[] productsbl=new String[size];
			click(homepageobject.Cart);
			test.log(Status.INFO, "Navigate to Cart Page");
			
			for(int i=0;i<size;i++)
			{
				productsbl[i]=cartpageobject.AllDescriptions.get(i).getText();
				AssertJUnit.assertEquals(true, cartpageobject.AllDescriptions.get(i).isDisplayed());
				test.log(Status.PASS, "Product is Displayed");
			}
			
			//  login user have empty cart 
			
			click(homepageobject.Signup_Login);
			test.log(Status.INFO, "Navigate to Login Page");
			
			enterData(signuploginpageobject.LoginEmail,"testcasesample@gmail.com");
			enterData(signuploginpageobject.LoginPassword,"testcasesample@gmail.com");
			test.log(Status.INFO, "Entered Valid email address and password");
			
			click(signuploginpageobject.LoginButton);
			test.log(Status.INFO, "Navigate to Home Page and Login as Entered Login User Name ");
		
			click(homepageobject.Cart);
			test.log(Status.INFO, "Navigate to Cart Page");
			
			String[] productsal=new String[size];
			for(int i=0;i<size;i++)
			{
				productsal[i]=cartpageobject.AllDescriptions.get(i).getText();
				AssertJUnit.assertEquals(true, cartpageobject.AllDescriptions.get(i).isDisplayed());
				test.log(Status.PASS, "Product is Displayed");

			}
			Arrays.sort(productsbl);
	        Arrays.sort(productsal);
			
			
			for(int i=0;i<size;i++)
			{
				if (!productsbl[i].equals(productsal[i]))
				{
					AssertJUnit.fail();
					test.log(Status.FAIL, "Products are not Equal");
				}
				test.log(Status.INFO, "Searched Product  is in Cart Page");
			}
			
			click(homepageobject.Home);
			
			// optional for future test cases delete registered user
			click(signuploginpageobject.DeleteAccount);				
			click(signuploginpageobject.ContinueButton);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("testcase20");
		}
	}
	

}
