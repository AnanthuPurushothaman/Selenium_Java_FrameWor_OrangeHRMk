package ananthuProject.pageobjects;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class LandingPage {

	WebDriver driver;
	Actions a;

	public LandingPage(WebDriver driver, Actions a) {

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
	
	
	//menu options
	@FindBy(css=".oxd-main-menu-item")
	List<WebElement> menuList;
	
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
	
	
	public boolean menuUrlAPIcalls() throws MalformedURLException, IOException {
		
		SoftAssert a= new SoftAssert();
		
		for(int i=0; i<menuList.size();i++) {
			
			String URL=menuList.get(i).getAttribute("href");
			String controlEnter=Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			System.out.println(menuList.get(i).getAttribute("href"));
			
			menuList.get(i).sendKeys(controlEnter);
			
			
			HttpURLConnection conn = (HttpURLConnection) new URL(URL).openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
		    int respCode=conn.getResponseCode();
		    System.out.println(respCode);
		    
		   
		    
		   a.assertTrue(respCode<300,"invalid response");
			
		   
		}
		
		
	     a.assertAll();
	     
	     return true;
		
		
		
	}
	
	
	
}
