package TestCase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.DocumentsScenarios1;
import Pages.Entities;
import Pages.EntitiesMeghana;
import Pages.Login;
import Pages.RecevierSide;
import Pages.RecevierSide1;
import Pages.globalVariables_meghana;
import Reports.TestNGExtentReport;
import Reports.Testlistner;
import TestBase.testCaseBase;
@Listeners({ TestNGExtentReport.class, Testlistner.class, })
public class globalVariableTestcase_meghana extends testCaseBase {
	Login login;
	globalVariables_meghana GlobalVariables_meghana;
	EntitiesMeghana entitiesMeghana;
	DocumentsScenarios1 documentsScenarios1;
	RecevierSide1 recevierSide1;

	public void setupDriver() {
		driver = new ChromeDriver(getChromeOptions());
	//	 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://nsui.esigns.io");
	}

	@BeforeMethod
	public void Start() throws InterruptedException {
		setupDriver();
		login = new Login(driver);
		GlobalVariables_meghana = new globalVariables_meghana(driver);
		entitiesMeghana = new EntitiesMeghana(driver);
		documentsScenarios1 = new DocumentsScenarios1(driver);
		recevierSide1 = new RecevierSide1(driver);
		//login.SigninNSUI("pmmeghana200@outlook.com", "Meghana@123");
		//login.VerifyLoginSucess();

	}

	// TC_Glo_Var_01:Verifying the Global Variable Button
	@Test
	public void clickGlobalVariableButton() throws Exception {
		GlobalVariables_meghana.clickGlobalVariable();
		GlobalVariables_meghana.VerifyClickGlobalVariable();
	}
	// TC_Glo_Var_02:Add variable

	@Test
	public void ClickNewVariable() throws Exception {
		GlobalVariables_meghana.clickGlobalVariable();
		GlobalVariables_meghana.VerifyClickGlobalVariable();
		GlobalVariables_meghana.clickNewVariable();
	}

	// TC_Glo_Var_03:Single Line text
	@Test
	public void singleLineText() throws Exception {
		GlobalVariables_meghana.clickGlobalVariable();
		GlobalVariables_meghana.VerifyClickGlobalVariable();
		GlobalVariables_meghana.clickNewVariable();
		GlobalVariables_meghana.selectDataType();
		GlobalVariables_meghana.selectNumberOrSinglineTextField("Single Line Text", "Single Line Text", "meghana123",
				"");
	}

	// TC_Glo_Var_04:Multi Line Text
	@Test
	public void multiLineText() throws Exception {
		GlobalVariables_meghana.clickGlobalVariable();
		GlobalVariables_meghana.VerifyClickGlobalVariable();
		GlobalVariables_meghana.clickNewVariable();
		GlobalVariables_meghana.selectDataType();
		GlobalVariables_meghana.multiLine("Multi Line Text", "Multi Line Text",
				"Peter Piper picked a peck of pickled peppers. A journey of a thousand miles begins with a single step.",
				"");
	}

	// TC_Glo_Var_05:Select
	@Test
	public void select() throws Exception {
		GlobalVariables_meghana.clickGlobalVariable();
		GlobalVariables_meghana.VerifyClickGlobalVariable();
		GlobalVariables_meghana.clickNewVariable();
		GlobalVariables_meghana.selectDataType();
		GlobalVariables_meghana.selectField("Select");
	}

	// TC_Glo_Var_06:Multiple Select
	@Test
	public void multiSelect() throws Exception {
		GlobalVariables_meghana.clickGlobalVariable();
		GlobalVariables_meghana.VerifyClickGlobalVariable();
		GlobalVariables_meghana.clickNewVariable();
		GlobalVariables_meghana.selectDataType();
		GlobalVariables_meghana.selectField("Multiple Select");
	}

	// TC_Glo_Var_07:Number
	@Test
	public void Number() throws Exception {
		GlobalVariables_meghana.clickGlobalVariable();
		GlobalVariables_meghana.VerifyClickGlobalVariable();
		GlobalVariables_meghana.clickNewVariable();
		GlobalVariables_meghana.selectDataType();
		GlobalVariables_meghana.selectNumberOrSinglineTextField("Number", "Number", "10", "");
	}

	// TC_Glo_Var_08:Date
	@Test
	public void Date() throws Exception {
		GlobalVariables_meghana.clickGlobalVariable();
		GlobalVariables_meghana.VerifyClickGlobalVariable();
		GlobalVariables_meghana.clickNewVariable();
		GlobalVariables_meghana.selectDataType();
		GlobalVariables_meghana.dateField("Date");
	}

	// TC_Glo_Var_09:Time
	@Test
	public void time() throws Exception {
		GlobalVariables_meghana.clickGlobalVariable();
		GlobalVariables_meghana.VerifyClickGlobalVariable();
		GlobalVariables_meghana.clickNewVariable();
		GlobalVariables_meghana.selectDataType();
		GlobalVariables_meghana.Time("Time");
	}

