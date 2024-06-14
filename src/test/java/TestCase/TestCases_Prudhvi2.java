package TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.Documents;
import Pages.DocumentsScenarios2;
import Pages.Entities;
import Pages.Login;
import Pages.Recieverside2;
import Reports.TestNGExtentReport;
import Reports.Testlistner;
import TestBase.testCaseBase;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners({ TestNGExtentReport.class, Testlistner.class })
public class TestCases_Prudhvi2 extends testCaseBase {
	Login login;
	DocumentsScenarios2 documentsScenarios2;
	Recieverside2 recieverside2;

	@BeforeMethod
	public void initialize() {
		setup();
		login = new Login(driver);
		documentsScenarios2 = new DocumentsScenarios2(driver);
		recieverside2 = new Recieverside2(driver);

	}

	@Test()
	public void VerifyLoginFunctionalityWithValidCredantials() throws Exception {
//	System.out.println("Testing");
		login.RamyaNsui();
		login.VerifyLoginSucess();
//	Assert.assertEquals(true, false);

	}

// rearrange to approver other signers and sender without enforce and without autofill
	@Test(priority = 30)
	public void VerifyAppSigSenderorderWOEWOA() throws Exception {
		String a = "VerifyAppSigSenderorderWOEWOA";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.RecipientSigner(2, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios2.RecipientSigner(3, "Receiver", "ramyasibbala200@outlook.com", "APPROVER");
		documentsScenarios2.Rearranges(3, 1);
		documentsScenarios2.Rearranges(0, 1);
		documentsScenarios2.Rearranges(1, 3);
		documentsScenarios2.Signorder();
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 60, 10, 90);
		documentsScenarios2.DradAndDropSigAndFullName(3, 10, -20, 10, 10);
		documentsScenarios2.DradAndDropSigAndFullName(4, 10, -100, 10, -70);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();
		documentsScenarios2.Outlooklogin("jeevithapatnana200@outlook.com", "Meghana@123");
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Jeevitha");
		recieverside2.FinishDocumentRecieverside();
		documentsScenarios2.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recieverside2.clickEmail(a);
		recieverside2.reviewandSignApprover();
		recieverside2.reviewandSign("Ramya");
		recieverside2.Approvedocument();
//	System.out.println("Testing");
//	Assert.assertEquals(false, true);
	}

//rearrange to sender other signers and cc without enforce and without autofill
	@Test(priority = 31)
	public void VerifySendersigCCorderWOEWOA() throws Exception {
		String a = "VerifySendersigCCorderWOEWOA";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.RecipientSigner(2, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios2.RecipientSigner(3, "Receiver", "ramyasibbala200@outlook.com", "CC");
		documentsScenarios2.Signorder();
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 60, 10, 90);
		documentsScenarios2.DradAndDropSigAndFullName(3, 10, -20, 10, 10);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();
		documentsScenarios2.Outlooklogin("jeevithapatnana200@outlook.com", "Meghana@123");
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Jeevitha");
		recieverside2.FinishDocumentRecieverside();
		documentsScenarios2.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recieverside2.documentcompleted(a);
	}

//rearrange to other signers and sender cc without enforce and without autofill
	@Test(priority = 32)
	public void VerifySigSenderCCorderWOEWOA() throws Exception {
		String a = "VerifySigSenderCCorderWOEWOA";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.RecipientSigner(2, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios2.RecipientSigner(3, "Receiver", "ramyasibbala200@outlook.com", "CC");
		documentsScenarios2.Rearranges(2, 1);
		documentsScenarios2.Rearranges(0, 1);
		documentsScenarios2.Rearranges(1, 2);
		documentsScenarios2.Signorder();
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 60, 10, 90);
		documentsScenarios2.DradAndDropSigAndFullName(3, 10, -20, 10, 10);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();
		documentsScenarios2.Outlooklogin("jeevithapatnana200@outlook.com", "Meghana@123");
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Jeevitha");
		recieverside2.FinishDocumentRecieverside();
		;
		documentsScenarios2.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recieverside2.documentcompleted(a);

	}

//rearrange to cc and sender  other signers without enforce and without autofill
	@Test(priority = 33)
	public void VerifyCCSenderSingerWOEWOA() throws Exception {
		String a = "VerifyCCSenderSingerWOEWOA";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.RecipientSigner(2, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios2.RecipientSigner(3, "Receiver", "ramyasibbala200@outlook.com", "CC");
		documentsScenarios2.Rearranges(3, 1);
		documentsScenarios2.Rearranges(0, 1);
		documentsScenarios2.Signorder();
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios2.DradAndDropSigAndFullName(4, 10, -20, 10, 10);
		recieverside2.SubDocScenarios(a);
		;
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();
		documentsScenarios2.Outlooklogin("jeevithapatnana200@outlook.com", "Meghana@123");
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Meghana");
		recieverside2.FinishDocumentRecieverside();
		documentsScenarios2.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recieverside2.documentcompleted(a);

	}

//rearrange to signer cc and sender without enforce and without autofill
	@Test(priority = 34)
	public void VerifySingerCCSenderWOEWOA() throws Exception {
		String a = "VerifySingerCCSenderWOEWOA";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.RecipientSigner(2, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios2.RecipientSigner(3, "Receiver", "ramyasibbala200@outlook.com", "CC");
		documentsScenarios2.Rearranges(2, 1);
		documentsScenarios2.Rearranges(0, 1);
		documentsScenarios2.Rearranges(1, 3);
		documentsScenarios2.Signorder();
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 60, 10, 90);
		documentsScenarios2.DradAndDropSigAndFullName(4, 10, -20, 10, 10);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();
		documentsScenarios2.Outlooklogin("jeevithapatnana200@outlook.com", "Meghana@123");
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Jeevitha");
		recieverside2.FinishDocumentRecieverside();
		documentsScenarios2.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recieverside2.documentcompleted(a);

	}

//rearrange to sender cc and signers without enforce and without autofill
	@Test(priority = 35)
	public void VerifySenderCCSignerWOEWOA() throws Exception {
		String a = "VerifySenderCCSignerWOEWOA";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.RecipientSigner(2, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios2.RecipientSigner(3, "Receiver", "ramyasibbala200@outlook.com", "CC");
		documentsScenarios2.Rearranges(3, 1);
		documentsScenarios2.Signorder();
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios2.DradAndDropSigAndFullName(4, 10, -20, 10, 10);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();
		documentsScenarios2.Outlooklogin("jeevithapatnana200@outlook.com", "Meghana@123");
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Jeevitha");
		recieverside2.FinishDocumentRecieverside();
		documentsScenarios2.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recieverside2.documentcompleted(a);
	}

//rearrange to cc and other signers sender without enforce and without autofill
	@Test(priority = 36)
	public void VerifyCCSignerSenderWOEWOA() throws Exception {
		String a = "VerifyCCSignerSenderWOEWOA";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.RecipientSigner(2, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios2.RecipientSigner(3, "Receiver", "ramyasibbala200@outlook.com", "CC");
		documentsScenarios2.Rearranges(3, 1);
		documentsScenarios2.Rearranges(0, 1);
		documentsScenarios2.Rearranges(1, 3);
		documentsScenarios2.Signorder();
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios2.DradAndDropSigAndFullName(4, 10, -20, 10, 10);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();
		documentsScenarios2.Outlooklogin("jeevithapatnana200@outlook.com", "Meghana@123");
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Jeevitha");
		recieverside2.FinishDocumentRecieverside();
		documentsScenarios2.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recieverside2.documentcompleted(a);

	}

//rearrange to sender multiple approvers without enforce and without autofill
	@Test(priority = 37)
	public void VerifySenderMultipleApprovers() throws Exception {
		String a = "VerifySenderMultipleApprovers";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "APPROVER");
		documentsScenarios2.RecipientSigner(2, "Receiver", "ramyasibbala200@outlook.com", "APPROVER");
		documentsScenarios2.Signorder();
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 60, 10, 90);
		documentsScenarios2.DradAndDropSigAndFullName(3, 10, -20, 10, 10);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.Approvedocument();
		documentsScenarios2.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Ramya");
		recieverside2.Approvedocument();

	}

//rearrange to multiple approvers sender without enforce and without autofill
	@Test(priority = 38)
	public void VerifyMultpleApproverSender() throws Exception {
		String a = "VerifyMultpleApproverSender";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "APPROVER");
		documentsScenarios2.RecipientSigner(2, "Receiver", "ramyasibbala200@outlook.com", "APPROVER");
		documentsScenarios2.Rearranges(2, 0);
		documentsScenarios2.Rearranges(2, 1);
		documentsScenarios2.Signorder();
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 60, 10, 90);
		documentsScenarios2.DradAndDropSigAndFullName(3, 10, -20, 10, 10);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewandSignApprover();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.Approvedocument();
		documentsScenarios2.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recieverside2.clickEmail(a);
		recieverside2.reviewandSignApprover();
		recieverside2.reviewandSign("Ramya");
		recieverside2.Approvedocument();

	}

