package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import elements.Credentials;

public class UserCreationSteps {

	@Given("^The user is on (.*) page$")
	public void userIsOnUserCreationPage(String pageTitle) {
		System.out.println("pageTitle: " + pageTitle);
		throw new PendingException();
	}

	@Given("^Username and password is set to:$")
	public void userCredentialsAreSetTo(DataTable credsDataTable) throws Throwable {
		Credentials creds = credsDataTable.asList(Credentials.class).get(0);
		System.out.println("user inputs username and pass: " + creds.getUsername() + " " + creds.getPassword());
		throw new PendingException();
	}

	@When("^The user inputs username and password:$")
	public void userInputsValidUsernameAndPassword(DataTable credsDataTable) throws Throwable {
		Credentials creds = credsDataTable.asList(Credentials.class).get(0);
		System.out.println("user inputs username and pass: " + creds.getUsername() + " " + creds.getPassword());
		throw new PendingException();
	}

	@When("^The user inputs (.*): (.*)$")
	public void userInputsValueToTheField(String fieldName, String valueToBeInputted) {
		throw new PendingException();
	}

	@When("^The user clears (.*) field$")
	public void userClearsTheField(String fieldName) {
		throw new PendingException();
	}

	@When("^The user clicks (.*) button$")
	public void userClicksTheButton(String buttonName) {
		System.out.println("button clicked: " + buttonName);
		throw new PendingException();
	}

	@Then("^The user can see this credentials set above the form:$")
	public void userCanSeeHisCredentialsOnTheForm(DataTable credsDataTable) throws Throwable {
		Credentials creds = credsDataTable.asList(Credentials.class).get(0);
		System.out.println("user inputs username and pass: " + creds.getUsername() + " " + creds.getPassword());
		throw new PendingException();
	}

	@Then("^The user can see the (.*) massage and closing it$")
	public void userCanSeeMassageAndClosingIt(String massage) {
		throw new PendingException();
	}
}
