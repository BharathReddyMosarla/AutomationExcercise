package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignupLoginPage 
{
	@FindBy(xpath="//*[@class='login-form']/h2")
	public 	WebElement LoginText;
	
	@FindBy(xpath="//*[@class='login-form']//*[@name='email']")
	public WebElement LoginEmail;
	
	@FindBy(xpath="//*[@class='login-form']//*[@name='password']")
	public 	WebElement LoginPassword;
	
	@FindBy(xpath="//*[@class='login-form']//p")
	public 	WebElement ErrorLoginText;
	
	@FindBy(xpath="//*[@class='login-form']//*[text()='Login']")
	public WebElement LoginButton;
	
	
	@FindBy(xpath="//*[@class='signup-form']/h2")
	public 	WebElement SignupText;
	
	@FindBy(xpath="//*[@class='signup-form']//*[@name='name']")
	public WebElement SignupName;
	
	@FindBy(xpath="//*[@class='signup-form']//*[@name='email']")
	public WebElement SignupEmail;
	
	@FindBy(xpath="//*[@class='signup-form']//p")
	public 	WebElement ErrorSignupText;
	
	@FindBy(xpath="//*[@class='signup-form']//*[text()='Signup']")
	public WebElement SignupButton;
	
	// for account create/delete confirmation buttton
	
	@FindBy(xpath="//*[@class='login-form']/h2/b")
	public WebElement accinfotext;
		
	@FindBy(id="id_gender1")
	public WebElement MaleRadio;
	@FindBy(id="id_gender2")
	public WebElement FemaleRadio;
	
	@FindBy(id="name")
	public WebElement Name;
	@FindBy(id="email")
	public WebElement Email;
	@FindBy(id="password")
	public WebElement Password;
	
	@FindBy(id="days")
	public WebElement DaysDropdown;
	@FindBy(id="months")
	public WebElement MonthsDropdown;
	@FindBy(id="years")
	public WebElement YearsDropdown;
	
	@FindBy(id="newsletter")
	public WebElement NewsletterCheckbox;
	@FindBy(id="optin")
	public 	WebElement OptinCheckbox;
	
	@FindBy(id="first_name")
	public WebElement FirstName;
	@FindBy(id="last_name")
	public WebElement LastName;
	@FindBy(id="company")
	public WebElement Company;
	@FindBy(id="address1")
	public WebElement Address1;
	@FindBy(id="address2")
	public WebElement Address2;	
	@FindBy(id="country")
	public WebElement CountryDropdown;
	@FindBy(id="state")
	public WebElement State;
	@FindBy(id="city")
	public WebElement City;
	@FindBy(id="zipcode")
	public WebElement Zipcode;
	@FindBy(id="mobile_number")
	public WebElement MobileNumber;

	@FindBy(xpath="//*[text()='Create Account']")
	public WebElement CreateAccountButton;	
	
	
	
	@FindBy(xpath="//h2/b")
	public WebElement Text;
	
	@FindBy(xpath="//*[text()='Continue']")
	public WebElement ContinueButton;
	
	
	@FindBy(xpath="//a[text()=' Logout']")
	public WebElement  Logout;
	
	@FindBy(xpath="//a[text()=' Delete Account']")
	public WebElement  DeleteAccount;
	
	@FindBy(xpath="//a/b")
	public WebElement	UserName;

	
	
	
	
	
	
}
