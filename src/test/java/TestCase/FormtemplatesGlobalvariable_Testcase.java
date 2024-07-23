package TestCase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.FormTemplate;
import Pages.Formtemplates_globalvariable;
import Pages.Login;
import Pages.MethodActions;
import Reports.TestNGExtentReport;
import Reports.Testlistner;
import Resources.ScreenRecorderUtil;
//import Resources.ScreenRecorderUtil;
import TestBase.testCaseBase;

@Listeners({ TestNGExtentReport.class, Testlistner.class })
public class FormtemplatesGlobalvariable_Testcase extends testCaseBase {
	Login login;
	Formtemplates_globalvariable formtemplates_globalvariable;
	FormTemplate formTemplate;
	ScreenRecorderUtil screenRecorderUtil;

	public void setupDriver() {
	//	driver = new ChromeDriver(getChromeOptions());
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://nsui.esigns.io/signin");

	}

	@BeforeMethod
	public void Start() {
		setupDriver();
		login = new Login(driver);
		formtemplates_globalvariable = new Formtemplates_globalvariable(driver);
		formTemplate = new FormTemplate(driver);

	}

	@Test
	public void validglobalvariable() throws Exception {
		ScreenRecorderUtil.startRecord("testRecording");
		login.SigninNSUI();
		MethodActions.Loadingmask();
		formTemplate.Template();
		// ScreenRecorderUtil.stopRecord();
		formTemplate.Createtemp();
		formtemplates_globalvariable.GlobalVariableActions();
		formtemplates_globalvariable.blankdoc();
		formtemplates_globalvariable.Recipient(1, "Receiver", "jeevithapatnana200@outlook.com", " SIGNER ");
		formtemplates_globalvariable.companyProfile();
		formtemplates_globalvariable.addrecevier();
		ScreenRecorderUtil.stopRecord();

	}

}
