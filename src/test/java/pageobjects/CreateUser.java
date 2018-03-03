package pageobjects;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateUser extends BasePage {

	private final String pageTitle = "Add a User";
	private final String createUserUrl = "http://thedemosite.co.uk/addauser.php";
	private final String saveUrl = "http://thedemosite.co.uk/savedata.php";

	Credentials currentCredentials;
	By pageTitleLocator = By.xpath("//strong[contains(text(),'" + pageTitle + "')]");
	By usernameForm = By.name("username");
	By passwordForm = By.name("password");
	By submit = By.name("FormsButton2");
	By credsBox = By.xpath("html/body/table/tbody/tr/td[1]/blockquote/blockquote[2]/blockquote");

	public CreateUser(WebDriver driver) {
		super(driver);
		visitBasePage();
	}

	public void visitBasePage() {
		visit(createUserUrl);
		assertTrue("The Add User Page didn't launch!", isDisplayed(pageTitleLocator));
		refreshCreds();
		System.out.println("The Add User Page launch correctly.\n" + currentCredentials);
	}

	public Boolean isBasePageLoaded() {
		System.out.println("Current page loaded: " + getCurrentUrl());
		return getCurrentUrl().equals(createUserUrl);
	}

	public Credentials getCreds() {
		refreshCreds();
		return currentCredentials;
	}

	public void refreshCreds() {
		String credsBoxText = find(credsBox).getText();
		// TODO implement regex parsing
		String user = credsBoxText.substring(credsBoxText.indexOf(':') + 2, credsBoxText.indexOf('\n'));
		String passLine = credsBoxText.substring(credsBoxText.indexOf('\n') + 1);
		String pass = passLine.substring(passLine.indexOf(':') + 2);
		currentCredentials = new Credentials(user, pass);
		System.out.println(currentCredentials);
	}

	public void withCredentials(Credentials creds) {
		inputUsername(creds.getUsername());
		inputPassword(creds.getPassword());
	}

	public void withCredentialsAndSubmit(Credentials creds) {
		withCredentials(creds);
		submit();
	}

	public void submit() {
		System.out.println("The user submits the form.");
		click(submit);
	}

	public void inputUsername(String username) {
		System.out.println("The user inputs username [" + username + "]");
		type(username, usernameForm);
		System.out.println("Inputed: " + find(usernameForm).getText());
	}

	public void inputPassword(String password) {
		System.out.println("The user inputs password [" + password + "]");
		type(password, passwordForm);
	}

	public void inputTextIntoField(String text, String fieldName) {
		if (fieldName.toLowerCase().equals("username")) {
			inputUsername(text);
		} else if (fieldName.toLowerCase().equals("password")) {
			inputPassword(text);
		}
	}

	public void clearAllFields() {
		clearField(usernameForm);
		clearField(passwordForm);
	}

	public void clearField(String fieldName) {
		if (fieldName.toLowerCase().equals("username")) {
			clearField(usernameForm);
		} else if (fieldName.toLowerCase().equals("password")) {
			clearField(passwordForm);
		}
	}

	public Boolean success() {
		return getCurrentUrl().equals(saveUrl);
	}

	public Boolean failure() {
		// TODO Popup must be closed
		return getCurrentUrl().equals(createUserUrl);
	}

}
