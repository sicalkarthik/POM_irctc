package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class LoungeHomePage extends GenericWrappers {
	public LoungeHomePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public LoungeHomePage sleep(long time) {
		threadSleep(time);
		return this;
	}

	public LoungeHomePage selectStationname(String Station_name) {
		selectVisibileTextByXPath(prop.getProperty("LoungeHomePage.selectStationname"), Station_name);
		return this;
	}

	public LoungeHomePage selectLounges(String Lounges) {
		selectVisibileTextByXPath(prop.getProperty("LoungeHomePage.selectLounges"), Lounges);
		return this;
	}

	public LoungeHomePage selectNoofPersons(String No_of_Persons) {
		selectValueByXPath(prop.getProperty("LoungeHomePage.selectNoofPersons"), No_of_Persons);
		return this;
	}

	// date
	public LoungeHomePage clickcalendar() {
		clickByXPath(prop.getProperty("LoungeHomePage.clickcalendar"));
		return this;
	}

	public LoungeHomePage clicknextmonth() {
		clickByXPath(prop.getProperty("LoungeHomePage.clicknextmonth"));
		return this;
	}

	public LoungeHomePage clickdate() {
		webTable("table",prop.getProperty("LoungeHomePage.clickdate"));// click_date
		return this;
	}

	public LoungeHomePage selecttime(String time) {
		selectVisibileTextByXPath(prop.getProperty("LoungeHomePage.selecttime"), time);
		return this;
	}

	public LoungeHomePage selectduration(String duration) {
		selectVisibileTextByXPath(prop.getProperty("LoungeHomePage.selectduration"), duration);
		return this;
	}

	// book
	public LoungeLoginPage clickbook() {
		clickByXPath(prop.getProperty("LoungeHomePage.clickbook"));
		return new LoungeLoginPage(driver, test);
	}
}
