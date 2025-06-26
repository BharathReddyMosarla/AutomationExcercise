package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{
	
	// All Header menu Items/Lists
	
	@FindBy(xpath="//a[text()=' Home']")
	public WebElement Home;
	
	@FindBy(xpath="//a[text()=' Products']")
	public WebElement  Products;
	
	@FindBy(xpath="//a[text()=' Cart']")
	public WebElement  Cart;
	
	@FindBy(xpath="//a[text()=' Signup / Login']")
	public WebElement  Signup_Login;
	
	@FindBy(xpath="//a[text()=' Test Cases']")
	public WebElement  TestCases;
	
	@FindBy(xpath="//a[text()=' API Testing']")
	public WebElement  APITesting;
	
	@FindBy(xpath="//a[text()=' Video Tutorials']")
	public WebElement  VideoTutorials;
	
	@FindBy(xpath="//a[text()=' Contact us']")
	public WebElement  Contactus;
	
	@FindBy(xpath="//*[@class='single-widget']/h2")
	public WebElement SubscribeText;
	
	@FindBy(xpath="//*[@id='success-subscribe']/div")
	public WebElement SubMessage;
	
	
	@FindBy(id="susbscribe_email")
	public WebElement subscribe_email;
	
	@FindBy(id="subscribe")
	public WebElement subscribeButton;
	
	@FindBy(xpath="//*[starts-with(@class,'logo')]/a/img")
	public WebElement Logo;
	
	@FindBy(xpath="//*[@class='container']/*[@class='row']/p")
	public WebElement copyright;

	
	@FindBy(id="scrollUp'")
	public WebElement ScrollUpArrow;
	
	@FindBy(xpath="//*[@id='slider-carousel']//h2")
	public WebElement HeaderScrollText;
	
	
	// recommanded products from home page
	
	@FindBy(xpath="//*[@class='recommended_items']/h2")
	public WebElement RecommandItemsText;
	
	@FindBy(xpath="//*[@class='recommended_items']//*[@class='single-products']/div/p")  
	public List<WebElement> AllProductNamesRecomm;
	
	@FindBy(xpath="//*[@class='recommended_items']//*[@class='single-products']/div/h2")  
	public List<WebElement> AllProductPricesRecomm;
	
	@FindBy(xpath="//*[@class='recommended_items']//*[@class='single-products']/div/a") 
	public List<WebElement> CartButtonAllRecomm;
}
