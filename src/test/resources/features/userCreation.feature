Feature: Creating a new user on the thedemosite.
  Should allow a user to create new credentials 
  with username and password with more than 4 characters.

  Scenario: A user can set valid credentials correctly
    Given The user is on Add a User page
    And Username and password is set to:
      | username | password |
      | test     | test     |
    When The user inputs username and password:
      | username | password |
      | testiwi  | testiwi  |
    And The user clicks Save button
    Then The user can see this credentials set above the form:
      | username | password |
      | testiwi  | testiwi  |

  Scenario: A user can not use username that is shorter than 4 characters
    Given The user is on Add a User page
    And Username and password is set to:
      | username | password |
      | test     | test     |
    When The user inputs username and password:
      | username | password |
      | xx       | testiwi  |
    And The user clicks Save button
    Then The user can see the UsernameTooShort massage and closing it
    And The user can see this credentials set above the form:
      | username | password |
      | test     | test     |

  Scenario: A user can not use password that is shorter than 4 characters
    Given The user is on Add a User page
    And Username and password is set to:
      | username | password |
      | test     | test     |
    When The user inputs username and password:
      | username | password |
      | testiwi  | xx       |
    And The user clicks Save button
    Then The user can see the PasswordTooShort massage and closing it
    And The user can see this credentials set above the form:
      | username | password |
      | test     | test     |

  Scenario: A user must input both values to set the credentials
    Given The user is on Add a User page
    And Username and password is set to:
      | username | password |
      | test     | test     |
    When The user clicks Save button
    Then The user can see the UsernameTooShort massage and closing it
    And The user can see this credentials set above the form:
      | username | password |
      | test     | test     |
    When The user inputs username: testiwi
    And The user clicks Save button
    Then The user can see the PasswordTooShort massage and closing it
    And The user can see this credentials set above the form:
      | username | password |
      | test     | test     |
    When The user clears username field
    And The user inputs password: testiwi
    And The user clicks Save button
    Then The user can see the UsernameTooShort massage and closing it
    And The user can see this credentials set above the form:
      | username | password |
      | test     | test     |
