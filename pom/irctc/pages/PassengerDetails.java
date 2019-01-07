package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class PassengerDetails extends GenericWrappers {
	public PassengerDetails(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public PassengerDetails selectGST(String yes_no) {
		selectVisibileTextByXPath(prop.getProperty("PassengerDetails.selectGST"), yes_no);
		return this;
	}

	public PassengerDetails enterGST(String gst) {
		enterByXPath(prop.getProperty("PassengerDetails.enterGST"), gst);
		return this;
	}

	public PassengerDetails entername1(String name1) {
		enterByXPath(prop.getProperty("PassengerDetails.entername1"), name1);
		return this;
	}

	public PassengerDetails entername2(String name2) {
		enterByXPath(prop.getProperty("PassengerDetails.entername2"), name2);
		return this;
	}

	public PassengerDetails entername3(String name3) {
		enterByXPath(prop.getProperty("PassengerDetails.entername3"), name3);
		return this;
	}

	public PassengerDetails enterage1(String age1) {
		enterByXPath(prop.getProperty("PassengerDetails.enterage1"), age1);
		return this;
	}

	public PassengerDetails enterage2(String age2) {
		enterByXPath(prop.getProperty("PassengerDetails.enterage2"), age2);
		return this;
	}

	public PassengerDetails enterage3(String age3) {
		enterByXPath(prop.getProperty("PassengerDetails.enterage3"), age3);
		return this;
	}

	public PassengerDetails selectgender1(String gender1) {
		selectValueByXPath(prop.getProperty("PassengerDetails.selectgender1"), gender1);
		return this;
	}

	public PassengerDetails selectgender2(String gender2) {
		selectValueByXPath(prop.getProperty("PassengerDetails.selectgender2"), gender2);
		return this;
	}

	public PassengerDetails selectgender3(String gender3) {
		selectValueByXPath(prop.getProperty("PassengerDetails.selectgender3"), gender3);
		return this;
	}

	public PassengerDetails selectState(String State) {
		selectVisibileTextByXPath(prop.getProperty("PassengerDetails.selectState"), State);
		return this;
	}

	public LoungeSummary clicksubmit1() {
		clickByXPath(prop.getProperty("PassengerDetails.clicksubmit1"));
		return new LoungeSummary(driver, test);
	}

	public PassengerDetails clicksubmit2() {
		clickByXPath(prop.getProperty("PassengerDetails.clicksubmit2"));
		return this;
	}

	public PassengerDetails verifyGST(String text) {
		verifyTextByXPath(prop.getProperty("PassengerDetails.verifyGST"), text);
		return this;
	}
}
