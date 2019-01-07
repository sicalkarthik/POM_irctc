package pom.irctc.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.irctc.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC003 extends ProjectWrappers
{
	@BeforeClass
	public void beforeClass()
	{
		testname="TC003";
		description="Voter";
		author="Karthi";
		category="sample";
		browser="chrome";
		dataSheetName="TC003";
	}
	@Test(dataProvider="fetchData")
	public void voter(String Language, String State, String District, String Constituency, 
			String Name, String Surname, String RelativeName, String RelativeSurname, String RelationType, 
			String DOByear, String DOBmonth, String Gender, String PresentHouseNo, String PresentStreet, 
			String PresentVillage, String PresentPostoffice, String PresentPincode, String Epicno, String InOtherDisability, 
			String Email, String Mobile, String uploadPhoto, String uploadIdProof, String IDProof, String uploadAddressProof, 
			String AddressProof, String BirthVillage, String BirthState, String BirthDistrict, String PreviousYear, String PreviousMonth, 
			String PreviousState, String PreviousConstituency, String PreviousStreet, String PreviousVillage, String PreviousPincode, 
			String PreviousDistrict, String Place, String Captcha)
	{
		new HomePage(driver,test)
		.clickOnAgentLogin()
		.mouseHoverMore()
		.clickNVSP()
		.switchWindow()
		.sleep(3000)
		.clickForm6()
		.switchWindow()
		.selectLanguage(Language)
		.selectState(State)
		.sleep(2000)
		.selectDistrict(District)
		.sleep(2000)
		.selectConstituency(Constituency)
		.clickDueToshiftFromAnotherConst()
		.enterName(Name)
		.enterSurname(Surname)
		.enterRelativeName(RelativeName)
		.enterRelativeSurname(RelativeSurname)
		.selectRelationType(RelationType)
		.clickRbdDateOfBirth()
		.clickDobCalendar()
		.selectDOByear(DOByear)
		.selectDOBmonth(DOBmonth)
		.clickDOBday()
		.selectGender(Gender)
		.enterPresentHouseNo(PresentHouseNo)
		.enterPresentStreet(PresentStreet)
		.enterPresentVillage(PresentVillage)
		.enterPresentPostoffice(PresentPostoffice)
		.enterPreviousPincode(PresentPincode)
		.clickSameAsAbove()
		.enterEpicno(Epicno)
		.enterInOtherDisability(InOtherDisability)
		.enterEmail(Email)
		.enterMobile(Mobile)
		.uploadPhoto(uploadPhoto)
		.uploadIdProof(uploadIdProof)
		.selectIDProof(IDProof)
		.sleep(2000)
		.uploadAddressProof(uploadAddressProof)
		.selectAddressProof(AddressProof)
		.enterBirthVillage(BirthVillage)
		.selectBirthState(BirthState)
		.selectBirthDistrict(BirthDistrict)
		.clickPreviousCalendar()
		.selectPreviousYear(PreviousYear)
		.selectPreviousMonth(PreviousMonth)
		.clickPreviousDate()
		.selectPreviousState(PreviousState)
		.selectPreviousConstituency(PreviousConstituency)
		.enterPreviousStreet(PreviousStreet)
		.enterPreviousVillage(PreviousVillage)
		.enterPreviousPincode(PreviousPincode)
		.selectPreviousDistrict(PreviousDistrict)
		.enterPlace(Place)
		.enterCaptcha(Captcha);	
	}
}
