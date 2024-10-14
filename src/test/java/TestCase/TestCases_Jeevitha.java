package TestCase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Alldocuments;
import Pages.Contacts;
import Pages.Login;
import TestBase.testCaseBase;

public class TestCases_Jeevitha extends testCaseBase {
	Login login;
	Contacts contacts;

	public void setupDriver() {
		driver = new ChromeDriver(getChromeOptions());
		//	driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.esigns.io/signin");
	}

	@BeforeMethod
	public void intilize() {
		setupDriver();
		login = new Login(driver);
		contacts = new Contacts(driver);
	}

	@Test

	public void verifyloginwithValidCredentials() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();

	}

	@Test
	public void Document() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();

	}

	@Test
	public void Upload() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();

	}

	@Test
	public void ContactsModule() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		contacts.contactsclick();
		contacts.contactssearch();
		// contacts.addcontacts();
		// contacts.contacttypespage();
		// contacts.entercontacttype();
		// contacts.selectcontacts();
		// contacts.createcontacts();
		// contacts.delcontacts();
		// contacts.editcontacts();
		// contacts.viewdocument();
		// contacts.Voiddoc();
		// contacts.importcontacts();
		// contacts.importcontactsdraganddrop();

	}

}
