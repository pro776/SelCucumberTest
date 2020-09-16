package stepDefinitions;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class RegisterSteps {
	
	static WebDriver driver;
	
	String url = "https://www.facebook.com";

	@Given("User is on FB home page")
	public void checkIfonFB() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		assertEquals(driver.getTitle(),"Facebook – log in or sign up");
		System.out.println("User is on FB Home Page");

	}

	@When("User clicks on the {string} button")
	public void clickCreateAcc(String link) throws InterruptedException {

		driver.findElement(By.linkText(link)).click();
		Thread.sleep(1000);
		
	}
	
	@Then("User is redirected to Register page")
	public void redirectToRegPage() {
		
		assertEquals(driver.findElement(By.xpath("//div[@class='mbs _52lq fsl fwb fcb']")).getText(), "Sign Up");
		System.out.println("User is on FB Register Page");
		
	}
	
	@Given("User is at the register page")
	public void checkIfOnRegPage() {
		
		assertEquals(driver.findElement(By.xpath("//div[@class='mbs _52lq fsl fwb fcb']")).getText(), "Sign Up");
		System.out.println("User is on FB Register Page");
		
	}
	
	@When("User enters {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void EnterDataToCreateAcc(String fName, String sName, String mobOrEmail, String nPass, String day, String month, String year, String gender) {

		driver.findElement(By.xpath("//input[@name='firstname']")).clear();
		driver.findElement(By.xpath("//input[@name='lastname']")).clear();
		driver.findElement(By.xpath("//input[@name='reg_email__']")).clear();
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).clear();
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(fName);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(sName);
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(mobOrEmail);
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(nPass);
		
		Select drpDay = new Select(driver.findElement(By.xpath("//select[@title='Day']")));
		Select drpMonth = new Select(driver.findElement(By.xpath("//select[@title='Month']")));
		Select drpYear = new Select(driver.findElement(By.xpath("//select[@title='Year']")));
		
		drpDay.selectByValue(day);
		drpMonth.selectByValue(month);
		drpYear.selectByValue(year);
		
		WebElement gen = driver.findElement(By.xpath("//input[@value='"+gender+"']"));
        gen.click();
		
	}
	
	@And("User clicks the {string} button")
	public void clickReg(String sign) throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='_1lch']//button[text()='"+sign+"']")).click();
		Thread.sleep(3000);
		
	}

	@Then("User should capture the error message if any")
	public void errMsg() {

		driver.findElements(By.xpath("//div[@class='_5633 _5634 _53ij']")).forEach(element -> System.out.println("\nError message: "+element.getText()));
		
	}
	
	
	
}
