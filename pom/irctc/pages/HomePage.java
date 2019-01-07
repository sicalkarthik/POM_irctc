package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {
	public HomePage(RemoteWebDriver driver1, ExtentTest test1) {
		driver = driver1;
		test = test1;
	}

	public LoginPage clickOnAgentLogin() {
		clickByXPath(prop.getProperty("HomePage.clickOnAgentLogin"));
			LoginPage obj=new LoginPage(driver, test); 
			return obj;	
	}
}
