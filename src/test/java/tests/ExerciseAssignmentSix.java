package tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ExerciseAssignmentSix {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// select radio button
		driver.findElement(By.xpath("//input[@value='option2']")).click();
		String textObtained = driver.findElement(By.xpath("//label[@for='benz']")).getText();
		System.out.println("text obtained: "+textObtained);
		
		//s select option from dropdown
		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByVisibleText(textObtained);
		
		// enter value in alert box
		driver.findElement(By.id("name")).sendKeys(textObtained);
		driver.findElement(By.id("alertbtn")).click();
		
		Alert alert =  driver.switchTo().alert();
		String alertText = alert.getText().split(",")[0];
		alertText = alertText.split(" ")[1];
		Assert.assertEquals(alertText, textObtained, "Text is Same in alert box");
		
		alert.accept();
		driver.close();
	
	}

}
