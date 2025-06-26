package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.ProductsPage;
import utilities.BaseClass;

public class Testcase09 extends BaseClass
{
	@Test
	public void searchProduct()
	{
		try 
		{
			test=extent.createTest("Search Product").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			

			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			ProductsPage productspageobject=PageFactory.initElements(driver,ProductsPage.class);
		
			AssertJUnit.assertEquals("Automation Exercise", driver.getTitle());
			test.log(Status.PASS, "Home Page is Displayed");
	
			
			click(homepageobject.Products);
			test.log(Status.INFO, "Navigate to Products Page");
			
			AssertJUnit.assertEquals("Automation Exercise - All Products", driver.getTitle());
			test.log(Status.PASS, "Products Page is Displayed");
			
			enterData(productspageobject.SearchBox,"top");   // entered search Input for products
			test.log(Status.INFO, "entered searched product ");
			
			click(productspageobject.SearchIconButton);
			test.log(Status.INFO, "Display search related products");
			
			AssertJUnit.assertEquals(true, productspageobject.SearchProductText.isDisplayed());
			test.log(Status.PASS, "SEARCHED PRODUCTS text is Displayed");
			
			for( WebElement element : productspageobject.AllProductNames)
			{
				String text = element.getText();
				
				AssertJUnit.assertEquals(true, text.contains("Top") || text.contains("Shirt"));
				test.log(Status.PASS, "Product is related to Searched Input ");
			}
			
			click(homepageobject.Home);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("testcase09");
		}

	}
}