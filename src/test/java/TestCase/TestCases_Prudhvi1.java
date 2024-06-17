package TestCase;

import java.io.File;
import java.time.Duration;
import java.util.UUID;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.Addrecipients;
import Pages.Alldocuments;
import Pages.Dashboard;
import Pages.DocumentsScenarios1;
import Pages.Dragdrop;
import Pages.Entities;
import Pages.FilePermission;
import Pages.Login;
import Pages.MethodActions;
import Pages.RecevierSide1;
import Pages.ReviewaNdSend;
import Pages.Signup;
import Pages.Templatespage;
import Pages.Uploaddocuments;
import Reports.TestNGExtentReport;
import Reports.Testlistner;
import TestBase.testCaseBase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Listeners({ TestNGExtentReport.class, Testlistner.class })
public class TestCases_Prudhvi1 extends testCaseBase {
	Login login;
	Alldocuments alldocuments;
	Uploaddocuments uploaddocuments;
	Addrecipients addrecipients;
	Dragdrop dragdrop;
	ReviewaNdSend reviewaNdSend;
	RecevierSide1 recevierSide1;
	Signup signup;
	Templatespage templatespage;
	Dashboard dashboard;
	DocumentsScenarios1 documentsScenarios1;
	Entities entities;
	Templatespage template;
	FilePermission filePermission;
	MethodActions methodActions;

	@BeforeMethod
	public void start() {
		setup();
        login = new Login(driver);
        alldocuments = new Alldocuments(driver);
        uploaddocuments = new Uploaddocuments(driver);
        addrecipients = new Addrecipients(driver);
        dragdrop = new Dragdrop(driver);
        reviewaNdSend = new ReviewaNdSend(driver);
        recevierSide1 = new RecevierSide1(driver);
        signup = new Signup(driver);
        templatespage = new Templatespage(driver);
        dashboard = new Dashboard(driver);
        documentsScenarios1 = new DocumentsScenarios1(driver);
        entities = new Entities(driver);
        template = new Templatespage(driver);
        methodActions =new MethodActions(driver);
    }

	// 3a,Blank Doc – Sender signer & Receiver signer (With enforcement)send
	// document with uploading blank doc for Sender & Receiver (Complete through
	// login from
	// sender & Complete through from mail receiver)
	@Test(priority = 1)
	public void BlankDocWithEnforcement() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		login.VerifyLoginSucess();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.DocScenario();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		MethodActions.takeScreenshot(driver);
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.VerifyDocCompleteReceiverEnd();
	}

//
//	// yes
//	// 3bsend document with uploading blank doc for Sender & Receiver(Complete
//	// through
//	// login from sender & Complete through from mail receiver & sender autofill
//	// enabled)
	@Test(priority = 2)
	public void BlankDocWithEnforcementWithAutofill() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofillon();
		documentsScenarios1.DocScenario();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.VerifyDocCompleteReceiverEnd();
	}

//
//	// yes
//	// 3c
	@Test(priority = 3)
	public void BlankDocWithEnforcementWithoutAutofill() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.VerifyDocCompleteReceiverEnd();
	}

//
//	// yes
//	// 4a
//	// Blank Doc – Sender signer & Receiver signer (With enforcement)send document
//	// with uploading blank doc for Sender & Receiver (Complete through login from
//	// sender & Complete through from mail receiver)
	@Test(priority = 4)
	public void BlankDocWithtEnforcement() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.VerifyDocCompleteReceiverEnd();
	}

//
//	// yes
//	// 4b
//	// send document with uploading blank doc for Sender & Receiver(Complete through
//	// login from sender & Complete through from mail receiver & sender autofill
//	// enabled)
	@Test(priority = 5)
	public void BlankDocWithoEnforcementWithAutofill() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofillon();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.VerifyDocCompleteReceiverEnd();
	}

