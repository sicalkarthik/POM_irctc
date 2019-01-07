package pom.irctc.testcases;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.irctc.pages.HomePage;
import pom.irctc.pages.LoginPage;
import pom.irctc.pages.SignUpPage;
import wrappers.ProjectWrappers;
public class TC001 extends ProjectWrappers
{
	@BeforeClass
	public void beforeClass()
	{
		testname="TC001";
		description="IRCTC Signup";
		author="Karthi";
		category="sample";
		browser="chrome";
		dataSheetName="TC001";
	}
	@Test(dataProvider="fetchData")
	public void irctcSignUp(String userName,String password,String confpasword,String securityQ,String securityAnswer,String preferred_language,
			String firstName,
			String middleName,String lastName,
			String gender,
			String maritalStatus,String dobDay,String dobMonth,String dateOfBirth,String occupation,
			String Aadhaar,String PAN,String country,String email,String mobile,String nationalityId,
			String address,String pincode,String cityName,String postofficeName,String landline,String nlpAnswer)
	{
		HomePage oh=new HomePage(driver, test);
		oh.clickOnAgentLogin()
		.clickOnSignUp()
		.enterUserId(userName)
		.enterPassword(password)
		.enterconfpasword(confpasword)
		.selectsecurityQ(securityQ)
		.entersecurityAnswer(securityAnswer)
		.selectpreferredlanguage(preferred_language)
		.enterfirstName(firstName)
		.entermiddleName(middleName)
		.enterlastName(lastName)
		.clickMale()
		.clickMarried()
		.selectdobDay(dobDay)
		.selectdobMonth(dobMonth)
		.selectdobYear(dateOfBirth)
		.selectoccupation(occupation)
		.enterAadhaar(Aadhaar)
		.enterPAN(PAN)
		.selectcountry(country)
		.enteremail1(email)
		.entermobile1(mobile)
		.selectnationalityId(nationalityId)
		.enteraddress1(address)
		.enterpincode(pincode)
		.sleep(2000)
		.clickState()
		.sleep(2000)
		.selectcityName(cityName)
		.sleep(2000)
		.selectpostofficeName(postofficeName)
		.enterPhone(landline)
		.clickYesCopyResidentToOfficeAddress()
		.enterCaptcha1(nlpAnswer)
		.clickNonewsletter()
		.clickNoCommercialPromotions()
		.clickNoPleaseinformSBIcard();
	}
}
