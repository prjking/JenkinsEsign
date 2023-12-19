package TestCase;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Alldocuments;
import Pages.Login;
import Pages.Uploaddocuments;
import TestBase.testCaseBase;

public class LoginPageTest extends testCaseBase {
	Login login;
	Alldocuments alldocuments;
	Uploaddocuments uploaddocuments;
	
	@BeforeMethod
	public void intilize() {
		setup();
		login = new Login(driver);
		alldocuments = new Alldocuments(driver);
		uploaddocuments =new Uploaddocuments(driver);
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
	uploaddocuments.Fileupload();
	uploaddocuments.VerifyUpload();
}
}
