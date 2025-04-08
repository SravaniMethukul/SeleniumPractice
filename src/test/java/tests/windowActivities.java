package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");// waits until all components are loaded by default
		driver.navigate().to("https://rahulshettyacademy.com"); //even if one element displayed it moves to next step
		
		driver.navigate().back();
		driver.navigate().forward();
		
		driver.close();
	}

}
