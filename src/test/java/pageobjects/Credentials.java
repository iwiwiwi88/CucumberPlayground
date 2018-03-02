package pageobjects;

public class Credentials {

	private final String username;
	private final String password;

	public Credentials(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Boolean equals(Credentials theOtherCreds) {
		return username.equals(theOtherCreds.getUsername()) && password.equals(theOtherCreds.getPassword());
	}

	public String toString() {
		return "Credentials -> Username: [" + username + "] Password: [" + password + "]";
	}
}
