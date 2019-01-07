package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class LoungePayment extends GenericWrappers {
	public LoungePayment(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public LoungePayment getTransactionid() {
		getAttributeByXPath(prop.getProperty("LoungePayment.getTransactionid"), "value");
		return this;
	}
}
