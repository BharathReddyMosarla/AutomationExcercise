package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentDetailsPage
{
	@FindBy(xpath="//*[@name='name_on_card']")
	public WebElement NameOnCard;
	
	@FindBy(xpath="//*[@name='card_number']")
	public WebElement CardNumber;
	
	@FindBy(xpath="//*[@name='cvc']")
	public WebElement CVC;
	
	@FindBy(xpath="//*[@name='expiry_month']")
	public WebElement ExpiryMonth;
	
	@FindBy(xpath="//*[@name='expiry_year']")
	public WebElement ExpiryYear;
	
	@FindBy(xpath="//*[@id='submit']")
	public WebElement PayandConfirmOrderButton;

	
	@FindBy(xpath="//a[text()='Download Invoice']")
	public WebElement DownloadInvoiceButton;
	
	@FindBy(xpath="//a[text()='Continue']")
	public WebElement ContinueButton;
	
	@FindBy(xpath="//*[@id='form']//p")
	public WebElement OrderConfirmMessage;
	
}
