<<<<<<< HEAD
package TestCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.Addrecipients;
import Pages.Alldocuments;
import Pages.Dashboard;
import Pages.DocumentsScenarios;
import Pages.Dragdrop;
import Pages.Login;
import Pages.RecevierSide;
import Pages.ReviewaNdSend;
import Pages.Signup;
import Pages.Templatespage;
import Pages.Uploaddocuments;
import TestBase.testCaseBase;
import Reports.TestNGExtentReport;
import Reports.Testlistner;
@Listeners({ TestNGExtentReport.class, Testlistner.class })

public class Docscenarios_Ramya extends testCaseBase {
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
		setup();
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

	@Test(priority = 30)
	public void VerifyAppSigSenderorderWOEWOA() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddApprover();
		documentsScenarios.AddRearrangeAPPSignerSenderThreeOne();
		documentsScenarios.AddRearrangeSender();
		documentsScenarios.AddRearrangeZeroFour();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddEssentialFields();
		documentsScenarios.AddEssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 31)
	public void VerifySendersigCCorderWOEWOA() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();

		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddRecipientsCC();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddEssentialFieldscc();
		documentsScenarios.AddEssentialFieldsccSender();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	@Test(priority = 32)
	public void VerifySigSenderCCorderWOEWOA() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();

		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddRecipientsCC();
		documentsScenarios.AddRearrangeSignerSenderCCThreeOne();
		documentsScenarios.AddRearrangeSigners();
		documentsScenarios.AddRearrangeOneTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddEssentialFieldscc();
		documentsScenarios.AddEssentialFieldsccSender();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 33)
	public void VerifyCCSenderSingerWOEWOA() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();

		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddRecipientsCC();
		documentsScenarios.AddRearrangeCCSenderSignerThreeOne();
		documentsScenarios.AddRearrangeSendercc();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddEssentialFields();
		documentsScenarios.AddEssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 34)
	public void VerifySingerCCSenderWOEWOA() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();

		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddRecipientsCC();
		documentsScenarios.AddRearrangeSignersCCSenderThreeOne();
		documentsScenarios.AddRearrangeCC();
		documentsScenarios.AddRearrangeOnetoThree();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddRearrangeSenderFields1();
		documentsScenarios.AddEssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 35)
	public void VerifySenderCCSignerWOEWOA() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddRecipientsCC();
		documentsScenarios.AddRearrangeSenderCCSignersThreeOne();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddSenderFields();
		documentsScenarios.AddEssentialFieldsccSender();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	@Test(priority = 36)
	public void VerifyCCSignerSenderWOEWOA() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddRecipientsCC();
		documentsScenarios.AddRearrangeCCSignerSENDERThreeOne();
		documentsScenarios.AddRearrangeccsignersender();
		documentsScenarios.AddRearrangeZeroFour1();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddSenderFields2();
		documentsScenarios.AddEssentialFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 37)
	public void VerifySenderMultipleApprovers() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();

		documentsScenarios.AddMultipleApprovers();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddSenderFields();
		documentsScenarios.AddMultipleAPPFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	@Test(priority = 38)
	public void VerifyMultpleApproverSender() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.AddMultipleApprovers();
		documentsScenarios.AddRearrangeMulApproverSENDERThreeOne();
		documentsScenarios.AddRearrangeMultipleApproverssender();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddRearrangeMultipleAPPFields();
		documentsScenarios.AddRearrangeSenderFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	@Test(priority = 39)
	public void VerifySenderMultipleCC() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.AddMultipleCC();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddSenderFields();
		documentsScenarios.AddFinishdocument();
	}

	@Test(priority = 40)
	public void VerifyMultpleCCSender() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.AddMultipleCC();
		documentsScenarios.AddRearrangeMulApproverSENDERThreeOne();
		documentsScenarios.AddRearrangeMultipleApproverssender();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddRearrangeSenderFields();
		documentsScenarios.AddFinishdocument();
	}
}
=======
package TestCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.Addrecipients;
import Pages.Alldocuments;
import Pages.Dashboard;
import Pages.DocumentsScenarios;
import Pages.Dragdrop;
import Pages.Login;
import Pages.RecevierSide;
import Pages.ReviewaNdSend;
import Pages.Signup;
import Pages.Templatespage;
import Pages.Uploaddocuments;
import TestBase.testCaseBase;

