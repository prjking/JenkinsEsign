package Pages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

public class EntityCases {
	WebDriver driver;
	MethodActions methodActions;

	public EntityCases(WebDriver driver) {
		this.driver = driver;
		methodActions = new MethodActions(driver);

	}

	public void entity() throws Exception {

		Thread.sleep(10000);

		MethodActions.Loadingmask();
		MethodActions.waitEle(By.xpath("//div[@class=\"icon-text\"]"));
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[7]"));
		System.out.println("Clicked on entities in profile completed");

	}

	public void CreateEntityScratch() throws Exception {
		Thread.sleep(10000);

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Create Entity']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		try {
			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

		}
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		By Title = By.xpath("//input[@placeholder='Title']");
		WebElement Title1 = wait.until(ExpectedConditions.elementToBeClickable(Title));
		Title1.sendKeys("entity-0001");

		By Description = By.xpath("//textarea[@placeholder='Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("This entity is only for testing purpose");

		MethodActions.waitEle(By.xpath("//span[normalize-space()='GENERAL']"));

		MethodActions.waitEle(
				By.xpath("//p[normalize-space()='Create a new app base with custom fields,tables, and filters.']"));

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Confirm']"));

	}

	public void actionView() throws Exception {
		Thread.sleep(10000);

		MethodActions.pagenation(
				"//div[@class='el-table__fixed']//div[contains(text(), 'bb')]/ancestor::tr//span[normalize-space()=\"Actions\"]");

		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(), 'bb')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[1]"));

	}

	public void actionView1() throws Exception {
		Thread.sleep(10000);

		MethodActions.pagenation(
				"//div[@class='el-table__fixed']//div[contains(text(), 'Sample')]/ancestor::tr//span[normalize-space()='Actions']");

		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(), 'Sample')]/ancestor::tr//span[normalize-space()='Actions']"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[1]"));

	}

	public void EyeIcon() throws Exception {
		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("//div[@class='el-table__fixed-right'] //tr[1]//button/span/i"));
	}

	public void layout() throws Exception {
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Layout']"));
		MethodActions.waitEle(By.xpath("//ul[@x-placement='bottom-end']"));
		MethodActions.waitEle(By.xpath("//a[@class='mt- el-link el-link--default']"));

	}

	public void clickOnLayout() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@class=\"right-block float-right\"]//i[@class=\"el-icon-more\"]"));

	}

	public void layoutChart() throws Exception {
		MethodActions.waitEle(By.xpath("//p[text()=\" Charts \"]"));
		MethodActions.waitEle(By.xpath("//header//i"));

	}

	public void SelectChart() throws Exception {

		Thread.sleep(10000);
		MethodActions.Javascriptclick(By.xpath("(//div[@class='entity-navbar']//input)[3]"));

		// pie
		MethodActions.waitEle(By.xpath("//div[@x-placement='bottom-start']//li[1]"));
		MethodActions.waitEle(By
				.xpath("//div[contains(@class,'el-select mr-1')]//input[contains(@placeholder,'Select chart field')]"));
		MethodActions.waitEle(By.xpath("//div[@x-placement='bottom-start']//li[1]"));
		MethodActions.Loadingmask();
		MethodActions.waitEle(By.xpath("(//div[@class='entity-navbar']//input)[3]"));
		// Bar
		MethodActions.waitEle(By.xpath("//div[@x-placement='bottom-start']//li[2]"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("(//div[@class='entity-navbar']//input)[3]"));
		// pie
		MethodActions.waitEle(By.xpath("//div[@x-placement='bottom-start']//li[1]"));

		WebElement imageElement = driver.findElement(By.xpath("//canvas[@id='pie-chart']"));
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage browserImage = ImageIO.read(screenshotFile);

		File localImageFile = new File("C:\\Users\\prudhvi.buddharaju\\Downloads\\download.png");
		BufferedImage localImage = ImageIO.read(localImageFile);

		boolean imagesAreEqual = compareImages(browserImage, localImage);

		if (imagesAreEqual) {
			System.out.println("Images are equal Bug Cleared");
		} else {
			System.out.println("Images are not equal Bug Not Yet Cleared");
		}

		driver.navigate().refresh();
	}

	private static boolean compareImages(BufferedImage image1, BufferedImage image2) {
		if (image1.getWidth() != image2.getWidth() || image1.getHeight() != image2.getHeight()) {
			return false;
		}

		for (int x = 0; x < image1.getWidth(); x++) {
			for (int y = 0; y < image1.getHeight(); y++) {
				if (image1.getRGB(x, y) != image2.getRGB(x, y)) {
					return false;
				}
			}
		}

		return true;

	}

	public void LayoutOptions() throws Exception {
		MethodActions.waitEle(By.xpath("//a[@class='el-link el-link--default']"));
		MethodActions.waitEle(By.xpath("//div[@class='layout-container']//input[@placeholder='Select layout']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement='bottom-start']//li[1]"));
		MethodActions.waitEle(By.xpath("//header//i"));
		MethodActions.waitEle(By.xpath("//div[@id='tab-65d7146e888acfaa3006c623']"));
	}

	public void Validdata() throws InterruptedException {
		String xpath1 = "//p[normalize-space()='(555) 697-456']";
		Thread.sleep(10000);
		String xpath2 = "//p[@style='height: 50px; font-weight: 400;']";

		WebElement element1 = driver.findElement(By.xpath(xpath1));
		Thread.sleep(10000);
		WebElement element2 = driver.findElement(By.xpath(xpath2));

		String text1 = element1.getText().trim();
		String text2 = element2.getText().trim();

		System.out.println("Element 1 text: " + text1);
		System.out.println("Element 2 text: " + text2);

		if (text1.equals(text2)) {
			System.out.println("Both elements have the same text.");
		} else {
			System.out.println("Both elements have different text.");
		}

	}

	public void actionView2() throws Exception {
		Thread.sleep(10000);

		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(), 'Testing')]/ancestor::tr//span[normalize-space()='Actions']"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));

	}

	public void actionView3() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver
				.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//span[normalize-space()='Actions']"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));

	}

	public void actionView4() throws Exception {
		Thread.sleep(10000);

		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(), '4575')]/ancestor::tr//span[normalize-space()='Actions']"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));

	}

	public void ValidBulkupdate() throws Exception {
		Thread.sleep(10000);

		MethodActions.waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[1]"));
		Thread.sleep(10000);
		MethodActions.Javascriptclick(By.xpath("//ul[@class='action-buttons hover-buttons unordered']//div"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[2]"));

		MethodActions.switchToNewWindow();
		Thread.sleep(10000);

		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));

		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[3]"));

		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Update']"));

		MethodActions.waitEle(By.xpath("//div[@class='el-badge item']//button"));

		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//button[@class='el-button el-button--text']"));
		MethodActions.waitEle(By.xpath("//div[@class='el-scrollbar']//input[@placeholder='Entity Field']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement='top-start']//li[1]"));
		MethodActions.waitEle(By.xpath("//div[@class='el-scrollbar']//input[@placeholder='Operator']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement='top-start']//li[1]"));
		MethodActions.waitEle(By.xpath("//div[@class='el-scrollbar']//input[@placeholder='Value type']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement='top-start']//li[1]"));
		MethodActions.waitEle(By.xpath("//div[@class='el-scrollbar']//input[@placeholder='Entity Field']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement='top-start']//li[1]"));
		MethodActions.sendKeysToElement(By.xpath("//div[@class='el-scrollbar']//div[@class='el-input el-input--mini']"),
				"150");

	}

	public void valid4833() {
		WebElement elementB = driver
				.findElement(By.xpath("(//td[@class='el-table_1_column_6   el-table__cell']//p[text()='B'])[1]"));
		WebElement elementC = driver
				.findElement(By.xpath("(//td[@class='el-table_1_column_6   el-table__cell']//p[text()='C'])[1]"));

		String status;
		if (elementB.getText().equals("failed")) {
			status = "failed";
		} else if (elementC.getText().equals("success")) {
			status = "success";
		} else {
			status = "unknown";
		}

		System.out.println("Status: " + status);

	}

	public void SigninPreetham() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
				.sendKeys("Malagapreetham0111@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Preetham@01");
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Log In']"));
		Thread.sleep(10000);

	}

	public void SigninAkhilorsu() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
				.sendKeys("akhil.orsu@nimbleaccounting.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Akhil@2001");
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Log In']"));
		Thread.sleep(10000);

	}

	public void ValidBulku4833() throws Exception {
		Thread.sleep(10000);

		WebElement elementToHover = driver.findElement(
				By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]//ul//i[@class='el-icon-more']"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[1]"));

	}

	public void ValidBulkuDel4833() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(
				By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]//ul//i[@class='el-icon-more']"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[3]"));
		System.out.println("Bug Yet to Be Cleared");
	}

	public void loopclick() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		int pageNumber = 1;
		do {
			try {
				WebElement elementToHover = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//div[@class='el-table__fixed']//div[normalize-space()='Employee form']/ancestor::tr//span[normalize-space()='Actions']")));
				Actions actions = new Actions(driver);
				actions.moveToElement(elementToHover).perform();
				MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[1]"));
				System.out.println("Element found on page " + pageNumber);
			} catch (Exception e) {
				System.out.println("Element not found on page " + pageNumber);
			}

			try {
				WebElement nextPageButton = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-next']")));
				nextPageButton.click();
				pageNumber++;
			} catch (Exception e) {
				System.out.println("Next page button not found or timeout, ending loop.");
				break;
			}
		} while (true);

	}

	public void listclick() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		int pageNumber = 1;
		boolean nextPageExists = true;

		do {
			try {
				List<WebElement> elementsList = driver.findElements(By.xpath(
						"//div[@class='el-table__fixed']//div[normalize-space()='Employee form']/ancestor::tr//span[normalize-space()='Actions']"));

				List<String> pages = elementsList.stream().map(WebElement::getText).collect(Collectors.toList());

				pages.forEach(a -> System.out.println(a));

				nextPageExists = !driver.findElements(By.xpath("//button[@class='btn-next']")).isEmpty();

				if (nextPageExists) {

					Actions actions = new Actions(driver);
					WebElement elementToHover = driver.findElement(By.xpath(
							"//div[@class='el-table__fixed']//div[normalize-space()='Employee form']/ancestor::tr//span[normalize-space()='Actions']"));
					actions.moveToElement(elementToHover).perform();

					driver.findElement(By.xpath("//button[@class='btn-next']")).click();
					pageNumber++;
				}
			} catch (Exception e) {
				System.out.println("Element not found on page " + pageNumber);
				break; // Exit the loop if there's an error
			}

		} while (nextPageExists);

	}

	private static String getPriceVeggie(WebElement s) {

		// TODO Auto-generated method stub

		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();

		return pricevalue;

	}

}