//
//	// 6yes
//	// 4c
	@Test(priority = 6)
	public void BlankDocWithoutEnforcementWithoutAutofill() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.VerifyDocCompleteReceiverEnd();
	}

	// 5a
	@Test(priority = 7)
	public void uploadpdfFile() throws Exception {
		// String file = System.getProperty("user.dir") + File.separator + "src" +
		// File.separator + "test" + File.separator + "resources" + File.separator +
		// "meghana" + File.separator + "TESTING.pdf";
		String file = System.getProperty("user.dir") + "/src/test/resources/meghana/TESTING.pdf";
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.blankurl();
		documentsScenarios1.uploadFileWithSendKeys(file);
		documentsScenarios1.nextButton();
		documentsScenarios1.VerifyFileUploadSucess();
	}

	@Test(priority = 8)
	public void uploadDoc() throws Exception {
		// String Wordfile = System.getProperty("user.dir") + File.separator + "src" +
		// File.separator + "test" + File.separator + "resources" + File.separator +
		// "meghana" + File.separator + "Test cases.docx";
		String Wordfile = System.getProperty("user.dir") + "/src/test/resources/meghana/Test cases.docx";
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.blankurl();
		documentsScenarios1.uploadFileWithSendKeys(Wordfile);
		documentsScenarios1.nextButton();
		documentsScenarios1.VerifyFileUploadSucess();
	}

//
	@Test(priority = 9)
	public void uploadPNG() throws Exception {
		String PNGfile = System.getProperty("user.dir") + "/src/test/resources/meghana/Screenshot.png";
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.blankurl();
		documentsScenarios1.uploadFileWithSendKeys(PNGfile);
		documentsScenarios1.nextButton();
		documentsScenarios1.VerifyFileUploadSucess();
	}

//
	@Test(priority = 10)
	public void uploadjpg() throws Exception {
		String jpgfile = System.getProperty("user.dir") + "/src/test/resources/meghana/Sample-jpg-image-50kb.jpg";
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.blankurl();
		documentsScenarios1.uploadFileWithSendKeys(jpgfile);
		documentsScenarios1.nextButton();
		documentsScenarios1.VerifyFileUploadSucess();
	}

//
	@Test(priority = 11)
	public void uploadTXT() throws Exception {
		// String txtfile = System.getProperty("user.dir")
		// +"\\src\\test\\resources\\meghana\\Documents scenarios.txt";
		// File.separator + "test" + File.separator + "resources" + File.separator +
		// "meghana" + File.separator + "Test cases.docx";
		String txtfile = System.getProperty("user.dir") + "/src/test/resources/meghana/Documents scenarios.txt";
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.blankurl();
		documentsScenarios1.uploadFileWithSendKeys(txtfile);
		documentsScenarios1.nextButton();
		documentsScenarios1.VerifyFileUploadSucess();
	}

//
//	// When we upload combination of PDF & DOC files and click on next it needs to
//	// navigate users page
	@Test(priority = 12)
	public void uploadPDFandDoc() throws Exception {
		String pdffile = System.getProperty("user.dir") + "/src/test/resources/meghana/TESTING.pdf";
		String Wordfile = System.getProperty("user.dir") + "/src/test/resources/meghana/Test cases.docx";
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.blankurl();
		documentsScenarios1.uploadFileWithSendKeys(pdffile);
		documentsScenarios1.uploadFileWithSendKeys(Wordfile);
		documentsScenarios1.nextButton();
		documentsScenarios1.VerifyFileUploadSucess();
	}

//
//	// When we upload combination of DOC & DOC files and click on next it needs to
//	// navigate users page
	@Test(priority = 13)
	public void uploadDocandDoc() throws Exception {
		String word2file = System.getProperty("user.dir") + "/src/test/resources/meghana/Feautures.docx";
		String Wordfile =System.getProperty("user.dir") + "/src/test/resources/meghana/Test cases.docx";
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.blankurl();
		documentsScenarios1.uploadFileWithSendKeys(word2file);
		documentsScenarios1.uploadFileWithSendKeys(Wordfile);
		documentsScenarios1.nextButton();
		documentsScenarios1.VerifyFileUploadSucess();
	}

//
//	// When we upload combination of DOC & TXT files and click on next it needs to
//	// navigate users page
	@Test(priority = 14)
	public void uploadDOCandTXT() throws Exception {
		String TXTfile = System.getProperty("user.dir") + "/src/test/resources/meghana/Documents scenarios.txt";
		String Wordfile = System.getProperty("user.dir") + "/src/test/resources/meghana/Test cases.docx";
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.blankurl();
		documentsScenarios1.uploadFileWithSendKeys(Wordfile);
		documentsScenarios1.uploadFileWithSendKeys(TXTfile);
		documentsScenarios1.nextButton();
		documentsScenarios1.VerifyFileUploadSucess();
	}

