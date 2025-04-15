package tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeExerciseScope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//1. calculate count of links from page
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2. Count links only in footer section (limited webdriver scope)
		WebElement footerEle = driver.findElement(By.id("gf-BIG"));
		
		System.out.println(footerEle.findElements(By.tagName("a")).size());
		
		//3. want link from first column in footer
		WebElement firstColumn = footerEle.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(firstColumn.findElements(By.tagName("a")).size());
		int count = firstColumn.findElements(By.tagName("a")).size();
		
		//4. click on each link in column and check if pages are opening
		for(int i=1; i<count; i++) {
			//on clicking ctrl and enter on link it will open in new tab
			String clickonlinkToopen = Keys.chord(Keys.CONTROL, Keys.ENTER);
			firstColumn.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkToopen);
			Thread.sleep(5000);
		}
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			String title = driver.getTitle();
			System.out.println(title);
		}
		
	}

}
