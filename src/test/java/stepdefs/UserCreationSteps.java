package stepdefs;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import elements.Credentials;

public class UserCreationSteps {

	@Given("^The user is on (.*) page$")
	public void userIsOnUserCreationPage(String pageTitle) {
		System.out.println("pageTitle: " + pageTitle);
	}

	@Given("^Username and password is set to:$")
	public void userCredentialsAreSetTo(DataTable credsDataTable) throws Throwable {
		Credentials creds = credsDataTable.asList(Credentials.class).get(0);
		System.out.println("user inputs username and pass: " + creds.getUsername() + " " + creds.getPassword());
	}

	@When("^The user inputs valid username and password:$")
	public void userInputsValidUsernameAndPassword(DataTable credsDataTable) throws Throwable {
		Credentials creds = credsDataTable.asList(Credentials.class).get(0);
		System.out.println("user inputs username and pass: " + creds.getUsername() + " " + creds.getPassword());
	}

	@When("^The user clicks (.*) button$")
	public void userClicksTheButton(String buttonName) {
		System.out.println("button clicked: " + buttonName);
	}

	@Then("^The user can see her/his credentials set correctly above the form:$")
	public void userCanSeeHisCredentialsOnTheForm(DataTable credsDataTable) throws Throwable {
		Credentials creds = credsDataTable.asList(Credentials.class).get(0);
		System.out.println("user inputs username and pass: " + creds.getUsername() + " " + creds.getPassword());
	}
}
