package pageobjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.security.UserAndPassword;

public class LoginPage extends BasePage {

	private final String pageTitle = "Login";
	private final String loginUrl = "http://thedemosite.co.uk/login.php";

	By pageTitleLocator = By.xpath("//strong[contains(text(),'" + pageTitle + "')]");
    By usernameForm = By.name("username");
	By passwordForm = By.name("password");
	By submit = By.name("FormsButton2");
	String successMsg = "**Successful Login**";
	String failureMsg = "**Failed Login**";

	public LoginPage(WebDriver driver) {
		super(driver);
		visitBasePage();
	}

	public void visitBasePage() {
		visit(loginUrl);
		assertTrue("The Add User Page didn't launch!", isDisplayed(pageTitleLocator));
	}

	public Boolean isPageLoaded(String pageShortName) {
		String currentUrl = getCurrentUrl();
		System.out.println("Current page loaded: " + currentUrl);
		if (pageShortName.equals("Login")) {
			assertEquals("Expected url isn't loaded!", loginUrl, currentUrl);
			return true;
		}
		return false;
	}

	public void inputCredentials(UserAndPassword creds) {
		inputUsername(creds.getUsername());
		inputPassword(creds.getPassword());
	}
	
	public void inputUsername(String username) {
		System.out.println("The user inputs username [" + username + "]");
		type(username, usernameForm);
	}

	public void inputPassword(String password) {
		System.out.println("The user inputs password [" + password + "]");
		type(password, passwordForm);
	}

	public void submit() {
		System.out.println("The user submits the form.");
		click(submit);
	}

	public void successMsgDisplayed(String msg) {
		isTextPresentInTheSource(successMsg);
	}

	public void failureMsgDisplayed(String msg) {
		isTextPresentInTheSource(failureMsg);
	}
}
