package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class exerciseSynchronization {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.findElement(By.cssSelector("input#username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input#password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		
		Select sel = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		sel.selectByVisibleText("Consultant");
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'btn-primary')]")));
		Thread.sleep(2000);
		
		List<WebElement> addElements = driver.findElements(By.xpath("//button[contains(@class, 'btn-info')]"));
		System.out.println(addElements.size());
		for(int i=0;i<addElements.size();i++) {
			addElements.get(i).click();
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'btn-success')]")));
		driver.findElement(By.xpath("//button[contains(@class,'btn-success')]")).click();
		
	}

}
