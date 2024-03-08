
package TestCase;
import Reports.TestNGExtentReport;
import Reports.Testlistner;
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
import Pages.Scrool;
import Pages.Signup;
import Pages.TemplateScenarios;
import Pages.Templatespage;
import Pages.Uploaddocuments;
import TestBase.testCaseBase;

@Listeners({ TestNGExtentReport.class, Testlistner.class })
public class Template_Testcase extends testCaseBase {

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

	}

	@Test
	public void ValidBlankTemplate() throws Exception {
		login.Signin();
		templatespage.Temp();
		templateScenarios.Creatempwithautofill();
		documentsScenarios.EssentialFields();
		templateScenarios.Creatdoc();
		templateScenarios.AddRecipients();
		documentsScenarios.Saveuser();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	@Test
	public void validCreatingNewContact() throws Exception {
		login.Signin();
		templatespage.Temp();
		templateScenarios.CreatingNewContactDocument();

	}

	@Test
	public void ValidSendtoContact() throws Exception {
		login.Signin();
		templatespage.Temp();
		templateScenarios.SendtoConatct();
	}

	@Test
	public void ValidBulksend() throws Exception {
		login.Signin();
		templatespage.Temp();
		templateScenarios.Bulksend();
	}

	@Test
	public void ValidGetlinkaccessToall() throws Exception {
		login.Signin();
		templatespage.Temp();
		templateScenarios.GetlinkaccessToall();
	}

	@Test
	public void ValidObserveStatofTheTemplate() throws Exception {
		login.Signin();
		templatespage.Temp();
		templateScenarios.ObserveStatofTheTemplate();
	}

	@Test
	public void ValidShareWithNew() throws Exception {
		login.Signin();
		templatespage.Temp();
		templateScenarios.ShareWithNew();
	}

	@Test
	public void ValidChangeowner() throws Exception {
		login.Signin();
		templatespage.Temp();
		templateScenarios.ChangeOwner();
	}

	@Test
	public void ValidViewdata() throws Exception {
		login.Signin();
		templatespage.Temp();
		templateScenarios.Viewdata();
	}

	@Test
	public void ValidEditTheTemplate() throws Exception {
		login.Signin();
		templatespage.Temp();
		templateScenarios.EditTheTemplate();
	}

	@Test
	public void ValidDuplicate() throws Exception {
		login.Signin();
		templatespage.Temp();
		templateScenarios.DuplicateTemplate();

	}

	@Test
	public void ValidRenameTemplate() throws Exception {
		login.Signin();
		templatespage.Temp();
		templateScenarios.RenameTemplate();

	}

	@Test
	public void ValidInactiveTemplate() throws Exception {
		login.Signin();
		templatespage.Temp();
		templateScenarios.inactive();

	}

	@Test
	public void ValidPDFfilling() throws Exception {
		login.Signin();
		templatespage.Temp();
		templateScenarios.PDFfilling();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
		

	}
}
