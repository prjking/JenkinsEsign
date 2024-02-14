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
	public void ValiddocumentsScenarios() throws Exception {
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
	public void ValiddocumentsScenariosGdrive() throws Exception {

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

//Meghana-Testcases
	@Test(priority = 16)
	public void ValidBlankDocSignerApproverAndCC() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Approver1();
		documentsScenarios.RecipientsCC3();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.DragAndDropAtThree();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	// Blank Doc- (Signer, Multiple Approvers & CC)With/Without enforce signature
	// order & Without sender autofill-
	@Test(priority = 17)
	public void ValidBlankDocSignerMulApproverAndCC() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.multipleApprover();
		documentsScenarios.CCAtFour();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DragAndDropAtThreeFour();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	// Blank Doc- (Signer, Approvers& Multiple CC)With/Without enforce signature
	// order & Without sender autofill-
	@Test(priority = 18)
	public void ValidBlankDocSignerApproverAndMultipleCC() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Approver1();
		documentsScenarios.multipleCCThreeFour();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.DragAndDropAtThree();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// Blank Doc- (Signer, Multiple Approvers & Multiple CC)With/Without enforce
	// signature order & Without sender autofill-
	@Test(priority = 19)
	public void validBlankDocSignerMulApproverAndMulCC() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.multipleApprover();
		documentsScenarios.multipleCCFourFive();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.DragAndDropAtThreeFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// 10.Blankdoc-Rearranging order first Approver and then Signer &&
	// CC-Without enforce signature order & Without sender autofill-
	@Test(priority = 20)
	public void validOneDriveRearrangeorderApproverSignerAndCC() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Approver1();
		documentsScenarios.RecipientsCC3();
		documentsScenarios.Rearrange();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DragAndDropAtThree();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// 11.Rearranging order first CC and then Signer && Approver Without enforce
	// signature order & Without sender autofill-
	@Test(priority = 21)
	public void validOneDriveRearrangeorderCCSignerApprover() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Approver1();
		documentsScenarios.RecipientsCC3();
		documentsScenarios.Rearrange();
		documentsScenarios.RearrangeThreeOne();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DragAndDropAtThreeFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// 12.Rearranging order first Approver and then CC && Signer-
	@Test(priority = 22)
	public void validRearrangeorderApproverCCSigner() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Approver1();
		documentsScenarios.RecipientsCC3();
		documentsScenarios.Rearrange();
		documentsScenarios.RearrangeAtThreeTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.dragaAndDropAtFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// 13. Blank Doc-Rearranging order first Signer and then CC && Approver-Without
	// enforce signature order & Without sender autofill-
	@Test(priority = 23)
	public void validBlankDocRearrangeorderSignerCCApprover() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Approver1();
		documentsScenarios.RecipientsCC3();
		documentsScenarios.RearrangeAtThreeTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.dragaAndDropAtFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// 14.Blank Doc-Rearranging order first CC and then Approver && Signer-Without
	// enforce signature order & Without sender autofill-
	@Test(priority = 24)
	public void validBlankDocRearrangeorderCCApproversigner() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Approver1();
		documentsScenarios.RecipientsCC3();
		documentsScenarios.RearrangeThreeOne();
		documentsScenarios.RearrangeAtThreeTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DragAndDropAtThreeFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// 15.Blank Doc-Multiple signers , approver&& CC Without enforce signature order
	// & Without sender autofill-d
	@Test(priority = 25)
	public void validBlankDocMulsignerApproverCC() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.multipleSigner();
		documentsScenarios.ApproverThree();
		documentsScenarios.CCAtFour();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.DragAndDropAtThreeFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	// 16.Rearranging order first Other Signers and then Sender Signer &&
	// Approver-Without enforce signature order & Without sender autofill-d
	@Test(priority = 26)
	public void validBlankDocOtherSignerSenderSignerApprover() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.multipleSigner();
		documentsScenarios.ApproverThree();
		documentsScenarios.RearrangeZeroTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.DragAndDropAtThree();
		documentsScenarios.dragaAndDropAtFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// 17.Rearranging order first Approver and then Sender Signer && Other Signers-d
	@Test(priority = 27)
	public void validBlankDocApproverSenderSignerOtherSigner() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.multipleSigner();
		documentsScenarios.ApproverThree();
		documentsScenarios.RearrangeThreeOne();
		documentsScenarios.scrollUp();
		documentsScenarios.RearrangeSender();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.DragAndDropAtThree();
		documentsScenarios.dragaAndDropAtFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// 18.Rearranging order first Other Signers and then Approver && Sender Signer-d
	@Test(priority = 28)
	public void validBlankDocOtherSignerApproverSenderSigner() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.multipleSigner();
		documentsScenarios.ApproverThree();
		documentsScenarios.RearrangeZeroTwo();
		documentsScenarios.scrollDown();
		documentsScenarios.RearrangeAtThreeTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.DragAndDropAtThree();
		documentsScenarios.dragaAndDropAtFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// 19.Rearranging order first Sender Signer and then Approver && Other Signers-d
	@Test(priority = 29)
	public void validBlankDocSenderSignerApproverOtherSigner() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.multipleSigner();
		documentsScenarios.ApproverThree();
		documentsScenarios.RearrangeThreeOne();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.DragAndDropAtThree();
		documentsScenarios.dragaAndDropAtFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

//Ramya_Testcases
	@Test(priority = 30)
	public void VerifyAppSigSenderorderWOEWOA() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddApprover();
		documentsScenarios.AddRearrangeAPPSignerSenderThreeOne();
		documentsScenarios.AddRearrangeSender();
		documentsScenarios.AddRearrangeZeroFour();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddEssentialFields();
		documentsScenarios.AddEssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 31)
	public void VerifySendersigCCorderWOEWOA() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();

		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddRecipientsCC();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddEssentialFieldscc();
		documentsScenarios.AddEssentialFieldsccSender();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	@Test(priority = 32)
	public void VerifySigSenderCCorderWOEWOA() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();

		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddRecipientsCC();
		documentsScenarios.AddRearrangeSignerSenderCCThreeOne();
		documentsScenarios.AddRearrangeSigners();
		documentsScenarios.AddRearrangeOneTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddEssentialFieldscc();
		documentsScenarios.AddEssentialFieldsccSender();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 33)
	public void VerifyCCSenderSingerWOEWOA() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();

		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddRecipientsCC();
		documentsScenarios.AddRearrangeCCSenderSignerThreeOne();
		documentsScenarios.AddRearrangeSendercc();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddEssentialFields();
		documentsScenarios.AddEssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 34)
	public void VerifySingerCCSenderWOEWOA() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();

		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddRecipientsCC();
		documentsScenarios.AddRearrangeSignersCCSenderThreeOne();
		documentsScenarios.AddRearrangeCC();
		documentsScenarios.AddRearrangeOnetoThree();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddRearrangeSenderFields1();
		documentsScenarios.AddEssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 35)
	public void VerifySenderCCSignerWOEWOA() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddRecipientsCC();
		documentsScenarios.AddRearrangeSenderCCSignersThreeOne();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddSenderFields();
		documentsScenarios.AddEssentialFieldsccSender();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	@Test(priority = 36)
	public void VerifyCCSignerSenderWOEWOA() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddRecipientsCC();
		documentsScenarios.AddRearrangeCCSignerSENDERThreeOne();
		documentsScenarios.AddRearrangeccsignersender();
		documentsScenarios.AddRearrangeZeroFour1();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddSenderFields2();
		documentsScenarios.AddEssentialFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 37)
	public void VerifySenderMultipleApprovers() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();

		documentsScenarios.AddMultipleApprovers();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddSenderFields();
		documentsScenarios.AddMultipleAPPFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	@Test(priority = 38)
	public void VerifyMultpleApproverSender() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.AddMultipleApprovers();
		documentsScenarios.AddRearrangeMulApproverSENDERThreeOne();
		documentsScenarios.AddRearrangeMultipleApproverssender();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddRearrangeMultipleAPPFields();
		documentsScenarios.AddRearrangeSenderFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	@Test(priority = 39)
	public void VerifySenderMultipleCC() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.AddMultipleCC();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddSenderFields();
		documentsScenarios.AddFinishdocument();
	}

	@Test(priority = 40)
	public void VerifyMultpleCCSender() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.AddMultipleCC();
		documentsScenarios.AddRearrangeMulApproverSENDERThreeOne();
		documentsScenarios.AddRearrangeMultipleApproverssender();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddRearrangeSenderFields();
		documentsScenarios.AddFinishdocument();
	}
}