//rearrange to sender multiple cc without enforce and without autofill
	@Test(priority = 39)
	public void VerifySenderMultipleCC() throws Exception {
		String a = "VerifySenderMultipleCC";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios2.RecipientSigner(2, "Receiver", "ramyasibbala200@outlook.com", "CC");
		documentsScenarios2.Signorder();
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.Finishdocument();
		recieverside2.prudhvioutlooklogin();
		recieverside2.documentcompleted(a);
		documentsScenarios2.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recieverside2.documentcompleted(a);

	}

//rearrange to multiple cc and sender without enforce and without autofill
	@Test(priority = 40)
	public void VerifyMultpleCCSender() throws Exception {
		String a = "VerifyMultipleCCSender";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios2.RecipientSigner(2, "Receiver", "ramyasibbala200@outlook.com", "CC");
		documentsScenarios2.Rearranges(2, 0);
		documentsScenarios2.Rearranges(2, 1);
		documentsScenarios2.Signorder();
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.Finishdocument();
		recieverside2.prudhvioutlooklogin();
		recieverside2.documentcompleted(a);
		documentsScenarios2.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recieverside2.documentcompleted(a);
	}

//send document with uploading blank doc for single sender (complete through login account)
	@Test(priority = 41)
	public void VerifyDocForSingleSender() throws Exception {
		String a = "VerifyDocForSingleSender";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
//	recieverside2.Meghanaesignslogin();
		documentsScenarios2.Finishdocument();

	}

