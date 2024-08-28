package TestCase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.Entities;
import Pages.Login;
import Pages.MethodActions;
import Pages.Relationships;
import Pages.RepeatableTemplate;
import Reports.TestNGExtentReport;
import Reports.Testlistner;
import TestBase.testCaseBase;

@Listeners({ TestNGExtentReport.class, Testlistner.class, })
public class Relationships_cases extends testCaseBase {
	Login login;
	Relationships relationships;
	RepeatableTemplate repeatableTemplate;

	public void setupDriver() {
		// driver = new ChromeDriver(getChromeOptions());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://nsui.esigns.io/entity");
	}

	@BeforeMethod
	public void initialize() throws Exception {
		setupDriver();
		login = new Login(driver);
		relationships = new Relationships(driver);
		repeatableTemplate = new RepeatableTemplate(driver);
		login.SigninNSUI();
	}

	@Test
	public void ValidDetails() throws Exception {
		String Type = "INDIVIDUAL";
		String scratch = "Start from scratch";
		relationships.url();
		repeatableTemplate.ClickCreateEntity();
		relationships.entiy("Manager122", Type, scratch);
		relationships.next();
		relationships.Template(scratch, "Team Lead222");
		relationships.singleLineTextDragAndDrop("Teamlead Name");
		relationships.Select();
		relationships.close();
		relationships.EntityFieldDragAndDrop("Manager", "Manager122");
		relationships.save();
		relationships.url();
		repeatableTemplate.ClickCreateEntity();
		relationships.entiy("Team Lead222", Type, scratch);
		relationships.entityadd("Team Lead222");
		relationships.Sync();
		relationships.next();
		relationships.Template(scratch, "Employee22");
		relationships.singleLineTextDragAndDrop("Employee Name");
		relationships.close();
		relationships.EntityFieldDragAndDrop("Team Lead", "Team Lead222");
		relationships.save();
		relationships.url();
		repeatableTemplate.ClickCreateEntity();
		relationships.entiy("Employee22", Type, scratch);
		relationships.entityadd("Employee22");
		relationships.Sync();
		relationships.next();
		relationships.url();
		repeatableTemplate.ClickEntityAction("Manager122");
		relationships.enterDetails("John", "D", "Doe", "john.doe@example.com", "Manager", "123 Main St", "India (भारत)",
				"9876543210");

		relationships.enterDetails("Jane", "E", "Smith", "jane.smith@example.com", "Manager", "456 Park Ave",
				"India (भारत)", "1234567890");
		relationships.url();
		repeatableTemplate.ClickEntityAction("Team Lead");
		relationships.enterDetails("Marcus", "K", "stonics", "marcus.stonics@example.com", "TeamLead", "113 Main St",
				"India (भारत)", "8976543210");
		relationships.Team("Jane Smith", "Marcus stonics", "Development");

		relationships.enterDetails("jos", "E", "Buttler", "jos.Buttler@example.com", "TeamLead", "365 Park Ave",
				"India (भारत)", "8786567990");
		relationships.Team("John Doe", "jos Buttler", "Testing");

		relationships.enterDetails("Joe", "R", "Root", "joe.root@example.com", "TeamLead", "395 Park Ave",
				"India (भारत)", "3786567990");
		relationships.Team("John Doe", "joe Root", "App-Development");
		relationships.url();
		repeatableTemplate.ClickEntityAction("Employee22");
		relationships.enterDetails("Ramya", "Sibbala", "sibbala", "ramya@abccorp.org", "Employee", "113 Main St",
				"India (भारत)", "8976543210");
		relationships.Team1("Joe Root", "Marcus stonics");
		relationships.url();
		repeatableTemplate.ClickEntityAction("Employee22");
		relationships.enterDetails("Meghana", "Pemma", "Mohan", "megana@abccorp.org", "Employee", "113 Main St",
				"India (भारत)", "8976543210");
		relationships.Team1("jos Buttler", "Marcus");
		relationships.Template(scratch, "Employee Details");
		relationships.processEntityField("Manager", "Manager122", false);
		relationships.processEntityField("Employee", "Team Lead222", false);
		relationships.processEntityField("TeamLead", "Team Lead222", false);
		relationships.save();
		relationships.url();
		relationships.entiy("Emplyoee Details", "GENERAL", scratch);
		relationships.entityadd("Emplyoee Details");
		relationships.primary();
		relationships.next();
		relationships.Sync3();
		relationships.next();
		relationships.url();
		repeatableTemplate.ClickEntityAction("Emplyoee Details");

	}

	@Test
	public void validmanual() throws Exception {
		String Type = "INDIVIDUAL";
		String scratch = "Start from scratch";
		repeatableTemplate.ClickCreateEntity();
		relationships.entiy("Teacher333", Type, scratch);
		relationships.next();
		relationships.Template(scratch, "Student333");
		relationships.singleLineTextDragAndDrop("Student Name333");
		relationships.singleLineTextDragAndDrop1("Teacher Name333");
		relationships.save();
		relationships.url();
		repeatableTemplate.ClickCreateEntity();
		relationships.entiy("Student333", Type, scratch);
		relationships.entityadd("Student333");
		relationships.relation("Teacher333");
		relationships.next();
		repeatableTemplate.ClickEntityAction("Student333");
		relationships.enterDetails("John", "D", "Doe", "john.doe@example.com", "Student", "123 Main St", "India (भारत)",
				"9876543210");
		relationships.Team2("John", "Mike");
		relationships.url();
		repeatableTemplate.ClickEntityAction("Student333");
		relationships.enterDetails("Jane", "E", "Smith", "jane.smith@example.com", "Student", "456 Park Ave",
				"India (भारत)", "1234567890");
		relationships.Team2("Jane", "Smith");
		relationships.url();
		repeatableTemplate.ClickEntityAction("Student333");
		relationships.enterDetails("kane", "W", "Willamson", "kane.Willamson@example.com", "Student", "856 Park Ave",
				"India (भारत)", "1245656890");
		relationships.Team2("kane", "Mike");
		relationships.url();
		repeatableTemplate.ClickEntityAction("Teacher333");
		relationships.enterDetails("Mike", "H", "Hussy", "Mike.hussy@example.com", "Teacher", "123 Main St",
				"India (भारत)", "9876543210");
		// relationships.Team1("Jane", "Smith");

		relationships.enterDetails("Smith", "S", "Steve", "Steve.smith@example.com", "Teacher", "456 Park Ave",
				"India (भारत)", "1234567890");
		relationships.url();
		repeatableTemplate.ClickEntityAction("Student333");
		relationships.assign1();
		
		relationships.assign2();
		relationships.assign3();

	}

}
