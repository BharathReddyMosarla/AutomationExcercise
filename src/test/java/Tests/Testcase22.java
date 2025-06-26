package Tests;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductsPage;
import utilities.BaseClass;

public class Testcase22 extends BaseClass
{
	@Test
	public void cartRecommandedItems()
	{
		try 
		{
			test=extent.createTest("Add to cart from Recommended items").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		
			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			ProductsPage productspageobject=PageFactory.initElements(driver,ProductsPage.class);
			CartPage cartpageobject = PageFactory.initElements(driver, CartPage.class);			
			
			hover(homepageobject.copyright);  // scrool down to bottom of apge
			
			AssertJUnit.assertEquals(true, homepageobject.RecommandItemsText.isDisplayed());
			test.log(Status.PASS, "RECOMMENDED ITEMS text is Displayed");

			wait.until(ExpectedConditions.visibilityOf(homepageobject.AllProductNamesRecomm.get(0)));
			String product=homepageobject.AllProductNamesRecomm.get(0).getText();
			
			click(homepageobject.CartButtonAllRecomm.get(0));
			test.log(Status.INFO, "From Recommanded Items - product is added to cart");

			click(productspageobject.ViewCartLink);
			test.log(Status.INFO, "Navigate to Cart Page");
			
			AssertJUnit.assertEquals(product, cartpageobject.AllDescriptions.get(0).getText());
			test.log(Status.PASS, "Added product is in Cart page verified");
		
			click(homepageobject.Home);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("testcase22");
		}

	}

}
