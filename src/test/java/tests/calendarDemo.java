package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class calendarDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String month = "6";
		String date = "15";
		String year = "2027";
		String[] expectedList = {month, date, year};
		
		WebElement datePicker = driver.findElement(By.cssSelector(".react-date-picker__inputGroup"));
		datePicker.click();
		
		WebElement navigationLabel = driver.findElement(By.cssSelector(".react-calendar__navigation__label"));
	
		navigationLabel.click();
		navigationLabel.click();
		
		driver.findElement(By.xpath("//button[text()= '"+year+"']")).click();
		
		driver.findElements(By.xpath("//div[@class='react-calendar__year-view__months']//button")).get(Integer.parseInt(month)-1).click();
		
		driver.findElement(By.xpath("//abbr[text()= '"+date+"']")).click();
		
		List<WebElement> dateText = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i=0;i<dateText.size();i++) {
			System.out.println(dateText.get(i).getAttribute("value"));
			Assert.assertEquals(dateText.get(i).getAttribute("value"), expectedList[i]);
		}
	}

}
