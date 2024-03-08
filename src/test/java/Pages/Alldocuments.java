package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Alldocuments {
	WebDriver driver;

	public Alldocuments(WebDriver driver) {
		this.driver = driver;
	}

	public void waitEle(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void Createdocument() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Create Document']"));

	}

	public void Validdocument() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement DocMessage = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//h3[@class='text-center text-dark fw-normal fs-4 mb-1']")));

		Assert.assertEquals(DocMessage.getText(), "Upload Documents");

		System.out.println("Upload Documents Page Displayed");
	}

}
