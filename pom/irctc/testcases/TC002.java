package pom.irctc.testcases;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.irctc.pages.HomePage;
import wrappers.ProjectWrappers;
public class TC002 extends ProjectWrappers
{
	@BeforeClass
	public void beforeClass()
	{
		testname="TC002";
		description="Accomodations";
		author="Karthi";
		category="sample";
		browser="chrome";
		dataSheetName="TC002";
	}
	@Test(dataProvider="fetchData")
	public void accomodations(String Station_name ,String Lounges ,String No_of_Persons ,String time ,String duration ,String guest_email ,
			String phone ,String name1,String name2,String name3,String age1,String age2,String age3,String gender1,String gender2,String gender3,String State)
	{
		new HomePage(driver,test)
		.clickOnAgentLogin()
		.mouseHoverTourism()
		.mouseHoverStays()
		.clickLounge()
		.switchWindow()
		.clickStay()
		.sleep(2000)
		.selectStationname(Station_name)
		.selectLounges(Lounges)
		.selectNoofPersons(No_of_Persons)
		.clickcalendar()
		.clicknextmonth()
		.clickdate()
		.selecttime(time)
		.selectduration(duration)
		.clickbook()
		.enterguestemail(guest_email)
		.enterphone(phone)
		.clicksignin()
		.entername1(name1)
		.entername2(name2)
		.entername3(name3)
		.enterage1(age1)
		.enterage2(age2)
		.enterage3(age3)
		.selectgender1(gender1)
		.selectgender2(gender2)
		.selectgender3(gender3)
		.selectState(State)
		.clicksubmit1()
		.verifyemail(guest_email)
		.verifyphonenumber(phone)
		.getamount()
		.clickAgree()
		.clickmakepayment()
		.getTransactionid();
	}
}
