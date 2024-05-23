package TestCase;

import Reports.TestNGExtentReport;
import Reports.Testlistner;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

	@BeforeMethod
	public void Start() {
		setup();
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
		formTemplate =new FormTemplate(driver);

	}

	@Test(priority = 1)
	public void ValiddocumentsScenarios() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
		Assert.assertEquals(true, true);

	}

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
		Assert.assertEquals(true, true);

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
		Assert.assertEquals(true, true);

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
