package stepdefs;

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

	@When("^The user inputs username and password:$")
	public void userInputsValidUsernameAndPassword(DataTable credsDataTable) throws Throwable {
		Credentials creds = credsDataTable.asList(Credentials.class).get(0);
		System.out.println("user inputs username and pass: " + creds.getUsername() + " " + creds.getPassword());
	}
	
	@When("^The user inputs (.*): (.*)$")
	public void userInputsValueToTheField(String fieldName, String valueToBeInputted) {
		
	}
	
	@When("^The user clears (.*) field$") 
	public void userClearsTheField(String fieldName) {
		
	}

	@When("^The user clicks (.*) button$")
	public void userClicksTheButton(String buttonName) {
		System.out.println("button clicked: " + buttonName);
	}

	@Then("^The user can see this credentials set above the form:$")
	public void userCanSeeHisCredentialsOnTheForm(DataTable credsDataTable) throws Throwable {
		Credentials creds = credsDataTable.asList(Credentials.class).get(0);
		System.out.println("user inputs username and pass: " + creds.getUsername() + " " + creds.getPassword());
	}
	
	@Then("^The user can see the (.*) massage and closing it$")
	public void userCanSeeMassageAndClosingIt(String massage) {
		
	}
}