//Verify status of draftdocument
	@Test(priority = 42)
	public void VerifyDaftsentdocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.DraftStatus();
		documentsScenarios2.VerifyDraft();
		documentsScenarios2.DraftSentDocument();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 60, 10, 90);
		documentsScenarios2.Senddoc();
		documentsScenarios2.ValidDraftSendDocument();
	}

//Performing action for save as template in draft documents
	@Test(priority = 43)
	public void VerifyDraftSaveAsTemplate() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.DraftStatus();
		documentsScenarios2.VerifyDraft();
		
		documentsScenarios2.DraftSaveAsTemplate();
		documentsScenarios2.ValidDraftSaveasTemplate();
	}

//Performing action for rename document in draft documents
	@Test(priority = 44)
	public void VerifyDraftrenamedocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.DraftStatus();
		documentsScenarios2.VerifyDraft();
		
		documentsScenarios2.DraftrenameDocument();
		documentsScenarios2.ValidDraftRenameDocument();
	}

//Performing action for document Settings in draft documents
	@Test(priority = 45)
	public void VerifyDraftDocumentSettings() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.DraftStatus();
		documentsScenarios2.VerifyDraft();
		documentsScenarios2.Draftdocumentsetting();
		documentsScenarios2.ValidDraftDocumentSettings();
	}

//Performing action for delete document in draft documents
	@Test(priority = 46)
	public void VerifyDraftDeleteDocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.DraftStatus();
		documentsScenarios2.VerifyDraft();
		documentsScenarios2.DraftDeletedocument();
		documentsScenarios2.ValidDraftDeleteDocument();
	}

////Performing action for save as templat in draft documents
//	@Test(priority = 47)
//	public void VerifyDraftDownloadOriginal() throws Exception {
//		login.RamyaNsui();
//		login.VerifyLoginSucess();
//		documentsScenarios2.DraftStatus();
//		documentsScenarios2.VerifyDraft();
//		documentsScenarios2.DraftDownloadOriginal();
////documents.ValidDraftDownloadOriginal();
//	}

//Performing action for correct document in sent documents
	@Test(priority = 48)
	public void VerifySentCorrectDocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.SentStatus();
		documentsScenarios2.ValidSent();
		documentsScenarios2.SentcorrectDocument();
//documents.ValidSentcorrectDocument();
		documentsScenarios2.Senddoc();
	}

//Performing action for Resend document in sent documents
	@Test(priority = 49)
	public void VerifySentResenddocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.SentStatus();
		documentsScenarios2.ValidSent();
		documentsScenarios2.SentResenddocument();
		documentsScenarios2.ValidSentResenddocument();
	}

//Performing action for save as template in sent documents
	@Test(priority = 50)
	public void VerifySentsavetoTemplate() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.SentStatus();
		documentsScenarios2.ValidSent();
		documentsScenarios2.SentsavetoTemplate();
		documentsScenarios2.ValidSentsavetoTemplate();
	}

//Performing action for void document in sent documents
	@Test(priority = 51)
	public void VerifySentVoiddocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.SentStatus();
		documentsScenarios2.ValidSent();
		documentsScenarios2.SentVoiddocument();
		documentsScenarios2.ValidSentVoiddocument();
	}

//Performing action for rename document in sent documents
	@Test(priority = 52)
	public void VerifySentRenamedocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.SentStatus();
		documentsScenarios2.ValidSent();
		documentsScenarios2.SentRenamedocument();
		documentsScenarios2.ValidSentRenamedocument();
	}

//Performing action for document settings in sent documents
	@Test(priority = 53)
	public void VerifySentdocumentsettings() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.SentStatus();
		documentsScenarios2.ValidSent();
		documentsScenarios2.Sentdocumentsettings();
		documentsScenarios2.ValidSentdocumentsettings();
	}

//Performing action for delete document in sent documents
	@Test(priority = 54)
	public void VerifySentDeletedocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.SentStatus();
		documentsScenarios2.ValidSent();
		documentsScenarios2.SentDeletedocument();
		documentsScenarios2.ValidSentDeletedocument();
	}

//Performing action for correct document in Approved documents
	@Test(priority = 55)
	public void VerifyApprovedCorrectdocumentDocuments() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.ApprovedStatus();
		documentsScenarios2.VerifySelectStatus();
		documentsScenarios2.ApprovedCorrectdocument();
		documentsScenarios2.ValidApprovedCorrectdocument();
	}

//Performing action for Resend document in Approved documents
	@Test(priority = 56)
	public void VerifyApprovedResendDocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.ApprovedStatus();
		documentsScenarios2.VerifySelectStatus();
		documentsScenarios2.ApprovedResenddocument();
		documentsScenarios2.ValidResendDocument();

	}

