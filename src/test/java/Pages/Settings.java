package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Settings {
	WebDriver driver;
	MethodActions methodActions;

	public Settings(WebDriver driver) {
		this.driver = driver;
		methodActions = new MethodActions(driver);
	}

	public void Set() throws Exception {
		Thread.sleep(5000);
		MethodActions.Loadingmask();
		// MethodActions.waitEle(By.xpath("//div[@class='icon-text']"));
		// Thread.sleep(5000);
		// MethodActions.waitEle(By.xpath("//ul[@x-placement]//li[normalize-space()='Settings']"));
		driver.get("https://nsui.esigns.io/profilesettings");

	}

	public void DashboardStatistics() throws Exception {
		Thread.sleep(5000);

		for (int i = 1; i <= 13; i++) {

			String xpath = ("(//span[@class='el-switch__core'])[" + i + "]");
			WebElement element = driver.findElement(By.xpath(xpath));
			element.click();
			Thread.sleep(5000);
			try {
				MethodActions.waitEle(By.xpath("//div[@class='el-notification__closeBtn el-icon-close']"));
			} catch (Exception e) {

			}

		}
	}
//		for (int i = 1; i <= 13; i++) {
//
//			String xpath = "(//span[@class='el-switch__label el-switch__label--right is-active'])[" + i + "]";
//
//			WebElement element = driver.findElement(By.xpath(xpath));
//			element.isDisplayed();
//
//			if (allDisplayed) {
//
//				System.out.println("Dashboard Stats settings ON successfully");
//				Thread.sleep(1000);
//				MethodActions.waitEle(By.xpath("//span[normalize-space()='Dashboard']"));
//				WebElement dashboard = driver
//						.findElement(By.xpath("(//div[contains(@class,'card dashboard-top-buttons')]//div)[1]"));
//
//				if (dashboard.isDisplayed()) {
//					System.out.println("Dashboard Buttons Displayed");
//				} else {
//
//				}
//			}
//
//			else {
//				System.out.println("Dashboard Stats settings OFF successfully");
//				Thread.sleep(1000);
//				MethodActions.waitEle(By.xpath("//span[normalize-space()='Dashboard']"));
//
//				WebElement dashboard = driver
//						.findElement(By.xpath("(//div[contains(@class,'card dashboard-top-buttons')]//div)[1]"));
//
//				if (!dashboard.isDisplayed()) {
//					System.out.println("Dashboard Buttons  not Displayed.");
//				} else {
//
//				}
//			}
//		}

	private void setInputFieldValue(int index, String value, String min) throws Exception {
		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("//a[normalize-space(text())='Expiration & Reminders']"));
		Thread.sleep(5000);
		String xpath = String.format("(//input[@min='%s'])[%d]", min, index);
		WebElement field = driver.findElement(By.xpath(xpath));
		field.clear();
		field.sendKeys(value);
	}

	public void Reminders() throws Exception {
		setInputFieldValue(1, "54", "1");
		setInputFieldValue(2, "4", "1");
		setInputFieldValue(3, "5", "1");
	}

	public void AutoReminders() throws Exception {
		setInputFieldValue(1, "3", "0");
		setInputFieldValue(2, "1", "0");
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Cancel']"));
		// MethodActions.waitEle(By.xpath("//span[normalize-space()='Save Changes']"));

	}

	public void ApplicationSettings() throws Exception {

		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("//a[normalize-space(text())='Application Settings']"));
		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("(//input[@class='el-input__inner'])[3]"));
		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[3]"));

		for (int i = 2; i <= 5; i++) {

			String xpath = "(//span[@class='el-checkbox__inner'])[" + i + "]";
			WebElement check = driver.findElement(By.xpath(xpath));
			check.click();
			Thread.sleep(2000);

		}

	}

	public void Notifications() throws Exception {

		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("//a[normalize-space(text())='Notifications']"));
		Thread.sleep(5000);

		for (int i = 1; i <= 7; i++) {

			String xpath = "(//span[@class='el-checkbox__inner'])[" + i + "]";
			WebElement check = driver.findElement(By.xpath(xpath));
			check.click();
			Thread.sleep(2000);

		}
		MethodActions.waitEle(By.xpath("//span[normalize-space(text())='Save Changes']"));
		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("//a[normalize-space(text())='My Apps & Credentials']"));

	}
	
}
