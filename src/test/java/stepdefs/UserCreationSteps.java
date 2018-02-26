package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserCreationSteps {

	@Given("^The user is on (.*) page$")
	public void userIsOnUserCreationPage(String pageTitle) {

	}

	@Given("^Username and password is set to:$")
	public void userCredentialsAreSetTo(String username, String password) throws Throwable {

	}

	@When("^The user inputs valid username and password:$")
	public void userInputsValidUsernameAndPassword(String username, String password) throws Throwable {

	}

	@When("^The user clicks (.*) button$")
	public void userClicksTheButton(String buttonName) {

	}

	@Then("^The user can see her/his credentials set correctly above the form:$")
	public void userCanSeeHisCredentialsOnTheForm(String username, String password) throws Throwable {

	}
}
