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

public class Testcase17 extends BaseClass
{
	@Test
	public void removeProductsCart() throws Exception
	{
		try 
		{
			test=extent.createTest("Remove Products from the Cart Page").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		
			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			ProductsPage productspageobject=PageFactory.initElements(driver,ProductsPage.class);
			CartPage cartpageobject = PageFactory.initElements(driver, CartPage.class);
			
			AssertJUnit.assertEquals("Automation Exercise", driver.getTitle());
			test.log(Status.PASS, "Home Page is Displayed");
			
			hover(productspageobject.AddtoCartButtonAll.get(4));
			
			String product1 = productspageobject.AllProductNames.get(0).getText();
			hover(productspageobject.AddtoCartButtonAll.get(0));
			click(productspageobject.AddtoCartButtonAll.get(0));
			test.log(Status.INFO, "First Product: "+product1 +" is added to cart");
			
			click(productspageobject.ContinueShoppingButton);
			test.log(Status.INFO, "Products are displayed for adding to cart");
			
			String product2 = productspageobject.AllProductNames.get(1).getText();
			hover(productspageobject.AddtoCartButtonAll.get(1));
			click(productspageobject.AddtoCartButtonAll.get(1));
			test.log(Status.INFO, "Second Product: "+product2 +" is added to cart");
			
			click(productspageobject.ViewCartLink);
			test.log(Status.INFO, "Navigate to Cart Page");

			AssertJUnit.assertEquals("Automation Exercise - Checkout", driver.getTitle());
			test.log(Status.PASS, "Checkout Page is Displayed");
			
			//----------deleteing a product refers to product1 name
			//----------- verifying deleted product is still in a cart page?
			for(int i=0;i<cartpageobject.AllDeleteButton.size();i++)
			{
				if(product1.equals(cartpageobject.AllDescriptions.get(i).getText()))
				{
					click(cartpageobject.AllDeleteButton.get(i));
					test.log(Status.INFO, product1 +" is deleted from Cart Page");
					
					Thread.sleep(1000);
					Assert.assertNotEquals(product1,cartpageobject.AllDescriptions.get(i).getText());
					test.log(Status.PASS, product1 +" is deleted Verified");
					break;
				}
				
			}
					
			// ------------deleteing all products in a cartpage
			for(int i=0;i<cartpageobject.AllDeleteButton.size();i++)
			{
				click(cartpageobject.AllDeleteButton.get(i));
			}
			
			
			click(homepageobject.Home);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL,"something went wrong");
			screenshot("testcase17");
		}
		
	}
}