	// TC_Glo_Var_10:Date Time
	@Test
	public void dateTime() throws Exception {
		GlobalVariables_meghana.clickGlobalVariable();
		GlobalVariables_meghana.VerifyClickGlobalVariable();
		GlobalVariables_meghana.clickNewVariable();
		GlobalVariables_meghana.selectDataType();
		GlobalVariables_meghana.dateTime("Date Time");
	}

	// TC_Glo_Var_11:Date Time Range
	@Test
	public void dateTimeRange() throws Exception {
		GlobalVariables_meghana.clickGlobalVariable();
		GlobalVariables_meghana.VerifyClickGlobalVariable();
		GlobalVariables_meghana.clickNewVariable();
		GlobalVariables_meghana.selectDataType();
		GlobalVariables_meghana.dateTimeRange("Date Time Range");
	}

	// TC_Glo_Var_12:Date Range
	@Test
	public void dateRange() throws Exception {
		GlobalVariables_meghana.clickGlobalVariable();
		GlobalVariables_meghana.VerifyClickGlobalVariable();
		GlobalVariables_meghana.clickNewVariable();
		GlobalVariables_meghana.selectDataType();
		GlobalVariables_meghana.dateRange("Date  Range");
	}

	// TC_Glo_Var_13:Time Range
	@Test
	public void timeRange() throws Exception {
		GlobalVariables_meghana.clickGlobalVariable();
		GlobalVariables_meghana.VerifyClickGlobalVariable();
		GlobalVariables_meghana.clickNewVariable();
		GlobalVariables_meghana.selectDataType();
		GlobalVariables_meghana.timeRange("Time Range");
	}

	// TC_Glo_Var_14:Weekdays
	@Test
	public void Weekdays() throws Exception {
		GlobalVariables_meghana.clickGlobalVariable();
		GlobalVariables_meghana.VerifyClickGlobalVariable();
		GlobalVariables_meghana.clickNewVariable();
		GlobalVariables_meghana.selectDataType();
		GlobalVariables_meghana.weekdays("Weekdays");
	}

	// FixedTime:Hold

	@Test
	public void fixedTime() throws Exception {
		GlobalVariables_meghana.clickGlobalVariable();
		GlobalVariables_meghana.VerifyClickGlobalVariable();
		GlobalVariables_meghana.clickNewVariable();
		GlobalVariables_meghana.selectDataType();
		GlobalVariables_meghana.fixedTime("Time");
	}

	// Add The template which contains global variables in to an entity
	@Test
	public void addToEntity() throws Exception {
		String arr[] = { "1", "06-01-2024 To 07-01-2024", "IMG", "06-05-2024 00:00:00", "YES", "Monday",
				"PemmaMohan ReddyMeghana", "06-01-2024", "TESTING.pdf", " ", "01:00", "List", "12:12:12", "1",
				"Computer science,maths", "9347618053", "Computer science", " PemmaMohan ReddyMeghana ", "1,2" };
		String docname = "AddToEntity10";
		entitiesMeghana.entity();
		entitiesMeghana.ClickCreateEntity();
		entitiesMeghana.CreateEntityFromScratch(docname, "Start from scratch", "INDIVIDUAL");
		entitiesMeghana.addtemplate(" gv ");
		documentsScenarios1.DocScenario();
		documentsScenarios1.Blankloginaccount(docname);
		documentsScenarios1.addContactAtAddrecipient(1, docname, "prudhvib200@outlook.com", "prudhvi", "b", "SIGNER");
		documentsScenarios1.Recipient(1, docname, "prudhvib200@outlook.com", "SIGNER");
		documentsScenarios1.Saveuser();
		documentsScenarios1.DradAndDropSigAndFullName(2, -250, -220, 0, -220);
		GlobalVariables_meghana.globalVariableDragAndDrop();
		documentsScenarios1.SubDocScenarios(docname);
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
		recevierSide1.firstOutlooklogin("prudhvib200@outlook.com");
		recevierSide1.clickEmail(docname);
		recevierSide1.reviewandSign("Review & sign");
		recevierSide1.signaturefill();
		recevierSide1.receiverSideUpdatedBasicFeildsFill();
		login.SigninNSUI("pmmeghana200@outlook.com", "Meghana@123");
		entitiesMeghana.entity();
		entitiesMeghana.ClickEntityAction(docname);
		entitiesMeghana.verifyBasicFieldDataFillInIndividualEntity();
	}

	@Test
	public void aa() throws Exception {
		GlobalVariables_meghana.companyProfile("gv");
	}

	@AfterMethod
	public void quit() {
		driver.quit();
		
		
	}
	
}