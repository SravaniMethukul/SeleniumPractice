package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscellenous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//delete all cookies
		driver.manage().deleteAllCookies();
		//delete particular cookies if we know name
		driver.manage().deleteCookieNamed("sessionKey");
		
		//delete the session cookie and secure login should be logged out
		//delete the cookie with session key and click on any link that loads the login page
		
		driver.get("https://www.google.com");
		
	}
}