//
//	// When we upload combination of PDF& PDF files and click on next it needs to
//	// navigate users page
	@Test(priority = 15)
	public void uploadPDFandPDF() throws Exception {
		String pdffile = System.getProperty("user.dir") + "/src/test/resources/meghana/TESTING.pdf";
		String pdffile2 = System.getProperty("user.dir") + "/src/test/resources/meghana/Evaluation form Ramya.pdf";
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.blankurl();
		documentsScenarios1.uploadFileWithSendKeys(pdffile);
		documentsScenarios1.uploadFileWithSendKeys(pdffile2);
		documentsScenarios1.nextButton();
		documentsScenarios1.VerifyFileUploadSucess();
	}

//
//	// When we upload combination of PDF & TXT files and click on next it needs to
//	// navigate users page
	@Test(priority = 16)
	public void uploadPDFandTXT() throws Exception {
		String pdffile = System.getProperty("user.dir") + "/src/test/resources/meghana/TESTING.pdf";
		String txtfile = System.getProperty("user.dir") + "/src/test/resources/meghana/Documents scenarios.txt";
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.blankurl();
		documentsScenarios1.uploadFileWithSendKeys(pdffile);
		documentsScenarios1.uploadFileWithSendKeys(txtfile);
		documentsScenarios1.nextButton();
		documentsScenarios1.VerifyFileUploadSucess();
	}

//
//	// When we upload combination of DOC & PNG files and click on next it needs to
//	// navigate users page
	@Test(priority = 17)
	public void uploadDOCandPNG() throws Exception {
		String Wordfile = System.getProperty("user.dir") + "/src/test/resources/meghana/Test cases.docx";
		String PNGfile = System.getProperty("user.dir") + "/src/test/resources/meghana/Screenshot.png";
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.blankurl();
		documentsScenarios1.uploadFileWithSendKeys(Wordfile);
		documentsScenarios1.uploadFileWithSendKeys(PNGfile);
		documentsScenarios1.nextButton();
		documentsScenarios1.VerifyFileUploadSucess();
	}

//
//	// When we upload combination of PDF & DOC files and click on next it needs to
//	// navigate users page
	@Test(priority = 18)
	public void uploadPDFandDOC() throws Exception {
		String pdffile = System.getProperty("user.dir") + "/src/test/resources/meghana/TESTING.pdf";

		String Wordfile = System.getProperty("user.dir") + "/src/test/resources/meghana/Test cases.docx";

		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.blankurl();
		documentsScenarios1.uploadFileWithSendKeys(pdffile);
		documentsScenarios1.uploadFileWithSendKeys(Wordfile);
		documentsScenarios1.nextButton();
		documentsScenarios1.VerifyFileUploadSucess();
	}

//
//	// When we upload combination of DOC & JPG files and click on next it needs to
//	// navigate users page
	@Test(priority = 19)
	public void uploadDOCandJPG() throws Exception {
		String Wordfile = System.getProperty("user.dir") + "/src/test/resources/meghana/Test cases.docx";
		String jpgfile = System.getProperty("user.dir") + "/src/test/resources/meghana/Sample-jpg-image-50kb.jpg";
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.blankurl();
		documentsScenarios1.uploadFileWithSendKeys(Wordfile);
		documentsScenarios1.uploadFileWithSendKeys(jpgfile);
		documentsScenarios1.nextButton();
		documentsScenarios1.VerifyFileUploadSucess();
	}

//
//	// When we upload combination of PDF & JPG files and click on next it needs to
//	// navigate users page
	@Test(priority = 20)
	public void uploadPDFandJPG() throws Exception {
		String pdffile = System.getProperty("user.dir") + "/src/test/resources/meghana/TESTING.pdf";
		String jpgfile = System.getProperty("user.dir") + "/src/test/resources/meghana/Sample-jpg-image-50kb.jpg";
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.blankurl();
		documentsScenarios1.uploadFileWithSendKeys(pdffile);
		documentsScenarios1.uploadFileWithSendKeys(jpgfile);
		documentsScenarios1.nextButton();
		documentsScenarios1.VerifyFileUploadSucess();
	}

