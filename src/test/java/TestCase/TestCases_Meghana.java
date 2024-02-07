package TestCase;

//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Dashboard;
import Pages.Login;
import Pages.clickWorkflow;
import TestBase.testCaseBase;


public class TestCases_Meghana extends testCaseBase {
	Login login;
	Dashboard dashboard;
	clickWorkflow WF;

	@BeforeMethod
	public void initalize() {
		setup();
		login = new Login(driver);
		dashboard = new Dashboard(driver);
		WF = new clickWorkflow(driver);

	}

	// login
	@Test
	public void verifyLoginWithInvalidCredentials() throws InterruptedException {
		login.Signin();
		login.VerifyLoginSucess();
	}

	@Test
	public void waitforOthers() throws Exception {
	login.Signin();
	dashboard.waitOthers();
	//	dashboard.VerifyWaitingForOthersClick();
//		dashboard.completeDoc();
//		dashboard.Alldoc();
//		dashboard.waitOthers();
//		dashboard.VerifyWaitingForOthersClick();
//		dashboard.resend();
//		dashboard.waitOthers();
//		dashboard.VerifyWaitingForOthersClick();
//		dashboard.saveAsTemplate();
//		dashboard.waitOthers();
//		dashboard.VerifyWaitingForOthersClick();
		dashboard.voidDoc();
//		dashboard.waitOthers();
//		dashboard.VerifyWaitingForOthersClick();
//		dashboard.rename();
//		dashboard.waitOthers();
//		dashboard.VerifyWaitingForOthersClick();
//		dashboard.docSettings();
//		dashboard.waitOthers();
//		dashboard.VerifyWaitingForOthersClick();
//		dashboard.deleteDoc();
//		dashboard.waitOthers();
//		dashboard.VerifyWaitingForOthersClick();
//		dashboard.downloadOriginal();
//		dashboard.Draft();
//		dashboard.VerifyDraftsClick();
//		dashboard.DSendDoc();
//		dashboard.Draft();
//		dashboard.VerifyDraftsClick();
//		dashboard.draftSaveAsTemplate();
//		dashboard.Draft();
//		dashboard.VerifyDraftsClick();
//		dashboard.DraftsRename();
//		dashboard.Draft();
//		dashboard.VerifyDraftsClick();
//		dashboard.DraftDocSettings();
//		dashboard.Draft();
//		dashboard.VerifyDraftsClick();
//		dashboard.DraftdeleteDoc();
//		dashboard.Draft();
//		dashboard.VerifyDraftsClick();
//		dashboard.DraftdownloadOriginal();
//		dashboard.completed();
//		dashboard.VerifyCompleteClick();
//		dashboard.comDownloadOriginal();
//		dashboard.completed();
//		dashboard.VerifyCompleteClick();
//		dashboard.comDownloadDoc();
//		dashboard.waitingForMe();
//		dashboard.VerifywaitingForMeClick();
//		dashboard.WFMCorrectDoc();
//		dashboard.expSoon();
//		dashboard.VerifyExpSoonClick();
//		dashboard.expSoondownloadOriginal();
//		dashboard.expSoon();
//		dashboard.VerifyExpSoonClick();
//		dashboard.expSoondeleteDoc();
//		dashboard.expSoon();
//		dashboard.VerifyExpSoonClick();
//		dashboard.expSoonDocSettings();
//		dashboard.expSoon();
//		dashboard.VerifyExpSoonClick();
//		dashboard.expSoonRename();
//		dashboard.expSoon();
//		dashboard.VerifyExpSoonClick();
//		dashboard.expSooncorrectDocument();
//		dashboard.expSoon();
//		dashboard.VerifyExpSoonClick();
//		dashboard.resendDocument();
//		dashboard.expSoon();
//		dashboard.VerifyExpSoonClick();
//		dashboard.expSoonSaveAsTemplate();
//		dashboard.expSoon();
//		dashboard.VerifyExpSoonClick();
//		dashboard.expSoonvoidDocument();
	}

	// Workflows

	@Test
	public void workflow() throws Exception {
		login.Signin();
		WF.clickWF();
		WF.status();
		WF.actionEdit();
		WF.actionEdit();
		
		WF.actionRename();
		WF.actionViewData();
		WF.actionInactive();
		WF.previewWF();
		WF.addGroup();
		WF.enforce();
		WF.primaryUser();

	}
	
	
 
 
	
	
}