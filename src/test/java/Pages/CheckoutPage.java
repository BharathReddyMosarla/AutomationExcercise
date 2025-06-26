package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage 
{

	// checkOut page details
	
	
		@FindBy(xpath="//*[@class='container']/div/a")
		public WebElement PlaceOrderButton;
		
		@FindBy(xpath="//*[@id='ordermsg']/textarea")
		public WebElement OrderDescription;
		
		@FindBy(xpath="(//*[@id='address_delivery']/li)[2]")
		public WebElement DFullName;
		
		@FindBy(xpath="(//*[@id='address_delivery']/li)[3]")
		public WebElement DCompany;
		
		@FindBy(xpath="(//*[@id='address_delivery']/li)[4]")
		public WebElement DAddress1;
		
		@FindBy(xpath="(//*[@id='address_delivery']/li)[5]")
		public WebElement DAddress2;
		
		@FindBy(xpath="(//*[@id='address_delivery']/li)[6]")
		public WebElement DSCZDetails;
		
		@FindBy(xpath="(//*[@id='address_delivery']/li)[7]")
		public WebElement DCountry;
		
		@FindBy(xpath="(//*[@id='address_delivery']/li)[8]")
		public WebElement DMobileNumber;
		
		
		@FindBy(xpath="(//*[@id='address_invoice']/li)[2]")
		public WebElement BFullName;
		
		@FindBy(xpath="(//*[@id='address_invoice']/li)[3]")
		public WebElement BCompany;
		
		@FindBy(xpath="(//*[@id='address_invoice']/li)[4]")
		public WebElement BAddress1;
		
		@FindBy(xpath="(//*[@id='address_invoice']/li)[5]")
		public WebElement BAddress2;
		
		@FindBy(xpath="(//*[@id='address_invoice']/li)[6]")
		public WebElement BSCZDetails;
		
		@FindBy(xpath="(//*[@id='address_invoice']/li)[7]")
		public WebElement BCountry;
		
		@FindBy(xpath="(//*[@id='address_invoice']/li)[8]")
		public WebElement BMobileNumber;
		
		@FindBy(xpath="//*[@class='cart_total_price']")
		List<WebElement> TotalAmounRows;
		
		public WebElement TotalAmount()
		{
			int size = TotalAmounRows.size();
			
			return TotalAmounRows.get(size);
		}
		
}
