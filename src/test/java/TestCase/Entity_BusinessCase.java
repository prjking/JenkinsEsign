package TestCase;

import java.util.Random;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Entity_Business;
import Pages.FormTemplate;
import Pages.Login;
import Pages.MethodActions;
import Pages.Settings;
import TestBase.testCaseBase;

public class Entity_BusinessCase extends testCaseBase {
	Entity_Business entity_Business;
	Login login;
	FormTemplate formTemplate;
	

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
		entity_Business = new Entity_Business(driver);
		formTemplate = new FormTemplate(driver);
		login.SigninNSUI();
		MethodActions.Loadingmask();

	}

	@Test
	public void bussiness() throws Exception {
		String name = "Bussiness Entity1";
		String file = System.getProperty("user.dir") + "/src/test/resources/dd.PNG";
		entity_Business.FormTemplate();
		entity_Business.CreateFormtemplate(name);
//		entity_Business.submit();
//		entity_Business.basicFeilds();
		entity_Business.entity();
//		entity_Business.ClickCreateEntity();
//		entity_Business.CreateEntityFromScratch(name, "Start from scratch", "BUSINESS");
//		entity_Business.addtemplate(name);
		entity_Business.ClickEntityAction(name);
		entity_Business.icon();
		MethodActions.uploadFileWithSendKeys(file);
		entity_Business.save();
		entity_Business.compareTableRowWithInputData();
	}

	@Test
	public void ValidRepeat() throws Exception {
		String name = "Repeat Formtemplate2323";
		//entity_Business.FormTemplate();
		//entity_Business.CreaterepeatFormtemplate(name);
		//entity_Business.submit();
		//entity_Business.basicFeilds();
		//entity_Business.Primary();
		//entity_Business.submit();
		entity_Business.entity();
		entity_Business.ClickCreateEntity();
		entity_Business.CreateEntityFromScratch(name, "Start from scratch", "BUSINESS");
		entity_Business.addRepeattemplate(name);
		entity_Business.ClickEntityAction(name);
		entity_Business.Adddata();
		entity_Business.edit();	

	}
}
