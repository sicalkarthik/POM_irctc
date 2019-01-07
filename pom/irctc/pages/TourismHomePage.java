package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class TourismHomePage extends GenericWrappers {
	public TourismHomePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public TourismHomePage switchWindow() {
		switchToLastWindow();
		return this;
	}

	public LoungeHomePage clickStay() {
		clickByXPath(prop.getProperty("TourismHomePage.clickStay"));// Stay
		return new LoungeHomePage(driver, test);
	}

	public TourismHomePage sleep(long time) {
		threadSleep(time);
		return this;
	}

	public CharterHomePage clickSaloon() {
		clickByXPath(prop.getProperty("TourismHomePage.clickSaloon"));// Saloon
		return new CharterHomePage(driver, test);
	}
}
