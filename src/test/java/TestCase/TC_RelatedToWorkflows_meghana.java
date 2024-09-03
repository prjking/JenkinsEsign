package TestCase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Dashboard;
import Pages.DocumentsScenarios;
import Pages.DocumentsScenarios1;
import Pages.Entities;
import Pages.Login;
import Pages.RecevierSide;
import Pages.RecevierSide1;
import TestBase.testCaseBase;
import Pages.clickWorkflow;
import Pages.clickWorkflow_meghana;

public class TC_RelatedToWorkflows_meghana extends testCaseBase {
	Login login;
	DocumentsScenarios1 documentsScenarios1;
	Dashboard dashboard;
	clickWorkflow_meghana WF;
	RecevierSide1 recevierSide1;
	Entities entities;

	public void setupDriver() {
		driver = new ChromeDriver(getChromeOptions());
		// driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://nsui.esigns.io/entity");
	}

	@BeforeMethod
	public void Start() throws InterruptedException {
		setupDriver();
		login = new Login(driver);
		WF = new clickWorkflow_meghana(driver);
		recevierSide1 = new RecevierSide1(driver);
		documentsScenarios1 = new DocumentsScenarios1(driver);
		entities = new Entities(driver);
		login.SigninNSUI("pmmeghana200@outlook.com", "Meghana@123");

	}

	// Workflow
	// TC_001:Verification of workflow
	@Test(priority = 1)
	public void clickWF() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
	}

	// TC_002:Verification of create workflow button
	@Test(priority = 2)
	public void clickCreateWF() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.createWFButton();
		WF.VerifycreateWFButton();
	}

	// TC_003:Verification of search
	@Test(priority = 3)
	public void search() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.search("3");
	}

	// TC_004:Verification of Active and Inactive Status
	@Test(priority = 4)
	public void inactive() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.status("Inactive");
	}

	@Test(priority = 5)
	public void active() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.status("Active");
	}

	// TC_005:Verification of Send workflow
	@Test(priority = 6)
	public void Sendworkflow() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.sendWorkflow();
		WF.verifySendWorkflow();
	}

	// TC_006:Verification of actions edit workflow
	@Test(priority = 7)
	public void actionEdit() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.actions("", "Edit");
		WF.actionEdit();
	}

	// TC_007:Verification of view workflow data from actions
	@Test(priority = 8)
	public void actionViewWFData() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.actions("", "View Workflow Data");
		WF.verifyViewWFData();

	}

//	TC_008:Checking view workflow data search is working or not
	@Test(priority = 9)
	public void actionViewWFDataSearch() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.actions("", "View Workflow Data");
		WF.verifyViewWFData();
		WF.search("Meghana");
		WF.verifyViewWFDataSearch();
	}

	// TC_009:Verification draft,sent and completed
	@Test(priority = 10)
	public void actionViewWFDataStatusDraft() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.actions("", "View Workflow Data");
		WF.verifyViewWFData();
		WF.status("Draft");

	}

	@Test(priority = 11)
	public void actionViewWFDataStatusSent() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.actions("", "View Workflow Data");
		WF.verifyViewWFData();
		WF.status("Sent");

	}

	@Test(priority = 12)
	public void actionViewWFDataStatusCompleted() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.actions("", "View Workflow Data");
		WF.verifyViewWFData();
		WF.status("Completed");

	}

	// TC_010:Verification Send workflow to receiver from view workflow data
	@Test(priority = 13)
	public void actionViewWFDataSendWf() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.actions("", "View Workflow Data");
		WF.verifyViewWFData();
		WF.sendWF();
		WF.verifySendWorkflow();
	}

	// TC_011:Verification of bulk delete with check marks
	@Test(priority = 14)
	public void actionViewWFBulkData() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.actions("", "View Workflow Data");
		WF.verifyViewWFData();
		WF.checkboxInHeader();
		WF.bulkDelete();
	}

	// TC_012:Verification of back button from view workflow data
	@Test(priority = 15)
	public void actionViewWFDataBack() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.actions("", "View Workflow Data");
		WF.verifyViewWFData();
		WF.back();
	}

	// TC_013:Verification of rename from actions
	@Test(priority = 16)
	public void actionRename() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.actions("", "Rename");
		WF.actionRename();
	}

	// TC_014:Verification of Inactive form actions
	@Test(priority = 17)
	public void actionInactive() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.actions("", "Inactive");
	}

	// TC_015:Verification of workflow creation responses
	@Test(priority = 18)
	public void StatusDraft() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseDraft();

	}

	@Test(priority = 19)
	public void StatusInProgress() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseInProgress();

	}

	@Test(priority = 20)
	public void StatusCompleted() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseCompleted();

	}