////	// OneDrive-signerand CC WithOut
////	// EnforceSignatureOrderWithSenderAutofill-receiver Email Login
	@Test(priority = 21)
	public void ValidDocscenarioOnedrive() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.DocScenario();
		documentsScenarios1.DocscenarioOnedrive();
		MethodActions.takeScreenshot(driver);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Recipient(2, "Receiver", "prudhvib200@outlook.com", " CC ");
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.outlooksigninpage();
		recevierSide1.switchEmail();
		recevierSide1.jeevithaOutlookloginPage();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide1.validateAtCCTwo();

	}

//
////GoogleDrive-signerand CC WithOut EnforceSignatureOrderWithSenderAutofill-receiver Email Login
//	@Test(priority = 22)
//	public void ValidDocscenariosGdrive() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		MethodActions.Loadingmask();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.blankurl();
//		documentsScenarios1.DocscenariosGdrive();
//		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
//		documentsScenarios1.Recipient(3, "Receiver", "prudhvib200@outlook.com", "CC");
//		documentsScenarios1.Signorder();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide1.jeevithaOutlooklogin();
//		recevierSide1.clickEmail(doc);
//		recevierSide1.reviewandSign("Review & sign");
//		recevierSide1.signaturefill();
//		recevierSide1.clickFinish();
//		recevierSide1.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
//		recevierSide1.clickEmail(doc);
//		recevierSide1.reviewandSign("Review & sign");
//		recevierSide1.signaturefill();
//		recevierSide1.clickFinish();
//		recevierSide1.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
//		recevierSide1.validateAtCCGdrive();
//
//	}
//
//	// Blankdoc-RearrangingOrderCCndSigner-Without enforce signature order & Without
//	// sender autofill-receiver Email Login
	@Test(priority = 23)
	public void ValidRearrangingOrderCCndSigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios1.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios1.Recipient(3, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios1.Rearranges(3, 1);
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide1.validateAtCC(doc);

	}

//
//	// BlankDoc-MultipleSigners and cc-Without enforce signature order & Without
//	// sender autofill-receiver Email Login
	@Test(priority = 24)
	public void ValidBlankDocMultipleSigners() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios1.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios1.Recipient(3, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.VerifyDocCompleteReceiverEnd();

	}

//
////Onedrive-DocMultipleSigners-Without enforce signature order & Without sender autofill-receiver Email Login
	@Test(priority = 25)
	public void ValidOneDriveDocMultipleSigners() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.DocscenarioOnedrive();
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios1.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.outlooksigninpage();
		recevierSide1.switchEmail();
		recevierSide1.jeevithaOutlookloginPage();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.VerifyDocCompleteReceiverEnd();

	}

//
//	// BlankDoc-RearrangingOrderFirstOtherSignersndThenSender-Without enforce
//	// signature order & Without sender autofill-receiver Email Login
	@Test(priority = 26)
	public void ValidRearrangingOrderFirstOtherSignersandThenSender() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios1.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios1.Rearranges(0, 2);
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.VerifyDocCompleteReceiverEnd();
	}

//
//	// Onedrive-RearrangingOrderFirstOtherSignersndThenSenderOnedrive-Without
//	// enforce signature order & Without sender autofill-receiver Email Login
	@Test(priority = 27)
	public void ValidRearrangingOrderFirstOtherSignersndThenSenderOnedrive() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		login.VerifyLoginSucess();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.DocscenarioOnedrive();
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios1.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios1.Rearranges(0, 2);
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.outlooksigninpage();
		recevierSide1.switchEmail();
		recevierSide1.jeevithaOutlookloginPage();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.VerifyDocCompleteReceiverEnd();

	}

//
//	// Blank DOc-SignerndApprover Without enforce signature order & Without sender
//	// autofill-receiver Email Login
	@Test(priority = 28)
	public void ValidBlankdocSignerndApprover() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.VerifyDocCompleteReceiverEnd();

	}

//
////OneDrive-SignerndApproverOnedrive Without enforce signature order & Without sender autofill-receiver Email Login
	@Test(priority = 29)
	public void ValidSignerndApproverOnedrive() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.DocscenarioOnedrive();
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.outlooksigninpage();
		recevierSide1.switchEmail();
		recevierSide1.jeevithaOutlookloginPage();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.VerifyDocCompleteReceiverEnd();

	}

