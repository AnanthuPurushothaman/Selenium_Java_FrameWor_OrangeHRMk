package ananthuProject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ananthuProject.AbstractComponent.AbstarctComponent;

public class TimeSheet extends AbstarctComponent {

	WebDriver driver;
	
	public TimeSheet(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);


	}
	@FindBy(xpath="//nav/ul/li[1]")
	WebElement timeSheets;
	
	@FindBy(xpath="//button[normalize-space()='Edit']")
	WebElement editTimeSheet;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[3]/div/div[2]/input[@class='oxd-input oxd-input--active']")
	WebElement inputboxforTime;
	
	@FindBy (xpath="//nav/ul/li[1]/ul/li")
	List<WebElement> timeSheetsDropDown;
	
	By inputboxVisibility= By.xpath("//input[@placeholder='Type for hints...']");

	public TimeSheet timeSheetSearcgh(String catNameTime) throws InterruptedException {
		
		selectMenuOption(catNameTime);
		timeSheets.click();
		Thread.sleep(1000);
		WebElement myTimeSheet=timeSheetsDropDown.stream().filter(list1->list1.getText().equals("My Timesheets")).findFirst().orElse(null);
		myTimeSheet.click();
		TimeSheet TimeSheet2 = new TimeSheet(driver);
		return TimeSheet2;
		

	}
	
	public void updateTimeSheet() {
		editTimeSheet.click();
		waitForElementToAppear(inputboxVisibility);
		inputboxforTime.sendKeys("8");
		
	}
	
	
}
