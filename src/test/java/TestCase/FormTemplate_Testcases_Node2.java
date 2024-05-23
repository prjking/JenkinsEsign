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
public class FormTemplate_Testcases_Node2 extends testCaseBase {

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

	@Test(priority = 15)

	public void BasicFieldsYesORNo() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.YesorNo();

	}

	@Test(priority = 16)
	public void BasicFieldsCheckbox() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.CheckBox();

	}

	@Test(priority = 17)
	public void BasicFieldsCheckBoxGroup() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.CheckBoxGroup();
		// formTemplate.CheckBoxGroupGlobalVariable();

	}

	@Test(priority = 18)
	public void BasicFieldsDocument() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Document();

	}

	@Test(priority = 19)
	public void BasicFieldsRadio() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Radio();

	}

	@Test(priority = 20)
	public void BasicFieldsRadioGroup() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.RadioGroup();
		// formTemplate.RadioGroupGlobalVariable();

	}

	@Test(priority = 21)
	public void BasicFieldsPhone() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Phone();

	}

	@Test(priority = 22)
	public void BasicFieldsSignature() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Signature();

	}

	@Test(priority = 23)
	public void BasicFieldsCaptcha() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Captcha();

	}

//Content Fields
	@Test(priority = 24)
	public void ContentHeading() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Heading();

	}

	@Test(priority = 25)
	public void ContentHTML() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.HTML();

	}

	@Test(priority = 26)
	public void ContentParagraph() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Paragraph();

	}

	@Test(priority = 27)
	public void ContentSingleLineContent() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.SingleLineContent();

	}

	@Test(priority = 28)
	public void ContentImage() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Image();

	}

	@Test(priority = 29)
	public void ContentVideo() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Video();

	}

	@Test(priority = 30)
	public void ContentActionButton() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.ActionButton();

	}

	@AfterMethod
	public void Close() throws Exception {
		Thread.sleep(1000);
		driver.close();
	}

}
