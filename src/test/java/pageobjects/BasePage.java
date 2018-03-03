package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	private WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		driver.manage().window().maximize();
	}

	public void visit(String url) {
		driver.get(url);
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public WebElement find(By locator) {
		return driver.findElement(locator);
	}

	public void click(By locator) {
		find(locator).click();
	}

	public void type(String inputText, By locator) {
		find(locator).sendKeys("");
		find(locator).sendKeys(inputText);
	}
	
	public void submit(By locator) {
		find(locator).submit();
	}
	
	public void clearField(By locator) {
		find(locator).clear();
	}
	
	public Boolean isDisplayed(By locator) {
		try {
			return find(locator).isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
}
