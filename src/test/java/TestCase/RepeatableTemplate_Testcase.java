package TestCase;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.DocumentsScenarios2;
import Pages.Login;
import Pages.MethodActions;
import Pages.Recieverside2;
import Pages.RepeatableTemplate;
import Reports.TestNGExtentReport;
import Reports.Testlistner;
import TestBase.testCaseBase;

@Listeners({ TestNGExtentReport.class, Testlistner.class })
public class RepeatableTemplate_Testcase extends testCaseBase {
	Login login;
	RepeatableTemplate repeatableTemplate;

	public void setupDriver() {
		// driver = new ChromeDriver(getChromeOptions());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://nsui.esigns.io/signin");
	}

	@BeforeMethod
	public void initialize() {
		setupDriver();
		login = new Login(driver);
		repeatableTemplate = new RepeatableTemplate(driver);

	}

	@Test
	public void validsRepeatableTemplate() throws Exception {
		login.SigninNSUI();
		repeatableTemplate.entity();
		repeatableTemplate.ClickCreateEntity();
		repeatableTemplate.CreateEntityFromScratch("Start from scratch", "INDIVIDUAL");
		repeatableTemplate.addtemplate(" Basic Fields ");
		repeatableTemplate.DocScenario();
		repeatableTemplate.Blankloginaccount(" ");
		// repeatableTemplate.addContactAtAddrecipient(1, name, "prudhvira@gmail.com",
		// "prudhvi", "raju", "SIGNER");

	}

}
