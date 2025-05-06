package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getWidthAndHeightOfElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//get height and width element
		WebElement nameEle = driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(nameEle.getRect().getDimension().getWidth());
		System.out.println(nameEle.getRect().getDimension().getHeight());
	}
}
