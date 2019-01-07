package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class LoungeSummary extends GenericWrappers {
	public LoungeSummary(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public LoungeSummary verifyemail(String guest_email) {
		verifyTextByXPath(prop.getProperty("LoungeSummary.verifyemail"), guest_email);
		return this;
	}

	public LoungeSummary verifyphonenumber(String phone) {
		verifyTextByXPath(prop.getProperty("LoungeSummary.verifyphonenumber"), phone);
		return this;
	}

	public LoungeSummary getamount() {
		getTextByXPath(prop.getProperty("LoungeSummary.getamount"));// amount
		return this;
	}

	public LoungeSummary clickAgree() {
		clickByXPath(prop.getProperty("LoungeSummary.clickAgree"));
		return this;
	}

	public LoungePayment clickmakepayment() {
		clickByXPath(prop.getProperty("LoungeSummary.clickmakepayment"));
		return new LoungePayment(driver, test);
	}

}
