package TestCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Addrecipients;
import Pages.Alldocuments;
import Pages.Dragdrop;
import Pages.Login;
import Pages.ReviewaNdSend;
import Pages.Uploaddocuments;
import TestBase.testCaseBase;

public class LoginPageTest extends testCaseBase {
	Login login;
	Alldocuments alldocuments;
	Uploaddocuments uploaddocuments;
	Addrecipients addrecipients;
	Dragdrop dragdrop;
	ReviewaNdSend reviewaNdSend;

	@BeforeMethod
	public void Start() {
		setup();
		login = new Login(driver);
		alldocuments = new Alldocuments(driver);
		uploaddocuments = new Uploaddocuments(driver);
		addrecipients = new Addrecipients(driver);
		dragdrop = new Dragdrop(driver);
		reviewaNdSend = new ReviewaNdSend(driver);

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
		alldocuments.Createdocument();
		alldocuments.Validdocument();
	}

	@Test
	public void Upload() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		alldocuments.Createdocument();
		alldocuments.Validdocument();
		uploaddocuments.Dropbox();
		// uploaddocuments.Fileupload();
		// uploaddocuments.VerifyUpload();
	}

	@Test
	public void AddingRecipients() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		alldocuments.Createdocument();
		alldocuments.Validdocument();
		uploaddocuments.Fileupload();
		addrecipients.Recipients();
		addrecipients.Recipients1();
		addrecipients.MoreFields();
		addrecipients.Verifrecipient();

	}

	@Test
	public void Drag() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		alldocuments.Createdocument();
		alldocuments.Validdocument();
		uploaddocuments.Fileupload();
		addrecipients.Recipients();
		dragdrop.EssentialFields();
		dragdrop.Contentfields();
		dragdrop.Draw();
		dragdrop.image();
		dragdrop.send();

	}

	@Test
	public void Review() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		alldocuments.Createdocument();
		alldocuments.Validdocument();
		uploaddocuments.Fileupload();
		addrecipients.Recipients();
		addrecipients.Recipients1();
		addrecipients.MoreFields();
		addrecipients.Verifrecipient();
		dragdrop.EssentialFields();
		dragdrop.Contentfields();
		dragdrop.Draw();
		dragdrop.image();
		dragdrop.send();
		reviewaNdSend.submit();

	}
}
