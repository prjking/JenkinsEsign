package Pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateFromExcell {
	WebDriver driver;
	MethodActions methodActions;

	public CreateFromExcell(WebDriver driver) {
		this.driver = driver;
		methodActions = new MethodActions(driver);

	}

	public void Importexcel() throws Exception {
		Thread.sleep(10000);
		MethodActions.Loadingmask();
		MethodActions.waitEle(By.xpath("//div[@class='icon-text']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[6]"));
		MethodActions.waitEle(By.xpath("//button[@class='p-button export-all p-button p-component']"));
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Description']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("(//span[@class='el-radio__label'])[2]"));
		MethodActions.waitEle(By.xpath("//span[text()='Confirm']"));
		MethodActions.waitEle(By.xpath("//button[@class='match_upload_button mt-0']"));
		Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\Importexcel\"");
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//span[text()='Next']"));
	}

	public void Selectall() throws Exception {
		Thread.sleep(10000);
		for (int i = 1; i <= 56; i++) {
			MethodActions.waitEle(By.xpath("(//input[@placeholder='Select form template'])[" + i + "]"));
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
			Thread.sleep(10000);
		}

	}

	public void selectlist() throws Exception {
		Thread.sleep(10000);
		Random random = new Random();

		for (int j = 1; j <= 56; j++) {

			MethodActions.waitEle(By.xpath("(//input[@placeholder='Select field'])[" + j + "]"));
			// String inputXpath = "(//input[@placeholder='Select field'])[" + j + "]";
			// WebElement inputElement1 = driver.findElement(By.xpath(inputXpath));
			// inputElement1.click();
			Thread.sleep(10000);

			// MethodActions.waitEle(By.xpath("//div[@x-palcment]//li[1]"));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@x-palcment]//li[1]")));

			List<WebElement> listItems = driver.findElements(By.xpath("//div[@x-palcment]//li"));
			int totalItems = listItems.size();

			int randomNumber = random.nextInt(totalItems) + 1;

			String listXpath = "//div[@x-palcment]//li[" + randomNumber + "]";
			WebElement liElement1 = driver.findElement(By.xpath(listXpath));

			wait1.until(ExpectedConditions.elementToBeClickable(liElement1));
			liElement1.click();

			wait1.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath("//div[@x-palcment]//li[" + randomNumber + "]")));
		}
	}

	public void add() throws Exception {
		MethodActions.waitEle(By.xpath("(//i[@class='el-icon-circle-plus'])[1]"));
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter template name']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[text()='Save']"));
		MethodActions.waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[1]"));
		MethodActions.waitEle(By.xpath("//span[text()='Next']"));
		MethodActions.switchToNewWindow();
		MethodActions.waitEle(By.xpath("//div[@style='text-align: right;']//span[text()='Confirm']"));
		MethodActions.waitEle(By.xpath("//span[text()='Import']"));
		MethodActions.waitEle(By.xpath("//div[@class='text-center popUp-content']//button"));

	}
}
