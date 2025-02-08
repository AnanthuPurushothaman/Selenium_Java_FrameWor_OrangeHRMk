package ananthuProject.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	ChromeDriver driver;
	Actions a;

	public LandingPage(ChromeDriver driver, Actions a) {

		this.driver = driver;
		this.a = a;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='username']")
	WebElement userName;

	@FindBy(css = "input[name='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement LogInClick;
	
	@FindBy(css="p[class='oxd-text oxd-text--p oxd-alert-content-text']")
	WebElement credentialsError;
	
	public HrmCatalouge catObject() {
		
		HrmCatalouge catalogue = new HrmCatalouge(driver, a);
		return catalogue;
	}

	public HrmCatalouge Login(String username, String password2) {

		userName.sendKeys(username);
		password.sendKeys(password2);
		LogInClick.click();
		
		return catObject();

	}
	
	

	public void GetPageURL() {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		

	}
	
	public String invalidCredentials() {
		
	String CredentialsErrorMessage=	credentialsError.getText();
	return CredentialsErrorMessage;
		
	}
}