//
//	// Blank Doc-RearrangingOrderFirstApproverthenSigner Without enforce signature
//	// order & Without sender autofill-receiver Email Login
	@Test(priority = 30)
	public void ValidRearrangingOrderFirstApproverthenSigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios1.Rearranges(2, 1);
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.VerifyDocCompleteReceiverEnd();
	}

//
//	// 9.Blank Doc- (Signer , Approver & CC)Without enforce signature order &
//	// Without sender autofill-receiver Email Login
	@Test(priority = 31)
	public void ValidBlankDocSignerApproverAndCCWithoutEnforceSignature() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		login.VerifyLoginSucess();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios1.Recipient(3, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide1.validateAtCC(doc);

	}

//
//	// Blank Doc- (Signer, Multiple Approvers & CC)With/Without enforce signature
//	// order & Without sender autofill--receiver Email Login
	@Test(priority = 32)
	public void ValidBlankDocSignerMulApproverAndCC() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		login.VerifyLoginSucess();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios1.Recipient(3, "Receiver", "meghanan180894@outlook.com", " APPROVER ");
		documentsScenarios1.Recipient(4, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide1.validateAtCC(doc);

	}

//
//	// Blank Doc- (Signer, Approvers& Multiple CC)With/Without enforce signature
//	// order & Without sender autofill--receiver Email Login
	@Test(priority = 33)
	public void ValidBlankDocSignerApproverAndMultipleCC() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		login.VerifyLoginSucess();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios1.Recipient(3, "Receiver", "meghanan180894@outlook.com", "CC");
		documentsScenarios1.Recipient(4, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide1.validateAtCC(doc);
		recevierSide1.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide1.validateAtCC(doc);

	}

//
//	// Blank Doc- (Signer, Multiple Approvers & Multiple CC)With/Without enforce
//	// signature order & Without sender autofill--receiver Email Login
	@Test(priority = 34)
	public void validBlankDocSignerMulApproverAndMulCC() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		login.VerifyLoginSucess();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios1.Recipient(3, "Receiver", "meghanan180894@outlook.com", " APPROVER ");
		documentsScenarios1.Recipient(4, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios1.Recipient(5, "Receiver", "ramyas200@outlook.com", "CC");
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide1.validateAtCC(doc);

	}

//
//	// 10.Blankdoc-Rearranging order first Approver and then Signer &&CC-Without
//	// enforce signature order & Without sender autofill--receiver Email Login
	@Test(priority = 35)
	public void validBlankDocRearrangeorderApproverSignerAndCC() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		login.VerifyLoginSucess();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios1.Recipient(3, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios1.Rearranges(2, 1);
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide1.validateAtCC(doc);

	}

//
//	// 11.Rearranging order first CC and then Signer && Approver Without enforce
//	// signature order & Without sender autofill--receiver Email Login
	@Test(priority = 36)
	public void validBlankDocRearrangeorderCCSignerApprover() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios1.Recipient(3, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios1.Rearranges(3, 1);
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide1.validateAtCC(doc);

	}

//
//	// 12.Rearranging order first Approver and then CC && Signer--receiver Email
//	// Login
	@Test(priority = 37)
	public void validRearrangeorderApproverCCSigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios1.Recipient(3, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios1.Rearranges(2, 1);
		documentsScenarios1.Rearranges(3, 2);
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide1.validateAtCC(doc);

	}

//
//	// 13. Blank Doc-Rearranging order first Signer and then CC && Approver-Without
//	// enforce signature order & Without sender autofill--receiver Email Login
	@Test(priority = 38)
	public void validBlankDocRearrangeorderSignerCCApprover() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios1.Recipient(3, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios1.Rearranges(3, 2);
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide1.validateAtCC(doc);

	}

//
//	// 14.Blank Doc-Rearranging order first CC and then Approver && Signer-Without
//	// enforce signature order & Without sender autofill--receiver Email Login
	@Test(priority = 39)
	public void validBlankDocRearrangeorderCCApproversigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios1.Recipient(2, "Receiver", "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios1.Recipient(3, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios1.Rearranges(3, 1);
		documentsScenarios1.Rearranges(2, 3);
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide1.validateAtCC(doc);

	}