//Performing action for save as template in Approved documents
	@Test(priority = 57)
	public void VerifyApprovedSaveAsTemplate() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.ApprovedStatus();
		documentsScenarios2.VerifySelectStatus();
		documentsScenarios2.ApprovedSaveastemplate();
		documentsScenarios2.ValidSaveAsTemplate();
	}

//Performing action for void document in Approved documents
	@Test(priority = 58)
	public void VerifyApprovedVoidDocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.ApprovedStatus();
		documentsScenarios2.VerifySelectStatus();
		documentsScenarios2.ApprovedVoiddocument();
		documentsScenarios2.ValidVoidDocument();
	}

//Performing action for rename document in Approved documents
	@Test(priority = 59)
	public void VerifyApprovedRenameDocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.ApprovedStatus();
		documentsScenarios2.VerifySelectStatus();
		documentsScenarios2.ApprovedRenamedocument();
		documentsScenarios2.ValidRenameDocument();
	}

//Performing action for document settings in Approved documents
	@Test(priority = 60)
	public void VerifyApprovedDocumentSettings() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.ApprovedStatus();
		documentsScenarios2.VerifySelectStatus();
		documentsScenarios2.ApprovedDocumentsettings();
		documentsScenarios2.ValidDocumentSettings();
	}

//Performing action for delete document in Approved documents
	@Test(priority = 61)
	public void VerifyApprovedApprovedDeleteDocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.ApprovedStatus();
		documentsScenarios2.VerifySelectStatus();
		documentsScenarios2.ApprovedDeletedocument();
		documentsScenarios2.ValidDeleteDocument();
	}

//Performing action for declined document in decline documents
	@Test(priority = 62)
	public void VerifyDelineddocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.DeclinedStatus();
		documentsScenarios2.VerifyDeclined();
		documentsScenarios2.DeclinedSaveastemplate();
		documentsScenarios2.ValidDeclinedSaveastemplate();
	}

//Performing action for void document in decline documents
	@Test(priority = 63)
	public void VerifyDeclinedVoiddocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.DeclinedStatus();
		documentsScenarios2.VerifyDeclined();
		documentsScenarios2.DeclinedVoiddocument();
		documentsScenarios2.ValidDeclinedVoiddocument();
	}

//Performing action for rename document in decline documents
	@Test(priority = 64)
	public void VerifyDeclinedDeclinedRenamedocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.DeclinedStatus();
		documentsScenarios2.VerifyDeclined();
		documentsScenarios2.DeclinedRenamedocument();
		documentsScenarios2.ValidDeclinedRenamedocument();
	}

//Performing action for document settings in decline documents
	@Test(priority = 65)
	public void VerifyDeclinedDocumentSettings() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.DeclinedStatus();
		documentsScenarios2.VerifyDeclined();
		documentsScenarios2.DeclinedDocumentsettings();
		documentsScenarios2.ValidDeclinedDocumentSettings();
	}

//Performing action for delete document in decline documents
	@Test(priority = 66)
	public void VerifyDeclinedDeletedocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.DeclinedStatus();
		documentsScenarios2.VerifyDeclined();
		documentsScenarios2.DeclinedDeletedocument();
		documentsScenarios2.ValidDeclinedDeleteDocument();
	}

//Performing action for save as template in void documents
	@Test(priority = 67)
	public void VerifYVoidSaveastemplate() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.VoidStatus();
		documentsScenarios2.ValidVoid();
		documentsScenarios2.VoidSaveastemplate();
		documentsScenarios2.ValidVoidSaveastemplate();
	}

//Performing action for clone document in void documents
	@Test(priority = 68)
	public void VerifyVoidClonedocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.VoidStatus();
		documentsScenarios2.ValidVoid();
		documentsScenarios2.VoidClonedocument();
//	documents.ValidVoidClonedocument();
		documentsScenarios2.Senddoc();

	}

//Performing action for delete document in void documents
	@Test(priority = 69)
	public void VerifyVoidDeletedocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.VoidStatus();
		documentsScenarios2.ValidVoid();
		documentsScenarios2.VoidDeletedocument();
		documentsScenarios2.ValidVoidDeletedocument();
	}

//Performing action for rename document in Archieved documents
	@Test(priority = 70)
	public void VerifyArchivedRenamedocuments() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.ArchievdStatus();
		documentsScenarios2.VerifyArchieved();
		documentsScenarios2.ArchivedRenamedocuments();
		documentsScenarios2.ValidRenamedocument();
	}

//Performing action for undo document in Archieved documents
	@Test(priority = 71)
	public void VerifyArchivedUndodocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.ArchievdStatus();
		documentsScenarios2.VerifyArchieved();
		documentsScenarios2.ArchivedUndodocument();
		documentsScenarios2.ValidUndodocument();
	}

//Performing action for permanent delete document in Archieved documents
	@Test(priority = 72)
	public void VerifyArchivedPermanentdelete() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.ArchievdStatus();
		documentsScenarios2.VerifyArchieved();
		documentsScenarios2.ArchivedPermanentdelete();
		documentsScenarios2.ValidPermanentDelete();
	}

//Performing action for save as template in Completed documents
	@Test(priority = 73)
	public void VerifyCompletedSaveastemplate() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.CompletedStatus();
		documentsScenarios2.VerifyCompleted();
		documentsScenarios2.CompletedSaveastemplate();
		documentsScenarios2.ValidSaveastemplate();
	}

