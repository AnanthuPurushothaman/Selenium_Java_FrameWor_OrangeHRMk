package ananthuProject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ananthuProject.AbstractComponent.AbstarctComponent;

public class PasswordResetPage extends AbstarctComponent {
	
	WebDriver driver;
	
	
	public PasswordResetPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 
//	driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();
	
	@FindBy (xpath="//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	WebElement forgotPassword;
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement userInput1;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitReser;
	
	@FindBy(xpath="//div/h6")
	WebElement getPasswordResetMessage;
	
	By passwordResetInputBox = By.xpath("//input[@placeholder='Username']");
	
	By PasswordResetSucessMessage =By.xpath("//div/h6");
	
	public String forgotPassword(String userName2) {
		
		forgotPassword.click();
		waitForElementToAppear(passwordResetInputBox);
		userInput1.sendKeys(userName2);
		submitReser.click();
		waitForElementToAppear(PasswordResetSucessMessage);
		String resetMessage=getPasswordResetMessage.getText();
		return resetMessage;
		
	}
	
	
	

}
