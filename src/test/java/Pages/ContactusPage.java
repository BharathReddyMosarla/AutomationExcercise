package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactusPage 
{
	
	
	@FindBy(xpath="//*[@class='contact-form']/h2")
	public WebElement ContactusText;
	
	@FindBy(name="name")
	public WebElement Name;
	
	@FindBy(name="email")
	public WebElement Email;
	
	@FindBy(name="message")
	public WebElement Message;
	
	@FindBy(name="subject")
	public WebElement Subject;
	
	@FindBy(name="upload_file")
	public WebElement FileUpload;
	
	@FindBy(name="submit")
	public WebElement SubmitButton;
	
	@FindBy(xpath="//*[text()='.']/a/u")
	public WebElement FeedbackEmail;
	
	@FindBy(xpath="(//*[@class='contact-form']/div)[2]")
	public WebElement SucessMessage;
	
	@FindBy(xpath="//*[@id='form-section']/a")
	public WebElement HomeButton;
	
	
}
