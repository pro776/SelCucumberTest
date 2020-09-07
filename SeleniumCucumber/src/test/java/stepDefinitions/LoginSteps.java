package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginSteps {

	static WebDriver driver;

	@Given("user is on the Login page")
	public void loginPage() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com");
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
	}

	@When("user enters username and password")
	public void uNamePass() {
		driver.findElement(By.id("input-email")).sendKeys("demoemail@email.com");
		driver.findElement(By.id("input-password")).sendKeys("Password");
	}

	@And("clicks submit")
	public void clickSubmit() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("user is redirected to the account page")
	public void homePage() {
		String myAcc = driver.findElement(By.xpath("//div[@id='content']//h2[text()='My Account']")).getText();
		assertEquals(myAcc, "My Account");
	}

}
