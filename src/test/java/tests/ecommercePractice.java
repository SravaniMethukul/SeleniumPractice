package tests;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ecommercePractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		// Expected Array
		String vegArray[] = { "Cucumber", "Brocolli", "Carrot", "Tomato", "Apple", "Orange" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		addToCart(driver,vegArray);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		
		//since the text is static so we are using xpath with text
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='promoCode']")));
		
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		
		//explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.promoBtn")));
		
		
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		String promoAppliedText=driver.findElement(By.cssSelector("span.promoInfo")).getText();
		System.out.println(promoAppliedText);
	}

	public static void addToCart(WebDriver driver, String[] vegArray) {
		int count = 0;
		List<WebElement> allElements = driver.findElements(By.cssSelector("h4.product-name"));

		// check if item is present in array
		// convert array into arraylist
		List vegArraylist = Arrays.asList(vegArray);

		for (int i = 0; i < allElements.size(); i++) {
			// format to get actual vegetable name
			// Brocolli - 1 Kg
			String item = allElements.get(i).getText().split("-")[0];
			String formattedName = item.trim();
			System.out.println(allElements.get(i).getText());
			if (vegArraylist.contains(formattedName)) {
				count = count + 1;
				// click on add to cart
				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click();
				// the above code fails because add to cart changes into added so we need to use
				// text only for static text. if dynamic go with xpath
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				System.out.println(formattedName);
				if (count == vegArray.length) {
					break;
				}
			}
		}
	}
}