//Performing action for Share with users in Completed documents
	@Test(priority = 74)
	public void VerifyCompletedSharewithothers() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.CompletedStatus();
		documentsScenarios2.VerifyCompleted();
		documentsScenarios2.CompletedSharewithothers();
		documentsScenarios2.ValidCompletedSharewithothers();
	}

//Performing action for clone document in Completed documents
	@Test(priority = 75)
	public void VerifyCompletedClonedocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.CompletedStatus();
		documentsScenarios2.VerifyCompleted();
		documentsScenarios2.CompletedClonedocument();
		documentsScenarios2.Senddoc();
	}

//Performing action for Rename document in Completed documents
	@Test(priority = 76)
	public void VerifyCompletedRenamedocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.CompletedStatus();
		documentsScenarios2.VerifyCompleted();
		documentsScenarios2.CompletedRenamedocument();
		documentsScenarios2.ValidCompletedRenamedocument();

	}

//Performing action for download document in Completed documents
	@Test(priority = 77)
	public void VerifyCompletedDownloaddocuement() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.CompletedStatus();
		documentsScenarios2.VerifyCompleted();
		documentsScenarios2.CompletedDownloaddocuement();
//	documents.ValidCompletedDownloaddocuement();
	}

//Performing action for delete document in Completed documents
	@Test(priority = 78)
	public void VerifyCompletedDeletedocuement() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.CompletedStatus();
		documentsScenarios2.VerifyCompleted();
		documentsScenarios2.CompletedDeletedocuement();
		documentsScenarios2.ValidCompletedDeletedocument();
	}

//Performing action for sent to mail in Completed documents
	@Test(priority = 79)
	public void VerifyCompletedSenttomail() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.CompletedStatus();
		documentsScenarios2.VerifyCompleted();
		documentsScenarios2.CompletedSenttomail();
		documentsScenarios2.ValidCompletedSenttomail();
	}

//Performing action in waiting for me documents
	@Test(priority = 80)
	public void VerifyWaitformeWaitforme() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.WaitingformeStatus();
		documentsScenarios2.ValidWaitingforme();
		documentsScenarios2.WaitformeWaitforme();
		documentsScenarios2.ValidWaitingforme();
	}

//Performing action for correct document in waiting for others documents
	@Test(priority = 81)
	public void VerifyWaitingForOthersCorrectdocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.Waitingforotherstatus();
		documentsScenarios2.ValidWaitingforothers();
		documentsScenarios2.WaitingForOthersCorrectdocument();
		documentsScenarios2.Senddoc();
	}

//Performing action for resend document in waiting for others documents
	@Test(priority = 82)
	public void VerifyWaitingForOthersResenddocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.Waitingforotherstatus();
		documentsScenarios2.ValidWaitingforothers();
		documentsScenarios2.WaitingForOthersResenddocument();
		documentsScenarios2.ValidWaitingForOthersResenddocument();
	}

//Performing action for save as template in waiting for others documents
	@Test(priority = 83)
	public void VerifyWaitingForOthersSaveastemplate() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.Waitingforotherstatus();
		documentsScenarios2.ValidWaitingforothers();
		documentsScenarios2.WaitingForOthersSaveastemplate();
		documentsScenarios2.ValidWaitingForOthersSaveastemplate();
	}

//Performing action for void document in waiting for others documents
	@Test(priority = 84)
	public void VerifyWaitingForOthersVoiddocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.Waitingforotherstatus();
		documentsScenarios2.ValidWaitingforothers();
		documentsScenarios2.WaitingForOthersVoiddocument();
		documentsScenarios2.ValidWaitingForOthersVoiddocument();
	}

//Performing action for rename document in waiting for others documents
	@Test(priority = 85)
	public void VerifyWaitingForOthersRenamedocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.Waitingforotherstatus();
		documentsScenarios2.ValidWaitingforothers();
		documentsScenarios2.WaitingForOthersRenamedocument();
		documentsScenarios2.ValidWaitingForOthersRenamedocument();
	}

//Performing action for document settings in waiting for others documents
	@Test(priority = 86)
	public void VerifyWaitingForOthersDocumentsettings() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.Waitingforotherstatus();
		documentsScenarios2.ValidWaitingforothers();
		documentsScenarios2.WaitingForOthersDocumentsettings();
		documentsScenarios2.ValidWaitingForOthersDocumentsettings();
	}

//Performing action for delete document in waiting for others documents
	@Test(priority = 87)
	public void VerifyWaitingForOthersDeletedocument() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.Waitingforotherstatus();
		documentsScenarios2.ValidWaitingforothers();
		documentsScenarios2.WaitingForOthersDeletedocument();
		documentsScenarios2.ValidWaitingForOthersDeletedocument();
	}

