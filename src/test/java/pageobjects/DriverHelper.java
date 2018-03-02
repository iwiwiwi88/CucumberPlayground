package pageobjects;

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
}
