package TestCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Documents;
import Pages.Login;
import TestBase.testCaseBase;

public class Testcases_Ramya extends testCaseBase {
	Login login;
	Documents documents;
@BeforeMethod
public void initialize() {
	setup();
	login = new Login(driver);
	documents = new Documents(driver);

}
@Test
public void VerifyLoginFunctionalityWithValidCredantials() {
	setup();
	login = new Login(driver);

}
@Test
public void VerifyDocuments() throws InterruptedException {
	login.Signin();
//documents.ApprovedCorrectdocument();
	//documents.ApprovedDeletedocument();
	//documents.ApprovedDocumentsettings();
	//documents.ApprovedDownloadoriginal();
	//documents.ApprovedRenamedocument();
	//documents.ApprovedResenddocument();
	//documents.ApprovedSaveastemplate();
	//documents.ApprovedVoiddocument();
	//documents.ArchivedDownloadoriginal();
	//documents.ArchivedPermanentdelete();
	//documents.ArchivedRenamedocuments();
	//documents.ArchivedUndodocument();
	documents.CompletedClonedocument();
	//documents.CompletedDeletedocuement();
	//documents.CompletedDownloaddocuement();
	//documents.CompletedDownloadoriginal();
	//documents.CompletedRenamedocument();
	//documents.CompletedSaveastemplate();
	//documents.CompletedSharewithothers();
	//documents.CompletedSenttomail();
	//documents.DeclinedDeletedocument();
	//documents.DeclinedDocumentsettings();
	//documents.DeclinedDownloadoriginal();
	//documents.DeclinedRenamedocument();
	//documents.DeclinedSaveastemplate();
	//documents.DeclinedVoiddocument();
	//documents.DraftDeletedocument();
	//documents.Draftdocumentsetting();
	//documents.DraftDownloaddocument();
	//documents.DraftrenameDocument();
	//documents.DraftSentDocument();
	//documents.DraftVoiddocument();
	//documents.SentcorrectDocument();
	//documents.SentDeletedocument();
	//documents.Sentdocumentsettings();
	//documents.SentDownloaddocument();
	//documents.SentRenamedocument();
	//documents.SentsavetoTemplate();
	//documents.SentVoiddocument();
	//documents.SentResenddocument();
	//documents.VoidClonedocument();
	//documents.VoidDeletedocument();
	//documents.VoidDownloadoriginal();
	//documents.VoidSaveastemplate();
	//documents.WaitformeWaitforme();
	//documents.WaitingForOthersCorrectdocument();
	//documents.WaitingForOthersDeletedocument();
	//documents.WaitingForOthersDocumentsettings();
	//documents.WaitingForOthersDownloadoriginal();
	//documents.WaitingForOthersRenamedocument();
	//documents.WaitingForOthersResenddocument();
	//documents.WaitingForOthersSaveastemplate();
	//documents.WaitingForOthersVoiddocument();

}
}
