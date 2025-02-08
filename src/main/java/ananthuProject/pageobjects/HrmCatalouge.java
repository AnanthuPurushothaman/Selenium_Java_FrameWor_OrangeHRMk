package ananthuProject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ananthuProject.AbstractComponent.AbstarctComponent;

public class HrmCatalouge extends AbstarctComponent{
	
	ChromeDriver driver;
	Actions a;
	public HrmCatalouge(ChromeDriver driver,Actions a) {
		super(driver);
		this.driver=driver;
		this.a=a;
		PageFactory.initElements(driver, this);
	}
	
	
	//List<WebElement> myCaalouges =driver.findElements(By.xpath("//ul/li/a/span[contains(@class, 'oxd-text oxd-text--span oxd-main')]"));
	@FindBy(xpath="//ul/li/a/span[contains(@class, 'oxd-text oxd-text--span oxd-main')]")
	List<WebElement> myCaalouges;
	
	
	

	public MyInfoPage goToCatalouge(String catName) {
		
//		WebElement actionList= myCaalouges.stream().filter(b->b.getText().equals(catName)).findFirst().orElse(null);
//		actionList.click();
		selectMenuOption(catName);
		MyInfoPage MyInfoPage = new MyInfoPage(driver,a);
		return MyInfoPage;
	}
	
	
	
	

}
