package pageobjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.security.UserAndPassword;

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

	public void refresh() {
		driver.navigate().refresh();
	}

	public WebElement find(By locator) {
		return driver.findElement(locator);
	}

	public void click(By locator) {
		find(locator).click();
	}

	public void type(String inputText, By locator) {
		find(locator).clear();
		find(locator).sendKeys(inputText);
	}

	public void submit(By locator) {
		find(locator).submit();
	}

	public void clearField(By locator) {
		find(locator).clear();
		assertEquals("Field isn't cleared, value: " + find(locator).getText(), find(locator).getText(), "");
	}

	public Boolean isDisplayed(By locator) {
		try {
			return find(locator).isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public Boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean isTextPresentInTheSource(String text) {
		return driver.getPageSource().contains(text);
	}

	public String getAlertsText() {
		try {
			return driver.switchTo().alert().getText();
		} catch (Exception e) {
			return "";
		}
	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
	}

	public String credentialsToString(UserAndPassword creds) {
		return "User [" + creds.getUsername() + "] Password [" + creds.getPassword() + "]";
	}
}
