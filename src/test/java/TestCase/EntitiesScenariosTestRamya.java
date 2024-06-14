package TestCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.Entities;
import Pages.Login;
import Pages.MethodActions;
import Reports.TestNGExtentReport;
import Reports.Testlistner;
import TestBase.testCaseBase;

@Listeners({ TestNGExtentReport.class, Testlistner.class, })
public class EntitiesScenariosTestRamya extends testCaseBase {
	Login login;
	Entities entities;

	@BeforeMethod
	public void initialize() {
		setup();
		login = new Login(driver);
		entities = new Entities(driver);
	}

	@Test(priority = 1, enabled = false)
	public void VerifyIndividualEntityType() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		entities.Entity();
		entities.EntityType();
		entities.IndividualEntity();
		entities.ExportAll();
		entities.SearchEntity();
	}

	@Test(priority = 2, enabled = false)
	public void VerifyBusinessentity() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		entities.Entity();
		entities.EntityType();
		entities.BusinessEntity();
		entities.ExportAll();
		entities.SearchEntity();
	}

	@Test(priority = 3, enabled = false)
	public void VerifyGeneralEntitytype() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		entities.Entity();
		entities.EntityType();
		entities.GeneralEntity();
		entities.ExportAll();
		entities.SearchEntity();
	}

	@Test(priority = 4, enabled = false)
	public void VerifyCreateEntities() throws Exception {
		login.Signin();
		login.VerifyLoginSucess();
		entities.Entity();
		entities.ClickCreateEntity();
		entities.CreateEntity();
		entities.addtemplates();
		entities.Relationship();
		entities.Customization();
		entities.Action();
	}

	@Test(priority = 5)
	public void Verify4841() throws Exception {
		login.SigninRamya();
		login.VerifyLoginSucess();
		MethodActions.Loadingmask();
		entities.Entity();
		entities.EntityType();
		entities.BusinessEntity();
		entities.Businessentityindex();
		entities.CheckSharedfileinEntity();
		// MethodActions.takeScreenshot(driver);

	}

	@Test(priority = 6)
	public void Verifybugid4841() throws Exception {
		login.SigninRamya();
		login.VerifyLoginSucess();
		MethodActions.Loadingmask();
		entities.Entity();
		entities.EntityType();
		entities.IndividualEntity();
		entities.Businessentityindex();
		entities.CheckSharedfileinEntity();
		// MethodActions.takeScreenshot(driver);

	}

	@Test(priority = 7, enabled = true)
	public void Validbugid4692() throws Exception {
		login.SigninRamya();
		login.VerifyLoginSucess();
		MethodActions.Loadingmask();
		entities.Entity();
		entities.ClickCreateEntity();
		entities.CreateBusinessentity();
		entities.addtemplates();
		entities.Updation();
		entities.ImportcontactFromspeadsheet();
	}

	@Test(priority = 8)
	public void Validbugid4786() throws Exception {
		entities.LoginAkhilpachiapala();
		login.VerifyLoginSucess();
		MethodActions.Loadingmask();
		entities.Entity();
		entities.ValidEntityField();
		// MethodActions.takeScreenshot(driver);

	}

	@Test(priority = 9, enabled = true)
	public void Validbugid4831() throws Exception {
		login.SigninRamya();
		login.VerifyLoginSucess();
		MethodActions.Loadingmask();
		entities.FormTemplate();
		entities.CreateFormtemplate();
		entities.Addbasicfields1();
		entities.Entity();
		entities.ClickCreateEntity();
		entities.CreateEntity();
		entities.addtemplatetogeneralentity();
		entities.Updation();
		entities.enterdata();
		entities.Entity1();
		entities.ClickCreateEntity();
		entities.CreateIndividualentity();
		entities.addtemplates();
		entities.Relationship();
		entities.Done1();
		entities.AssignData();

	}

	@Test(priority = 10, enabled = true)
	public void ValidBugID3280() throws Exception {
		login.SigninRamya();
		login.VerifyLoginSucess();
		MethodActions.Loadingmask();
		entities.FormTemplate();
		entities.CreateFormtemplate1();
		entities.Repeatabletemplate();
		entities.FormTemplate();
		entities.CreateFormtemplate1();
		entities.AddSelectField();
		entities.Formrule1();
		entities.Formrule2();
		entities.Entity();
		entities.ClickCreateEntity();
		entities.CreateEntity();
		entities.AddTwotemplatestoData();
		entities.Updation();
		entities.Adddatato3280();
	}

	@Test(priority = 11, enabled = true)
	public void ValidBugID1553() throws Exception {
		login.SigninRamya();
		login.VerifyLoginSucess();
		MethodActions.Loadingmask();
		entities.FormTemplate();
		entities.CreateFormtemplate();
		entities.AddCurrField();
		entities.Entity();
		entities.ClickCreateEntity();
		entities.CreateEntity();
		entities.addtemplatetogeneralentity();
		entities.Updation();
		entities.enterdata1();
		entities.FormTemplate();
		entities.CreateFormtemplate();
		entities.AddNamefields();
		entities.Entity();
		entities.ClickCreateEntity();
		entities.CreateIndividualentity();
		entities.addtemplates();
		entities.Relationship();
		entities.Done1();
		entities.AddDatato1553();
	}

	@Test(priority = 12, enabled = true)
	public void ValidBugID2199() throws Exception {
		login.SigninRamya();
		login.VerifyLoginSucess();
		MethodActions.Loadingmask();
		entities.FormTemplate();
		entities.CreateFormtemplate1();
		entities.Repeatabletemplate();
		entities.FormTemplate();
		entities.CreateFormtemplate1();
		entities.Repeatableformtemplate1();
		entities.Entity();
		entities.ClickCreateEntity();
		entities.CreateEntity();
		entities.AddTwotemplatestoData();
		entities.Updation();
		entities.AddDatato1299();

	}
}
