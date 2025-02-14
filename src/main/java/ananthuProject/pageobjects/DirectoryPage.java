package ananthuProject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ananthuProject.AbstractComponent.AbstarctComponent;

public class DirectoryPage extends AbstarctComponent{

	
	public String adminJobTitle="HR Manager";
	WebDriver driver;
	String catName;
	
	
	public DirectoryPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement employeeName;
	
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[1]")
	WebElement jobTitle;
	
	@FindBy (css="div[class='oxd-autocomplete-option']")
	List<WebElement> searchList;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitSearch;
	
	@FindBy(css="div[class='oxd-select-option']")
	List<WebElement> jobTitleList;
	
	
	
	
	public void myAction(String catName,String actualName) throws InterruptedException {
		
		selectMenuOption(catName);
		employeeName.sendKeys(actualName);
		Thread.sleep(3000);
		WebElement nameElement=searchList.stream().filter(findName->findName.getText().contains(actualName)).findFirst().orElse(null);
		nameElement.click();
		jobTitle.click();
		WebElement selectJobTitle=jobTitleList.stream().filter(jTitle->jTitle.getText().equals(adminJobTitle)).findFirst().orElse(null);
		selectJobTitle.click();
		submitSearch.click();
		
//		System.out.println(nameElement.getText());
//		searchList.stream().forEach(s->System.out.println(s.getText()));
		
		
		
	}
 
}
