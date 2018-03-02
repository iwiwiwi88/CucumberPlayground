package pageobjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateUserPage extends BasePage {

	private final String pageTitle = "Add a User";
	private final String createUserUrl = "http://thedemosite.co.uk/addauser.php";
	private final String saveUrl = "http://thedemosite.co.uk/savedata.php";
	
	Credentials currentCredentials;
	By pageTitleLocator = By.xpath("//strong[contains(text(),'" + pageTitle + "')]");
	By usernameForm = By.name("username");
	By passwordForm = By.name("password");
	By submit = By.name("FormsButton2");
	By credsBox = By.xpath("html/body/table/tbody/tr/td[1]/blockquote/blockquote[2]/blockquote");

	public CreateUserPage(WebDriver driver) {
		super(driver);
		visit(createUserUrl);
		assertTrue(isDisplayed(pageTitleLocator));
		refreshCreds();
	}
	
	public void visitBasePage() {
		visit(createUserUrl);
		assertTrue(isDisplayed(pageTitleLocator));
		refreshCreds();
	}

	public Credentials getCreds() {
		refreshCreds();
		return currentCredentials;
	}

	public void refreshCreds() {
		String credsBoxText = find(credsBox).getText();
		String user = credsBoxText.substring(credsBoxText.indexOf(':') + 2, credsBoxText.indexOf('\n'));
		String passLine = credsBoxText.substring(credsBoxText.indexOf('\n') + 1);
		String pass = passLine.substring(passLine.indexOf(':') + 2);
		currentCredentials = new Credentials(user, pass);
		System.out.println("Current "+currentCredentials);
	}
	
	public Boolean success() {
		return getCurrentUrl().equals(saveUrl);
	}
	
	public Boolean failure() {
		return getCurrentUrl().equals(createUserUrl);
	}
}
