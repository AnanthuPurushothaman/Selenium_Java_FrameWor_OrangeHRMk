package ananthuProject.AbstractComponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ananthuProject.pageobjects.MyInfoPage;

public class AbstarctComponent {
	
	WebDriver driver;
	
	public AbstarctComponent(WebDriver driver) {
		this.driver=driver;
	}

	public void waitForElementToAppear(By findBy) {
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToInvisible(By findBy) {
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public void pageRefresh() {
		
		driver.navigate().refresh();
	}
	@FindBy(xpath="//ul/li/a/span[contains(@class, 'oxd-text oxd-text--span oxd-main')]")
	List<WebElement> myCaalouges;
	

	public void selectMenuOption(String catName) {
		
		WebElement actionList= myCaalouges.stream().filter(b->b.getText().equals(catName)).findFirst().orElse(null);
		actionList.click();
	}

	

	
	

}
