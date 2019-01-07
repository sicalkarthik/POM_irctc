package pom.irctc.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class NvspHomePage extends GenericWrappers {
	public NvspHomePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public NvspHomePage switchWindow() {
		switchToLastWindow();
		return this;
	}

	public NvspHomePage clickForm6() {
		clickByXPath(prop.getProperty("NvspHomePage.clickForm6"));
		return this;
	}

	public NvspHomePage sleep(long time) {
		threadSleep(time);
		return this;
	}

	public NvspHomePage selectLanguage(String language) {
		selectVisibileTextByXPath(prop.getProperty("NvspHomePage.selectLanguage"), language);
		return this;
	}

	public NvspHomePage selectState(String stateList) {
		selectVisibileTextByXPath(prop.getProperty("NvspHomePage.selectState"), stateList);
		return this;
	}

	public NvspHomePage selectDistrict(String distList) {
		selectVisibileTextByXPath(prop.getProperty("NvspHomePage.selectDistrict"), distList);
		return this;
	}

	public NvspHomePage selectConstituency(String acList) {
		selectVisibileTextByXPath(prop.getProperty("NvspHomePage.selectConstituency"), acList);
		return this;
	}

	public NvspHomePage clickDueToshiftFromAnotherConst() {
		clickByXPath(prop.getProperty("NvspHomePage.clickDueToshiftFromAnotherConst"));
		return this;
	}

	public NvspHomePage enterName(String applicantName) {
		enterByXPath(prop.getProperty("NvspHomePage.enterName"), applicantName);
		return this;
	}

	public NvspHomePage enterSurname(String applicantSurname) {
		enterByXPath(prop.getProperty("NvspHomePage.enterSurname"), applicantSurname);
		return this;
	}

	public NvspHomePage enterRelativeName(String applicantFMHName) {
		enterByXPath(prop.getProperty("NvspHomePage.enterRelativeName"), applicantFMHName);
		return this;
	}

	public NvspHomePage enterRelativeSurname(String applicantFMHSurname) {
		enterByXPath(prop.getProperty("NvspHomePage.enterRelativeSurname"), applicantFMHSurname);
		return this;
	}

	public NvspHomePage selectRelationType(String applicantRelationType) {
		selectVisibileTextByXPath(prop.getProperty("NvspHomePage.selectRelationType"),
				applicantRelationType);
		return this;
	}

	public NvspHomePage clickRbdDateOfBirth() {
		clickByXPath(prop.getProperty("NvspHomePage.clickRbdDateOfBirth"));
		return this;
	}

	public NvspHomePage clickDobCalendar() {
		clickByXPath(prop.getProperty("NvspHomePage.clickDobCalendar"));
		return this;
	}

	public NvspHomePage selectDOByear(String ui_datepicker_year) {
		selectVisibileTextByXPath(prop.getProperty("NvspHomePage.selectDOByear"), ui_datepicker_year);
		return this;
	}

	public NvspHomePage selectDOBmonth(String ui_datepicker_month) {
		selectVisibileTextByXPath(prop.getProperty("NvspHomePage.selectDOBmonth"),ui_datepicker_month);
		return this;
	}

	public NvspHomePage clickDOBday() {
		webTable("table",prop.getProperty("NvspHomePage.clickDOBday"));
		return this;
	}

	public NvspHomePage selectGender(String elector_gender) {
		selectVisibileTextByXPath(prop.getProperty("NvspHomePage.selectGender"), elector_gender);
		return this;
	}

	public NvspHomePage enterPresentHouseNo(String applicantPresentHouseNo) {
		enterByXPath(prop.getProperty("NvspHomePage.enterPresentHouseNo"), applicantPresentHouseNo);
		return this;
	}

	public NvspHomePage enterPresentStreet(String applicantPresentStreet) {
		enterByXPath(prop.getProperty("NvspHomePage.enterPresentStreet"), applicantPresentStreet);
		return this;
	}

	public NvspHomePage enterPresentVillage(String applicantPresentVillage) {
		enterByXPath(prop.getProperty("NvspHomePage.enterPresentVillage"), applicantPresentVillage);
		return this;
	}

	public NvspHomePage enterPresentPostoffice(String applicantPresentPostoffice) {
		enterByXPath(prop.getProperty("NvspHomePage.enterPresentPostoffice"), applicantPresentPostoffice);
		return this;
	}

	public NvspHomePage enterPresentPincode(String applicantPresentPincode) {
		enterByXPath(prop.getProperty("NvspHomePage.enterPresentPincode"), applicantPresentPincode);
		return this;
	}

	public NvspHomePage clickSameAsAbove() {
		clickByXPath(prop.getProperty("NvspHomePage.clickSameAsAbove"));
		return this;
	}

	public NvspHomePage enterEpicno(String applicantPrevepicno) {
		enterByXPath(prop.getProperty("NvspHomePage.enterEpicno"), applicantPrevepicno);
		return this;
	}

	public NvspHomePage enterInOtherDisability(String Other) {
		enterByXPath(prop.getProperty("NvspHomePage.enterInOtherDisability"), Other);
		return this;
	}

	public NvspHomePage enterEmail(String applicantEmail) {
		enterByXPath(prop.getProperty("NvspHomePage.enterEmail"), applicantEmail);
		return this;
	}

	public NvspHomePage enterMobile(String applicantMobile) {
		enterByXPath(prop.getProperty("NvspHomePage.enterMobile"), applicantMobile);
		return this;
	}

	public NvspHomePage uploadPhoto(String applicant_photo_image) {
		fileUploadbyXPath(prop.getProperty("NvspHomePage.uploadPhoto"), applicant_photo_image);
		return this;
	}

	public NvspHomePage uploadIdProof(String applicant_identity_image) {
		fileUploadbyXPath(prop.getProperty("NvspHomePage.uploadIdProof"), applicant_identity_image);
		return this;
	}

	public NvspHomePage selectIDProof(String IDProof) {
		selectVisibileTextByXPath(prop.getProperty("NvspHomePage.selectIDProof"), IDProof);
		return this;
	}

	public NvspHomePage uploadAddressProof(String applicant_address_image) {
		fileUploadbyXPath(prop.getProperty("NvspHomePage.uploadAddressProof"), applicant_address_image);
		return this;
	}

	public NvspHomePage selectAddressProof(String AddressProof) {
		selectVisibileTextByXPath(prop.getProperty("NvspHomePage.selectAddressProof"), AddressProof);
		return this;
	}

	public NvspHomePage enterBirthVillage(String applicantBirthVillage) {
		enterByXPath(prop.getProperty("NvspHomePage.enterBirthVillage"), applicantBirthVillage);
		return this;
	}

	public NvspHomePage selectBirthState(String applicantBirthState) {
		selectVisibileTextByXPath(prop.getProperty("NvspHomePage.selectBirthState"), applicantBirthState);
		return this;
	}

	public NvspHomePage selectBirthDistrict(String applicantBirthDistrict) {
		selectVisibileTextByXPath(prop.getProperty("NvspHomePage.selectBirthDistrict"),
				applicantBirthDistrict);
		return this;
	}

	public NvspHomePage clickPreviousCalendar() {
		clickByXPath(prop.getProperty("NvspHomePage.clickPreviousCalendar"));
		return this;
	}

	public NvspHomePage selectPreviousYear(String ui_datepicker_year_1) {
		selectVisibileTextByXPath(prop.getProperty("NvspHomePage.selectPreviousYear"),ui_datepicker_year_1);
		return this;
	}

	public NvspHomePage selectPreviousMonth(String ui_datepicker_month_1) {
		selectVisibileTextByXPath(prop.getProperty("NvspHomePage.selectPreviousMonth"),ui_datepicker_month_1);
		return this;
	}

	public NvspHomePage clickPreviousDate() {
		webTable("table",prop.getProperty("NvspHomePage.clickPreviousDate"));
		return this;
	}

	public NvspHomePage selectPreviousState(String Prev_State) {
		selectVisibileTextByXPath(prop.getProperty("NvspHomePage.selectPreviousState"), Prev_State);
		return this;
	}

	public NvspHomePage selectPreviousConstituency(String Prev_cons) {
		selectVisibileTextByXPath(prop.getProperty("NvspHomePage.selectPreviousConstituency"), Prev_cons);
		return this;
	}

	public NvspHomePage enterPreviousStreet(String applicantPreStreet) {
		enterByXPath(prop.getProperty("NvspHomePage.enterPreviousStreet"), applicantPreStreet);
		return this;
	}

	public NvspHomePage enterPreviousVillage(String applicantPreVillage) {
		enterByXPath(prop.getProperty("NvspHomePage.enterPreviousVillage"), applicantPreVillage);
		return this;
	}

	public NvspHomePage enterPreviousPincode(String applicantPrePincode) {
		enterByXPath(prop.getProperty("NvspHomePage.enterPreviousPincode"), applicantPrePincode);
		return this;
	}

	public NvspHomePage selectPreviousDistrict(String Prev_DistNo) {
		selectVisibileTextByXPath(prop.getProperty("NvspHomePage.selectPreviousDistrict"), Prev_DistNo);
		return this;
	}

	public NvspHomePage enterPlace(String applicantFormPlace) {
		enterByXPath(prop.getProperty("NvspHomePage.enterPlace"), applicantFormPlace);
		return this;
	}

	public NvspHomePage enterCaptcha(String Captcha) {
		enterByXPath(prop.getProperty("NvspHomePage.enterCaptcha"), Captcha);
		return this;
	}

}
