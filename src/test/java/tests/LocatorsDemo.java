package tests;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LocatorsDemo {


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//implicit wait - wait for the seconds specified for each element 
		//(if we find element within 5 seconds then it return if it fails after 5 seconds it will display error)
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5) );
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		
		String texterror = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(texterror);
	
	
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder=\"Name\"]")).sendKeys("John");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Sravani@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Sravani123@gmail.com");
		//driver.findElement(By.cssSelector("input[placeholder=\"Phone Number\"]")).sendKeys("9876543210");
		driver.findElement(By.xpath("//input[@type=\"text\"][3]")).sendKeys("9876543210");
		
		driver.findElement(By.xpath("//form/input[3]")).clear();
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9876543210");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String text = driver.findElement(By.cssSelector("form p")).getText();
		System.out.println(text);
		
		//login correctly with correct details
		
		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='Pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
		driver.findElement(By.className("logout-btn")).click();
		Thread.sleep(1000);
		
		
	}

}