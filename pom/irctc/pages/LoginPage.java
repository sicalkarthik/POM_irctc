package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class LoginPage extends GenericWrappers {
	public LoginPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public SignUpPage clickOnSignUp() {
		clickByXPath(prop.getProperty("LoginPage.clickOnSignUp"));
		return new SignUpPage(driver, test);
	}

	public LoginPage mouseHoverTourism() {
		mouseHover(prop.getProperty("LoginPage.mouseHoverTourism"));
		return this;
	}

	public LoginPage mouseHoverStays() {
		mouseHover(prop.getProperty("LoginPage.mouseHoverStays"));
		return this;
	}

	public TourismHomePage clickLounge() {
		mouseHover(prop.getProperty("LoginPage.clickLounge"));
		return new TourismHomePage(driver, test);
	}

	public LoginPage mouseHoverMore() {
		mouseHover(prop.getProperty("LoginPage.mouseHoverMore"));
		return this;
	}

	public NvspHomePage clickNVSP() {
		mouseHover(prop.getProperty("LoginPage.clickNVSP"));
		return new NvspHomePage(driver, test);
	}
}