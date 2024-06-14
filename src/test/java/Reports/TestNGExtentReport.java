package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Pages.MethodActions;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestNGExtentReport implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        // Initialize ExtentReports
        extent = new ExtentReports();

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/extent.html");
        htmlReporter.config().setDocumentTitle("TestNG Extent Report");
        htmlReporter.config().setReportName("TestNG Extent Report");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        // Attach the Spark HTML reporter to ExtentReports
        extent.attachReporter(htmlReporter);

        // Add system and environment info
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("User", System.getProperty("user.name"));
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush the ExtentReports instance
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a test entry in the Extent Report
        test = extent.createTest(result.getMethod().getMethodName()).assignCategory(result.getTestContext().getName()); // Assign test category
        test.assignAuthor("Author Name"); // Assign test author
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log test success status
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log test failure status and exception details
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable());

        // Capture screenshot
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        if (driver != null) {
            String screenshotPath = captureScreenshot(driver, result.getMethod().getMethodName());
            try {
                test.fail("Screenshot",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (Exception e) {
                test.log(Status.FAIL, "Failed to capture screenshot: " + e.getMessage());
            }
        }

        // Log bug details
        test.log(Status.FAIL, "Bug Details: <details>");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log test skipped status
        test.log(Status.SKIP, "Test Skipped");
    }

    // Method to capture screenshot
    private String captureScreenshot(WebDriver driver, String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String userDir = System.getProperty("user.dir");
        String screenshotPath = userDir + "/src/test/Screenshots/" + screenshotName + "_" + timestamp + ".png";
        try {
            MethodActions.takeScreenshot(driver);
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to capture screenshot: " + e.getMessage());
        }
        return screenshotPath;
    }
}
