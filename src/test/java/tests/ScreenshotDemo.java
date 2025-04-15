package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ScreenshotDemo {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://google.com");
		
		try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            // Updated XPath: Google's button structure sometimes nests divs
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button//div[normalize-space()='Alle akzeptieren']")
            ));

            // Try normal click first
            try {
                acceptButton.click();
            } catch (ElementClickInterceptedException e) {
                // Fallback to JavaScript click
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", acceptButton);
            }

            System.out.println("Cookies accepted.");

        } catch (TimeoutException e) {
            System.out.println("Accept button not found within timeout.");
        }
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\methu\\Documents\\ecilipseProjects\\Screenshots\\screenshot.png"));	
	}
}
