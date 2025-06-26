package Tests;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import utilities.BaseClass;

public class Testcase13 extends BaseClass
{
	@Test
	public void productQuantity() throws Exception

	{
		try 
		{
			test=extent.createTest("Verify Product Quantity in Cart").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			
			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			ProductsPage productspageobject=PageFactory.initElements(driver,ProductsPage.class);
			ProductDetailsPage productdetailspageobject=PageFactory.initElements(driver,ProductDetailsPage.class);
			CartPage cartpageobject = PageFactory.initElements(driver, CartPage.class);
		
			AssertJUnit.assertEquals("Automation Exercise", driver.getTitle());
			test.log(Status.PASS, "Home Page is Displayed");
			
			hover(productspageobject.AllProductNames.get(4));
			
			click(productspageobject.ViewProductButtonAll.get(0));
			test.log(Status.INFO, "Navigate to First Product Details Page");
			
			AssertJUnit.assertEquals("Automation Exercise - Product Details", driver.getTitle());
			test.log(Status.PASS, "Product Details Page is Displayed");
			
			productdetailspageobject.ProductQuantity.clear();
			enterData(productdetailspageobject.ProductQuantity,"4");
			test.log(Status.INFO, "Quantity is changed ton 4");
			
			click(productdetailspageobject.AddtoCartButton);
			click(productspageobject.ViewCartLink);
			test.log(Status.INFO, "Navigate to Cart Page");
				
			AssertJUnit.assertEquals("4", cartpageobject.AllQuantities.get(0).getText());
			test.log(Status.PASS, "Product Quantity is Verified");
			
			// ----- For Future Use ------- deleteing all products in a cartpage
			for(int i=0;i<cartpageobject.AllDeleteButton.size();i++)	
			{
				click(cartpageobject.AllDeleteButton.get(i));
			}
			click(homepageobject.Home);
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("testcase13");
		}			
	}
}