//uploading different types of files (processing it as single document)
	@Test(priority = 88)
	public void VerifyProcessSingleDoc() throws Throwable {
		String file = System.getProperty("user.dir") + "/src/test/resources/ramya/blank.pdf";
		String file1 = System.getProperty("user.dir") + "/src/test/resources/ramya/blank1.pdf";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.PCOnedoc();
		documentsScenarios2.blankurl();
		documentsScenarios2.uploadFileWithSendKeys(file);
		documentsScenarios2.uploadFileWithSendKeys(file1);
		documentsScenarios2.Nextbt();
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.Selecttofillrec();
		documentsScenarios2.Selectautofill();
		documentsScenarios2.Senddoc();
	}

//uploading different types of files ( without processing it as single document)
	@Test(priority = 89)
	public void VerifyProcessWithOutSingledoc() throws Throwable {
		String file = System.getProperty("user.dir") + "/src/test/resources/ramya/blank.pdf";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.blankurl();
		documentsScenarios2.uploadFileWithSendKeys(file);
		documentsScenarios2.UploadMultipledocuments();
		documentsScenarios2.Nextbt();
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.Selecttofillrec();
		documentsScenarios2.Selectautofill();
		documentsScenarios2.Senddoc();
	}

	@Test(priority = 90)
	public void VerfySaveAsDraft() throws Exception {
		String a = "VerfySaveAsDraft";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "APPROVER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.SaveAsDraft();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Jeevitha");
	}

// Verify settings before sending document
	@Test(priority = 91)
	public void VerifySettings() throws Exception {
		String a = "VerifySettings";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "APPROVER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.Settings();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();

	}

//Verify change document before sending document
	@Test(priority = 92)
	public void VerifyChangeDoc() throws Exception {
		String a = "VerifyChangeDoc";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "APPROVER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.changedoc();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();
	}

//Verify lock fields before sending document
//Lock fields
	@Test(priority = 93)
	public void VerifyLockFields() throws Exception {
		String a = "VerifyLockFields";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "APPROVER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.Lockfields();

	}

//Verify adding extra pages before sending document
//Add pages
	@Test(priority = 94)
	public void VerifyAddPages() throws Exception {
		String a = "VerifyAddPages";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "APPROVER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.Addpages();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();

	}

//Verify deleting pages from document before sending document
//Delete pages
	@Test(priority = 95)
	public void VerifyDeletePages() throws Exception {
		String a = "VerifyDeletePages";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "APPROVER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		documentsScenarios2.Deletepages();
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();

	}

//Approve document for single approver
// Approve document
	@Test(priority = 96)
	public void VerifyApproverSenderapprove() throws Exception {
		String a = "VerifyApproverSenderapprove";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "APPROVER");
		documentsScenarios2.Signorder();
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewandSignApprover();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.Approvedocument();
	}

//decline document for sigle approver
//Decline document
	@Test(priority = 97)
	public void VerifyApproverSenderDecline() throws Exception {
		String a = "VerifyApproverSenderDecline";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "APPROVER");
		documentsScenarios2.Signorder();
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewandSignApprover();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.Declinedocument();
	}

// verify other options in document from reciever side -Finsih later
	@Test(priority = 98)
	public void Verifyotheroptionsfinishlater() throws Exception {
		String a = "Verifyotheroptionsfinishlater";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.OtherOptions();
		documentsScenarios2.otheroptionsfinishlater();
		documentsScenarios2.Afterfinishlater();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();

	}

//verify other options in document from reciever side - Print and sign
	@Test(priority = 99)
	public void Verifyotheroptionsprintandsign() throws Exception {
		String a = "Verifyotheroptionsprintandsign";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.OtherOptions();
		documentsScenarios2.otheroptionsprintandsign();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();
	}

//verify other options in document from reciever side -Download
	@Test(priority = 100)
	public void VerifyOtheroptionsdownload() throws Exception {
		String a = "VerifyOtheroptionsdownload";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.OtherOptions();
		documentsScenarios2.Otheroptionsdownload();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();
	}

//verify other options in document from reciever side -History
	@Test(priority = 101)
	public void Verifyotheroptionshistory() throws Exception {
		String a = "Verifyotheroptionshistory";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.OtherOptions();
		documentsScenarios2.otheroptionshistory();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();
	}

//verify other options in document from reciever side - Settings
	@Test(priority = 102)
	public void Verifyotheroptionssettings() throws Exception {
		String a = "Verifyotheroptionssettings";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.OtherOptions();
		documentsScenarios2.otheroptionssettings();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();
	}

//verify other options in document from reciever side - Correct document
	@Test(priority = 103)
	public void VerifyotheroptionsCorrectdoc() throws Exception {
		String a = "VerifyotheroptionsCorrectdoc";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.OtherOptions();
		documentsScenarios2.otheroptionsCorrectdoc();
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();
	}

//verify other options in document from reciever side -Save as template
	@Test(priority = 104)
	public void Verifyotheroptionssaveastem() throws Exception {
		String a = "Verifyotheroptionssaveastem";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.OtherOptions();
		documentsScenarios2.otheroptionssaveastem();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();
	}

//verify other options in document from reciever side - Void document
	@Test(priority = 105)
	public void Verifyotheroptionsvoiddoc() throws Exception {
		String a = "Verifyotheroptionsvoiddoc";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.OtherOptions();
		documentsScenarios2.otheroptionsvoiddoc();
		documentsScenarios2.Clonedocument();
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();

	}