//
//	// 15.Blank Doc-Multiple signers , approver&& CC Without enforce signature
//	// order& Without sender autofill-receiver Email Login
	@Test(priority = 40)
	public void validBlankDocMulsignerApproverCC() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios1.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios1.Recipient(3, "Receiver", "ramyas200@outlook.com", "APPROVER");
		documentsScenarios1.Recipient(4, "Receiver", "prudhvib200@outlook.com", "CC");
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide1.validateAtCC(doc);

	}

//
//	// 16.Rearranging order first Other Signers and then Sender Signer
//	// &&Approver-Without enforce signature order & Without sender autofill-receiver
//	// Email Login
	@Test(priority = 41)
	public void validBlankDocOtherSignerSenderSignerApprover() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios1.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios1.Recipient(3, "Receiver", "ramyas200@outlook.com", "APPROVER");
		documentsScenarios1.Rearranges(0, 2);
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.VerifyDocCompleteReceiverEnd();
	}

//
//	// 17.Rearranging order first Approver and then Sender Signer && Other
//	// Signers-receiver Email Login
	@Test(priority = 42)
	public void validBlankDocApproverSenderSignerOtherSigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios1.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios1.Recipient(3, "Receiver", "ramyas200@outlook.com", "APPROVER");
		documentsScenarios1.Rearranges(3, 2);
		documentsScenarios1.scrollUp();
		documentsScenarios1.Rearranges(0, 1);
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.VerifyDocCompleteReceiverEnd();
	}

//
//	// 18.Rearranging order first Other Signers and then Approver && Sender
//	// Signer--receiver Email Login
	@Test(priority = 43)
	public void validBlankDocOtherSignerApproverSenderSigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios1.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios1.Recipient(3, "Receiver", "ramyas200@outlook.com", "APPROVER");
		documentsScenarios1.Rearranges(0, 2);
		documentsScenarios1.scrollDown();
		documentsScenarios1.Rearranges(3, 2);
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.VerifyDocCompleteReceiverEnd();
	}

//
//	// 19.Rearranging order first Sender Signer and then Approver && Other
//	// Signers-receiver Email Login
	@Test(priority = 44)
	public void validBlankDocSenderSignerApproverOtherSigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.autofilloff();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios1.Recipient(2, "Receiver", "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios1.Recipient(3, "Receiver", "ramyas200@outlook.com", "APPROVER");
		documentsScenarios1.Rearranges(3, 2);
		documentsScenarios1.Signorder();
		documentsScenarios1.Saveuser();
		documentsScenarios1.SignatureAndFullNameFeilds();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		documentsScenarios1.Viewdocument();
		documentsScenarios1.Blankwithoutsenderautofill();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & Approve");
		recevierSide1.signaturefill();
		recevierSide1.clickApprove();
		recevierSide1.VerifyDocCompleteReceiverEnd();
	}

//
	@Test(priority = 45)
	public void uploadVedio() throws Exception {
		String vediofile = System.getProperty("user.dir") + "/src/test/resources/meghana/Demo.mp4";
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.blankurl();
		documentsScenarios1.uploadFileWithSendKeys(vediofile);
		documentsScenarios1.nextButton();
	}

//
//	// 3.Reuploading a completed Esigns ID Generated DOC
	@Test(priority = 46)
	public void ReuploadingCompletedEsignsIDGeneratedDOC() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		String file = System.getProperty("user.dir") + "/src/test/resources/meghana/Evaluation form Ramya.pdf";
		login.SigninNSUI();
		MethodActions.Loadingmask();
		documentsScenarios1.blankurl();
		documentsScenarios1.uploadFileWithSendKeys(file);
		documentsScenarios1.nextButton();
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios1.Saveuser();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		recevierSide1.jeevithaOutlooklogin();
		recevierSide1.clickEmail(doc);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		recevierSide1.VerifyDocCompleteReceiverEnd();
	}

