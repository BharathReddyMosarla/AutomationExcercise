package Tests;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import utilities.BaseClass;

public class Testcase08 extends BaseClass
{
	@Test
	public void productdetails()

	{
		try 
		{
			test=extent.createTest("Product Details Page Information").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			
			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			ProductsPage productspageobject=PageFactory.initElements(driver,ProductsPage.class);
			ProductDetailsPage productdetailspageobject=PageFactory.initElements(driver,ProductDetailsPage.class);
		
			AssertJUnit.assertEquals("Automation Exercise", driver.getTitle());
			test.log(Status.PASS, "Home Page is Displayed");
	
			click(homepageobject.Products);
			test.log(Status.INFO, "Navigate to Products Page");
			
			AssertJUnit.assertEquals("Automation Exercise - All Products", driver.getTitle());
			test.log(Status.PASS, "PRODUCTS Page is Displayed");
			AssertJUnit.assertEquals(true, productspageobject.AllProductsText.isDisplayed());
			test.log(Status.PASS, "Product list is Displayed");
			
			hover(productspageobject.AllProductNames.get(4));
			
			click(productspageobject.ViewProductButtonAll.get(0));
			test.log(Status.INFO, "Navigate to first product details page");
			
			AssertJUnit.assertEquals("Automation Exercise - Product Details", driver.getTitle());
			test.log(Status.PASS, "Product details page is Displayed");
			
			AssertJUnit.assertEquals(true, productdetailspageobject.ProductName.isDisplayed());
			test.log(Status.PASS, "Product name is Displayed");
			AssertJUnit.assertEquals(true, productdetailspageobject.ProductCategory.isDisplayed());
			test.log(Status.PASS, "Product category  is Displayed");
			AssertJUnit.assertEquals(true, productdetailspageobject.ProductPrice.isDisplayed());
			test.log(Status.PASS, "Product price  is Displayed");
			AssertJUnit.assertEquals(true, productdetailspageobject.ProductAvailability.isDisplayed());
			test.log(Status.PASS, "Product availability is Displayed");
			AssertJUnit.assertEquals(true, productdetailspageobject.ProductCondition.isDisplayed());
			test.log(Status.PASS, "Product condition is Displayed");
			AssertJUnit.assertEquals(true, productdetailspageobject.ProductBrand.isDisplayed());
			test.log(Status.PASS, "Product brand is Displayed");
			
			click(homepageobject.Home);
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("testcase08");
		}

	}
}
