package TestCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Alldocuments;
import Pages.Contacts;
import Pages.Login;
import TestBase.testCaseBase;

public class TestCases_Jeevitha extends testCaseBase {
	Login login;
	Contacts contacts;
	@BeforeMethod
	public void intilize() {
		setup();
		login = new Login(driver);
		contacts=new Contacts(driver);
	}

	@Test

	public void verifyloginwithValidCredentials() throws InterruptedException {
		login.Signin();
		login.VerifyLoginSucess();

	}
@Test
	public void Document() throws InterruptedException {
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
	//contacts.addcontacts();
	//contacts.contacttypespage();
	//contacts.entercontacttype();
	//contacts.selectcontacts();
	//contacts.createcontacts();
	//contacts.delcontacts();
	//contacts.editcontacts();
	//contacts.viewdocument();
	//contacts.Voiddoc();
	//contacts.importcontacts();
	//contacts.importcontactsdraganddrop();


}





}



