package Tests;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductsPage;
import utilities.BaseClass;

public class Testcase12 extends BaseClass
{
	@Test
	public void addProducts()
	{
		try 
		{
			test=extent.createTest("Add Products to Cart").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			

			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			ProductsPage productspageobject=PageFactory.initElements(driver,ProductsPage.class);
			CartPage cartpageobject=PageFactory.initElements(driver,CartPage.class);
		
			AssertJUnit.assertEquals("Automation Exercise", driver.getTitle());
			test.log(Status.PASS, "Home Page is Displayed");
	
			click(homepageobject.Products);
			test.log(Status.INFO, "Navigate to Products Page");
	
			hover(productspageobject.AddtoCartButtonAll.get(4));
			String name1 = productspageobject.AllProductNames.get(0).getText();
			String price1 = productspageobject.AllProductPrices.get(0).getText();
			hover(productspageobject.AddtoCartButtonAll.get(0));
			click(productspageobject.AddtoCartButtonAll.get(0));
			test.log(Status.INFO, "First Product is added to cart");
			
			click(productspageobject.ContinueShoppingButton);
			test.log(Status.INFO, "Navigate to products Page");
			
			String name2 = productspageobject.AllProductNames.get(1).getText();
			String price2 = productspageobject.AllProductPrices.get(1).getText();
			
			hover(productspageobject.AddtoCartButtonAll.get(1));
			click(productspageobject.AddtoCartButtonAll.get(1));
			test.log(Status.INFO, "Second Product is added to cart");
			
			click(productspageobject.ViewCartLink);
			test.log(Status.INFO, "Navigate to Cart Page");
			
			AssertJUnit.assertEquals(2,cartpageobject.AllItems.size() );
			test.log(Status.PASS, "Two products are Displayeed in Cart Page");
			
			AssertJUnit.assertEquals(name1, cartpageobject.AllDescriptions.get(0).getText());
			test.log(Status.PASS, "First Product is Displayed");
			AssertJUnit.assertEquals(name2, cartpageobject.AllDescriptions.get(1).getText());
			test.log(Status.PASS, "Second Product is Displayed");
			
			AssertJUnit.assertEquals(price1, cartpageobject.AllPrices.get(0).getText());
			test.log(Status.PASS, "First Product Price is Verified");
			AssertJUnit.assertEquals(price2, cartpageobject.AllPrices.get(1).getText());
			test.log(Status.PASS, "Second Product Price is Verified");
			
			AssertJUnit.assertEquals("1", cartpageobject.AllQuantities.get(0).getText());
			test.log(Status.PASS, "First Product Quantity is Verified");
			AssertJUnit.assertEquals("1", cartpageobject.AllQuantities.get(1).getText());
			test.log(Status.PASS, "Second Product Quantity is Verified");
			
			AssertJUnit.assertEquals(price1, cartpageobject.AllCartTotal.get(0).getText());
			test.log(Status.PASS, "First Product CartTotal is Verified");
			AssertJUnit.assertEquals(price2, cartpageobject.AllCartTotal.get(1).getText());
			test.log(Status.PASS, "Second Product CartTotal is Verified");
			
			
			
			// ----- For Future Use -------deleteing all products in a cartpage
			for(int i=0;i<cartpageobject.AllDeleteButton.size();i++)
			{
				click(cartpageobject.AllDeleteButton.get(i));
			}
			click(homepageobject.Home);
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("testcase12");
		}

	}

}
