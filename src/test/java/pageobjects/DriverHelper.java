package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHelper {

	public static WebDriver getWebDriver(String browser) {
		if (browser.equals("CHROME")) {
			System.setProperty("webdriver.chrome.driver", "/Users/iwonasasak/Documents/selenium/chromedriver");
			return new ChromeDriver();
		}
		return null;
	}

	public static void getToTheBasePage(WebDriver driver, String pageTitle) {
		if (pageTitle.equals("Add a User")) {
			driver.get("http://thedemosite.co.uk/addauser.php");
			Assert.assertTrue(
					driver.findElement(By.xpath("//strong[contains(text(),'" + pageTitle + "')]")).isDisplayed());
		}
	}
}
