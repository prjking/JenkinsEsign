package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login {
	WebDriver driver;

	public Login(WebDriver driver) {

		this.driver = driver;

	}

	public void Signin() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
				.sendKeys("saikumar.basolutions@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Nimble#2022");
		driver.findElement(By.xpath("//span[normalize-space()='Log In']")).click();
		Thread.sleep(10000);

	}

	public void VerifyLoginSucess() {

	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
	        WebElement welcomeMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class='fw-large blue-dark mb-3 fs-10']")));


	        Assert.assertNotNull(welcomeMessage, "Welcome message element is not present Login Failed");
	        System.out.println("Login Successful");
    }
	    }


