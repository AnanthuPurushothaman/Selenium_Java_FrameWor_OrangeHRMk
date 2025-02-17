package ananthuProject.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ananthuProject.TestComponents.BaseTest;
import ananthuProject.pageobjects.PasswordResetPage;

public class LoginCheckTest extends BaseTest {

	@Test(dataProvider = "getData")
	public void logInError(String email, String password) throws IOException {

		landingPage.Login(email, password);
		String expectedErrorMessage = "Invalid credentials";
		assertEquals(landingPage.invalidCredentials(), expectedErrorMessage, "Error message does not match");

	}

	@Test
	public void passwordReset() throws IOException {

		String userName2 = "Admin";
		String expectedText = "Reset Password link sent successfully";

		PasswordResetPage passwordResetPage = new PasswordResetPage(driver);
		String resetText = passwordResetPage.forgotPassword(userName2);
		assertTrue(resetText.contains(expectedText));

	}

	@Test(dataProvider = "getDataFromSQL")
	public void logInWithDataBaseCredentials(String emailfromSQL, String passwordfromSQL) {

		landingPage.Login(emailfromSQL, passwordfromSQL);
		String expectedErrorMessage = "Invalid credentials";
		assertEquals(landingPage.invalidCredentials(), expectedErrorMessage, "Error message does not match");

	}

	@DataProvider
	public Object[][] getData() {

		return new Object[][] { { "Ananthu", "test123" }, { "jackson", "test896" }, { "Test", "ananthu" },
				{ "sdwdfsf", "sdfsdfgdggdf" } };
	}

	@DataProvider
	public Object[][] getDataFromSQL() throws SQLException {

		String host = "localhost";
		String port = "3306";

		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/oragehrm", "root",
				"Thekingmaker369@");

		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from credentials where expied=\"Y\";");

		List<Object[]> data = new ArrayList<Object[]>();

		while (rs.next()) {

			data.add(new Object[] { rs.getString("user_id"), rs.getString("password") });
		}

		return data.toArray(new Object[0][0]);

	}

}