//	TC_016:Verification of Draft status actions
	@Test(priority = 21)
	public void StatusDraftActionsPermanentDelete() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseDraft();
		WF.action(1);
		WF.deleteSuccessNotification();
	}

	// TC_017:Verification of Send workflow from draft status
	@Test(priority = 22)
	public void StatusDraftActionsSendWF() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseDraft();
		WF.sendWF();
		WF.verifySendWorkflow();
	}

	// TC_018:Verification of bulk delete with check marks in draft
	@Test(priority = 23)
	public void WfResponseDraftBulkDelete() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseDraft();
		WF.checkboxInHeader();
		WF.bulkDelete();
	}

	// TC_019:Verification of Back button from Draft data
	@Test(priority = 24)
	public void WfResponseDraftBack() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseDraft();
		WF.back();
	}

	// TC_020:Verification of InProgress actions
	@Test(priority = 25)
	public void WfResponseInProgressDelete() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseInProgress();
		WF.action(1);

	}

	// hold
	@Test(priority = 26)
	public void WfResponseInProgressResend() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseInProgress();
		WF.action(2);
		WF.resendSuccessNotification();
	}

	// TC_021:Verification of view workflow from in progress
	@Test(priority = 27)
	public void WfResponseInProgressViewWF() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseInProgress();
		WF.viewWorkflow();
		WF.verifyViewWF();
	}

