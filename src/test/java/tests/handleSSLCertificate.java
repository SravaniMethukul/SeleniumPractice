package tests;


import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class handleSSLCertificate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);
		
		//used to set the extension
		//options.addExtensions(Filepath);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https:expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		
	}
}
