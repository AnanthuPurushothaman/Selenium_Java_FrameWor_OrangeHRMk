package ananthuProject.Test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import ananthuProject.TestComponents.BaseTest;
import ananthuProject.TestComponents.Retry;
import ananthuProject.pageobjects.PimPage;

public class PIMpageTest extends BaseTest {
	
	
	@Test(retryAnalyzer=Retry.class)
	public void testHelpButton(){
		
		String menu="PIM";
		landingPage.Login("Admin", "admin123");
		PimPage pm= new PimPage(driver);
		assertTrue(pm.testHelpButton(menu));
	}

}