//
////	(All These in Change Document also)
//	@Test(priority = 47)
//	public void changeDocument() throws InterruptedException, Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		String file = System.getProperty("user.dir") + "/src/test/resources/meghana/TESTING.pdf";
//        String pdffile = System.getProperty("user.dir") + "/src/test/resources/meghana/TESTING.pdf";
//		
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.blankurl();
//		documentsScenarios1.Fileuploads(file);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.Recipient(1, "Receiver","jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.changeDoc();
//		documentsScenarios1.uploadFileTwoWithSendKeys(pdffile);
//		documentsScenarios1.clickContinue();
//		documentsScenarios1.DradAndDropSigAndFullName(2,10,-20,10,10);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		recevierSide1.jeevithaOutlooklogin();
//		recevierSide1.clickEmail(doc);
//		recevierSide1.reviewandSign("Review & sign");
//		recevierSide1.signaturefill();
//		recevierSide1.clickFinish();
//		recevierSide1.VerifyDocCompleteReceiverEnd();
//
//	}
//////
////////	5.Attachment Downloads
//////
//	@Test(priority = 48)
//	public void attachmentDownloads() throws Exception {
//		String file = System.getProperty("user.dir") + "/src/test/resources/meghana/Evaluation form Ramya.pdf";
//		String TESTING = System.getProperty("user.dir") + "/src/test/resources/meghana/TESTING.pdf";
//		login.SigninNSUI();
//		MethodActions.Loadingmask();
//		documentsScenarios1.blankurl();
//		documentsScenarios1.uploadFileWithSendKeys(file);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.dragRequestDocFeild();
//		documentsScenarios1.uploadFileTwoWithSendKeys(TESTING);
//		documentsScenarios1.save();
//		documentsScenarios1.clickFinishDoc();
//	documentsScenarios1.viewDocandDownload();
//
//	}
//
////	// drag and drop feilds after adding the form template to the company profile
	@Test(priority = 49)
	public void contentFeildsCompanyProfile() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		MethodActions.Loadingmask();
//		entities.FormTemplate();
//		entities.CreateFormtemplate(doc);
//		entities.templateContentFeilds();
//		entities.submit();
//		entities.contentFeildsDragAndDrop();
//		entities.companyProfile();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios1.Saveuser();
		documentsScenarios1.DragContentFeildsCompanyProfile();
		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
	}

//
	@Test(priority = 50)
	public void BasicfeildsCompanyProfile() throws Exception {
		String feilds[] = { "RadioG...", "DateRa...", "Sign", "DateTi...", "YesorN...", "Weekda...", "Single...",
				"Date", "Docume...", "FixedT...", "list", "Time", "Number", "Multis...", "Phonon...", "Select",
				"Multil...", "Checkb..." };
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
//		entities.FormTemplate();
//		entities.CreateFormtemplate(doc);
//		entities.templateBasicFeilds();
//		entities.submit();
//		entities.basicFeilds();
//		entities.companyProfile();
		documentsScenarios1.blankurl();
		documentsScenarios1.Blankloginaccount(doc);
		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios1.Saveuser();
		documentsScenarios1.DragAndDropFeildsInDocument("templateBasicFeilds", feilds);
		documentsScenarios1.DradAndDropSigAndFullName(2, -250, -120, 0, -120);
		documentsScenarios1.SubDocScenarios(doc);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
	}
 

////
//	@Test(priority = 51, enabled = false)
//	public void AdvancedFieldsCompanyProfile() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		entities.FormTemplate();
////		entities.CreateFormtemplate(doc);
////		entities.templateAdvancedFeilds();
////		entities.submit();
////		entities.advancedFeilds();
////		entities.companyProfile();
//		documentsScenarios1.blankurl();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.Saveuser();
////		documentsScenarios1.DragFeildsCompanyProfile();
////		documentsScenarios1.DradAndDropSigAndFullName(2,10,-20,10,10);
////		documentsScenarios1.SubDocScenarios(doc);
////		documentsScenarios1.clickSubmit();
////		documentsScenarios1.Verifysubmit();
//	}
////Entity mapping from documents: (Individual entity)(Update after document completion from settings)
//
//	@Test(priority = 52, enabled = false)
//	public void EntityMappingIndividualEntityUpdateAfterDocumentCompletionFromSettings() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.Updateafterdocumentcompletionfromsettings();
//		documentsScenarios1.blankurl();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.Recipient(1, "individualEntity", "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.DradAndDropSigAndFullName(2, -250, 150, -250, 180);
//		documentsScenarios1.DragBasicFeildsCompanyProfile();
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		recevierSide1.jeevithaOutlooklogin();
//		recevierSide1.clickEmail(doc);
//		recevierSide1.reviewandSign("Review & sign");
//		recevierSide1.signaturefill();
//
////		recevierSide1.clickFinish();
//	}

//	@AfterMethod
//	public void quit() {
//		driver.quit();
//	}

}
