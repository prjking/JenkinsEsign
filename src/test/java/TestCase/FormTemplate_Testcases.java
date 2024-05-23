package TestCase;

import Reports.TestNGExtentReport;
import Reports.Testlistner;
import org.testng.annotations.Listeners;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
import io.github.bonigarcia.wdm.WebDriverManager;

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
		formTemplate = new FormTemplate(driver);

	}

////Basic Fields
//	@Test(priority = 1)
//	public void BasicFieldsSingleline() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.SingleLine();
//		// formTemplate.closeingleline();
//		// formTemplate.SinglelineGlobalVariable();
//		// formTemplate.StyleSettings();
//	}
//
//	@Test(priority = 2)
//	public void BasicFieldsMultiline() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Multiline();
//		// formTemplate.MultilineGlobalVariable();
//	}
//
//	@Test(priority = 3)
//	public void BasicFieldsSelect() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Select();
//		// formTemplate.SelectGlobalVariable();
//	}
//
//	@Test(priority = 4)
//	public void BasicFieldsNumber() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Number();
//		// formTemplate.NumberGlobalVariable();
//	}
//
//	@Test(priority = 5)
//	public void BasicFieldsMultipleSelect() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.MultipleSelect();
//		// formTemplate.MultipleGlobalVariable();
//	}
//
//	@Test(priority = 6)
//	public void BasicFieldsList() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.List();
//		// formTemplate.ListGlobalVariable();
//	}
//
//	@Test(priority = 7)
//	public void BasicFieldsDate() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Date();
//		// formTemplate.DateGlobalVariable();
//	}
//
//	@Test(priority = 8)
//	public void BasicFieldsTime() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Time();
//		// formTemplate.TimeGlobalVariable();
//	}
//
//	@Test(priority = 9)
//	public void BasicFieldsFixedTime() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.FixedTime();
//		// formTemplate.FixedTimeGlobalVariable();
//
//	}
//
//	@Test(priority = 10)
//	public void BasicFieldsTimerange() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Timerange();
//		// formTemplate.TimerangeGlobalVariable();
//
//	}
//
//	@Test(priority = 11)
//	public void BasicFieldsDateTime() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Date();
//
//	}
//
//	@Test(priority = 12)
//	public void BasicFieldsWeekDays() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.WeekDays();
//		// formTemplate.WeekDaysGlobalVariable();
//
//	}
//
//	@Test(priority = 13, enabled = false)
//	public void BasicFieldsDateTimeRange() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Date();
//
//	}
//
//	@Test(priority = 14, enabled = false)
//	public void BasicFieldsDateRange() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Date();
//
//	}
//
//	@Test(priority = 15)
//	public void BasicFieldsYesORNo() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.YesorNo();
//
//	}
//
//	@Test(priority = 16)
//	public void BasicFieldsCheckbox() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.CheckBox();
//
//	}
//
//	@Test(priority = 17)
//	public void BasicFieldsCheckBoxGroup() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.CheckBoxGroup();
//		// formTemplate.CheckBoxGroupGlobalVariable();
//
//	}
//
//	@Test(priority = 18)
//	public void BasicFieldsDocument() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Document();
//
//	}
//
//	@Test(priority = 19)
//	public void BasicFieldsRadio() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Radio();
//
//	}
//
//	@Test(priority = 20)
//	public void BasicFieldsRadioGroup() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.RadioGroup();
//		// formTemplate.RadioGroupGlobalVariable();
//
//	}
//
//	@Test(priority = 21)
//	public void BasicFieldsPhone() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Phone();
//
//	}
//
//	@Test(priority = 22)
//	public void BasicFieldsSignature() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Signature();
//
//	}
//
//	@Test(priority = 23)
//	public void BasicFieldsCaptcha() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Captcha();
//
//	}
//
////Content Fields
//	@Test(priority = 24)
//	public void ContentHeading() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Heading();
//
//	}
//
//	@Test(priority = 25)
//	public void ContentHTML() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.HTML();
//
//	}
//
//	@Test(priority = 26)
//	public void ContentParagraph() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Paragraph();
//
//	}
//
//	@Test(priority = 27)
//	public void ContentSingleLineContent() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.SingleLineContent();
//
//	}
//
//	@Test(priority = 28)
//	public void ContentImage() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Image();
//
//	}
//
//	@Test(priority = 29)
//	public void ContentVideo() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.Video();
//
//	}
//
//	@Test(priority = 30)
//	public void ContentActionButton() throws Exception {
//		login.Signin();
//		MethodActions.Loadingmask();
//		formTemplate.Template();
//		formTemplate.Createtemp();
//		formTemplate.ActionButton();
//
//	}

	@Test(priority = 31)
	public void ContentHorizontalLine() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.HorizontalLine();

	}

	@Test(priority = 32)
	public void ContentDivision() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Division();

	}

//Advanced Fields
	@Test(priority = 33)
	public void AdvancedAutoIncrementNumber() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.AutoIncrementNumber();

	}

	@Test(priority = 34)
	public void AdvancedLocation() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Location();

	}

	@Test(priority = 35)
	public void AdvancedCurrency() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Currency();
		// formTemplate.CurrencyGlobalVariable();

	}

	@Test(priority = 36)
	public void AdvancedQuestion() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Question();

	}

	@Test(priority = 37, enabled = false)
	public void AdvancedAuthorizedSignature() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.AuthorizedSignature();// check

	}

	@Test(priority = 38)
	public void AdvancedEntity() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.EntityVariable();

	}

	@Test(priority = 39)
	public void AdvancedFormula() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Formula();

	}

	@Test(priority = 40)
	public void AdvancedAggregateFunction() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.AggregateFunction();

	}

	@Test(priority = 41, enabled = false)
	public void AdvancedDataTable() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.DataTable();// same place

	}

	@Test(priority = 42)
	public void AdvancedChildEntityTable() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.ChildEntityTable();

	}

	@Test(priority = 43)
	public void AdvancedPayButtons() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.PayButtons();

	}

	@Test(priority = 44)
	public void AdvancedPaymentVariable() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.PaymentVariable();

	}

	@Test(priority = 45)
	public void AdvancedStarRating() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.StarRating();
		// formTemplate.StarRatingGlobalVariable();

	}

	@Test(priority = 46)
	public void AdvancedConcatenate() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Concatenate();

	}

	@Test(priority = 47)
	public void AdvancedAudio() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.Audio();

	}

	@Test(priority = 48)
	public void AdvancedQRCode() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.QRCode();
	}

	@Test(priority = 49)
	public void AdvancedQRReader() throws Exception {
		login.Signin();
		MethodActions.Loadingmask();
		formTemplate.Template();
		formTemplate.Createtemp();
		formTemplate.QRReader();

	}

	@AfterMethod
	public void Close() throws Exception {
		Thread.sleep(1000);
		driver.close();
	}

}
