package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Signup {
	WebDriver driver;

	public Signup(WebDriver driver) {
		this.driver = driver;

	}
public void Newsignind() throws Exception {
	driver.findElement(By.linkText("Sign Up")).click();
	Thread.sleep(10000);
driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']")).sendKeys("prudhvi.buddharaju@nimbleaccounting.com");
Thread.sleep(100000);
driver.findElement(By.xpath("//input[@placeholder='Enter first name']")).sendKeys("Prudhvi raju");
Thread.sleep(10000);
driver.findElement(By.xpath("//input[@placeholder='Enter last name']")).sendKeys("Buddharaju");
Thread.sleep(10000);
driver.findElement(By.xpath("//input[@placeholder='989 989 9899']")).sendKeys("9701339701");
Thread.sleep(10000);
driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Nimble#2023");
Thread.sleep(10000);
driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Nimble#2023");
Thread.sleep(10000);
driver.findElement(By.xpath("//span[@class='el-checkbox__input']")).click();
Thread.sleep(10000);
driver.findElement(By.xpath("//span[normalize-space()='Register Account']")).click();

}
	public void Validsignup() {
		driver.findElement(By.xpath("//div[@class='mt-5']//h1")).isDisplayed();
		System.out.println("Signup Sucessfull");
	}
}
