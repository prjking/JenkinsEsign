package TestCase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.MethodActions;
import Pages.Settings;
import Reports.TestNGExtentReport;
import Reports.Testlistner;
import TestBase.testCaseBase;

@Listeners({ TestNGExtentReport.class, Testlistner.class })
public class Settings_Case extends testCaseBase {
	Login login;
	Settings settings;

	public void setupDriver() {
		// driver = new ChromeDriver(getChromeOptions());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://nsui.esigns.io/signin");

	}

	@BeforeMethod
	public void Start() throws Exception {
		setupDriver();
		login = new Login(driver);
		settings = new Settings(driver);
		login.SigninNSUI();
		MethodActions.Loadingmask();

	}

	@Test
	public void validesettings() throws Exception {
		settings.Set();
		settings.DashboardStatistics();
		settings.Reminders();
		settings.AutoReminders();
		settings.ApplicationSettings();
		settings.Notifications();
		

	}
}
