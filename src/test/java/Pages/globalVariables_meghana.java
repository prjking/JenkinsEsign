package Pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class globalVariables_meghana {
	static WebDriver driver;

	public globalVariables_meghana(WebDriver driver) {

		globalVariables_meghana.driver = driver;

	}

	public void waitEle(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public static void Javascriptclick(By xpath) throws Exception {
		Thread.sleep(3000);

		WebElement element = driver.findElement(xpath);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	public void windowHandle() {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
	}

	public void waitAndClick(Actions actions, WebElement sourceElement, WebElement targetElement, int xOffset,
			int yOffset) {
		actions.clickAndHold(sourceElement).moveToElement(targetElement, xOffset, yOffset).release().build().perform();
	}

	public void sendKeysToElement(By by, CharSequence keysToSend) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(keysToSend);
	}

	public void Loadingmask() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

		}

	}

	public void clickGlobalVariable() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@class='icon-text']"));
		Javascriptclick(By.xpath("//li[normalize-space()='Global Variables']"));

		System.out.println("Clicked on Global Variables in profile completed");
	}

	public boolean VerifyClickGlobalVariable() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement name = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@id=\"global-variables-list\"]")));
		System.out.println("Click on global variables done Sucessfully");
		return name.isDisplayed();
	}

	public void clickNewVariable() throws Exception {
		waitEle(By.xpath("//span[@class='new-variable']"));
	}

	public void selectDataType() throws Exception {
		waitEle(By.xpath("//input[@placeholder=\"Select Data Type\"]"));
	}

	public void selectNumberOrSinglineTextField(String Feild, String title, String value, String tagName)
			throws Exception {
		String selectfield = String.format("//span[text()=\"%s\"]", Feild);
		Javascriptclick(By.xpath(selectfield));
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Field Title\"]"), Feild);
		sendKeysToElement(By.xpath("(//input[@class=\"el-input__inner\"])[5]"), value);
		waitEle(By.xpath("//span[normalize-space()=\"Add Variable\"]"));
	}

	public void multiLine(String Feild, String title, String value, String tagName) throws Exception {
		String selectfield = String.format("//span[text()=\"%s\"]", Feild);
		Javascriptclick(By.xpath(selectfield));
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Field Title\"]"), Feild);
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Number Of Rows\"]"), "5");
		sendKeysToElement(By.xpath("//textarea[@placeholder=\"Value\"]"), value);
		waitEle(By.xpath("//span[normalize-space()=\"Add Variable\"]"));
	}

	public void selectField(String Feild) throws Exception {
		String selectfield = String.format("//span[text()=\"%s\"]", Feild);
		Javascriptclick(By.xpath(selectfield));
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Field Title\"]"), Feild);

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//div[@class='el-form-item__content']//div[@class='el-select__tags']//input[@type='text']")));

			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

			jsExecutor.executeScript("arguments[0].focus();", element);
			jsExecutor.executeScript("arguments[0].value = '';", element);
			jsExecutor.executeScript(
					"var event = new Event('input', { bubbles: true }); arguments[0].dispatchEvent(event);", element);
			Thread.sleep(2000);

			jsExecutor.executeScript(
					"arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
					element, "meghana");
			Thread.sleep(10000);

			WebElement firstSuggestion = waitEle(driver, By.xpath("//div[@x-placement]//li[1]"));
			firstSuggestion.click();
			Thread.sleep(2000);
			jsExecutor.executeScript("arguments[0].focus();", element);
			jsExecutor.executeScript(
					"var event = new Event('input', { bubbles: true }); arguments[0].dispatchEvent(event);", element);
			jsExecutor.executeScript(
					"arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
					element, "pemma");
			Thread.sleep(10000);

			Javascriptclick(By.xpath("//div[@x-placement]//li[1]"));
			Thread.sleep(5000);
			jsExecutor.executeScript("arguments[0].focus();", element);
			jsExecutor.executeScript(
					"var event = new Event('input', { bubbles: true }); arguments[0].dispatchEvent(event);", element);
			jsExecutor.executeScript(
					"arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
					element, "mohan");
			Thread.sleep(5000);

			Javascriptclick(By.xpath("//div[@x-placement]//li[1]"));
			Thread.sleep(2000);

			waitEle(By.xpath("//span[normalize-space()='Add Variable']"));

		} finally {

		}
	}

	private static WebElement waitEle(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void dateField(String Feild) throws Exception {
		String selectfield = String.format("//span[text()=\"%s\"]", Feild);
		Javascriptclick(By.xpath(selectfield));
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Field Title\"]"), Feild);
		waitEle(By.xpath("//input[@placeholder=\"Pick a day\"]"));
		waitEle(By.xpath("// div[@class=\"el-picker-panel__content\"]//tr[@class=\"el-date-table__row\"][3]//td[1]"));
		waitEle(By.xpath("//span[normalize-space()=\"Add Variable\"]"));
	}

	public void Time(String Feild) throws Exception {
		String selectfield = String.format("//span[text()=\"%s\"]", Feild);
		Javascriptclick(By.xpath(selectfield));
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Field Title\"]"), Feild);
		waitEle(By.xpath("//input[@placeholder=\"Select Time\"]"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[1]//ul//li[text()='12']"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[2]//ul//li[text()='12']"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[3]//ul//li[text()='12']"));
		waitEle(By.xpath("//button[text()=\"OK\"]"));
		waitEle(By.xpath("//span[normalize-space()=\"Add Variable\"]"));
	}

	public void fixedTime(String Feild) throws Exception {
		String selectfield = String.format("//span[text()=\"%s\"]", Feild);
		Javascriptclick(By.xpath(selectfield));
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Field Title\"]"), Feild);
		waitEle(By.xpath("//span[@class='el-checkbox__inner']"));

		waitEle(By.xpath("//span[normalize-space()=\"Add Variable\"]"));
	}

	public void dateTime(String Feild) throws Exception {
		String selectfield = String.format("//span[text()=\"%s\"]", Feild);
		Javascriptclick(By.xpath(selectfield));
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Field Title\"]"), Feild);
		waitEle(By.xpath(
				"//div[@class=\"el-date-editor el-input el-input--prefix el-input--suffix el-date-editor--datetime\"]//input[@type=\"text\"]"));
		waitEle(By.xpath("// div[@class=\"el-picker-panel__content\"]//tr[@class=\"el-date-table__row\"][3]//td[1]"));
		waitEle(By.xpath("//input[@placeholder=\"Select time\"]"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[1]//ul//li[text()='12']"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[2]//ul//li[text()='12']"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[3]//ul//li[text()='12']"));
		waitEle(By.xpath("//button[text()=\"OK\"]"));
		waitEle(By.xpath("//div[@class=\"el-picker-panel__footer\"]//span[normalize-space()=\"OK\"]"));
		waitEle(By.xpath("//span[normalize-space()=\"Add Variable\"]"));

	}

	public void dateTimeRange(String Feild) throws Exception {
		String selectfield = String.format("//span[text()=\"%s\"]", Feild);
		Javascriptclick(By.xpath(selectfield));
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Field Title\"]"), Feild);
		waitEle(By.xpath("//input[@placeholder=\"Start date\"]"));
		waitEle(By.xpath(
				"//div[@x-placement]//div[@class=\"el-picker-panel__content el-date-range-picker__content is-left\"]//tr[3]//td[4]"));
		waitEle(By.xpath(
				"//div[@x-placement]//div[@class=\"el-picker-panel__content el-date-range-picker__content is-right\"]//tr[3]//td[4]"));

		waitEle(By.xpath("//input[@placeholder=\"Start Time\"]"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[1]//ul//li[text()='12']"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[2]//ul//li[text()='12']"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[3]//ul//li[text()='12']"));
		waitEle(By.xpath("//button[text()=\"OK\"]"));
		waitEle(By.xpath("//input[@placeholder=\"End Time\"]"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[4]//ul//li[text()='12']"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[5]//ul//li[text()='12']"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[6]//ul//li[text()='12']"));
		waitEle(By.xpath("(//button[text()=\"OK\"])[2]"));
		waitEle(By.xpath("//div[@class=\"el-picker-panel__footer\"]//span[normalize-space()=\"OK\"]"));
		waitEle(By.xpath("//span[normalize-space()=\"Add Variable\"]"));
	}

	public void dateRange(String Feild) throws Exception {
		String selectfield = String.format("//span[text()=\"%s\"]", Feild);
		Javascriptclick(By.xpath(selectfield));
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Field Title\"]"), Feild);
		waitEle(By.xpath("//input[@placeholder=\"Start date\"]"));
		waitEle(By.xpath(
				"//div[@x-placement]//div[@class=\"el-picker-panel__content el-date-range-picker__content is-left\"]//tr[3]//td[4]"));
		waitEle(By.xpath(
				"//div[@x-placement]//div[@class=\"el-picker-panel__content el-date-range-picker__content is-right\"]//tr[3]//td[4]"));
		waitEle(By.xpath("//span[normalize-space()=\"Add Variable\"]"));

	}

	public void timeRange(String Feild) throws Exception {
		String selectfield = String.format("//span[text()=\"%s\"]", Feild);
		Javascriptclick(By.xpath(selectfield));
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Field Title\"]"), Feild);
		waitEle(By.xpath("//input[@placeholder=\"Start Time\"]"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[1]//ul//li[text()='12']"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[2]//ul//li[text()='12']"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[3]//ul//li[text()='12']"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[4]//ul//li[text()='12']"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[5]//ul//li[text()='12']"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[6]//ul//li[text()='12']"));
		waitEle(By.xpath("//button[text()=\"OK\"]"));
		waitEle(By.xpath("//span[normalize-space()=\"Add Variable\"]"));
	}

	public void weekdays(String Feild) throws Exception {
		String selectfield = String.format("//span[text()=\"%s\"]", Feild);
		Javascriptclick(By.xpath(selectfield));
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Field Title\"]"), Feild);
		waitEle(By.xpath("//input[@placeholder=\"Select\"]"));
		waitEle(By.xpath("//span[text()=\"Sunday\"]"));
		waitEle(By.xpath("//span[normalize-space()=\"Add Variable\"]"));

	}

	public void globalVariableDragAndDrop() throws Exception {
		Thread.sleep(10000);
		String[] fields = { "Field1", "Field2", "Field3", "Field4", "Field5", "Field6", "Field7", "Field8", "Field9",
				"Field10", "Field11", "Field12", "Field13", "Field14", "Field15", "Field16", "Field17", "Field18" };

		int numberOfElements = fields.length;
		String targetXPath = "//*[@id=\"svg\"]";

		Thread.sleep(10000);
		waitEle(By.xpath("//div[text()=\"global variable\"]"));

		Thread.sleep(5000);
		int[][] coordinates = { { -350, -180 }, { -350, -130 }, { -350, -80 }, { -350, -30 }, { -350, 20 },
				{ -100, -180 }, { -100, -130 }, { -100, -80 }, { -100, -30 }, { -100, 20 }, { 150, -180 },
				{ 150, -130 }, { 150, -80 }, { 150, -30 }, { 150, 20 }, { 400, -180 }, { 400, -130 }, { 400, -80 } };

		for (int i = 0; i < numberOfElements; i++) {
			WebElement element = driver.findElement(By.xpath("(//div[@class='name'])[" + (i + 1) + "]"));
			WebElement target = driver.findElement(By.xpath(targetXPath));

			int x = coordinates[i][0];
			int y = coordinates[i][1];

			Actions actions = new Actions(driver);
			actions.clickAndHold(element).moveToElement(target, x, y).release().build().perform();
		}
	}

	public void DragAndDropFeildsInDocument(String templateName, String arr[]) throws Exception {
		String feilds[] = arr;
		int l = feilds.length;
		System.out.println(l);
		Thread.sleep(5000);

		String TName = String.format("//div[text()=\"%s\"]", templateName);
		waitEle(By.xpath(TName));
		Thread.sleep(5000);
		int i = 1;
		for (int x = -350; x <= 250; x = x + 250) {
			for (int y = -180; y <= 210; y = y + 50) {
				if (i >= l) {
					break;
				}
				String xpath = String.format("(//div[@class='name'])[i]", i);
				WebElement element = driver.findElement(RelativeLocator.with(By.xpath(xpath)).below(By.xpath(TName)));

				Actions actions = new Actions(driver);
				WebElement target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
				waitAndClick(actions, element, target, x, y);
				System.out.printf("%s Field Drag and Drop Done\n", feilds[i - 1]);
				i++;
			}
		}
		waitEle(By.xpath(TName));
	}

	public void companyProfile(String Temp) throws Exception {
		Thread.sleep(5000);
		driver.get("https://nsui.esigns.io/profile/companyProfile?key=60504");
//		waitEle(By.xpath("(//div[@class=\"icon-text\"])[1]"));
//		Thread.sleep(5000);
//		Javascriptclick(By.xpath("//li[text()=\" Profile \"]"));
		Thread.sleep(20000);
		Javascriptclick(By.xpath(
				"//div[@class=\"profile-card text-center\"]/div[@class=\"list-group text-left\"]//span[@class='list-group-item list-group-item-action active']"));
		System.out.println("Click on company profile done ");
		String temp = String.format("//div[@id='tab-%s']", Temp);
		waitEle(By.xpath(temp));
		Thread.sleep(20000);
		Loadingmask();
		WebElement space = driver.findElement(By.xpath("//div[2]/section[1]//form[1]"));

		List<WebElement> elements = space.findElements(By.tagName("p"));
		elements.addAll(space.findElements(By.tagName("span")));
		for (WebElement ele : elements) {
			System.out.println(ele.getText());

		}
		List<String> expectedTexts = Arrays.asList("1","-", "meghana123", "a", "a,b", "10", "₹1.00", "c,b", "List1",
				"07-15-2024 00:00:00", "a", "01-18-2000", "11:23:58", "Monday",
				"07-15-2024 00:00:00 (From ~ To) 08-14-2024 00:00:00", "11:25:06 - 12:25:06",
				"07-15-2024 (From ~ To) 08-13-2024");
		int i = 0;
		int length = expectedTexts.size();

		for (WebElement column : elements) {
			for (i = 0; i < length; i++) {
				if (column.getText().equals(expectedTexts.get(i))) {
					System.out.println(column.getText()+" is equal to "+expectedTexts.get(i));
					System.out.println("pass");
					break;
				} 
			}
		}
	}
}