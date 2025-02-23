package ananthuProject.Test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

import ananthuProject.TestComponents.BaseTest;

public class APITest extends BaseTest {

	
	@Test
	public void APIstatusCheck() throws MalformedURLException, IOException {
		
		landingPage.Login("Admin", "admin123");
		assertTrue(landingPage.menuUrlAPIcalls());
		
		
	}
	
}
