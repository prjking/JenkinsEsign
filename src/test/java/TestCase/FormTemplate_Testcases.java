package TestCase;

import Reports.TestNGExtentReport;
import Reports.Testlistner;
import org.testng.annotations.Listeners;
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

public class FormTemplate_Testcases extends testCaseBase {

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

	}

	@Test
	public void BasicFieldsSingleline() throws Exception {
		login.Signinprj();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.SelectSender();
		formTemplate.SingleLineWithSENDER();
		formTemplate.SingleLineWithSENDERORRECEIVER();
		formTemplate.closeingleline();
		formTemplate.SinglelineGlobalVariable();

	}

	@Test
	public void BasicFieldsMultiline() throws Exception {
		login.Signinprj();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.MultilineSender();
		formTemplate.MultilineRecevier();
		formTemplate.MultilineSENDERORRECEIVER();
	}

	@Test
	public void BasicFieldsSelect() throws Exception {
		login.Signinprj();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.SelectSender();
		formTemplate.SelectRecevier();
		formTemplate.SelectSENDERORRECEIVER();

	}

	@Test
	public void BasicFieldsNumber() throws Exception {
		login.Signinprj();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.NumberSender();

	}

//		formTemplate.Multiline();
//		formTemplate.Select();
//		formTemplate.MultipleSelect();
//		formTemplate.List();
//		formTemplate.Checkboxgroup();
//		formTemplate.Radiogroup();
//		formTemplate.Multipleactions();

//	@Test
//	public void ValidContentfields() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Contentfields();
//
//	}
//
//	@Test
//	public void ValidAdvancedFields() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.AdvancedFields();
//
//	}
}
