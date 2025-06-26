package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage 
{
	
	@FindBy(xpath="//*[@class='features_items']/h2")
	public WebElement AllProductsText;
	
	
	@FindBy(id="search_product")
	public WebElement SearchBox;
	
	@FindBy(id="submit_search")
	public WebElement SearchIconButton;
	
	
	@FindBy(xpath="//*[@class='features_items']/h2")
	public WebElement SearchProductText;
	
	@FindBy(xpath="//*[@id='Women']//preceding::div[@class='panel-heading']//a")
	public WebElement WomenCategory;
	
	@FindBy(xpath="//*[@id='Women']//a[text()='Dress ']")
	public WebElement Women_Dress;
	
	@FindBy(xpath="//*[@id='Women']//a[text()='Tops ']")
	public WebElement Women_Tops;
	
	@FindBy(xpath="//*[@id='Women']//a[text()='Saree ']")
	public WebElement Women_Saree;
	
	@FindBy(xpath="//a[@href='#Men']")
	public WebElement MenCategory;
	
	@FindBy(xpath="//*[@id='Men']//a[text()='Tshirts ']")
	public WebElement Men_Tshirts;
	
	@FindBy(xpath="//*[@id='Men']//a[text()='Jeans ']")
	public WebElement Men_Jeans;
	
	@FindBy(xpath="//a[@href='#Kids']")
	public WebElement KidsCategory;
	
	@FindBy(xpath="//*[@id='Kids']//a[text()='Dress ']")
	public WebElement Kids_Dress;
	
	@FindBy(xpath="//*[@id='Kids']//a[text()='Tops & Shirts ']")
	public WebElement Kids_TopsShirts;
	
	@FindBy(xpath="//*[@class='brands-name']//a[text()='Polo']")   //*[@class='brands-name']//a[text()='Polo']
	public WebElement Polo;

	@FindBy(xpath="//*[@class='brands-name']//a[text()='H&M']")
	public WebElement HM;
	
	@FindBy(xpath="//*[@class='brands-name']//a[text()='Madame']")
	public WebElement Madame;
	
	@FindBy(xpath="//*[@class='brands-name']//a[text()='Mast & Harbour']")
	public WebElement MastHarbour;
	
	@FindBy(xpath="//*[@class='brands-name']//a[text()='Babyhug']")
	public WebElement Babyhug;
	
	@FindBy(xpath="//*[@class='brands-name']//a[text()='Allen Solly Junior']")
	public WebElement AllenSollyJunior;
	
	@FindBy(xpath="//*[@class='brands-name']//a[text()='Kookie Kids']")
	public WebElement KookieKids;
	
	@FindBy(xpath="//*[@class='brands-name']//a[text()='Biba']") 
	public WebElement Biba;
	
	@FindBy(xpath="//*[@class='features_items']//*[@class='single-products']/div/p")     //*[@class='product-overlay']/div/p
	public List<WebElement> AllProductNames;
	
	@FindBy(xpath="//*[@class='features_items']//*[@class='single-products']/div/h2")   //*[@class='product-overlay']/div/h2
	public List<WebElement> AllProductPrices;
	
	@FindBy(xpath="//*[@class='features_items']//*[@class='single-products']/div/a")  //*[@class='product-overlay']/div/a
	public List<WebElement> AddtoCartButtonAll;
	
	
	@FindBy(xpath="//*[@class='choose']/ul/li/a")  
	public List<WebElement> ViewProductButtonAll;
	
	
	@FindBy(xpath="//u[text()='View Cart']")
	public WebElement ViewCartLink;
	
	@FindBy(xpath="//button[text()='Continue Shopping']")
	public WebElement ContinueShoppingButton;
	
	@FindBy(xpath="//*[@class='left-sidebar']/h2")
	public WebElement CategoryText;
	
	
	@FindBy(xpath="//*[@class='features_items']/h2")
	public WebElement Category3Text;
	
	@FindBy(xpath="//*[@class='brands_products']/h2")
	public WebElement BrandText;
	
	
}