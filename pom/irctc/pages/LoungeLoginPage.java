package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class LoungeLoginPage extends GenericWrappers {
	public LoungeLoginPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public LoungeLoginPage sleep(long time) {
		threadSleep(time);
		return this;
	}

	public LoungeLoginPage enterguestemail(String guest_email) {
		enterByXPath(prop.getProperty("LoungeLoginPage.enterguestemail"), guest_email);
		return this;
	}

	public LoungeLoginPage enterphone(String phone) {
		enterByXPath(prop.getProperty("LoungeLoginPage.enterphone"), phone);
		return this;
	}

	public PassengerDetails clicksignin() {
		clickByXPath(prop.getProperty("LoungeLoginPage.clicksignin"));
		return new PassengerDetails(driver, test);
	}
}
