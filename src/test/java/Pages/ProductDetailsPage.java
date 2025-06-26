package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage 
{
	@FindBy(xpath="//*[@class='product-information']/h2")
	public 	WebElement ProductName;
	
	@FindBy(xpath="(//*[@class='product-information']/p)[1]")
	public 	WebElement ProductCategory;
	
	@FindBy(xpath="//*[@class='product-information']/span/span")
	public 	WebElement ProductPrice;
	
	@FindBy(xpath="//*[@class='product-information']//*[@id='quantity']")
	public 	WebElement ProductQuantity;
	
	@FindBy(xpath="//*[@class='product-information']//button")
	public 	WebElement AddtoCartButton;
	
	@FindBy(xpath="(//*[@class='product-information']/p)[2]")
	public 	WebElement ProductAvailability;
	
	@FindBy(xpath="(//*[@class='product-information']/p)[3]")
	public 	WebElement ProductCondition;
	
	@FindBy(xpath="(//*[@class='product-information']/p)[4]")
	public 	WebElement ProductBrand;
	
	@FindBy(xpath="//*[@id='review-form']//*[@id='name']")
	public 	WebElement ReviewName;
	
	@FindBy(xpath="//*[@id='review-form']//*[@id='email']")
	public 	WebElement ReviewEmail;
	
	@FindBy(xpath="//*[@id='review-form']//*[@id='review']")
	public 	WebElement AddReviewText;
	
	@FindBy(xpath="//*[@id='review-form']//*[@id='button-review']")
	public 	WebElement ReviewSubmitButton;
	
	
	@FindBy(xpath="//*[@class='active']/a")
	public 	WebElement ReviewText;
	
	
	
	@FindBy(xpath="//*[@id='review-section']//span")
	public 	WebElement ThankyouText;

}
