package ananthuProject.TestComponents;

import org.testng.ITestListener;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ananthuProject.resources.ExtentResprterNG;
public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	ExtentReports extent=ExtentResprterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
		
	@Override
	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);;
		
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, "Test Passed");
		
		
	}
	@Override
	
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
	    
	    try {
	    driver=(ChromeDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	    }
	    catch(Exception e1){
	    	e1.printStackTrace();
	    	
	    }
	    String filepath = null;

	    try {
	        // Get the screenshot path
	        filepath = getScreenshot(result.getMethod().getMethodName(),driver);
	    } catch (IOException e) {
	        // Log the exception
	        e.printStackTrace();
	    }

	    // Add the screenshot to the report
	    if (filepath != null) {
	    	extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	    } else {
	        System.out.println("Screenshot path is null. Unable to attach screenshot to the report.");
	    }
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
	
	

	

}
