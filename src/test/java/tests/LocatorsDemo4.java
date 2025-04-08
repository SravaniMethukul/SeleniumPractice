package tests;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo4{
	
	//Traverse from parent to child and child to parent
	
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5) );
				
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//traverse from parent to child
		String text = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
		System.out.println(text);
		
		//traverse from child to parent
		String text1 = driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText();
		System.out.println(text1);
		
		driver.close();
	}
}