package ananthuProject.pageobjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ananthuProject.AbstractComponent.AbstarctComponent;

public class PimPage extends AbstarctComponent {

	WebDriver driver;
	int actualListSize;
	
	String expectedHelpPageTitle="How to Filter the Employee List – OrangeHRM";

	public PimPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='oxd-table-cell oxd-padding-cell'][3]")
	List<WebElement> myList1;

	@FindBy(xpath = "//i[@class='oxd-icon bi-chevron-right']")

	List<WebElement> clicknext;

	@FindBy(xpath = "//i[@class='oxd-icon bi-chevron-right']")
	WebElement nextPageOfTable;

	@FindBy(xpath = "//div/div/span[@class='oxd-text oxd-text--span']")
	WebElement expaectedCountElement;

	@FindBy(xpath = "//div[@class='oxd-table-filter-header-title']/h5")
	WebElement h6TextOnPage;
	
	@FindBy(css="button[title='Help']")
	WebElement helpButton;

	public int countCheck(String menu) throws InterruptedException {

		selectMenuOption(menu);
		List<String> myList2 = new <String>ArrayList();
		do {

			myList1 = driver.findElements(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell'][3]"));
			List<String> currentPageItem = myList1.stream().map(c -> c.getText()).collect(Collectors.toList());
			myList2.addAll(currentPageItem);

			Thread.sleep(1000);
			clicknext = driver.findElements(By.xpath("//i[@class='oxd-icon bi-chevron-right']"));

			if (clicknext.size() > 0) {
				nextPageOfTable.click();

			}

		} while (clicknext.size() > 0);

		actualListSize = myList2.size();
		return actualListSize;
	}

	public int getExpectedCount() {

		String myString = expaectedCountElement.getText().replaceAll("[^0-9]", "");
		int expectedCount = Integer.parseInt(myString);

		return expectedCount;
	}

	public boolean testVisibilityOfH6Title(String menu) {

		selectMenuOption(menu);

		if (h6TextOnPage.isDisplayed()) {

			return true;

		} else {

			return false;
		}

	}
	
	public boolean testHelpButton(String menu) {
		
		selectMenuOption(menu);
		String clickonLink=Keys.chord(Keys.CONTROL,Keys.ENTER);
		helpButton.sendKeys(clickonLink);
		
		Set<String> window =driver.getWindowHandles();
		
		Iterator<String> it = window.iterator();
		String currentPage= it.next();
		
		while(it.hasNext()) {
			
			String title=	driver.switchTo().window(it.next()).getTitle();
			
			System.out.println(title);
		
			if(title.equalsIgnoreCase(expectedHelpPageTitle)) {
				
				return true;
			}
			
			}
		
		driver.switchTo().window(currentPage);
			return false;
		}
	
		
		
	}


