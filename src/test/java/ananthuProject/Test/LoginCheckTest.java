package ananthuProject.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ananthuProject.TestComponents.BaseTest;
import ananthuProject.pageobjects.PasswordResetPage;

public class LoginCheckTest extends BaseTest {

	
	@Test(dataProvider="getData")
	public void logInError(String email,String password) throws IOException {
		
		landingPage.Login(email, password);
		String expectedErrorMessage ="Invalid credentials";
		assertEquals(landingPage.invalidCredentials(), expectedErrorMessage, "Error message does not match");
		
		
	}
	
	
	@Test
	public void passwordReset() throws IOException {
		
		String userName2="Admin";  
		String expectedText="Reset Password link sent successfully";
		
		PasswordResetPage passwordResetPage =new PasswordResetPage(driver);
		String resetText=passwordResetPage.forgotPassword(userName2);
		 assertTrue(resetText.contains(expectedText));
		 
		 
		
	
	}
	
	@DataProvider
	public Object[][] getData() {
		
	  return	new Object [][] {{"sdfsf", "dfg"},{"sdfsf", "sdfdfgdsdf"},{"sdwdfsf", "sdfsdfgdggdf"},{"sdwdfsf", "sdfsdfgdggdf"}};
	}
}