//verify chats and logs from sender to reciever side
	@Test(priority = 106)
	public void Verifychatandlogs() throws Exception {
		String a = "Verifychatandlogs";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		documentsScenarios2.Chat();
		documentsScenarios2.Logs();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		documentsScenarios2.Viewcommenteddocument();
	}

//verify other options in document from reciever side - Delete document
	@Test(priority = 107)
	public void VerifyOtheroptionsdeletedocument() throws Exception {
		String a = "VerifyOtheroptionsdeletedocument";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
//	documentsScenarios2.Signorder();
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.OtherOptions();
		documentsScenarios2.otheroptionsdelete();
		documentsScenarios2.Blankwithoutsenderautofill();
//	recieverside2.prudhvioutlooklogin();
//	recieverside2.clickEmail(a);
//	recieverside2.reviewandSignSigner();
	}

//Upload autofill document and complete it from both sender and reciever side
	@Test(priority = 108)
	public void VerifyPdfAutoFillreceiver() throws Throwable {
		String file1 = System.getProperty("user.dir") + "/src/test/resources/ramya/blank1.pdf";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.blankurl();
		documentsScenarios2.uploadFileWithSendKeys(file1);
		documentsScenarios2.Nextbt();
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.Selecttofillrec();
		documentsScenarios2.Selectautofill();
		documentsScenarios2.Senddoc();
		recieverside2.ABCaccount();
	}

//Bulk delete documents
	@Test(priority = 109)
	public void VerifyBuldDeleteDocuments() throws Exception {
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.clickondocuments();
		documentsScenarios2.BuldDelete();
	}

// strike, Erase in uploaded document
//	@Test(priority = 110)
//	public void VerifyStrikeEraseuploadDocument() throws Throwable {
//		login.RamyaNsui();
//		login.VerifyLoginSucess();
//		documentsScenarios2.blankurl();
//		documentsScenarios2.uploadDocument();
//		documentsScenarios2.Nextbt();
//		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
//		documentsScenarios2.Saveuser();
//		documentsScenarios2.Selecttofillrec();
//		documentsScenarios2.Selectautofill();
//		documentsScenarios2.PdfEditmode();
//		documentsScenarios2.Senddoc();
//	}

//Slipting single line text fields into different boxes in document
	@Test(priority = 111)
	public void SplitSinglelineText() throws Exception {
		String a = "SplitSinglelineText";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.Signorder();
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		documentsScenarios2.SplitBox();
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewandSignSignerSplitbox();

	}

//changing user for the document
	@Test(priority = 112)
	public void Verifychangeuser() throws Exception {
		String a = "Verifychangeuser";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios2.Signorder();
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.OtherOptions();
		documentsScenarios2.otheroptionsfinishlater();
		documentsScenarios2.Afterfinishlater();
		documentsScenarios2.Changeruser();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();
	}

//copy link option when we click on finish later
	@Test(priority = 113)
	public void VerifyCopylink() throws Exception {
		String a = "VerifyCopylink";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.Signorder();
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.DradAndDropSigAndFullName(2, 10, 50, 10, 80);
		recieverside2.SubDocScenarios(a);
		documentsScenarios2.clickSubmit();
		documentsScenarios2.Verifysubmit();
		documentsScenarios2.Viewdocument();
		documentsScenarios2.OtherOptions();
		documentsScenarios2.otheroptionsfinishlater();
		documentsScenarios2.Afterfinishlater();
		documentsScenarios2.Copylink();
		documentsScenarios2.Blankwithoutsenderautofill();
		recieverside2.prudhvioutlooklogin();
		recieverside2.clickEmail(a);
		recieverside2.reviewSigner();
		recieverside2.reviewandSign("Prudvi");
		recieverside2.FinishDocumentRecieverside();

	}

