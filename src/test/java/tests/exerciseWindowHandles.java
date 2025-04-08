package tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class exerciseWindowHandles {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://the-internet.herokuapp.com/windows");

		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		String parentId = it.next();
		String childId = it.next();

		driver.switchTo().window(childId);

		String text = driver.findElement(By.tagName("h3")).getText();
		System.out.println(text);

		driver.switchTo().window(parentId);

		String textInParent = driver.findElement(By.tagName("h3")).getText();
		System.out.println(textInParent);
	}

}