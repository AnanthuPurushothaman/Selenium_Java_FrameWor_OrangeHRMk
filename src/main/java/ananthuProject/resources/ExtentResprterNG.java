package ananthuProject.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentResprterNG {
	
	public static ExtentReports getReportObject() {
	
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("OrangeHRM Test Results");
		
//		ExtentReports extent = new ExtentReports();
		
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
		
		
	}

}
