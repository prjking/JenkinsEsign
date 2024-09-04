package TestCase;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import Pages.Addrecipients;
import Pages.Alldocuments;
import Pages.Dashboard;
import Pages.DocumentsScenarios;
import Pages.Dragdrop;
import Pages.FormTemplate;
import Pages.Login;
import Pages.RecevierSide;
import Pages.ReviewaNdSend;
import Pages.Scrool;
import Pages.Signup;
import Pages.TemplateScenarios;
import Pages.Templatespage;
import Pages.Uploaddocuments;
import Reports.TestNGExtentReport;
import Reports.Testlistner;
import TestBase.testCaseBase;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners({ TestNGExtentReport.class, Testlistner.class })
public class LoginPageTest extends testCaseBase {
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
	Scrool scrool;

	public void setupDriver() {
		 driver = new ChromeDriver(getChromeOptions());

//		ChromeOptions options = new ChromeOptions();
//		Map<String, Object> prefs = new HashMap<>();
//		Map<String, Object> profile = new HashMap<>();
//		Map<String, Object> contentSettings = new HashMap<>();
//		contentSettings.put("notifications", 1);
//		contentSettings.put("clipboard", 1);
//		profile.put("managed_default_content_settings", contentSettings);
//		prefs.put("profile", profile);
//		options.setExperimentalOption("prefs", prefs);
		// driver = new ChromeDriver(Opions);
	//	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.esigns.io/signin");
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
		scrool = new Scrool(driver);

	}

//	@Test
//	public void Signupverify() throws Exception {
//		signup.Newsignind();
//
//	}
//
//	@Test
//
//	public void verifyloginwithValidCredentials() throws InterruptedException {
//		login.Signin();
//		login.VerifyLoginSucess();
//
//	}
//
//	@Test
//	public void Document() throws InterruptedException {
//		login.Signin();
//		login.VerifyLoginSucess();
//		alldocuments.Createdocument();
//		alldocuments.Validdocument();
//	}
//
//	@Test
//	public void Upload() throws Exception {
//		login.Signin();
//		login.VerifyLoginSucess();
//		alldocuments.Createdocument();
//		alldocuments.Validdocument();
//		uploaddocuments.Dropbox();
//		// uploaddocuments.Fileupload();
//		// uploaddocuments.VerifyUpload();
//	}
//
//	@Test
//	public void AddingRecipients() throws Exception {
//		login.Signin();
//		login.VerifyLoginSucess();
//		alldocuments.Createdocument();
//		alldocuments.Validdocument();
//		uploaddocuments.Fileupload();
//		addrecipients.Recipients();
//		addrecipients.Recipients1();
//		addrecipients.MoreFields();
//		addrecipients.Verifrecipient();
//
//	}
//
//	@Test
//	public void Drag() throws Exception {
//		login.Signin();
//		login.VerifyLoginSucess();
//		alldocuments.Createdocument();
//		alldocuments.Validdocument();
//		uploaddocuments.Fileupload();
//		addrecipients.Recipients();
//		dragdrop.EssentialFields();
//		dragdrop.Contentfields();
//		dragdrop.Draw();
//		dragdrop.image();
//		dragdrop.send();
//
//	}

//	@Test
	// public void Review() throws Exception {
	// login.Signin();
	// login.VerifyLoginSucess();
//		alldocuments.Createdocument();
//		alldocuments.Validdocument();
//		// uploaddocuments.Fileupload();
//		uploaddocuments.Blankdoc();
//		addrecipients.Recipients();
//		addrecipients.Recipients1();
//		addrecipients.Verifrecipient();
//		dragdrop.EssentialFields();
//		dragdrop.Contentfields();
//		dragdrop.Draw();
//		// dragdrop.image();
//		dragdrop.send();
//		reviewaNdSend.submit();
	// }

//	@Test
//	public void ValidRecevierSide() throws Exception {
//		recevierSide.CheckRecevierSide();
//
//	}

//	@Test
//	public void ValidTemplates() throws Exception {
//		login.Signin();
//		templatespage.Temp();
//		templatespage.EditTemp();
//		templatespage.SendTocontacts();
//		templatespage.Addnew();
//		templatespage.Send();
//		templatespage.ConfirmationAlert();
//		templatespage.BulkSend();
//		templatespage.ValidBulk();
//		templatespage.Getlink();
//		templatespage.Share();
//		templatespage.Settings();
//		templatespage.ChangeOwner();
//		templatespage.Viewdata();
//		templatespage.DuplicateTemplate();
//		templatespage.RenameTemplate();
//		templatespage.inactive();
//		templatespage.Delete();
//		templatespage.Creategroup();
//
//	
	@Test
	public void Verifyscrool() throws Exception {
		login.Signin();
//		login.VerifyLoginSucess();
//		scrool.AllCombos();
//		scrool.BlankDoc();
//		scrool.AddRep();
//		scrool.AddSigner();
//		scrool.Saveuser();
//		scrool.Receiverfields();
//		scrool.Senddocument();
//		scrool.Yahoomail();
		// scrool.autofill(true);

	}

	@Test
	public void addbuilder() throws Exception {
	//	scrool.Signinjp();
//		scrool.Addformbuilder();
//		scrool.ViewFormbuilder();
//		scrool.Addmail("Ramya","Sibbala","ramyas200@outlook.com");
//		scrool.DatatoFormbuilder();
//		scrool.Finishformbuilder();
//		scrool.prudhvioutlooklogin();
//		scrool.clickEmail("Approval request");
//		scrool.Reviewandapproveformbuilder();
		scrool.FineDueNotificationEntityActions();
//                                                                                               	
//
	}
}
