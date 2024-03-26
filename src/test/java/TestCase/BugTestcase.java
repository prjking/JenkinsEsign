package TestCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.Addrecipients;
import Pages.Alldocuments;
import Pages.Bug;
import Pages.Dashboard;
import Pages.DocumentsScenarios;
import Pages.Dragdrop;
import Pages.EntityCases;
import Pages.FormTemplate;
import Pages.Login;
import Pages.MethodActions;
import Pages.RecevierSide;
import Pages.ReviewaNdSend;
import Pages.Signup;
import Pages.TemplateScenarios;
import Pages.Templatespage;
import Pages.Uploaddocuments;
import Reports.TestNGExtentReport;
import Reports.Testlistner;
import TestBase.testCaseBase;

@Listeners({ TestNGExtentReport.class, Testlistner.class })
public class BugTestcase extends testCaseBase {
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
	EntityCases entityCases;
	FormTemplate formTemplate;
	Bug bug;

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
		entityCases = new EntityCases(driver);
		formTemplate = new FormTemplate(driver);
		bug = new Bug(driver);

	}

	@Test
	public void Bug4004() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		bug.entity();
		bug.ClickCreateEntity();
		bug.CreateEntityScratch();
		bug.entity4004();
		bug.confirmButton();
		bug.validSuccessBug4004();
		MethodActions.takeScreenshot(driver);
	}
}