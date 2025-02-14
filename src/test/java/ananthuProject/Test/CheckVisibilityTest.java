package ananthuProject.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import ananthuProject.TestComponents.BaseTest;
import ananthuProject.pageobjects.PimPage;

public class CheckVisibilityTest extends BaseTest {

	
	
	@Test
	public void testTotalRecord() throws InterruptedException {
		
		
		String menu="PIM";
		landingPage.Login("Admin", "admin123");
		PimPage pm= new PimPage(driver);
		assertEquals(pm.countCheck(menu), pm.getExpectedCount());	
		//Thread.sleep(3000);	
	}
	
	@Test
	public void checkTheVisibilityofH6() {
		
		String menu="PIM";
		landingPage.Login("Admin", "admin123");
		PimPage pm= new PimPage(driver);
		assertTrue(pm.testVisibilityOfH6Title(menu));
	}
}
