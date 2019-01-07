package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class SignUpPage extends GenericWrappers {
	public SignUpPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public SignUpPage enterUserId(String username) {
		enterByXPath(prop.getProperty("SignUpPage.enterUserId"), username);
		return this;
	}

	public SignUpPage enterPassword(String password) {
		enterByXPath(prop.getProperty("SignUpPage.enterPassword"), password);
		return this;
	}

	public SignUpPage enterconfpasword(String confpasword) {
		enterByXPath(prop.getProperty("SignUpPage.enterconfpasword"), confpasword);
		return this;
	}

	public SignUpPage selectsecurityQ(String securityQ) {
		selectVisibileTextByXPath(prop.getProperty("SignUpPage.selectsecurityQ"), securityQ);
		return this;
	}

	public SignUpPage entersecurityAnswer(String securityAnswer) {
		enterByXPath(prop.getProperty("SignUpPage.entersecurityAnswer"), securityAnswer);
		return this;
	}

	public SignUpPage selectpreferredlanguage(String preferred_language) {
		selectVisibileTextByXPath(prop.getProperty("SignUpPage.selectpreferredlanguage"), preferred_language);
		return this;
	}

	public SignUpPage enterfirstName(String firstName) {
		enterByXPath(prop.getProperty("SignUpPage.enterfirstName"), firstName);
		return this;
	}

	public SignUpPage entermiddleName(String middleName) {
		enterByXPath(prop.getProperty("SignUpPage.entermiddleName"), middleName);
		return this;
	}

	public SignUpPage enterlastName(String lastName) {
		enterByXPath(prop.getProperty("SignUpPage.enterlastName"), lastName);
		return this;
	}

	public SignUpPage clickMale() {
		clickByXPath(prop.getProperty("SignUpPage.clickMale"));
		return this;
	}

	public SignUpPage clickFemale() {
		clickByXPath(prop.getProperty("SignUpPage.clickFemale"));
		return this;
	}

	public SignUpPage clickTransgender() {
		clickByXPath(prop.getProperty("SignUpPage.clickTransgender"));
		return this;
	}

	public SignUpPage clickMarried() {
		clickByXPath(prop.getProperty("SignUpPage.clickMarried"));
		return this;
	}

	public SignUpPage clickUnmarried() {
		clickByXPath(prop.getProperty("SignUpPage.clickUnmarried"));
		return this;
	}

	public SignUpPage selectdobDay(String dobDay) {
		selectValueByXPath(prop.getProperty("SignUpPage.selectdobDay"), dobDay);
		return this;
	}

	public SignUpPage selectdobMonth(String dobMonth) {
		selectValueByXPath(prop.getProperty("SignUpPage.selectdobMonth"), dobMonth);
		return this;
	}

	public SignUpPage selectdobYear(String dateOfBirth) {
		selectValueByXPath(prop.getProperty("SignUpPage.selectdobYear"), dateOfBirth);
		return this;
	}

	public SignUpPage selectoccupation(String occupation) {
		selectVisibileTextByXPath(prop.getProperty("SignUpPage.selectoccupation"), occupation);
		return this;
	}

	public SignUpPage enterAadhaar(String Aadhaar) {
		enterByXPath(prop.getProperty("SignUpPage.enterAadhaar"), Aadhaar);
		return this;
	}

	public SignUpPage enterPAN(String PAN) {
		enterByXPath(prop.getProperty("SignUpPage.enterPAN"), PAN);
		return this;
	}

	public SignUpPage selectcountry(String country) {
		selectVisibileTextByXPath(prop.getProperty("SignUpPage.selectcountry"), country);
		return this;
	}

	public SignUpPage enteremail1(String email) {
		enterByXPath(prop.getProperty("SignUpPage.enteremail"), email);
		return this;
	}

	public SignUpPage entermobile1(String mobile) {
		enterByXPath(prop.getProperty("SignUpPage.entermobile"), mobile);
		return this;
	}

	public SignUpPage selectnationalityId(String nationalityId) {
		selectVisibileTextByXPath(prop.getProperty("SignUpPage.selectnationalityId"), nationalityId);
		return this;
	}

	public SignUpPage enteraddress1(String address) {
		enterByXPath(prop.getProperty("SignUpPage.enteraddress"), address);
		return this;
	}

	public SignUpPage enterpincode(String pincode) {
		enterByXPath(prop.getProperty("SignUpPage.enterpincode"), pincode);
		return this;
	}

	public SignUpPage sleep(long time) {
		threadSleep(time);
		return this;
	}

	public SignUpPage clickState() {
		clickByXPath(prop.getProperty("SignUpPage.clickState"));
		return this;
	}

	public SignUpPage selectcityName(String cityName) {
		selectValueByXPath(prop.getProperty("SignUpPage.selectcityName"), cityName);
		return this;
	}

	public SignUpPage selectpostofficeName(String postofficeName) {
		selectVisibileTextByXPath(prop.getProperty("SignUpPage.selectpostofficeName"), postofficeName);
		return this;
	}

	public SignUpPage enterPhone(String landline) {
		enterByXPath(prop.getProperty("SignUpPage.enterPhone"), landline);
		return this;
	}

	public SignUpPage clickYesCopyResidentToOfficeAddress() {
		clickByXPath(prop.getProperty("SignUpPage.clickYesCopyResidentToOfficeAddress"));
		return this;
	}

	public SignUpPage enterCaptcha1(String nlpAnswer) {
		enterByXPath(prop.getProperty("SignUpPage.enterCaptcha1"), nlpAnswer);
		return this;
	}

	public SignUpPage clickNonewsletter() {
		clickByXPath(prop.getProperty("SignUpPage.clickNonewsletter"));
		return this;
	}

	public SignUpPage clickNoCommercialPromotions() {
		clickByXPath(prop.getProperty("SignUpPage.clickNoCommercialPromotions"));
		return this;
	}

	public SignUpPage clickNoPleaseinformSBIcard() {
		clickByXPath(prop.getProperty("SignUpPage.clickNoPleaseinformSBIcard"));
		return this;
	}
}
