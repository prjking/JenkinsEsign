package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scrool {

	WebDriver driver;

	public Scrool(WebDriver driver) {

		this.driver = driver;

	}

	public void waitEle(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	private void waitAndClick(Actions actions, WebElement element, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		try {

			WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));

			actions.clickAndHold(clickableElement).moveToElement(target).release().build().perform();

			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void Scroolele() throws Exception {
		driver.get(
				"https://dev.esigns.io/company-documents/65cdd5aaf0daa150cf954a29/configure/image/65cdd5aaf0daa150cf954a2a/update");
        Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("(//div[normalize-space()='EMPLOYEE FORM'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement CC = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='name'][normalize-space()='NAME']")));
		WebElement Signer = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(CC).moveToElement(Signer).release().build().perform();
		System.out.println("Rearranged Fields Successfully");
	}

}
