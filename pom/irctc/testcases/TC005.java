package pom.irctc.testcases;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.irctc.pages.HomePage;
import wrappers.ProjectWrappers;
public class TC005 extends ProjectWrappers 
{
	@BeforeClass
	public void beforeClass()
	{
		testname="TC005";
		description="GST";
		author="Karthi";
		category="sample";
		browser="chrome";
		dataSheetName="TC005";
	}
	@Test(dataProvider="fetchData")
	public void gst(String city,String laungecity,String selPassangers,String checkInTime,String checkOutTime,String email,String mobile,
			String GST_yes_no,String GST,String name1,String name2,String name3,String age1,String age2,String age3,String gender1,String gender2,String gender3,String state)
	{
		new HomePage(driver,test)
		.clickOnAgentLogin()
		.mouseHoverTourism()
		.mouseHoverStays()
		.clickLounge()
		.switchWindow()
		.sleep(2000)
		.clickStay()
		.selectStationname(city)
		.selectLounges(laungecity)
		.selectNoofPersons(selPassangers)
		.clickcalendar()
		.clicknextmonth()
		.clickdate()
		.selecttime(checkInTime)
		.selectduration(checkOutTime)
		.sleep(2000)
		.clickbook()
		.sleep(2000)
		.enterguestemail(email)
		.enterphone(mobile)
		.clicksignin()
		.selectGST(GST_yes_no)
		.enterGST(GST)
		.entername1(name1)
		.entername2(name2)
		.entername3(name3)
		.enterage1(age1)
		.enterage2(age2)
		.enterage3(age3)
		.selectgender1(gender1)
		.selectgender2(gender2)
		.selectgender3(gender3)
		.selectState(state)		
		.clicksubmit2()
		.verifyGST("Please Enter Valid GSt number");
	}
}
