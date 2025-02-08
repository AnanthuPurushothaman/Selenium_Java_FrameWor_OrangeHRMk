package ananthuProject.pageobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ananthuProject.AbstractComponent.AbstarctComponent;

public class PimPage extends AbstarctComponent {

	ChromeDriver driver;
	int actualListSize;

	public PimPage(ChromeDriver driver) {
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
	
	@FindBy(xpath="//div/div/span[@class='oxd-text oxd-text--span']")
	WebElement expaectedCountElement;

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
		
		 String myString=expaectedCountElement.getText().replaceAll("[^0-9]", "");
		 int expectedCount = Integer.parseInt(myString);
		
		 return expectedCount;
	}
	

}
