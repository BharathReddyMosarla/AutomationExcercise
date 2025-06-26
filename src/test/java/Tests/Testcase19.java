package Tests;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.ProductsPage;
import utilities.BaseClass;

public class Testcase19 extends BaseClass
{
	@Test
	public void viewBrandProducts()
	{
		try 
		{
			test=extent.createTest("view Brand Products").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		
			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			ProductsPage productspageobject=PageFactory.initElements(driver,ProductsPage.class);
			
			click(homepageobject.Products);
			test.log(Status.INFO, "Navigate to Products Page");
			
			AssertJUnit.assertEquals(true, productspageobject.BrandText.isDisplayed());
			test.log(Status.PASS, "Brands of products are Displayed on left side");

			hover(productspageobject.AddtoCartButtonAll.get(4));
			
			click(productspageobject.Polo);
			test.log(Status.INFO, "Navigate to Selected Brand Products Page");
			
			AssertJUnit.assertEquals("Brand - Polo Products".toUpperCase(), productspageobject.Category3Text.getText());
			test.log(Status.PASS, "Brand - Polo Products text is Displayed");
			
			AssertJUnit.assertEquals(true, productspageobject.AllProductNames.get(0).isDisplayed());
			test.log(Status.PASS, " Products  are  Displayed");
			
			click(productspageobject.Madame);
			test.log(Status.INFO, "Navigate to Selected Brand Products Page");
			
			AssertJUnit.assertEquals("Brand - Madame Products".toUpperCase(), productspageobject.Category3Text.getText());
			test.log(Status.PASS, "Brand - Madame Products text is Displayed");
			
			AssertJUnit.assertEquals(true, productspageobject.AllProductNames.get(0).isDisplayed());
			test.log(Status.PASS, " Products  are  Displayed");
			
			click(homepageobject.Home);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("testcase19");
		}

		}

}
