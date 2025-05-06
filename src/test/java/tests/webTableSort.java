package tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class webTableSort {
	
	//video 117
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on column
		//capture all webelement into list
		//capture text of all web elements into new list
		//then apply sort in list on step 3 -> sorted list and compare two list
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//click on sort icon
		driver.findElement(By.cssSelector(".sort-icon")).click();
		
		//capture all web elements into list
		List<WebElement> elementslist = driver.findElements(By.xpath("//tbody//tr//td[1]"));
		
		//capture text of all webelements into new(priginal) list
		List<String> originallist = elementslist.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort on the original list of step 3 -> sorted list
		List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList());
		Assert.assertEquals(originallist, sortedlist);
		
	}

}