@Listeners(Testlistner.class)

public class Docscenarios_Ramya extends testCaseBase {
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
		setup();
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

	@Test(priority = 30)
	public void VerifyAppSigSenderorderWOEWOA() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddApprover();
		documentsScenarios.AddRearrangeAPPSignerSenderThreeOne();
		documentsScenarios.AddRearrangeSender();
		documentsScenarios.AddRearrangeZeroFour();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddEssentialFields();
		documentsScenarios.AddEssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 31)
	public void VerifySendersigCCorderWOEWOA() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();

		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddRecipientsCC();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddEssentialFieldscc();
		documentsScenarios.AddEssentialFieldsccSender();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	@Test(priority = 32)
	public void VerifySigSenderCCorderWOEWOA() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();

		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddRecipientsCC();
		documentsScenarios.AddRearrangeSignerSenderCCThreeOne();
		documentsScenarios.AddRearrangeSigners();
		documentsScenarios.AddRearrangeOneTwo();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddEssentialFieldscc();
		documentsScenarios.AddEssentialFieldsccSender();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 33)
	public void VerifyCCSenderSingerWOEWOA() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();

		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddRecipientsCC();
		documentsScenarios.AddRearrangeCCSenderSignerThreeOne();
		documentsScenarios.AddRearrangeSendercc();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddEssentialFields();
		documentsScenarios.AddEssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 34)
	public void VerifySingerCCSenderWOEWOA() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();

		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddRecipientsCC();
		documentsScenarios.AddRearrangeSignersCCSenderThreeOne();
		documentsScenarios.AddRearrangeCC();
		documentsScenarios.AddRearrangeOnetoThree();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddRearrangeSenderFields1();
		documentsScenarios.AddEssentialFields1();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 35)
	public void VerifySenderCCSignerWOEWOA() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddRecipientsCC();
		documentsScenarios.AddRearrangeSenderCCSignersThreeOne();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddSenderFields();
		documentsScenarios.AddEssentialFieldsccSender();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	@Test(priority = 36)
	public void VerifyCCSignerSenderWOEWOA() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.AddMultipleSigners();
		documentsScenarios.AddRecipientsCC();
		documentsScenarios.AddRearrangeCCSignerSENDERThreeOne();
		documentsScenarios.AddRearrangeccsignersender();
		documentsScenarios.AddRearrangeZeroFour1();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddSenderFields2();
		documentsScenarios.AddEssentialFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();

	}

	@Test(priority = 37)
	public void VerifySenderMultipleApprovers() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();

		documentsScenarios.AddMultipleApprovers();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddSenderFields();
		documentsScenarios.AddMultipleAPPFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	@Test(priority = 38)
	public void VerifyMultpleApproverSender() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.AddMultipleApprovers();
		documentsScenarios.AddRearrangeMulApproverSENDERThreeOne();
		documentsScenarios.AddRearrangeMultipleApproverssender();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddRearrangeMultipleAPPFields();
		documentsScenarios.AddRearrangeSenderFields();
		documentsScenarios.Senddoc();
		documentsScenarios.Blankwithoutsenderautofill();
	}

	@Test(priority = 39)
	public void VerifySenderMultipleCC() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.AddMultipleCC();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddSenderFields();
		documentsScenarios.AddFinishdocument();
	}

	@Test(priority = 40)
	public void VerifyMultpleCCSender() throws Exception {
		login.Signin();

		documentsScenarios.DocScenario();
		documentsScenarios.Blankdocloginaccount();
		documentsScenarios.AddMultipleCC();
		documentsScenarios.AddRearrangeMulApproverSENDERThreeOne();
		documentsScenarios.AddRearrangeMultipleApproverssender();
		documentsScenarios.Signorder();
		documentsScenarios.Saveuser();
		documentsScenarios.AddRearrangeSenderFields();
		documentsScenarios.AddFinishdocument();
	}
}
>>>>>>> 757c8599b6f379ae5caf0697938fa6202124e5dc
