package pageobjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	private final String pageTitle = "Login";
	private final String loginUrl = "http://thedemosite.co.uk/login.php";
	
	By pageTitleLocator = By.xpath("//strong[contains(text(),'" + pageTitle + "')]");
	
	public LoginPage(WebDriver driver) {
		super(driver);
		visitBasePage();
	}

	public void visitBasePage() {
		visit(loginUrl);
		assertTrue("The Add User Page didn't launch!", isDisplayed(pageTitleLocator));
	}

}
