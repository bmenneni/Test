package smoketests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {
//working with Bhagee is fun..
	public static void main(String[] args) {
		String mySearchItem = "Baby";
		System.setProperty("webdriver.chrome.driver","C:\\TestDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		dropdown.click();
		Select mySelect = new Select(dropdown);
		List<WebElement> myList = mySelect.getOptions();
		System.out.println(myList.size());
		for (int i=0; i < myList.size(); i++) {
			String myIndexText = myList.get(i).getText();
			System.out.println(myIndexText);
			if (myIndexText.contains(mySearchItem)) {
				System.out.println("I found it.");
				mySelect.selectByIndex(i);
				break;
			}
		}
		driver.findElement(By.id("nav-search-submit-button")).click();

	}

}
