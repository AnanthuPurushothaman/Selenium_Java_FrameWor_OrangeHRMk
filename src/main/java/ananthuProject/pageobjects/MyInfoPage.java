package ananthuProject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ananthuProject.AbstractComponent.AbstarctComponent;

public class MyInfoPage extends AbstarctComponent {

	WebDriver driver;
	Actions a;

	public MyInfoPage(WebDriver driver, Actions a) {
		super(driver);
		this.driver = driver;
		this.a = a;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstName;

	@FindBy(css = "input[name='lastName']")
	WebElement lastName;

	@FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//div/ul/li[6]")
	WebElement infoButton;

	@FindBy(xpath = "//span/p[@class='oxd-userdropdown-name']")
	WebElement profleName;

	By firstWait = By.xpath("//input[@placeholder='First Name']");

	By vsibilityOfTost = By.xpath("//div[@class='oxd-toast-content oxd-toast-content--success']");

	By invisibilityOfTost = By.xpath("//div[@class='oxd-toast-content oxd-toast-content--success']");

	public void updateName(String actualName, String actualLastName) throws InterruptedException {
		infoButton.click();
		waitForElementToAppear(firstWait);
		Thread.sleep(2000);

		a.moveToElement(firstName).click() // Click to focus on the input field
				.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL) // Select all text
				.sendKeys(Keys.BACK_SPACE) // Delete the selected text
				.sendKeys(actualName.toLowerCase()) // Send lowercase text
				.build().perform();
		a.moveToElement(lastName).click() // Click to focus on the input field
				.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL) // Select all text
				.sendKeys(Keys.BACK_SPACE) // Delete the selected text
				.sendKeys(actualLastName.toLowerCase()) // Send lowercase text
				.build().perform();
		saveButton.click();
		waitForElementToAppear(vsibilityOfTost);
		waitForElementToInvisible(invisibilityOfTost);
		pageRefresh();
		

	}
	


	public String concatFirstAndLastName(String actualName, String actualLastName) {

		String expectedFirstandLastName = actualName.concat(" ").concat(actualLastName);
		return expectedFirstandLastName;
	}

	public String getUpdatedProfileName() {

		String profileName1 = profleName.getText();
		return profileName1;

	}

}
