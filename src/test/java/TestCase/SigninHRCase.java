package TestCase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
import Pages.SigninHR;
import Pages.Signup;
import Pages.TemplateScenarios;
import Pages.Templatespage;
import Pages.Uploaddocuments;
import Reports.TestNGExtentReport;
import Reports.Testlistner;
import TestBase.testCaseBase;

@Listeners({ TestNGExtentReport.class, Testlistner.class })
public class SigninHRCase extends testCaseBase {

	SigninHR signinHR;

	public void setupDriver() {
		// driver = new ChromeDriver(getChromeOptions());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://hgtl.greythr.com/uas/portal/auth/login?login_challenge=21756908ea374a919dbdfbdb711c6db0");
	}

	@BeforeMethod
	public void Start() {
		setupDriver();
		signinHR = new SigninHR(driver);

	}

	@Test
	public void Validsignin() throws Exception {
		signinHR.checksignin();
		signinHR.inandout();
	}
}