package jqueryui.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class DragDropEtcPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url = "https://jqueryui.com/";
		
		WebElement draggable, droppable, resize1, resize2, resize3, selected, sorted;
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		Actions act = new Actions(driver);
		driver.manage().window().maximize();
		driver.get(url);
		
		//Draggable
		driver.findElement(By.linkText("Draggable")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		draggable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='draggable']")));
		
		act.dragAndDropBy(draggable, 193, 93).perform();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		//Droppable
		driver.findElement(By.linkText("Droppable")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		draggable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='draggable']")));
		droppable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='droppable']")));
		
		act.dragAndDrop(draggable, droppable).perform();
		
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		//Resizable
		driver.findElement(By.linkText("Resizable")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		resize1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='resizable']//div)[1]")));
		resize2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='resizable']//div)[2]")));
		resize3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='resizable']//div)[3]")));
		
		act
		.clickAndHold(resize1)
		.moveByOffset(20,0)
		.release(resize1)
		.pause(Duration.ofSeconds(1))
		.clickAndHold(resize2)
		.moveByOffset(0,20)
		.release()
		.pause(Duration.ofSeconds(1))
		.clickAndHold(resize3)
		.moveByOffset(150,200)
		.release(resize3)
		.build()
		.perform();
		
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		//Selectable : Find the selected item
		driver.findElement(By.linkText("Selectable")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		selected = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ui-widget-content ui-selectee ui-selected']")));
		
		System.out.println("\nSelected Items:");
		driver.findElements(By.xpath("//li[@class='ui-widget-content ui-selectee ui-selected']")).forEach(element -> System.out.println(element.getText()));
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		//Sortable : Find the sorted list
		driver.findElement(By.linkText("Sortable")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		sorted = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ui-state-default ui-sortable-handle ui-sortable-helper']")));
		
		Thread.sleep(5000);
		System.out.println("\nNew Sorted Order:\n");
		driver.findElements(By.xpath("//li[@class='ui-state-default ui-sortable-handle']")).forEach(element -> System.out.println(element.getText()));
		
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.close();
		
	}

}
