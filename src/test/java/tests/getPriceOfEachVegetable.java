package tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getPriceOfEachVegetable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		List<WebElement> elementslist = driver.findElements(By.xpath("//tr//td"));

		// scan the name column with getText() -> if the text is rice then print price
		// of rice
		List<String> price;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr//td"));
			price = rows.stream().filter(s -> s.getText().contains("Apple"))
					.map(s -> getPriceVeggie(s)).collect(Collectors.toList());

			if (price.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (price.size() < 1);
		
		price.forEach(s -> System.out.println(s));
	}

	public static String getPriceVeggie(WebElement e) {
		String price = e.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}
}
