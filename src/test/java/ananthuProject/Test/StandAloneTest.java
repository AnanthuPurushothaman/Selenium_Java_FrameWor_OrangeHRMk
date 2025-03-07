package ananthuProject.Test;


import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import ananthuProject.TestComponents.BaseTest;
import ananthuProject.pageobjects.DirectoryPage;
import ananthuProject.pageobjects.HrmCatalouge;
import ananthuProject.pageobjects.LandingPage;
import ananthuProject.pageobjects.MyInfoPage;
import ananthuProject.pageobjects.TimeSheet;

public class StandAloneTest extends BaseTest {
	
	public String actualName = "sam";

	@Test
	public void testUpdatingUserName() throws IOException, InterruptedException {

		//String actualName = "";
		String actualLastName = "davidtony";
		String catName = "My Info";
		HrmCatalouge catalouge = landingPage.Login("Admin", "admin123");
		Thread.sleep(2000);
		MyInfoPage MyInfoPage = catalouge.goToCatalouge(catName);
		MyInfoPage.updateName(actualName, actualLastName);
		assertEquals(MyInfoPage.getUpdatedProfileName(), MyInfoPage.concatFirstAndLastName(actualName, actualLastName),"Name string is not same");
		
	}
	
	
	@Test(dependsOnMethods= {"testUpdatingUserName"}) 
	public void searchUpdatedUserFromDirectory() throws IOException, InterruptedException {
		
		
		HrmCatalouge catalouge = landingPage.Login("Admin", "admin123");
		String catName="Directory";
		DirectoryPage directoryPage = new DirectoryPage(driver);
		directoryPage.myAction(catName,actualName);
		
	}
	
	
	@Test(dependsOnMethods= {"testUpdatingUserName"})
	public void searchNameInTimeSheet() throws IOException, InterruptedException {
		
		HrmCatalouge catalouge = landingPage.Login("Admin", "admin123");
		String catNameTime="Time";
		TimeSheet timeSheet = new TimeSheet(driver);
		timeSheet.timeSheetSearcgh(catNameTime);
		timeSheet.updateTimeSheet();
		//this comment is just got git push
		
	}

	


}
