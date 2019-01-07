package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class CharterHomePage extends GenericWrappers {
	public CharterHomePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public CharterHomePage switchWindow() {
		switchToLastWindow();
		return this;
	}

	public CharterHomePage clickEnquiry() {
		clickByXPath(prop.getProperty("CharterHomePage.clickEnquiry"));
		return this;
	}

	public CharterHomePage entername(String name) {
		enterByXPath(prop.getProperty("CharterHomePage.entername"), name);
		return this;
	}

	public CharterHomePage enterorganization(String organization) {
		enterByXPath(prop.getProperty("CharterHomePage.enterorganization"), organization);
		return this;
	}

	public CharterHomePage enteraddress(String address) {
		enterByXPath(prop.getProperty("CharterHomePage.enteraddress"), address);
		return this;
	}

	public CharterHomePage entermobile(String mobile) {
		enterByXPath(prop.getProperty("CharterHomePage.entermobile"), mobile);
		return this;
	}

	public CharterHomePage enteremail(String email) {
		enterByXPath(prop.getProperty("CharterHomePage.enteremail"), email);
		return this;
	}

	public CharterHomePage selectRequestFor(String requestFor) {
		selectValueByXPath(prop.getProperty("CharterHomePage.selectRequestFor"), requestFor);
		return this;
	}


	public CharterHomePage enteroriginStation(String originStation) {
		enterByXPath(prop.getProperty("CharterHomePage.enteroriginStation"), originStation);
		return this;
	}

	public CharterHomePage enterdestnStation(String destnStation) {
		enterByXPath(prop.getProperty("CharterHomePage.enterdestnStation"), destnStation);
		return this;
	}

	// Departure
	public CharterHomePage clickDepartureCalendar() {
		clickByXPath(prop.getProperty("CharterHomePage.clickDepartureCalendar"));
		return this;
	}

	public CharterHomePage clickNextMonthDeparture() {
		clickByXPath(prop.getProperty("CharterHomePage.clickNextMonthDeparture"));
		clickByXPath(prop.getProperty("CharterHomePage.clickNextMonthDeparture"));
		return this;
	}

	public CharterHomePage clickDepartureDate() {
		webTable("table",prop.getProperty("CharterHomePage.clickDepartureDate"));
		return this;
	}

	// Arrival
	public CharterHomePage clickArrivalCalendar() {
		clickByXPath(prop.getProperty("CharterHomePage.clickArrivalCalendar"));
		return this;
	}

	public CharterHomePage clickNextMonthArrival() {
		clickByXPath(prop.getProperty("CharterHomePage.clickNextMonthArrival"));
		clickByXPath(prop.getProperty("CharterHomePage.clickNextMonthArrival"));
		return this;
	}

	public CharterHomePage clickArrivalDate() {
		webTable("table",prop.getProperty("CharterHomePage.clickArrivalDate"));
		return this;
	}

	public CharterHomePage enterdurationPeriod(String durationPeriod) {
		enterByXPath(prop.getProperty("CharterHomePage.enterdurationPeriod"), durationPeriod);
		return this;
	}

	public CharterHomePage entercoachDetails(String coachDetails) {
		enterByXPath(prop.getProperty("CharterHomePage.entercoachDetails"), coachDetails);
		return this;
	}

	public CharterHomePage enternumPassenger(String numPassenger) {
		enterByXPath(prop.getProperty("CharterHomePage.enternumPassenger"), numPassenger);
		return this;
	}

	public CharterHomePage entercharterPurpose(String charterPurpose) {
		enterByXPath(prop.getProperty("CharterHomePage.entercharterPurpose"), charterPurpose);
		return this;
	}

	public CharterHomePage clickSubmit() {
		clickByXPath(prop.getProperty("CharterHomePage.clickSubmit"));
		return this;
	}

	public CharterHomePage verifyText() {
		verifyTextByXPath(prop.getProperty("CharterHomePage.verifyText"), "This field is required.");
		return this;
	}
}