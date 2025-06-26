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

public class Testcase18 extends BaseClass
{
	@Test
	public void viewCategoryProducts()
	{
		try 
		{
			test=extent.createTest("view Category Products").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			
			ProductsPage productspageobject=PageFactory.initElements(driver,ProductsPage.class);
			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			
			AssertJUnit.assertEquals(true, productspageobject.CategoryText.isDisplayed());
			test.log(Status.PASS, "Category of products are Displayed on left side");
			
			hover(productspageobject.AddtoCartButtonAll.get(4));
			click(productspageobject.WomenCategory);
			test.log(Status.INFO, "Women category is expanded");
			click(productspageobject.Women_Tops);
			test.log(Status.INFO, "Selected Category Product Page is Displayed");
			
			AssertJUnit.assertEquals("Women - Tops Products".toUpperCase(), productspageobject.Category3Text.getText());
			test.log(Status.PASS, "WOMEN - TOPS PRODUCTS text is  Displayed ");
			
			click(productspageobject.MenCategory);
			test.log(Status.INFO, "Men category is expanded");
			click(productspageobject.Men_Tshirts);
			test.log(Status.INFO, "Selected Category Product Page is Displayed");
			
			AssertJUnit.assertEquals("Men - Tshirts Products".toUpperCase(), productspageobject.Category3Text.getText());
			test.log(Status.PASS, "Men - Tshirts Products text is  Displayed ");
			
			click(homepageobject.Home);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("testcase18");
		}
		
	}

}
