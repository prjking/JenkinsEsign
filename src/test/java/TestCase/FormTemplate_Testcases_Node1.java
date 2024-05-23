package TestCase;

import Reports.TestNGExtentReport;
import Reports.Testlistner;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Addrecipients;
import Pages.Alldocuments;
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
import TestBase.testCaseBase;

@Listeners({ TestNGExtentReport.class, Testlistner.class })
public class FormTemplate_Testcases_Node1 extends testCaseBase {
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

	@BeforeMethod
	public void Start() throws Exception {
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

	}

//Basic Fields
	@Test(priority = 1)
	public void BasicFieldsSingleline() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.SingleLine();
		// formTemplate.closeingleline();
		// formTemplate.SinglelineGlobalVariable();
		// formTemplate.StyleSettings();
	}

	@Test(priority = 2)
	public void BasicFieldsMultiline() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Multiline();
		// formTemplate.MultilineGlobalVariable();
	}

	@Test(priority = 3)
	public void BasicFieldsSelect() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Select();
		// formTemplate.SelectGlobalVariable();
	}

	@Test(priority = 4)
	public void BasicFieldsNumber() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Number();
		// formTemplate.NumberGlobalVariable();
	}

	@Test(priority = 5)
	public void BasicFieldsMultipleSelect() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.MultipleSelect();
		// formTemplate.MultipleGlobalVariable();
	}

	@Test(priority = 6)
	public void BasicFieldsList() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.List();
		// formTemplate.ListGlobalVariable();
	}

	@Test(priority = 7)
	public void BasicFieldsDate() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Date();
		// formTemplate.DateGlobalVariable();
	}

	@Test(priority = 8)
	public void BasicFieldsTime() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Time();
		// formTemplate.TimeGlobalVariable();
	}

	@Test(priority = 9)
	public void BasicFieldsFixedTime() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.FixedTime();
		// formTemplate.FixedTimeGlobalVariable();

	}

	@Test(priority = 10)
	public void BasicFieldsTimerange() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Timerange();
		// formTemplate.TimerangeGlobalVariable();

	}

	@Test(priority = 11)
	public void BasicFieldsDateTime() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Date();

	}

	@Test(priority = 12)
	public void BasicFieldsWeekDays() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.WeekDays();
		// formTemplate.WeekDaysGlobalVariable();

	}

	@Test(priority = 13, enabled = false)
	public void BasicFieldsDateTimeRange() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Date();

	}

	@Test(priority = 14, enabled = false)
	public void BasicFieldsDateRange() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Date();

	}

	@AfterMethod
	public void Close() throws Exception {
		Thread.sleep(1000);
		driver.close();
	}

}
