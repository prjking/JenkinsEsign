package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Dashboard {
	WebDriver driver;

	public Dashboard(WebDriver driver) {

		this.driver = driver;

	}
	public void Verifydashboard() throws Exception {
		driver.get("https://dev.esigns.io/dashboard?type=all-documents");
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		WebElement subMenuItem = driver.findElement(By.xpath("(//ul/a[2]/li/i)[1]"));
		actions.click(subMenuItem).perform();
		
	}
}
