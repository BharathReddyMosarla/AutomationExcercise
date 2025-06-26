package Pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage 
{

	@FindBy(linkText="Proceed To Checkout")
	public WebElement ProceedToCheckout;
	
	@FindBy(id="cart_info_table")
	public WebElement Table;
	
	@FindBy(xpath="//*[@id='cart_info_table']/tbody/tr")
	public List<WebElement> TableRows;
	
	@FindBy(xpath="//*[@class='cart_product']/a/img")
	public List<WebElement> AllItems ;
	
	@FindBy(xpath="//*[@class='cart_description']/h4/a")
	public List<WebElement> AllDescriptions;
	
	@FindBy(xpath="//*[@class='cart_price']/p")
	public List<WebElement> AllPrices ;
	
	@FindBy(xpath="//*[@class='cart_quantity']/button")
	public List<WebElement> AllQuantities;
	
	@FindBy(xpath="//*[@class='cart_total']/p")
	public List<WebElement> AllCartTotal;
	
	@FindBy(xpath="//*[@class='cart_quantity_delete']")
	public List<WebElement> AllDeleteButton;
	
	@FindBy(xpath="//*[text()='Register / Login']")
	public WebElement RegisterLoginLink;
	
	@FindBy(xpath="//*[text()='Continue On Cart']")
	public WebElement ContinueonCartButton;
	
	@FindBy(xpath="//*[@id='empty_cart']/p/b")
	public WebElement CartEmptyMessage;
	
}
