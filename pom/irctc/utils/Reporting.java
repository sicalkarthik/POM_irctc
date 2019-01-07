package pom.irctc.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Reporting {

	public ExtentReports report;   
	public ExtentTest test;
	public String testname,description,author,category,browser;

	public void startReport() {
		report = new ExtentReports("./reports/sample.html", true);
	}

	public void startTestCase(String testName, String description) {
		test = report.startTest(testName, description);
	}
	
	public abstract long takeSnap();
	
	public void reportStep(String details, String status) {	
		long number = 1000000l;
		try {		number = takeSnap();	} 
		catch (Exception e) {	e.printStackTrace();	}
		
		if (status.equalsIgnoreCase("pass")) test.log(LogStatus.PASS, details+test.addScreenCapture("./../screenshots/"+number+".jpeg"));
		
		else if(status.equalsIgnoreCase("close"))	test.log(LogStatus.PASS, details);
		
		else if (status.equalsIgnoreCase("fail"))	test.log(LogStatus.FAIL, details);
		
		else if (status.equalsIgnoreCase("warning")) 	test.log(LogStatus.WARNING, details);
		
		else if (status.equalsIgnoreCase("info")) 	test.log(LogStatus.INFO, details);
	}
	
	public void endTestCase() {
		report.endTest(test);
	}

	public void endReport() {
		report.flush();
	}

}