//hold
	// TC_022:Verification of Delete workflow from in progress view workflows
	// pop-ups
	@Test(priority = 28)
	public void WfResponseInProgressViewWFDelete() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseInProgress();
		WF.viewWorkflow();
		WF.SpanButton("Delete Workflow");
		WF.SpanButton("Yes");
	}

	// TC_023::Verification of view popup inprogress Actions
	@Test(priority = 29)
	public void WfResponseInProgressViewWFActionView() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseInProgress();
		Thread.sleep(10000);
		WF.viewWorkflow();
		WF.popUpAction(1);
	}

	@Test(priority = 30)
	public void WfResponseInProgressViewWFActionResend() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseInProgress();
		WF.viewWorkflow();
		WF.popUpAction(2);
	}

	// TC_024:Verification of actions from sent status documents from popup
	@Test(priority = 31)
	public void WfResponseInprogressViewWFActionHistory() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseInProgress();
		WF.viewWorkflow();
		WF.viewWorkflowActions(1);
		WF.verifyActionHistory("Document History");
	}

	@Test(priority = 32)
	public void WfResponseInprogressViewWFActionDownloadHistory() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseInProgress();
		WF.viewWorkflow();
		WF.viewWorkflowActions(1);
		WF.verifyActionHistory("Document History");
		WF.SpanButton("Download History");
	}

	@Test(priority = 33)
	public void WfResponseInprogressViewWFActionCorrectDocument() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseInProgress();
		WF.viewWorkflow();
		WF.viewWorkflowActions(2);
		WF.SpanButton("Yes");
		WF.VerifycorrectDoc();

	}

	@Test(priority = 34)
	public void WfResponseInprogressViewWFActionvoidDocument() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseInProgress();
		WF.viewWorkflow();
		WF.viewWorkflowActions(3);
		WF.SpanButton("Yes");
	}

	@Test(priority = 35)
	public void WfResponseInprogressViewWFActionDeleteDocument() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseInProgress();
		WF.viewWorkflow();
		WF.viewWorkflowActions(3);
		WF.SpanButton("Yes");

	}

	// TC_025:Verification of back button form in progress status
	@Test(priority = 36)
	public void WfResponseInprogressBackButton() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseInProgress();
		WF.back();
	}

	// TC_026:Verification of completed workflow actions
	@Test(priority = 37)
	public void WfResponseCompletedActionDelete() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseCompleted();
		WF.action(1);

	}

	// hold
	// TC_027:Verification of bulk delete with check marks from completed workflows
	@Test(priority = 38)
	public void WfResponseCompletedBulkDelete() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseCompleted();
		WF.checkboxInHeader();
		WF.bulkDelete();
	}

	// TC_028:Verification of view workflow from completed workflows data
	@Test(priority = 39)
	public void WfResponseCompletedViewWF() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseCompleted();
		WF.viewWorkflow();
		WF.verifyViewWF();
	}

	@Test(priority = 40)
	public void WfResponseCompletedViewWFDownload() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseCompleted();
		WF.viewWorkflow();
		WF.popUpAction(2);
	}

	@Test(priority = 41)
	public void WfResponseCompletedViewWFHistory() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseCompleted();
		WF.viewWorkflow();
		WF.viewWorkflowActions(1);
	}

	@Test(priority = 42)
	public void WfResponseCompletedViewWFClone() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseCompleted();
		WF.viewWorkflow();
		WF.viewWorkflowActions(2);
		Thread.sleep(10000);
		documentsScenarios1.SendDocumentInDocument();
		documentsScenarios1.SubDoc("Clone");
		documentsScenarios1.clickSubmit();
		documentsScenarios1.Verifysubmit();
	}

	@Test(priority = 43)
	public void WfResponseCompletedViewWFDelete() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.WFResponseCompleted();
		WF.viewWorkflow();
		WF.viewWorkflowActions(3);
	}

	// TC_029:Verification of workflow open page when we click on Workflow title
	@Test(priority = 44)
	public void verifyClickOnWFTitle() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.buildPage();
		WF.verifybuildPageInWorkflow();
	}

	// TC_030:Verification of build page in workflow
	@Test(priority = 45)
	public void verifyBuildPage() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.buildPage();
		WF.verifybuildPageInWorkflow();
		WF.addTemplates("Student", "Gmail");
	}

	@Test(priority = 46)
	public void verifyBuildPageviewTempViewTempUser() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.buildPage();
		WF.verifybuildPageInWorkflow();
		WF.WFTempAddActions(1);
		WF.verifyActionHistory("Template Users");
	}

	@Test(priority = 47)
	public void verifyBuildPageviewTempSettings() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.buildPage();
		WF.verifybuildPageInWorkflow();
		WF.WFTempAddActions(2);
		WF.VerifyTempSettings();
	}

	@Test(priority = 48)
	public void verifyBuildPageviewTempDelete() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.buildPage();
		WF.verifybuildPageInWorkflow();
		WF.deleteTempInWF();
	}

	@Test(priority = 49)
	public void verifyBuildPageviewTempRename() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.buildPage();
		WF.verifybuildPageInWorkflow();
		WF.rename();
	}

	@Test(priority = 50)
	public void verifyBuildPageviewTempSave() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.buildPage();
		WF.verifybuildPageInWorkflow();
		WF.saveAndSend();
		WF.verifySendWorkflow();
	}

	// check
	// TC_031:Verification of users page in workflow
	@Test(priority = 51)
	public void verifyUserPageSelectRecipient() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.buildPage();
		WF.verifybuildPageInWorkflow();
		WF.saveAndSend();
		WF.verifySendWorkflow();
		WF.addRecipientLoop("pmmeghanan180894@outlook.com", "Meghana", "PM", "SIGNER");
	}

	@Test(priority = 52)
	public void verifyUserPageAddRecipient() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.buildPage();
		WF.verifybuildPageInWorkflow();
		WF.saveAndSend();
		WF.verifySendWorkflow();
		WF.addRecipientLoop("pmmeghanan180894@outlook.com", "Meghana", "PM", "SIGNER");
	}

	@Test(priority = 53)
	public void verifyUserPageAddRecipientNextButton() throws Exception {
		WF.clickWF();
		WF.VerifyclickWF();
		WF.buildPage();
		WF.verifybuildPageInWorkflow();
		WF.saveAndSend();
		WF.verifySendWorkflow();
		WF.addRecipientLoop("pmmeghanan180894@outlook.com", "Meghana", "PM", "SIGNER");
		WF.nextButtonAfterAddingRecipientInTemp();
	}

	// TC_033:Verification of documents navigation after send workflow
	// TC_034:Verification of back button from sent workflow
	// TC_035:Verification of receiver side workflow mail
	// TC_036:Verification of navigations from receiver side in workflow
	// TC_037:Verification of finish document navigating to next document
	@Test(priority = 54)
	public void wf() throws Exception {
		String essentialFields[] = { "signatureEle", "initialEle", "fullNameEle", "dateSingedEle", "companyEle",
				"titleEle", "singleLineTextEle", "checkboxEle", "addressEle" };
		String WFdoc = "TC33To37c";
		documentsScenarios1.Templatesceanario();
		documentsScenarios1.CreateBlankTemplate(WFdoc + "Temp1");
		documentsScenarios1.RecipientSignerToTemplate("Receiver", "SIGNER");
		documentsScenarios1.Saveuser();
		documentsScenarios1.selectRecipientForDragAndDrop(2);
		documentsScenarios1.DradAndDropSigAndFullName(2, 0, -180, 250, -180);
		documentsScenarios1.saveTemplate();
		documentsScenarios1.back();
		documentsScenarios1.Templatesceanario();
		documentsScenarios1.CreateBlankTemplate(WFdoc + "Temp2");
		documentsScenarios1.RecipientSignerToTemplate("Receiver", "SIGNER");
		documentsScenarios1.Saveuser();
		documentsScenarios1.selectRecipientForDragAndDrop(2);
		documentsScenarios1.DragAndDropFeildsInDocumentUsingId(essentialFields);
		documentsScenarios1.saveTemplate();
		documentsScenarios1.back();
		WF.clickWF();
		WF.createWF(WFdoc, WFdoc + "Temp2", WFdoc + "Temp1");
		WF.saveAndSend();
		documentsScenarios1.Recipient(0, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		WF.nextButtonAfterAddingRecipientInTemp();
		documentsScenarios1.Viewdocument();
		WF.SelectDocAfterWFsend(2);
		WF.VerifyTC33(WFdoc + "Temp1");
		WF.back2();
		WF.SpanButton("Yes");

		recevierSide1.firstOutlooklogin("prudhvib200@outlook.com");
		recevierSide1.clickEmail(WFdoc);
		recevierSide1.reviewandSign(WFdoc + "Temp1");
		recevierSide1.signaturefill();
		recevierSide1.clickFinish();
		WF.VerifyTC33(WFdoc + "Temp2");
		recevierSide1.fillEssentialFeilds(1);
		WF.SelectDocAfterWFsend(2);
		WF.VerifyTC33(WFdoc + "Temp1");
	}

	// TC_032:Verification of Preview page in workflow
	@Test(priority = 55)
	public void preview() throws Exception {
		String essentialFields[] = { "signatureEle", "initialEle", "fullNameEle", "dateSingedEle", "companyEle",
				"titleEle", "singleLineTextEle", "checkboxEle", "addressEle" };
		String WFdoc = "TC32d";
		documentsScenarios1.Templatesceanario();
		documentsScenarios1.CreateBlankTemplate(WFdoc + "Temp1");
		documentsScenarios1.RecipientSignerToTemplate("Receiver", "SIGNER");
		documentsScenarios1.Saveuser();
		documentsScenarios1.selectRecipientForDragAndDrop(2);
		documentsScenarios1.DradAndDropSigAndFullName(2, 0, -180, 250, -180);
		documentsScenarios1.saveTemplate();
		documentsScenarios1.back();
		documentsScenarios1.Templatesceanario();
		documentsScenarios1.CreateBlankTemplate(WFdoc + "Temp2");
		documentsScenarios1.RecipientSignerToTemplate("Receiver", "SIGNER");
		documentsScenarios1.Saveuser();
		documentsScenarios1.selectRecipientForDragAndDrop(2);
		documentsScenarios1.DragAndDropFeildsInDocumentUsingId(essentialFields);
		documentsScenarios1.saveTemplate();
		documentsScenarios1.back();
		WF.clickWF();
		WF.createWF(WFdoc, WFdoc + "Temp2", WFdoc + "Temp1");
		WF.saveAndSend();
		documentsScenarios1.Recipient(0, "Receiver", "prudhvib200@outlook.com", "SIGNER");
		WF.SpanButton("Next");
		WF.rename();
		WF.SpanButton("Next");
		WF.verifyPreviewNextButton(WFdoc + "Temp1");
		WF.SpanButton("Prev");
		WF.verifyPreviewNextButton(WFdoc + "Temp2");
		WF.SpanButton("Settings");
		documentsScenarios1.SettingsExpirationAndRemainder(1);

	}

}