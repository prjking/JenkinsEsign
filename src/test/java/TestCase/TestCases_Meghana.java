//package TestCase;
//
//import java.util.UUID;
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import Pages.Addrecipients;
//import Pages.Alldocuments;
//import Pages.Dashboard;
//import Pages.DocumentsScenarios1;
//import Pages.documentsScenarios1;
//import Pages.Dragdrop;
//import Pages.Entities;
//import Pages.Login;
//import Pages.RecevierSide;
//import Pages.ReviewaNdSend;
//import Pages.Signup;
//import Pages.Templatespage;
//import Pages.Uploaddocuments;
//import TestBase.testCaseBase;
//
//public class TestCases_Meghana extends testCaseBase {
//	Login login;
//	Alldocuments alldocuments;
//	Uploaddocuments uploaddocuments;
//	Addrecipients addrecipients;
//	Dragdrop dragdrop;
//	ReviewaNdSend reviewaNdSend;
//	RecevierSide recevierSide;
//	Signup signup;
//	Templatespage templatespage;
//	Dashboard dashboard;
//	DocumentsScenarios1 documentsScenarios1;
//	Entities entities;
//	RecevierSide receiverSide;
//	Templatespage template;
//
//	@BeforeMethod
//	public void Start() {
//		setup();
//		login = new Login(driver);
//		alldocuments = new Alldocuments(driver);
//		uploaddocuments = new Uploaddocuments(driver);
//		addrecipients = new Addrecipients(driver);
//		dragdrop = new Dragdrop(driver);
//		reviewaNdSend = new ReviewaNdSend(driver);
//		recevierSide = new RecevierSide(driver);
//		signup = new Signup(driver);
//		templatespage = new Templatespage(driver);
//		dashboard = new Dashboard(driver);
//		documentsScenarios1 = new DocumentsScenarios1(driver);
//		entities = new Entities(driver);
//		receiverSide = new RecevierSide(driver);
//		template = new Templatespage(driver);
//
//	}
//
//	// 3a,Blank Doc – Sender signer & Receiver signer (With enforcement)send
//	// document with uploading blank doc for Sender & Receiver (Complete through
//	// login from
//	// sender & Complete through from mail receiver)
//	@Test(priority = 1)
//	public void BlankDocWithEnforcement() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//	}
//
//	// yes
//	// 3bsend document with uploading blank doc for Sender & Receiver(Complete
//	// through
//	// login from sender & Complete through from mail receiver & sender autofill
//	// enabled)
//	@Test(priority = 2)
//	public void BlankDocWithEnforcementWithAutofill() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		documentsScenarios1.autofillon();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//	}
//
//	// yes
//	// 3c
//	@Test(priority = 3)
//	public void BlankDocWithEnforcementWithoutAutofill() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//	}
//
//	// yes
//	// 4a
//	// Blank Doc – Sender signer & Receiver signer (With enforcement)send document
//	// with uploading blank doc for Sender & Receiver (Complete through login from
//	// sender & Complete through from mail receiver)
//	@Test(priority = 4)
//	public void BlankDocWithtEnforcement() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.Signorder();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//	}
//
//	// yes
//	// 4b
//	// send document with uploading blank doc for Sender & Receiver(Complete through
//	// login from sender & Complete through from mail receiver & sender autofill
//	// enabled)
//	@Test(priority = 5)
//	public void BlankDocWithoEnforcementWithAutofill() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		documentsScenarios1.autofillon();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.Signorder();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//	}
//
//	// 6yes
//	// 4c
//	@Test(priority = 6)
//	public void BlankDocWithoutEnforcementWithoutAutofill() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.Signorder();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//	}
//
//	// 5a
//	@Test(priority = 7)
//	public void uploadpdfFile() throws Exception {
//		String pdffile = "C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\PDFFile.exe";
//		login.SigninNSUI();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Fileuploads(pdffile);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.VerifyFileUploadSucess();
//	}
//
//	@Test(priority = 8)
//	public void uploadDoc() throws Exception {
//		String Wordfile = "C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\WordFile.exe";
//		login.SigninNSUI();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Fileuploads(Wordfile);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.VerifyFileUploadSucess();
//	}
//
//	@Test(priority = 9)
//	public void uploadPNG() throws Exception {
//		String PNGfile = "C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\pngFile.exe";
//		login.SigninNSUI();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Fileuploads(PNGfile);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.VerifyFileUploadSucess();
//	}
//
//	@Test(priority = 10)
//	public void uploadjpg() throws Exception {
//		String jpgfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\jpgFile.exe\"";
//		login.SigninNSUI();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Fileuploads(jpgfile);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.VerifyFileUploadSucess();
//	} 
//
//	@Test(priority = 11)
//	public void uploadTXT() throws Exception {
//		String txtfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\TXTFile.exe\"";
//		login.SigninNSUI();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Fileuploads(txtfile);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.VerifyFileUploadSucess();
//	}
//
//	// When we upload combination of PDF & DOC files and click on next it needs to
//	// navigate users page
//	@Test(priority = 12)
//	public void uploadPDFandDoc() throws Exception {
//		String pdffile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\PDFFile.exe\"";
//		String Wordfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\WordFile.exe\"";
//		login.SigninNSUI();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Fileuploads(pdffile);
//		documentsScenarios1.Fileuploads(Wordfile);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.VerifyFileUploadSucess();
//	}
//
//	// When we upload combination of DOC & DOC files and click on next it needs to
//	// navigate users page
//	@Test(priority = 13)
//	public void uploadDocandDoc() throws Exception {
//		String word2file = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\wordFile2.exe\"";
//		String Wordfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\WordFile.exe\"";
//		login.SigninNSUI();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Fileuploads(word2file);
//		documentsScenarios1.Fileuploads(Wordfile);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.VerifyFileUploadSucess();
//	}
//
//	// When we upload combination of DOC & TXT files and click on next it needs to
//	// navigate users page
//	@Test(priority = 14)
//	public void uploadDOCandTXT() throws Exception {
//		String TXTfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\TXTFile.exe\"";
//		String Wordfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\WordFile.exe\"";
//		login.SigninNSUI();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Fileuploads(Wordfile);
//		documentsScenarios1.Fileuploads(TXTfile);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.VerifyFileUploadSucess();
//	}
//
//	// When we upload combination of PDF& PDF files and click on next it needs to
//	// navigate users page
//	@Test(priority = 15)
//	public void uploadPDFandPDF() throws Exception {
//		String pdffile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\PDFFile.exe\"";
//		String pdffile2 = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\fileupload1.exe\"";
//		login.SigninNSUI();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Fileuploads(pdffile);
//		documentsScenarios1.Fileuploads(pdffile2);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.VerifyFileUploadSucess();
//	}
//
//	// When we upload combination of PDF & TXT files and click on next it needs to
//	// navigate users page
//	@Test(priority = 16)
//	public void uploadPDFandTXT() throws Exception {
//		String pdffile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\PDFFile.exe\"";
//		String txtfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\TXTFile.exe\"";
//		login.SigninNSUI();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Fileuploads(pdffile);
//		documentsScenarios1.Fileuploads(txtfile);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.VerifyFileUploadSucess();
//	}
//
//	// When we upload combination of DOC & PNG files and click on next it needs to
//	// navigate users page
//	@Test(priority = 17)
//	public void uploadDOCandPNG() throws Exception {
//		String Wordfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\WordFile.exe\"";
//		String PNGfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\pngFile.exe\"";
//		login.SigninNSUI();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Fileuploads(Wordfile);
//		documentsScenarios1.Fileuploads(PNGfile);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.VerifyFileUploadSucess();
//	}
//
//	// When we upload combination of PDF & DOC files and click on next it needs to
//	// navigate users page
//	@Test(priority = 18)
//	public void uploadPDFandDOC() throws Exception {
//		String pdffile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\PDFFile.exe\"";
//		String Wordfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\WordFile.exe\"";
//		login.SigninNSUI();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Fileuploads(pdffile);
//		documentsScenarios1.Fileuploads(Wordfile);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.VerifyFileUploadSucess();
//	}
//
//	// When we upload combination of DOC & JPG files and click on next it needs to
//	// navigate users page
//	@Test(priority = 19)
//	public void uploadDOCandJPG() throws Exception {
//		String Wordfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\WordFile.exe\"";
//		String jpgfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\jpgFile.exe\"";
//		login.SigninNSUI();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Fileuploads(Wordfile);
//		documentsScenarios1.Fileuploads(jpgfile);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.VerifyFileUploadSucess();
//	}
//
//	// When we upload combination of PDF & JPG files and click on next it needs to
//	// navigate users page
//	@Test(priority = 20)
//	public void uploadPDFandJPG() throws Exception {
//		String pdffile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\PDFFile.exe\"";
//		String jpgfile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\jpgFile.exe\"";
//		login.SigninNSUI();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Fileuploads(pdffile);
//		documentsScenarios1.Fileuploads(jpgfile);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.VerifyFileUploadSucess();
//	}
////	@Test//hold
////	public void ValidDocScenarios() throws Exception {
////		String a=" DocScenarios sta... ";
////		login.SigninNSUI();
////		documentsScenarios1.autofilloff();
////		documentsScenarios1.DocScenario();
////		documentsScenarios1.Blankloginaccount(a);
////		documentsScenarios1.RecipientSigner(1,"jeevithapatnana200@outlook.com"," SIGNER ");
////		documentsScenarios1.Saveuser();
////		documentsScenarios1.SignatureAndFullNameFeilds();
////		documentsScenarios1.documentsScenarios1.DradAndDropSigAndFullName(2,10,-20,10,10);
////		documentsScenarios1.SubDocScenarios(a);
////		documentsScenarios1.clickSubmit();
////		documentsScenarios1.Verifysubmit();
////		documentsScenarios1.Viewdocument();
////		documentsScenarios1.Blankwithoutsenderautofill();
////		documentsScenarios1.nsui();
////		documentsScenarios1.clickLogout();
////		documentsScenarios1.SigninNSUIJeevitha();
////		documentsScenarios1.loginAccountDocumentClick();
////		recevierSide.signloginAccount();
////	}
//
////	// OneDrive-signerand CC WithOut
////	// EnforceSignatureOrderWithSenderAutofill-receiver Email Login
//	@Test(priority = 21)
//	public void ValidDocscenarioOnedrive() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
////		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.DocscenarioOnedrive();
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.RecipientSigner(2, "prudhvib200@outlook.com", " CC ");
//		documentsScenarios1.Signorder();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.outlooksigninpage();
//		recevierSide.switchEmail();
//		recevierSide.jeevithaOutlookloginPage();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
//		recevierSide.validateAtCCTwo();
//
//	}
//
////GoogleDrive-signerand CC WithOut EnforceSignatureOrderWithSenderAutofill-receiver Email Login
//	@Test(priority = 22)
//	public void ValidDocscenariosGdrive() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
////		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.DocscenariosGdrive();
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(3, "prudhvib200@outlook.com", "CC");
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
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
//		recevierSide.validateAtCCGdrive();
//
//	}
//
//// Blankdoc-RearrangingOrderCCndSigner-Without enforce signature order & Without
//	// sender autofill-receiver Email Login
//	@Test(priority = 23)
//	public void ValidRearrangingOrderCCndSigner() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
////		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(3, "prudhvib200@outlook.com", "CC");
//		documentsScenarios1.RearrangeThreeOne();
//		documentsScenarios1.Signorder();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
//		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
//		recevierSide.validateAtCC(doc);
//
//	}
//
//	// BlankDoc-MultipleSigners and cc-Without enforce signature order & Without
//	// sender autofill-receiver Email Login
//	@Test(priority = 24)
//	public void ValidBlankDocMultipleSigners() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(3, "prudhvib200@outlook.com", "CC");
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
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//
//	}
//
////Onedrive-DocMultipleSigners-Without enforce signature order & Without sender autofill-receiver Email Login
//	@Test(priority = 25)
//	public void ValidOneDriveDocMultipleSigners() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.DocscenarioOnedrive();
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
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
//		recevierSide.outlooksigninpage();
//		recevierSide.switchEmail();
//		recevierSide.jeevithaOutlookloginPage();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//
//	}
//
//	// BlankDoc-RearrangingOrderFirstOtherSignersndThenSender-Without enforce
//	// signature order & Without sender autofill-receiver Email Login
//	@Test(priority = 26)
//	public void ValidRearrangingOrderFirstOtherSignersandThenSender() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
//		documentsScenarios1.RearrangeZeroTwo();
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
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//	}
//
//	// Onedrive-RearrangingOrderFirstOtherSignersndThenSenderOnedrive-Without
//	// enforce signature order & Without sender autofill-receiver Email Login
//	@Test(priority = 27)
//	public void ValidRearrangingOrderFirstOtherSignersndThenSenderOnedrive() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.DocscenarioOnedrive();
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
//		documentsScenarios1.RearrangeZeroTwo();
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
//		recevierSide.outlooksigninpage();
//		recevierSide.switchEmail();
//		recevierSide.jeevithaOutlookloginPage();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//
//	}
//
//	// Blank DOc-SignerndApprover Without enforce signature order & Without sender
//	// autofill-receiver Email Login
//	@Test(priority = 28)
//	public void ValidBlankdocSignerndApprover() throws Exception {
////		String doc = "SignerndApproverOnedrive";
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
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
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//
//	}
//
////OneDrive-SignerndApproverOnedrive Without enforce signature order & Without sender autofill-receiver Email Login
//	@Test(priority = 29)
//	public void ValidSignerndApproverOnedrive() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.DocscenarioOnedrive();
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
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
//		recevierSide.outlooksigninpage();
//		recevierSide.switchEmail();
//		recevierSide.jeevithaOutlookloginPage();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//
//	}
//
//	// Blank Doc-RearrangingOrderFirstApproverthenSigner Without enforce signature
//	// order & Without sender autofill-receiver Email Login
//	@Test(priority = 30)
//	public void ValidRearrangingOrderFirstApproverthenSigner() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
//		documentsScenarios1.Rearrange();
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
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//	}
//
//	// 9.Blank Doc- (Signer , Approver & CC)Without enforce signature order &
//	// Without sender autofill-receiver Email Login
//	@Test(priority = 31)
//	public void ValidBlankDocSignerApproverAndCCWithoutEnforceSignature() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
//		documentsScenarios1.RecipientSigner(3, "prudhvib200@outlook.com", "CC");
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
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
//		recevierSide.validateAtCC(doc);
//
//	}
//
//	// Blank Doc- (Signer, Multiple Approvers & CC)With/Without enforce signature
//	// order & Without sender autofill--receiver Email Login
//	@Test(priority = 32)
//	public void ValidBlankDocSignerMulApproverAndCC() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.multipleApprover();
//		documentsScenarios1.CCAtFour();
//		documentsScenarios1.Signorder();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
//		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
//		recevierSide.validateAtCC(doc);
//
//	}
//
//	// Blank Doc- (Signer, Approvers& Multiple CC)With/Without enforce signature
//	// order & Without sender autofill--receiver Email Login
//	@Test(priority = 33)
//	public void ValidBlankDocSignerApproverAndMultipleCC() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
//		documentsScenarios1.multipleCCThreeFour();
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
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
//		recevierSide.validateAtCC(doc);
//		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
//		recevierSide.validateAtCC(doc);
//
//	}
//
//	// Blank Doc- (Signer, Multiple Approvers & Multiple CC)With/Without enforce
//	// signature order & Without sender autofill--receiver Email Login
//	@Test(priority = 34)
//	public void validBlankDocSignerMulApproverAndMulCC() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.multipleApprover();
//		documentsScenarios1.multipleCCFourFive();
//		documentsScenarios1.Signorder();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
//		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
//		recevierSide.validateAtCC(doc);
//
//	}
//
//	// 10.Blankdoc-Rearranging order first Approver and then Signer &&CC-Without
//	// enforce signature order & Without sender autofill--receiver Email Login
//	@Test(priority = 35)
//	public void validBlankDocRearrangeorderApproverSignerAndCC() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
//		documentsScenarios1.RecipientSigner(3, "prudhvib200@outlook.com", "CC");
//		documentsScenarios1.Rearrange();
//		documentsScenarios1.Signorder();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
//		recevierSide.validateAtCC(doc);
//
//	}
//
//	// 11.Rearranging order first CC and then Signer && Approver Without enforce
//	// signature order & Without sender autofill--receiver Email Login
//	@Test(priority = 36)
//	public void validBlankDocRearrangeorderCCSignerApprover() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
//		documentsScenarios1.RecipientSigner(3, "prudhvib200@outlook.com", "CC");
//		documentsScenarios1.Rearrange();
//		documentsScenarios1.RearrangeThreeOne();
//		documentsScenarios1.Signorder();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
//		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
//		recevierSide.validateAtCC(doc);
//
//	}
//
//	// 12.Rearranging order first Approver and then CC && Signer--receiver Email
//	// Login
//	@Test(priority = 37)
//	public void validRearrangeorderApproverCCSigner() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
//		documentsScenarios1.RecipientSigner(3, "prudhvib200@outlook.com", "CC");
//		documentsScenarios1.Rearrange();
//		documentsScenarios1.RearrangeAtThreeTwo();
//		documentsScenarios1.Signorder();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
//		recevierSide.validateAtCC(doc);
//
//	}
//
//	// 13. Blank Doc-Rearranging order first Signer and then CC && Approver-Without
//	// enforce signature order & Without sender autofill--receiver Email Login
//	@Test(priority = 38)
//	public void validBlankDocRearrangeorderSignerCCApprover() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
//		documentsScenarios1.RecipientSigner(3, "prudhvib200@outlook.com", "CC");
//		documentsScenarios1.RearrangeAtThreeTwo();
//		documentsScenarios1.Signorder();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
//		recevierSide.validateAtCC(doc);
//
//	}
//
//	// 14.Blank Doc-Rearranging order first CC and then Approver && Signer-Without
//	// enforce signature order & Without sender autofill--receiver Email Login
//	@Test(priority = 39)
//	public void validBlankDocRearrangeorderCCApproversigner() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", " SIGNER ");
//		documentsScenarios1.RecipientSigner(2, "ramyasibbala200@outlook.com", " APPROVER ");
//		documentsScenarios1.RecipientSigner(3, "prudhvib200@outlook.com", "CC");
//		documentsScenarios1.RearrangeThreeOne();
//		documentsScenarios1.RearrangeAtThreeTwo();
//		documentsScenarios1.Signorder();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
//		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("ramyasibbala200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
//		recevierSide.validateAtCC(doc);
//
//	}
//
//	// 15.Blank Doc-Multiple signers , approver&& CC Without enforce signature
//	// order& Without sender autofill-receiver Email Login
//	@Test(priority = 40)
//	public void validBlankDocMulsignerApproverCC() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
////		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(3, "ramyas200@outlook.com", "APPROVER");
//		documentsScenarios1.RecipientSigner(4, "prudhvib200@outlook.com", "CC");
//		documentsScenarios1.Signorder();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
//		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.Outlooklogin("prudhvib200@outlook.com", "Meghana@123");
//		recevierSide.validateAtCC(doc);
//
//	}
//
//	// 16.Rearranging order first Other Signers and then Sender Signer
//	// &&Approver-Without enforce signature order & Without sender autofill-receiver
//	// Email Login
//	@Test(priority = 41)
//	public void validBlankDocOtherSignerSenderSignerApprover() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(3, "ramyas200@outlook.com", "APPROVER");
//		documentsScenarios1.RearrangeZeroTwo();
//		documentsScenarios1.Signorder();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
//		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//	}
//
//	// 17.Rearranging order first Approver and then Sender Signer && Other
//	// Signers-receiver Email Login
//	@Test(priority = 42)
//	public void validBlankDocApproverSenderSignerOtherSigner() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(3, "ramyas200@outlook.com", "APPROVER");
//		documentsScenarios1.RearrangeThreeOne();
//		documentsScenarios1.scrollUp();
//		documentsScenarios1.RearrangeSender();
//		documentsScenarios1.Signorder();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
//		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//	}
//
//	// 18.Rearranging order first Other Signers and then Approver && Sender
//	// Signer--receiver Email Login
//	@Test(priority = 43)
//	public void validBlankDocOtherSignerApproverSenderSigner() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(3, "ramyas200@outlook.com", "APPROVER");
//		documentsScenarios1.RearrangeZeroTwo();
//		documentsScenarios1.scrollDown();
//		documentsScenarios1.RearrangeAtThreeTwo();
//		documentsScenarios1.Signorder();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
//		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//	}
//
//	// 19.Rearranging order first Sender Signer and then Approver && Other
//	// Signers-receiver Email Login
//	@Test(priority = 44)
//	public void validBlankDocSenderSignerApproverOtherSigner() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
////		documentsScenarios1.autofilloff();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(2, "meghanan180894@outlook.com", "SIGNER");
//		documentsScenarios1.RecipientSigner(3, "ramyas200@outlook.com", "APPROVER");
//		documentsScenarios1.RearrangeThreeOne();
//		documentsScenarios1.Signorder();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.DradAndDropSigAndFullName(3, 10, 60, 10, 90);
//		documentsScenarios1.DradAndDropSigAndFullName(4, 10, 130, 10, 160);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		documentsScenarios1.Viewdocument();
//		documentsScenarios1.Blankwithoutsenderautofill();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("meghanan180894@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.Outlooklogin("ramyas200@outlook.com", "Meghana@123");
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignApprover();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//	}
//
//	@Test(priority = 45)
//	public void uploadVedio() throws Exception {
//		String vediofile = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\vedio.exe\"";
//		login.SigninNSUI();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Fileuploads(vediofile);
//		documentsScenarios1.nextButton();
//	}
//
//	// 3.Reuploading a completed Esigns ID Generated DOC
//	@Test(priority = 46)
//	public void ReuploadingCompletedEsignsIDGeneratedDOC() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		String file = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\fileupload1.exe\"";
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Fileuploads(file);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//	}
//
////	(All These in Change Document also)
//	@Test(priority = 47)
//	public void changeDocument() throws InterruptedException, Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		String file = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\fileupload1.exe\"";
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Fileuploads(file);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.changeDoc();
//		documentsScenarios1.FileuploadTwo();
//		documentsScenarios1.clickContinue();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//		recevierSide.jeevithaOutlooklogin();
//		recevierSide.clickEmail(doc);
//		recevierSide.reviewandSignSigner();
//		recevierSide.VerifyDocCompleteReceiverEnd();
//
//	}
//
////	5.Attachment Downloads
////hold
//	@Test(priority = 48)
//	public void attachmentDownloads() throws Exception {
//		String file = "\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\fileupload1.exe\"";
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Fileuploads(file);
//		documentsScenarios1.nextButton();
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.SignatureAndFullNameFeilds();
//		documentsScenarios1.dragRequestDocFeild();
//		documentsScenarios1.FileuploadTwo();
//		documentsScenarios1.save();
//		documentsScenarios1.clickFinishDoc();
//		documentsScenarios1.viewDocandDownload();
//
//	}
//
////	// drag and drop feilds after adding the form template to the company profile
//	@Test(priority = 49)
//	public void contentFeildsCompanyProfile() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
////		entities.FormTemplate();
////		entities.CreateFormtemplate(doc);
////		entities.templateContentFeilds();
////		entities.submit();
////		entities.contentFeildsDragAndDrop();
////		entities.companyProfile();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankloginaccount(doc);
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.Saveuser();
//		documentsScenarios1.DragContentFeildsCompanyProfile();
//		documentsScenarios1.DradAndDropSigAndFullName(2, 10, -20, 10, 10);
//		documentsScenarios1.SubDocScenarios(doc);
//		documentsScenarios1.clickSubmit();
//		documentsScenarios1.Verifysubmit();
//	}
//
//	@Test(priority = 50, enabled = false)
//	public void BasicfeildsCompanyProfile() throws Exception {
//		UUID uuid = UUID.randomUUID();
//		String doc = uuid.toString().replaceAll("-", "");
//		login.SigninNSUI();
//		login.VerifyLoginSucess();
//		documentsScenarios1.FormTemplate();
//		documentsScenarios1.CreateFormtemplate(doc);
//		// documentsScenarios1.templateBasicFeilds();
//		documentsScenarios1.submit();
//		// documentsScenarios1.basicFeilds();
//		documentsScenarios1.companyProfile();
//		documentsScenarios1.DocScenario();
//		documentsScenarios1.Blankdocloginaccount();
//		documentsScenarios1.RecipientSigner(1, "jeevithapatnana200@outlook.com", "SIGNER");
//		documentsScenarios1.Saveuser();
////		documentsScenarios1.DragContentFeildsCompanyProfile();
////		documentsScenarios1.DradAndDropSigAndFullName(2,10,-20,10,10);
////		documentsScenarios1.Senddoc();
////		documentsScenarios1.Verifysubmit();
//	}
//
////
////	@Test
////	public void AdvancedFieldsCompanyProfile() throws Exception {
////		login.SigninNSUI();
////		login.VerifyLoginSucess();
////		entities.FormTemplate();
////		entities.CreateFormtemplate();
////		entities.templateAdvancedFeilds();
////		entities.submit();
////		entities.advancedFeilds();
////		entities.companyProfile();
////		documentsScenarios1.DocScenario();
////		documentsScenarios1.Blankdocloginaccount();
////		addrecipients.Recipients();
////		documentsScenarios1.Saveuser();
////		documentsScenarios1.DragContentFeildsCompanyProfile();
////		documentsScenarios1.DradAndDropSigAndFullName(2,10,-20,10,10);
////		documentsScenarios1.Senddoc();
////		documentsScenarios1.Verifysubmit();
////	}
//
//	@AfterMethod
//	public void quit() throws Exception {
//		Thread.sleep(1000);
//		driver.quit();
//	}
//
//}
