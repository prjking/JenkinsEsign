package TestCase;

import Reports.TestNGExtentReport;
import Reports.Testlistner;
import TestBase.testCaseBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Pages.*;

@Listeners({ TestNGExtentReport.class, Testlistner.class })
public class Docscenarios_Meghana_wl extends testCaseBase {
    Login login;
    Alldocuments alldocuments;
    Uploaddocuments uploaddocuments;
    Addrecipients addrecipients;
    Dragdrop dragdrop;
    ReviewaNdSend reviewaNdSend;
    RecevierSide recevierSide;
    Signup signup;
    Templatespage templatespage;
    Dashboard dashboard;
    DocumentsScenarios documentsScenarios;

 

    @BeforeMethod
    public void Start() {
        setupDriver();
        login = new Login(driver);
        alldocuments = new Alldocuments(driver);
        uploaddocuments = new Uploaddocuments(driver);
        addrecipients = new Addrecipients(driver);
        dragdrop = new Dragdrop(driver);
        reviewaNdSend = new ReviewaNdSend(driver);
        recevierSide = new RecevierSide(driver);
        signup = new Signup(driver);
        templatespage = new Templatespage(driver);
        dashboard = new Dashboard(driver);
        documentsScenarios = new DocumentsScenarios(driver);
    }

    @Test(priority = 16)
    public void ValidBlankDocSignerApproverAndCC() throws Exception {
        login.Signin();
        documentsScenarios.DocScenario();
        documentsScenarios.Blankdocloginaccount();
        documentsScenarios.Recipients();
        documentsScenarios.Approver1();
        documentsScenarios.RecipientsCC3();
        documentsScenarios.Signorder();
        documentsScenarios.Saveuser();
        documentsScenarios.SignatureAndFullNameFeilds();
        documentsScenarios.DradAndDropAtTwo();
        documentsScenarios.DragAndDropAtThree();
        documentsScenarios.Senddoc();
        documentsScenarios.Blankwithoutsenderautofill();
    }

	// Blank Doc- (Signer, Multiple Approvers & CC)With/Without enforce signature
	// order & Without sender autofill-
	@Test(priority = 17)
	public void ValidBlankDocSignerMulApproverAndCC() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.multipleApprover();
		documentsScenarios.CCAtFour();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DragAndDropAtThreeFour();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	// Blank Doc- (Signer, Approvers& Multiple CC)With/Without enforce signature
	// order & Without sender autofill-
	@Test(priority = 18)
	public void ValidBlankDocSignerApproverAndMultipleCC() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Approver1();
		documentsScenarios.multipleCCThreeFour();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.DragAndDropAtThree();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// Blank Doc- (Signer, Multiple Approvers & Multiple CC)With/Without enforce
	// signature order & Without sender autofill-
	@Test(priority = 19)
	public void validBlankDocSignerMulApproverAndMulCC() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.multipleApprover();
		documentsScenarios.multipleCCFourFive();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.DragAndDropAtThreeFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// 10.Blankdoc-Rearranging order first Approver and then Signer &&
	// CC-Without enforce signature order & Without sender autofill-
	@Test(priority = 20)
	public void validOneDriveRearrangeorderApproverSignerAndCC() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Approver1();
		documentsScenarios.RecipientsCC3();
		documentsScenarios.Rearrange();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DragAndDropAtThree();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// 11.Rearranging order first CC and then Signer && Approver Without enforce
	// signature order & Without sender autofill-
	@Test(priority = 21)
	public void validOneDriveRearrangeorderCCSignerApprover() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Approver1();
		documentsScenarios.RecipientsCC3();
		documentsScenarios.Rearrange();
		documentsScenarios.RearrangeThreeOne();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DragAndDropAtThreeFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// 12.Rearranging order first Approver and then CC && Signer-
	@Test(priority = 22)
	public void validRearrangeorderApproverCCSigner() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Approver1();
		documentsScenarios.RecipientsCC3();
		documentsScenarios.Rearrange();
		documentsScenarios.RearrangeAtThreeTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.dragaAndDropAtFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// 13. Blank Doc-Rearranging order first Signer and then CC && Approver-Without
	// enforce signature order & Without sender autofill-
	@Test(priority = 23)
	public void validBlankDocRearrangeorderSignerCCApprover() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Approver1();
		documentsScenarios.RecipientsCC3();
		documentsScenarios.RearrangeAtThreeTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.dragaAndDropAtFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// 14.Blank Doc-Rearranging order first CC and then Approver && Signer-Without
	// enforce signature order & Without sender autofill-
	@Test(priority = 24)
	public void validBlankDocRearrangeorderCCApproversigner() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.Recipients();
		documentsScenarios.Approver1();
		documentsScenarios.RecipientsCC3();
		documentsScenarios.RearrangeThreeOne();
		documentsScenarios.RearrangeAtThreeTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DragAndDropAtThreeFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// 15.Blank Doc-Multiple signers , approver&& CC Without enforce signature order
	// & Without sender autofill-d
	@Test(priority = 25)
	public void validBlankDocMulsignerApproverCC() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.multipleSigner();
		documentsScenarios.ApproverThree();
		documentsScenarios.CCAtFour();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.DragAndDropAtThreeFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	// 16.Rearranging order first Other Signers and then Sender Signer &&
	// Approver-Without enforce signature order & Without sender autofill-d
	@Test(priority = 26)
	public void validBlankDocOtherSignerSenderSignerApprover() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.multipleSigner();
		documentsScenarios.ApproverThree();
		documentsScenarios.RearrangeZeroTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.DragAndDropAtThree();
		documentsScenarios.dragaAndDropAtFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// 17.Rearranging order first Approver and then Sender Signer && Other Signers-d
	@Test(priority = 27)
	public void validBlankDocApproverSenderSignerOtherSigner() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.multipleSigner();
		documentsScenarios.ApproverThree();
		documentsScenarios.RearrangeThreeOne();
		documentsScenarios.scrollUp();
		documentsScenarios.RearrangeSender();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.DragAndDropAtThree();
		documentsScenarios.dragaAndDropAtFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// 18.Rearranging order first Other Signers and then Approver && Sender Signer-d
	@Test(priority = 28)
	public void validBlankDocOtherSignerApproverSenderSigner() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.multipleSigner();
		documentsScenarios.ApproverThree();
		documentsScenarios.RearrangeZeroTwo();
		documentsScenarios.scrollDown();
		documentsScenarios.RearrangeAtThreeTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.DragAndDropAtThree();
		documentsScenarios.dragaAndDropAtFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	// 19.Rearranging order first Sender Signer and then Approver && Other Signers-d
	@Test(priority = 29)
	public void validBlankDocSenderSignerApproverOtherSigner() throws Exception {
		login.Signin();
		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.multipleSigner();
		documentsScenarios.ApproverThree();
		documentsScenarios.RearrangeThreeOne();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.SignatureAndFullNameFeilds();
		documentsScenarios.DradAndDropAtTwo();
		documentsScenarios.DragAndDropAtThree();
		documentsScenarios.dragaAndDropAtFour();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}
}
