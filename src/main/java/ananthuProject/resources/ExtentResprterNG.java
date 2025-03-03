package ananthuProject.resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentResprterNG {
	
	public static ExtentReports getReportObject() {
	
		String path = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("OrangeHRM Test Results");
		
//		ExtentReports extent = new ExtentReports();
		
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
		
		
	}

}
