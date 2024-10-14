package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SigninHR {
	WebDriver driver;
	MethodActions methodActions;

	public SigninHR(WebDriver driver) {

		this.driver = driver;
		methodActions = new MethodActions(driver);

	}

	public void checksignin() throws Exception {
		Thread.sleep(1000);
		MethodActions.sendKeysToElement(By.xpath("//input[@id='username']"), "HGTCON310");
		MethodActions.sendKeysToElement(By.xpath("//input[@id='password']"), "Prj@esign99");
		MethodActions.waitEle(By.xpath("//button[@type='submit']"));
		Thread.sleep(1000);

	}

	public void inandout() throws Exception {

		// JavaScript to access the shadow DOM and determine the sign-in state
		String scriptCheckState = "let shadowHost = document.querySelector('shadow-host-selector');" + // Replace
																										// 'shadow-host-selector'
				"let shadowRoot = shadowHost.shadowRoot || shadowHost.attachShadow({mode: 'open'});"
				+ "let signOutButton = shadowRoot.querySelector('button[name=\"primary\"]');"
				+ "let signInButton = shadowRoot.querySelector('button[name=\"secondary\"]');" + "if (signOutButton) {"
				+ "  if (getComputedStyle(signOutButton).display !== 'none') {" + // Assume hidden means signed out
				"    return 'signedIn';" + "  } else {" + "    return 'signedOut';" + "  }" + "} else {"
				+ "  return 'unknown';" + "}";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String state = (String) js.executeScript(scriptCheckState);

		if ("signedIn".equals(state)) {
			// Click the "Sign Out" button
			String scriptSignOut = "let shadowHost = document.querySelector('shadow-host-selector');"
					+ "let shadowRoot = shadowHost.shadowRoot || shadowHost.attachShadow({mode: 'open'});"
					+ "let signOutButton = shadowRoot.querySelector('button[name=\"primary\"]');"
					+ "signOutButton.click();";
			js.executeScript(scriptSignOut);
		} else if ("signedOut".equals(state)) {
			// Click the "Sign In" button
			String scriptSignIn = "let shadowHost = document.querySelector('shadow-host-selector');"
					+ "let shadowRoot = shadowHost.shadowRoot || shadowHost.attachShadow({mode: 'open'});"
					+ "let signInButton = shadowRoot.querySelector('button[name=\"secondary\"]');"
					+ "signInButton.click();";
			js.executeScript(scriptSignIn);
		} else {
			System.out.println("Unable to determine sign-in state");
		}
	}

}