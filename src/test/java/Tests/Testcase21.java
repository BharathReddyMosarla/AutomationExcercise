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

public class Testcase21 extends BaseClass
{
	@Test
	public void addReview()
	{
		try 
		{
			test=extent.createTest("Add Review on product").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");

			HomePage homepageobject=PageFactory.initElements(driver,HomePage.class);
			ProductsPage productspageobject=PageFactory.initElements(driver,ProductsPage.class);
			ProductDetailsPage productdetilspageobject =PageFactory.initElements(driver,ProductDetailsPage.class);
			
			click(homepageobject.Products);
			test.log(Status.INFO, "Navigate to Products Page");
			
			AssertJUnit.assertEquals(true, productspageobject.AllProductsText.isDisplayed());
			test.log(Status.PASS, "ALL PRODUCTS text is Displayed");
			
			hover(productspageobject.AddtoCartButtonAll.get(4));
			click(productspageobject.ViewProductButtonAll.get(0));
			test.log(Status.INFO, " Product is added to cart");
			
			AssertJUnit.assertEquals(true, productdetilspageobject.ReviewText.isDisplayed());
			test.log(Status.PASS, "Write Your Review text is Displayed");

			hover(homepageobject.copyright);
			
			enterData(productdetilspageobject.ReviewName,config.getProperty("Name"));
			enterData(productdetilspageobject.ReviewEmail,config.getProperty("Email"));
			enterData(productdetilspageobject.AddReviewText,config.getProperty("Message"));
			test.log(Status.INFO, " Entered all detail for review");
			
			click(productdetilspageobject.ReviewSubmitButton);
			test.log(Status.INFO, " Submitteed the Review");
			
			AssertJUnit.assertEquals(true, productdetilspageobject.ThankyouText.isDisplayed());
			test.log(Status.PASS, "Thank you for your review Message is Displayed");
			
			click(homepageobject.Home);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("testcase21");
		}
	}

}
