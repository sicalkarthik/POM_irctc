package wrappers;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import pom.irctc.utils.DP;

public class ProjectWrappers extends GenericWrappers
{
	@BeforeSuite
	public void beforeSuite()
	{
		startReport();
	}
	@BeforeTest
	public void beforeTest(){
		loadObjects();
	}
	@BeforeMethod
	public void launchIrctcApplication()
	{
		startTestCase(testname, description);
		test.assignAuthor(author);
		test.assignCategory(category);
		invokeApp(browser, surl);
	}
	@AfterMethod
	public void CloseApplication()
	{
		closeAllBrowsers();
	}
	@AfterClass
	public void afterClass()
	{
		endTestCase();
	}
	@AfterTest
	public void afterTest()
	{
		prop=null;
	}
	@AfterSuite
	public void afterSuite()
	{
		endReport();
	}
	
	public static String dataSheetName;
	@DataProvider(name="fetchData")
		public static String[][] getInput() throws IOException{
			return DP.getData(dataSheetName);
	}
	
		
}

