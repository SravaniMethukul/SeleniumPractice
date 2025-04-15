package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciseSevenWebTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		List<WebElement> elements = driver.findElements(By.xpath("//table[@name='courses']//tr"));
		System.out.println("Number of Rows: " + String.valueOf(elements.size()));
		
		List<WebElement> colElements = driver.findElements(By.cssSelector("table[name='courses'] tr:nth-child(1) th"));
		System.out.println("Number of Columns: " + String.valueOf(colElements.size()));
		
		List<WebElement> secondRow = driver.findElements(By.cssSelector("table[name='courses'] tr:nth-child(2) td"));
		System.out.println("Second Row text is");
		for(int i=0;i<secondRow.size();i++) {
			System.out.println(secondRow.get(i).getText());
		}
		
		driver.close();
		
		/*
		 Solution:
		 WebElement table=driver.findElement(By.id("product"));
		 System.out.println(table.findElements(By.tagName("tr")).size());
		 System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		 List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		 System.out.println(secondrow.get(0).getText());
		 System.out.println(secondrow.get(1).getText());
		 System.out.println(secondrow.get(2).getText()); 
		*/
	}

}
