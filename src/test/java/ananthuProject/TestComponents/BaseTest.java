package ananthuProject.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ananthuProject.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	Actions a;
	public LandingPage landingPage;

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\ananthuProject\\resources\\GlobalData.properties");
		prop.load(fis);

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browserName.contains("chrome")) {

			ChromeOptions options = new ChromeOptions();

			if (browserName.contains("headless")) {

				options.addArguments("headless");
			}
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));
			a = new Actions(driver);

		}

		else if (browserName.equals("firefox")) {

			// invoke frirefox browser
		} else if (browserName.equals("edge")) {

			// invoke frirefox browser

			EdgeOptions optins = new EdgeOptions();

			if (browserName.contains("headless")) {

				optins.addArguments("headless");
			}
			WebDriverManager.edgedriver().setup();;
			driver = new EdgeDriver(optins);
			driver.manage().window().setSize(new Dimension(1440, 900));
			a = new Actions(driver);

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;

	}

	@BeforeMethod
	public LandingPage launchApplication() throws IOException {

		driver = initializeDriver();
		landingPage = new LandingPage(driver, a);
		landingPage.GetPageURL();
		return landingPage;
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		// Capture the screenshot and store it in a file
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Define the destination path for the screenshot
		String destinationFile = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

		// Copy the screenshot file to the destination
		FileUtils.copyFile(src, new File(destinationFile));

		// Return the path of the screenshot
		return destinationFile;
	}

}
