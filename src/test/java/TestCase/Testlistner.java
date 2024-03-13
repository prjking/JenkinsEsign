
package TestCase;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Testlistner implements ITestListener {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33;1m";
	public static final String ANSI_GREEN = "\u001B[32;1m";
	public static final String ANSI_RED = "\u001B[31;1m";
	public static final String ANSI_BLUE = "\u001B[34;1m";
	public static final String ANSI_BOLD = "\u001B[1m";

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(
				ANSI_YELLOW + ANSI_BOLD + "Test method starting: " + result.getMethod().getMethodName() + ANSI_RESET);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(
				ANSI_GREEN + ANSI_BOLD + "Test method passed: " + result.getMethod().getMethodName() + ANSI_RESET);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(
				ANSI_RED + ANSI_BOLD + "Test method failed: " + result.getMethod().getMethodName() + ANSI_RESET);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(
				ANSI_BLUE + ANSI_BOLD + "Test method skipped: " + result.getMethod().getMethodName() + ANSI_RESET);
	}

}

