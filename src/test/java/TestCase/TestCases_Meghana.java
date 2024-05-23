package TestCase;

import java.util.UUID;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Addrecipients;
import Pages.Alldocuments;
import Pages.Dashboard;
import Pages.DocumentsScenarios;
import Pages.Dragdrop;
import Pages.Entities;
import Pages.Login;
import Pages.RecevierSide;
import Pages.ReviewaNdSend;
import Pages.Signup;
import Pages.Templatespage;
import Pages.Uploaddocuments;
import TestBase.testCaseBase;

public class TestCases_Meghana extends testCaseBase {
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
	Entities entities;
	RecevierSide receiverSide;
	Templatespage template;

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
		entities = new Entities(driver);
		receiverSide = new RecevierSide(driver);
		template = new Templatespage(driver);

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
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// yes
	// 3bsend document with uploading blank doc for Sender & Receiver(Complete
	// through
	// login from sender & Complete through from mail receiver & sender autofill
	// enabled)
	@Test(priority = 2)
	public void BlankDocWithEnforcementWithAutofill() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		documentsScenarios.autofillon();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// yes
	// 3c
	@Test(priority = 3)
	public void BlankDocWithEnforcementWithoutAutofill() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// yes
	// 4a
	// Blank Doc – Sender signer & Receiver signer (With enforcement)send document
	// with uploading blank doc for Sender & Receiver (Complete through login from
	// sender & Complete through from mail receiver)
	@Test(priority = 4)
	public void BlankDocWithtEnforcement() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// yes
	// 4b
	// send document with uploading blank doc for Sender & Receiver(Complete through
	// login from sender & Complete through from mail receiver & sender autofill
	// enabled)
	@Test(priority = 5)
	public void BlankDocWithoEnforcementWithAutofill() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		documentsScenarios.autofillon();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// 6yes
	// 4c
	@Test(priority = 6)
	public void BlankDocWithoutEnforcementWithoutAutofill() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// 5a
	@Test(priority = 7)
	public void uploadpdfFile() throws Exception {
		String pdffile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\PDFFile.exe\"";
		login.SigninNSUI();
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(pdffile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	@Test(priority = 8)
	public void uploadDoc() throws Exception {
		String Wordfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\WordFile.exe\"";
		login.SigninNSUI();
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(Wordfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	@Test(priority = 9)
	public void uploadPNG() throws Exception {
		String PNGfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\pngFile.exe\"";
		login.SigninNSUI();
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(PNGfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	@Test(priority = 10)
	public void uploadjpg() throws Exception {
		String jpgfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\jpgFile.exe\"";
		login.SigninNSUI();
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(jpgfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	} 

	@Test(priority = 11)
	public void uploadTXT() throws Exception {
		String txtfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\TXTFile.exe\"";
		login.SigninNSUI();
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(txtfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	// When we upload combination of PDF & DOC files and click on next it needs to
	// navigate users page
	@Test(priority = 12)
	public void uploadPDFandDoc() throws Exception {
		String pdffile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\PDFFile.exe\"";
		String Wordfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\WordFile.exe\"";
		login.SigninNSUI();
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(pdffile);
		documentsScenarios.Fileuploads(Wordfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	// When we upload combination of DOC & DOC files and click on next it needs to
	// navigate users page
	@Test(priority = 13)
	public void uploadDocandDoc() throws Exception {
		String word2file = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\wordFile2.exe\"";
		String Wordfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\WordFile.exe\"";
		login.SigninNSUI();
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(word2file);
		documentsScenarios.Fileuploads(Wordfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	// When we upload combination of DOC & TXT files and click on next it needs to
	// navigate users page
	@Test(priority = 14)
	public void uploadDOCandTXT() throws Exception {
		String TXTfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\TXTFile.exe\"";
		String Wordfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\WordFile.exe\"";
		login.SigninNSUI();
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(Wordfile);
		documentsScenarios.Fileuploads(TXTfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	// When we upload combination of PDF& PDF files and click on next it needs to
	// navigate users page
	@Test(priority = 15)
	public void uploadPDFandPDF() throws Exception {
		String pdffile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\PDFFile.exe\"";
		String pdffile2 = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\fileupload1.exe\"";
		login.SigninNSUI();
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(pdffile);
		documentsScenarios.Fileuploads(pdffile2);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	// When we upload combination of PDF & TXT files and click on next it needs to
	// navigate users page
	@Test(priority = 16)
	public void uploadPDFandTXT() throws Exception {
		String pdffile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\PDFFile.exe\"";
		String txtfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\TXTFile.exe\"";
		login.SigninNSUI();
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(pdffile);
		documentsScenarios.Fileuploads(txtfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	// When we upload combination of DOC & PNG files and click on next it needs to
	// navigate users page
	@Test(priority = 17)
	public void uploadDOCandPNG() throws Exception {
		String Wordfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\WordFile.exe\"";
		String PNGfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\pngFile.exe\"";
		login.SigninNSUI();
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(Wordfile);
		documentsScenarios.Fileuploads(PNGfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	// When we upload combination of PDF & DOC files and click on next it needs to
	// navigate users page
	@Test(priority = 18)
	public void uploadPDFandDOC() throws Exception {
		String pdffile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\PDFFile.exe\"";
		String Wordfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\WordFile.exe\"";
		login.SigninNSUI();
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(pdffile);
		documentsScenarios.Fileuploads(Wordfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	// When we upload combination of DOC & JPG files and click on next it needs to
	// navigate users page
	@Test(priority = 19)
	public void uploadDOCandJPG() throws Exception {
		String Wordfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\WordFile.exe\"";
		String jpgfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\jpgFile.exe\"";
		login.SigninNSUI();
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(Wordfile);
		documentsScenarios.Fileuploads(jpgfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}

	// When we upload combination of PDF & JPG files and click on next it needs to
	// navigate users page
	@Test(priority = 20)
	public void uploadPDFandJPG() throws Exception {
		String pdffile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\PDFFile.exe\"";
		String jpgfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\jpgFile.exe\"";
		login.SigninNSUI();
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(pdffile);
		documentsScenarios.Fileuploads(jpgfile);
		documentsScenarios.nextButton();
		documentsScenarios.VerifyFileUploadSucess();
	}
//	@Test//hold
//	public void ValidDocScenarios() throws Exception {
//		String a=" DocScenarios sta... ";
//		login.SigninNSUI();
//		documentsScenarios.autofilloff();
//		documentsScenarios.DocScenario();
//		documentsScenarios.Blankloginaccount(a);
//		documentsScenarios.RecipientSigner(1,"jeevithapatnana200@outlook.com"," SIGNER ");
//		documentsScenarios.Saveuser();
//		documentsScenarios.SignatureAndFullNameFeilds();
//		documentsScenarios.documentsScenarios.DradAndDropSigAndFullName(2,10,-20,10,10);
//		documentsScenarios.SubDocScenarios(a);
//		documentsScenarios.clickSubmit();
//		documentsScenarios.Verifysubmit();
//		documentsScenarios.Viewdocument();
//		documentsScenarios.Blankwithoutsenderautofill();
//		documentsScenarios.nsui();
//		documentsScenarios.clickLogout();
//		documentsScenarios.SigninNSUIJeevitha();
//		documentsScenarios.loginAccountDocumentClick();
//		recevierSide.signloginAccount();
//	}

//	// OneDrive-signerand CC WithOut
//	// EnforceSignatureOrderWithSenderAutofill-receiver Email Login
	@Test(priority = 21)
	public void ValidDocscenarioOnedrive() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
//		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.RecipientSigner(2, "prudhvib200@outlook.com", " CC ");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.outlooksigninpage();
		recevierSide.switchEmail();
		recevierSide.jeevithaOutlookloginPage();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCCTwo();

	}

//GoogleDrive-signerand CC WithOut EnforceSignatureOrderWithSenderAutofill-receiver Email Login
	@Test(priority = 22)
	public void ValidDocscenariosGdrive() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
//		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenariosGdrive();
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(3, "prudhvib200@outlook.com", "CC");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCCGdrive();

	}

// Blankdoc-RearrangingOrderCCndSigner-Without enforce signature order & Without
	// sender autofill-receiver Email Login
	@Test(priority = 23)
	public void ValidRearrangingOrderCCndSigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
//		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(3, "prudhvib200@outlook.com", "CC");
		documentsScenarios.RearrangeThreeOne();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// BlankDoc-MultipleSigners and cc-Without enforce signature order & Without
	// sender autofill-receiver Email Login
	@Test(priority = 24)
	public void ValidBlankDocMultipleSigners() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(3, "prudhvib200@outlook.com", "CC");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.VerifyDocCompleteReceiverEnd();

	}

//Onedrive-DocMultipleSigners-Without enforce signature order & Without sender autofill-receiver Email Login
	@Test(priority = 25)
	public void ValidOneDriveDocMultipleSigners() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.outlooksigninpage();
		recevierSide.switchEmail();
		recevierSide.jeevithaOutlookloginPage();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.VerifyDocCompleteReceiverEnd();

	}

	// BlankDoc-RearrangingOrderFirstOtherSignersndThenSender-Without enforce
	// signature order & Without sender autofill-receiver Email Login
	@Test(priority = 26)
	public void ValidRearrangingOrderFirstOtherSignersandThenSender() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.RearrangeZeroTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// Onedrive-RearrangingOrderFirstOtherSignersndThenSenderOnedrive-Without
	// enforce signature order & Without sender autofill-receiver Email Login
	@Test(priority = 27)
	public void ValidRearrangingOrderFirstOtherSignersndThenSenderOnedrive() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		login.VerifyLoginSucess();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.RearrangeZeroTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.outlooksigninpage();
		recevierSide.switchEmail();
		recevierSide.jeevithaOutlookloginPage();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.VerifyDocCompleteReceiverEnd();

	}

	// Blank DOc-SignerndApprover Without enforce signature order & Without sender
	// autofill-receiver Email Login
	@Test(priority = 28)
	public void ValidBlankdocSignerndApprover() throws Exception {
//		String doc = "SignerndApproverOnedrive";
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.VerifyDocCompleteReceiverEnd();

	}

//OneDrive-SignerndApproverOnedrive Without enforce signature order & Without sender autofill-receiver Email Login
	@Test(priority = 29)
	public void ValidSignerndApproverOnedrive() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.DocscenarioOnedrive();
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.outlooksigninpage();
		recevierSide.switchEmail();
		recevierSide.jeevithaOutlookloginPage();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.VerifyDocCompleteReceiverEnd();

	}

	// Blank Doc-RearrangingOrderFirstApproverthenSigner Without enforce signature
	// order & Without sender autofill-receiver Email Login
	@Test(priority = 30)
	public void ValidRearrangingOrderFirstApproverthenSigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.Rearrange();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// 9.Blank Doc- (Signer , Approver & CC)Without enforce signature order &
	// Without sender autofill-receiver Email Login
	@Test(priority = 31)
	public void ValidBlankDocSignerApproverAndCCWithoutEnforceSignature() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		login.VerifyLoginSucess();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.RecipientSigner(3, "prudhvib200@outlook.com", "CC");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// Blank Doc- (Signer, Multiple Approvers & CC)With/Without enforce signature
	// order & Without sender autofill--receiver Email Login
	@Test(priority = 32)
	public void ValidBlankDocSignerMulApproverAndCC() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		login.VerifyLoginSucess();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.multipleApprover();
		documentsScenarios.CCAtFour();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// Blank Doc- (Signer, Approvers& Multiple CC)With/Without enforce signature
	// order & Without sender autofill--receiver Email Login
	@Test(priority = 33)
	public void ValidBlankDocSignerApproverAndMultipleCC() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		login.VerifyLoginSucess();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.multipleCCThreeFour();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// Blank Doc- (Signer, Multiple Approvers & Multiple CC)With/Without enforce
	// signature order & Without sender autofill--receiver Email Login
	@Test(priority = 34)
	public void validBlankDocSignerMulApproverAndMulCC() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		login.VerifyLoginSucess();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.multipleApprover();
		documentsScenarios.multipleCCFourFive();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// 10.Blankdoc-Rearranging order first Approver and then Signer &&CC-Without
	// enforce signature order & Without sender autofill--receiver Email Login
	@Test(priority = 35)
	public void validBlankDocRearrangeorderApproverSignerAndCC() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		login.VerifyLoginSucess();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.RecipientSigner(3, "prudhvib200@outlook.com", "CC");
		documentsScenarios.Rearrange();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// 11.Rearranging order first CC and then Signer && Approver Without enforce
	// signature order & Without sender autofill--receiver Email Login
	@Test(priority = 36)
	public void validBlankDocRearrangeorderCCSignerApprover() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		login.VerifyLoginSucess();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.RecipientSigner(3, "prudhvib200@outlook.com", "CC");
		documentsScenarios.Rearrange();
		documentsScenarios.RearrangeThreeOne();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// 12.Rearranging order first Approver and then CC && Signer--receiver Email
	// Login
	@Test(priority = 37)
	public void validRearrangeorderApproverCCSigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		login.VerifyLoginSucess();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.RecipientSigner(3, "prudhvib200@outlook.com", "CC");
		documentsScenarios.Rearrange();
		documentsScenarios.RearrangeAtThreeTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// 13. Blank Doc-Rearranging order first Signer and then CC && Approver-Without
	// enforce signature order & Without sender autofill--receiver Email Login
	@Test(priority = 38)
	public void validBlankDocRearrangeorderSignerCCApprover() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		login.VerifyLoginSucess();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.RecipientSigner(3, "prudhvib200@outlook.com", "CC");
		documentsScenarios.RearrangeAtThreeTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// 14.Blank Doc-Rearranging order first CC and then Approver && Signer-Without
	// enforce signature order & Without sender autofill--receiver Email Login
	@Test(priority = 39)
	public void validBlankDocRearrangeorderCCApproversigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		login.VerifyLoginSucess();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
		documentsScenarios.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
		documentsScenarios.RecipientSigner(3, "prudhvib200@outlook.com", "CC");
		documentsScenarios.RearrangeThreeOne();
		documentsScenarios.RearrangeAtThreeTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// 15.Blank Doc-Multiple signers , approver&& CC Without enforce signature
	// order& Without sender autofill-receiver Email Login
	@Test(priority = 40)
	public void validBlankDocMulsignerApproverCC() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		login.VerifyLoginSucess();
//		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(3, "ramyas200@outlook.com", "APPROVER");
		documentsScenarios.RecipientSigner(4, "prudhvib200@outlook.com", "CC");
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
		recevierSide.validateAtCC(doc);

	}

	// 16.Rearranging order first Other Signers and then Sender Signer
	// &&Approver-Without enforce signature order & Without sender autofill-receiver
	// Email Login
	@Test(priority = 41)
	public void validBlankDocOtherSignerSenderSignerApprover() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		login.VerifyLoginSucess();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(3, "ramyas200@outlook.com", "APPROVER");
		documentsScenarios.RearrangeZeroTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// 17.Rearranging order first Approver and then Sender Signer && Other
	// Signers-receiver Email Login
	@Test(priority = 42)
	public void validBlankDocApproverSenderSignerOtherSigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		login.VerifyLoginSucess();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(3, "ramyas200@outlook.com", "APPROVER");
		documentsScenarios.RearrangeThreeOne();
		documentsScenarios.scrollUp();
		documentsScenarios.RearrangeSender();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// 18.Rearranging order first Other Signers and then Approver && Sender
	// Signer--receiver Email Login
	@Test(priority = 43)
	public void validBlankDocOtherSignerApproverSenderSigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		login.VerifyLoginSucess();
		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(3, "ramyas200@outlook.com", "APPROVER");
		documentsScenarios.RearrangeZeroTwo();
		documentsScenarios.scrollDown();
		documentsScenarios.RearrangeAtThreeTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	// 19.Rearranging order first Sender Signer and then Approver && Other
	// Signers-receiver Email Login
	@Test(priority = 44)
	public void validBlankDocSenderSignerApproverOtherSigner() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		login.VerifyLoginSucess();
//		documentsScenarios.autofilloff();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
		documentsScenarios.RecipientSigner(3, "ramyas200@outlook.com", "APPROVER");
		documentsScenarios.RearrangeThreeOne();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
		documentsScenarios.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		documentsScenarios.Viewdocument();
		documentsScenarios.Blankwithoutsenderautofill();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignApprover();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

	@Test(priority = 45)
	public void uploadVedio() throws Exception {
		String vediofile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\vedio.exe\"";
		login.SigninNSUI();
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(vediofile);
		documentsScenarios.nextButton();
	}

	// 3.Reuploading a completed Esigns ID Generated DOC
	@Test(priority = 46)
	public void ReuploadingCompletedEsignsIDGeneratedDOC() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		String file = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\fileupload1.exe\"";
		login.SigninNSUI();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(file);
		documentsScenarios.nextButton();
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.VerifyDocCompleteReceiverEnd();
	}

//	(All These in Change Document also)
	@Test(priority = 47)
	public void changeDocument() throws InterruptedException, Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		String file = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\fileupload1.exe\"";
		login.SigninNSUI();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(file);
		documentsScenarios.nextButton();
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.changeDoc();
		documentsScenarios.FileuploadTwo();
		documentsScenarios.clickContinue();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
		recevierSide.jeevithaOutlooklogin();
		recevierSide.clickEmail(doc);
		recevierSide.reviewandSignSigner();
		recevierSide.VerifyDocCompleteReceiverEnd();

	}

//	5.Attachment Downloads
//hold
	@Test(priority = 48)
	public void attachmentDownloads() throws Exception {
		String file = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\fileupload1.exe\"";
		login.SigninNSUI();
		login.VerifyLoginSucess();
		documentsScenarios.DocScenario();
		documentsScenarios.Fileuploads(file);
		documentsScenarios.nextButton();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.dragRequestDocFeild();
		documentsScenarios.FileuploadTwo();
		documentsScenarios.save();
		documentsScenarios.clickFinishDoc();
		documentsScenarios.viewDocandDownload();

	}

//	// drag and drop feilds after adding the form template to the company profile
	@Test(priority = 49)
	public void contentFeildsCompanyProfile() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		login.VerifyLoginSucess();
//		entities.FormTemplate();
//		entities.CreateFormtemplate(doc);
//		entities.templateContentFeilds();
//		entities.submit();
//		entities.contentFeildsDragAndDrop();
//		entities.companyProfile();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankloginaccount(doc);
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Saveuser();
		documentsScenarios.DragContentFeildsCompanyProfile();
		documentsScenarios.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
		documentsScenarios.SubDocScenarios(doc);
		documentsScenarios.clickSubmit();
		documentsScenarios.Verifysubmit();
	}

	@Test(priority = 50, enabled = false)
	public void BasicfeildsCompanyProfile() throws Exception {
		UUID uuid = UUID.randomUUID();
		String doc = uuid.toString().replaceAll("-", "");
		login.SigninNSUI();
		login.VerifyLoginSucess();
		documentsScenarios.FormTemplate();
		documentsScenarios.CreateFormtemplate(doc);
		// documentsScenarios.templateBasicFeilds();
		documentsScenarios.submit();
		// documentsScenarios.basicFeilds();
		documentsScenarios.companyProfile();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
		documentsScenarios.Saveuser();
//		documentsScenarios.DragContentFeildsCompanyProfile();
//		documentsScenarios.DradAndDropSigAndFullName(2,10,-20,10,10);
//		documentsScenarios.Senddoc();
//		documentsScenarios.Verifysubmit();
	}

//
//	@Test
//	public void AdvancedFieldsCompanyProfile() throws Exception {
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		entities.FormTemplate();
//		entities.CreateFormtemplate();
//		entities.templateAdvancedFeilds();
//		entities.submit();
//		entities.advancedFeilds();
//		entities.companyProfile();
//		documentsScenarios.DocScenario();
//		documentsScenarios.Blankdocloginaccount();
//		addrecipients.Recipients();
//		documentsScenarios.Saveuser();
//		documentsScenarios.DragContentFeildsCompanyProfile();
//		documentsScenarios.DradAndDropSigAndFullName(2,10,-20,10,10);
//		documentsScenarios.Senddoc();
//		documentsScenarios.Verifysubmit();
//	}

	@AfterMethod
	public void quit() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
