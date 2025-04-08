package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Select dropdown = new Select(driver.findElement(By.xpath("//select[contains(@name, 'DropDownListCurrency')]")));
		dropdown.selectByIndex(3);
		WebElement option = dropdown.getFirstSelectedOption();
		System.out.println(option.getText());
		
		 dropdown.selectByVisibleText("AED");
		 WebElement optionSelected = dropdown.getFirstSelectedOption();
		 System.out.println(optionSelected.getText());
		
		 dropdown.selectByValue("INR");
		 WebElement optionSelected1 = dropdown.getFirstSelectedOption();
		 System.out.println(optionSelected1.getText());
	
	}

}
