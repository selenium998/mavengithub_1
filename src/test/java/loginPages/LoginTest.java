package loginPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest {
	//checking the ci process for jenkins
	public static WebDriver driver;
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Madhu\\geckodriver.exe\\");
	 driver = new FirefoxDriver();
	}
	@Test
	public void doLogin() {
		driver.get("https://www.mycontactform.com/");
		driver.findElement(By.id("user")).sendKeys("sukkumar3");
		driver.findElement(By.id("pass")).sendKeys("selenium@2020");
		driver.findElement(By.name("btnSubmit")).click();
		Reporter.log("credentials submitted");
		String actMsg = driver.findElement(By.tagName("h5")).getText();
		String expMsg = "Welcome sukkumar3";

		if (actMsg.equals(expMsg)) {
			System.out.println("test case pass");

		} else {
			System.out.println("test case fail");

		}
		Reporter.log("verify the expected message");
		System.out.println("test completed");
		Reporter.log("test completed");
	}
	@AfterSuite
	public void teatDown() {
		driver.quit();
	}
}
