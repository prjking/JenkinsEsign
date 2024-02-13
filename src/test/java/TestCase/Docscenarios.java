package TestCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.Addrecipients;
import Pages.Alldocuments;
import Pages.Dashboard;
import Pages.DocumentsScenarios;
import Pages.Dragdrop;
import Pages.Login;
import Pages.RecevierSide;
import Pages.ReviewaNdSend;
import Pages.Signup;
import Pages.Templatespage;
import Pages.Uploaddocuments;
import TestBase.testCaseBase;

@Listeners(Testlistner.class)

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

	}

	@Test(priority = 1)
	public void ValidDocScenarios() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
		System.out.println(
				"Blank Doc Single Signer completed through login account and View Account sender autofill enabled and Without enforce signature order Done Successfully");

	}

	@Test(priority = 2, enabled = false)
	public void ValidBlankdocView() throws Exception {
		recevierSide.CheckRecevierSide();
	}

	@Test(priority = 3)
	public void ValidBlankwithoutsenderautofill() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
		System.out.println(
				"Blankwithout Senderautofil through login account and View Account sender autofill enabled and Without enforce signature order Done Sucessfully");

	}

	@Test(priority = 4)
	public void ValidWithoutEnforceSignatureThroughLoginAccount() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.RecipientsCC();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
		System.out.println("Blank without EnforceSignatureThroughLoginAccount Done Sucessfully");

	}

	@Test(priority = 5, enabled = false)
	public void ValidDocscenarioOnedrive() throws Exception {

		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Recipients();
		documentsScenarios.RecipientsCC();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
		System.out.println("Onedrive without EnforceSignatureThroughLoginAccount Done Sucessfully");

	}

	@Test(priority = 6, enabled = false)
	public void ValidDocscenariosGdrive() throws Exception {

		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenariosGdrive();
		documentsScenarios.Recipients();
		documentsScenarios.RecipientsCC();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 7)
	public void ValidWithEnforceSignatureOrderWithSenderAutofill() throws Exception {

		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.RecipientsCC();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.EssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
		System.out.println("Blank with EnforceSignatureThroughLoginAccount Done Sucessfully");

	}

	@Test(priority = 8)
	public void ValidRearrangingOrderCCndSigner() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
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
		System.out.println("Rearrange Signer and CC with EnforceSignatureThroughLoginAccount Done Sucessfully");

	}

	@Test(priority = 9)
	public void ValidBlankDocMultipleSigners() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.MultipleSigners();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.MultipleSignersEssentialFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
		System.out.println("BlankDocMultipleSigners with EnforceSignatureThroughLoginAccount Done Sucessfully");

	}

	@Test(priority = 10, enabled = false)
	public void ValidOneDriveDocMultipleSigners() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Recipients();
		documentsScenarios.MultipleSigners();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.MultipleSignersEssentialFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
		System.out.println("OneDriveDocMultipleSigners with EnforceSignatureThroughLoginAccount Done Sucessfully");

	}

	@Test(priority = 11)
	public void ValidRearrangingOrderFirstOtherSignersndThenSender() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
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
		System.out.println(
				"RearrangingOrderFirstOther Signers nd ThenSender with EnforceSignature ThroughLogin Account Done Sucessfully");

	}

	@Test(priority = 12, enabled = false)
	public void ValidRearrangingOrderFirstOtherSignersndThenSenderOnedrive() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
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
		System.out.println(
				"One Drive RearrangingOrderFirstOther Signers nd ThenSender with EnforceSignature ThroughLogin Account Done Sucessfully");

	}

	@Test(priority = 13)
	public void ValidBlankdocSignerndApprover() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Approver();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
		System.out.println("Blankdoc SignerndApprover with EnforceSignature ThroughLogin Account Done Sucessfully");

	}

	@Test(priority = 14, enabled = false)
	public void ValiddocSignerndApproverOnedrive() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Recipients();
		documentsScenarios.Approver();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
		System.out.println("Onedrive SignerndApprover with EnforceSignature ThroughLogin Account Done Sucessfully");

	}

	@Test(priority = 15, enabled = false)
	public void ValidRearrangingOrderFirstApproverthenSigner() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.Recipients();
		documentsScenarios.Approver();
		documentsScenarios.Rearrange();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
		System.out.println(
				"Rearranging Order First Approver then Signer with EnforceSignature ThroughLogin Account Done Sucessfully");

	}
}
