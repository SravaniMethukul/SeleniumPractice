package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciseEightAutoSuggestionDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String text = "Ind";
		driver.findElement(By.id("autocomplete")).sendKeys(text);
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
		
		for(WebElement e:elements) {
			System.out.println(e.getText());
			if(e.getText().equalsIgnoreCase("India")) {
				e.click();
				break;
			}
		}
		
		driver.close();
		
	}

}
