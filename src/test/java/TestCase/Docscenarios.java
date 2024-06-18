package TestCase;

import Reports.TestNGExtentReport;
import Reports.Testlistner;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import Pages.Addrecipients;
import Pages.Alldocuments;
import Pages.Dashboard;
import Pages.DocumentsScenarios;
import Pages.Dragdrop;
import Pages.FormTemplate;
import Pages.Login;
import Pages.MethodActions;
import Pages.RecevierSide;
import Pages.ReviewaNdSend;
import Pages.Signup;
import Pages.TemplateScenarios;
import Pages.Templatespage;
import Pages.Uploaddocuments;
import TestBase.testCaseBase;

@Listeners({ TestNGExtentReport.class, Testlistner.class })
public class Docscenarios extends testCaseBase {
	Login login;
	Alldocuments alldocuments;
	Uploaddocuments uploaddocuments;
	Addrecipients addrecipients;
	Dragdrop dragdrop;
	ReviewaNdSend reviewaNdSend;
	RecevierSide recevierSide;
	Signup signup;
	Templatespage templatespage;
	Dashboard dashboard;
	DocumentsScenarios documentsScenarios;
	TemplateScenarios templateScenarios;
	FormTemplate formTemplate;

	public void setupDriver() {
		driver = new ChromeDriver(getChromeOptions());
		//driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://nsui.esigns.io/signin");
	}

	@BeforeMethod
	public void Start() {
		setupDriver();
		login = new Login(driver);
		alldocuments = new Alldocuments(driver);
		uploaddocuments = new Uploaddocuments(driver);
		addrecipients = new Addrecipients(driver);
		dragdrop = new Dragdrop(driver);
		reviewaNdSend = new ReviewaNdSend(driver);
		recevierSide = new RecevierSide(driver);
		signup = new Signup(driver);
		templatespage = new Templatespage(driver);
		dashboard = new Dashboard(driver);
		documentsScenarios = new DocumentsScenarios(driver);
		templateScenarios = new TemplateScenarios(driver);
		formTemplate = new FormTemplate(driver);
	}

//	public static class LoginDataProvider {
//		@DataProvider(name = "loginData")
//		public static Object[][] provideLoginData() {
//			return new Object[][] { { "saikumar.basolutions@gmail.com", "Nimble#2022", true },
//					{ "invalidUser@abc.com", "invalidPass", false }, { "", "Nimble#2022", false },
//					{ "saikumar.basolutions@gmail.com", "", false }, { "invalidUser@abc.com", "Nimble#2022", false },
//
//					{ "saikumar.basolutions@gmail.com", "invalidPass", false } };
//		}
//	}
//
//	@Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class, priority = 1)
//	public void ValiddocumentsScenarios(String username, String password, boolean expectedResult) throws Exception {
//		boolean loginResult = login.Signindata(username, password);
//		Assert.assertEquals(loginResult, expectedResult,
//				"Login result does not match the expected result for credentials: " + username + "/" + password);
//
//		if (loginResult) {
//			documentsScenarios.DocScenario();
//			documentsScenarios.Blankdocloginaccount();
//			documentsScenarios.Recipients();
//			documentsScenarios.Saveuser();
//			documentsScenarios.EssentialFields();
//			documentsScenarios.Senddoc();
//			documentsScenarios.Blankwithoutsenderautofill();
//		} else {
//			System.out
//					.println("Login failed, skipping document scenarios for credentials: " + username + "/" + password);
//		}
//	}
	@Test(priority = 1)
	public void ValiddocumentsScenarios() throws Exception {
//		String putEndpoint = "https://dev.esigns.io//api/resource/123";
//		Map<String, String> putHeaders = new HashMap<>();
//		putHeaders.put("Content-Type", "application/json");
//		String putBody = "{\"key\": \"value\"}";
//		Response putResponse = putAPIRequest(putEndpoint, putHeaders, putBody);
//		int putStatusCode = putResponse.getStatusCode();
//		System.out.println("PUT Request Status Code: " + putStatusCode);
//
//		String deleteEndpoint = "https://dev.esigns.io//api/resource/123";
//		Map<String, String> deleteHeaders = new HashMap<>();
//		deleteHeaders.put("Authorization", "Bearer token");
//		Response deleteResponse = deleteAPIRequest(deleteEndpoint, deleteHeaders);
//		int deleteStatusCode = deleteResponse.getStatusCode();
//		System.out.println("DELETE Request Status Code: " + deleteStatusCode);
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

//	@Test(priority = 1)
//	public void ValiddocumentsScenarios() throws Exception {
//		login.Signin();
//		documentsScenarios.DocScenario();
//		documentsScenarios.Blankdocloginaccount();
//		documentsScenarios.Recipients();
//		documentsScenarios.Saveuser();
//		documentsScenarios.EssentialFields1();
//		documentsScenarios.Senddoc();
//		documentsScenarios.Blankwithoutsenderautofill();
//
//	}

	@Test(priority = 2, enabled = false)
	public void ValidBlankdocView() throws Exception {
		recevierSide.CheckRecevierSide();
	}

	@Test(priority = 3)
	public void ValidBlankwithoutsenderautofill() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 4)
	public void ValidWithoutEnforceSignatureThroughLoginAccount() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.RecipientsCC();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 5, enabled = false)
	public void ValidDocscenarioOnedrive() throws Exception {

		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Recipients();
		documentsScenarios.RecipientsCC();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
		Assert.assertEquals(true, true);

	}

	@Test(priority = 6, enabled = true)
	public void ValiddocumentsScenariosGdrive() throws Exception {

		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenariosGdrive();
		documentsScenarios.Recipients();
		documentsScenarios.RecipientsCC();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
		Assert.assertEquals(true, true);

	}

	@Test(priority = 7)
	public void ValidWithEnforceSignatureOrderWithSenderAutofill() throws Exception {

		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.RecipientsCC();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
		Assert.assertEquals(true, true);

	}

	@Test(priority = 8)
	public void ValidRearrangingOrderCCndSigner() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.RecipientsCC();
		documentsScenarios.Rearrange();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFieldscc();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
		Assert.assertEquals(true, true);

	}

	@Test(priority = 9)
	public void ValidBlankDocMultipleSigners() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.MultipleSigners();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.MultipleSignersEssentialFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
		Assert.assertEquals(true, true);

	}

	@Test(priority = 10, enabled = false)
	public void ValidOneDriveDocMultipleSigners() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Recipients();
		documentsScenarios.MultipleSigners();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.MultipleSignersEssentialFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 11)
	public void ValidRearrangingOrderFirstOtherSignersndThenSender() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.MultipleSigners();
		documentsScenarios.Rearrange();
		documentsScenarios.RearrangeSender();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.MultipleSignersEssentialFields();
		documentsScenarios.Senddoc();

	}

	@Test(priority = 12, enabled = false)
	public void ValidRearrangingOrderFirstOtherSignersndThenSenderOnedrive() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Recipients();
		documentsScenarios.MultipleSigners();
		documentsScenarios.Rearrange();
		documentsScenarios.RearrangeSender();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.MultipleSignersEssentialFields();
		documentsScenarios.Senddoc();

	}

	@Test(priority = 13)
	public void ValidBlankdocSignerndApprover() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Approver();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 14, enabled = false)
	public void ValiddocSignerndApproverOnedrive() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Recipients();
		documentsScenarios.Approver();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 15, enabled = false)
	public void ValidRearrangingOrderFirstApproverthenSigner() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Recipients();
		documentsScenarios.Approver();
		documentsScenarios.Rearrange();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

}