//send document document for single send with any feilds after that clone that document and try to sennd that document again ,Verify whether it showig pop up for to add reciever fields
	@Test(priority = 114)
	public void VerifyClonedocumentForsinglesender() throws Exception {
		String a = "VerifyClonedocumentForsinglesender";
		login.RamyaNsui();
		login.VerifyLoginSucess();
		documentsScenarios2.autofilloff();
		documentsScenarios2.blankurl();
		documentsScenarios2.BlankDoc(a);
		documentsScenarios2.Signorder();
		documentsScenarios2.Saveuser();
		documentsScenarios2.DradAndDropSigAndFullName(1, 10, 130, 10, 160);
		documentsScenarios2.Finishdocument();
		documentsScenarios2.Clonedocumentforsinglesender();
		documentsScenarios2.RecipientSigner(1, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios2.Saveuser();
		documentsScenarios2.SendClonedoc();
	}

//@Test
//public void VerifyAddEntityfieldstodocumentprimaryfields() throws Exception {
//	String a ="VerifyAddEntityfieldstodocumentprimaryfields";
//	login.RamyaNsui();
//	login.VerifyLoginSucess();
//	documentsScenarios2.Entity();
//	documentsScenarios2.ClickCreateEntity();
//	documentsScenarios2.Createentity(a,"BUSINESS","Create a new app base with custom fields,tables, and filters.");
//	documentsScenarios2.addtemplatetoentity();
//	documentsScenarios2.Updation();
//	documentsScenarios2.autofilloff();
//	documentsScenarios2.Settings();
//	documentsScenarios2.blankurl();
//	documentsScenarios2.BlankDoc(a);
//	documentsScenarios2.AddRecipientforEntity(1,"VerifyAddEntityfieldstodocumentprimaryfields","prudhvib200@outlook.com","SIGNER");
//	documentsScenarios2.Signorder();
//	documentsScenarios2.Saveuser();
//	documentsScenarios2.DradAndDropSigAndFullName(1,-10,-200,-10,-250);
//	documentsScenarios2.DragBasicFeildsCompanyProfile(2);
//	recieverside2.SubDocScenarios(a);
//	documentsScenarios2.clickSubmit();
//	documentsScenarios2.Verifysubmit();
//	documentsScenarios2.documentsettings();
//	documentsScenarios2.Viewdocument();
////	documentsScenarios2.Blankwithoutsenderautofill();
////	documentsScenarios2.Checkbox();
////	recieverside2.FinishDocumentrecieverside2();
//	recieverside2.prudhvioutlooklogin();
//	recieverside2.clickEmail(a);
//	recieverside2.reviewSigner();
////	recieverside2.reviewandSign("Prudvi");
//	documentsScenarios2.enteringdatatoentity();
//	recieverside2.FinishDocumentrecieverside2();
//	documentsScenarios2.VerifyEntityData();
//	documentsScenarios2.verifyBasicFeildDataFillInIndividualEntity(a);
//	
//	}
//@Test
//public void VerifyUpdateAddEntityfieldstodocumentprimaryfields() throws Exception {
//	String a="VerifyUpdateAddEntityfieldstodocumentprimaryfields";
//	login.RamyaNsui();
//	login.VerifyLoginSucess();
//	documentsScenarios2.autofilloff();
//	documentsScenarios2.Updateafterdocumentcompletionfromsettings();
//	documentsScenarios2.Settings();
//	documentsScenarios2.blankurl();
//	documentsScenarios2.BlankDoc(a);
//	documentsScenarios2.RecipientSigner(1,"Business entity", "prudhvib200@outlook.com", "SIGNER");
//	documentsScenarios2.Signorder();
//	documentsScenarios2.Saveuser();
//	documentsScenarios2.DradAndDropSigAndFullName(1,10,130,10,160);
//	documentsScenarios2.DragBasicFeildsCompanyProfile(2);
//	recieverside2.SubDocScenarios(a);
//	documentsScenarios2.clickSubmit();
//	documentsScenarios2.Verifysubmit();
//	documentsScenarios2.Viewdocument();
//	documentsScenarios2.Blankwithoutsenderautofill();
//	recieverside2.prudhvioutlooklogin();
//	recieverside2.clickEmail(a);
//	recieverside2.reviewSigner();
//	recieverside2.reviewandSign("Prudvi");
//	documentsScenarios2.UpdateDatatoEntity();
//	recieverside2.FinishDocumentrecieverside2();
//	
//}
//@Test
//public void VerifyUpdateafteruserfinishesthedocument() throws Exception {
//	String a="VerifyUpdateafteruserfinishesthedocument";
//	login.RamyaNsui();
//	login.VerifyLoginSucess();
//	documentsScenarios2.autofilloff();
//	//documentsScenarios2.Updateafterdocumentcompletionfromsettings();
//	documentsScenarios2.Settings2();
//	documentsScenarios2.blankurl();
//	documentsScenarios2.BlankDoc(a);
//	documentsScenarios2.RecipientSigner(1,"Business Entity2", "prudhvib200@outlook.com", "SIGNER");
//	documentsScenarios2.RecipientSigner(2,"Business Entity2", "jeevithapatnana200@outlook.com", "SIGNER");
//	documentsScenarios2.Signorder();
//	documentsScenarios2.Saveuser();
//	documentsScenarios2.DradAndDropSigAndFullName(1,10,130,10,160);
//	documentsScenarios2.DragBasicFeildsCompanyProfile(2);
//	documentsScenarios2.DragBasicFeildsCompanyProfile(3);
//	recieverside2.SubDocScenarios(a);
//	documentsScenarios2.clickSubmit();
//	documentsScenarios2.Verifysubmit();
//	documentsScenarios2.Viewdocument();
//	documentsScenarios2.Blankwithoutsenderautofill();
//	recieverside2.prudhvioutlooklogin();
//	recieverside2.clickEmail(a);
//	recieverside2.reviewSigner();
//	recieverside2.reviewandSign("Prudvi");
//	documentsScenarios2.enteringdatatoentity();
//	recieverside2.FinishDocumentrecieverside2();
//	documentsScenarios2.Outlooklogin("jeevithapatnana200@outlook.com", "Meghana@123");
//	recieverside2.clickEmail(a);
//	recieverside2.reviewSigner();
//	recieverside2.reviewandSign("Jeevitha");
//	documentsScenarios2.enteringdatatoentity();
//	recieverside2.FinishDocumentrecieverside2();
//}
	@AfterMethod
	public void quit() {
		driver.close();
		
	}
}
