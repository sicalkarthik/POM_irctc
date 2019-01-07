package pom.irctc.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.irctc.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC004 extends ProjectWrappers
{
	@BeforeClass
	public void beforeClass()
	{
		testname="TC004";
		description="Saloon";
		author="Karthi";
		category="sample";
		browser="chrome";
		dataSheetName="TC004";
	}
	@Test(dataProvider="fetchData")
	public void saloon(String name, String organization, String address, String mobile, String email, String requestFor,
			String originStation, String destnStation, String durationPeriod, String coachDetails, String numPassenger,
			String charterPurpose)
	{
		new HomePage(driver,test)
		.clickOnAgentLogin()
		.mouseHoverTourism()
		.mouseHoverStays()
		.clickLounge()
		.switchWindow()
		.sleep(3000)
		.clickSaloon()
		.switchWindow()
		.clickEnquiry()
		.entername(name)
		.enterorganization(organization)
		.enteraddress(address)
		.entermobile(mobile)
		.enteremail(email)
		.selectRequestFor(requestFor)
		.enteroriginStation(originStation)
		.enterdestnStation(destnStation)
		.clickDepartureCalendar()
		.clickNextMonthDeparture()
		.clickDepartureDate()
		.clickArrivalCalendar()
		.clickNextMonthArrival()
		.clickArrivalDate()
		.enterdurationPeriod(durationPeriod)
		.entercoachDetails(coachDetails)
		.enternumPassenger(numPassenger)
		.entercharterPurpose(charterPurpose)
		.clickSubmit()
		.verifyText();
	}
}
