Feature: Login Page Feature

  Scenario: Login Page Title
    Given User is on the Login Page
    When User gets the Title of the Page
    Then Page Title should be "Login - My Store"

  Scenario: Forgot Password Link
    Given User is on the Login Page
    Then Forgot your password link should be Visible

  Scenario Outline: Login using Valid Credentials
    Given User is on the Login Page
    When user enters username "<userName>"
    And user enter valid password "<password>"
    And user click the Login Button
    Then User gets the Title of the Page
    And Page Title should be "My account - My Store"

    Examples:
      | userName                 | password     |
      | techsystems@safeboda.com | Safeboda123$ |


  Scenario Outline: Login using Invalid Credentials
    Given User is on the Login Page
    When user enters username "<userName>"
    But user enters invalid password "<password>"
    And user click the Login Button
    Then Error message is Displayed

Examples:
  | userName          | password     |
  | techssafeboda.com | Safeboda123$ |
