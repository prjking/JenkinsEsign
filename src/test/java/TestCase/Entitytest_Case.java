
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
import Pages.EntityCases;
import Pages.Login;
import Pages.MethodActions;
import Pages.RecevierSide;
import Pages.ReviewaNdSend;
import Pages.Scrool;
import Pages.Signup;
import Pages.TemplateScenarios;
import Pages.Templatespage;
import Pages.Uploaddocuments;
import TestBase.testCaseBase;

@Listeners({ TestNGExtentReport.class, Testlistner.class })
public class Entitytest_Case extends testCaseBase {

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

	}

	@Test
	public void validBugid4732() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		entityCases.entity();
		entityCases.actionView();
		entityCases.clickOnLayout();
		entityCases.layoutChart();
		entityCases.SelectChart();
		//MethodActions.takeScreenshot(driver);

	}

	@Test
	public void validBugid4731() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		entityCases.entity();
		entityCases.actionView1();
		entityCases.EyeIcon();
		entityCases.LayoutOptions();
		entityCases.Validdata();
		//MethodActions.takeScreenshot(driver);
	}

//	@Test
//	public void validBugid4833() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		entityCases.entity();
//		entityCases.listclick();

	// }

}