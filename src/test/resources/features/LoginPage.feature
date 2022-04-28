Feature: Modulr Login Feature

  Scenario: Verification of login functionality for valid username and password
    Given the user navigates to login page
    When user enters username "Kirti.Mahalunkar77" and password "Kirti@7276!#"
    And user clicks on SignIn button
    Then Sign In button is disabled after clicking once
    Then user is taken to account overview page for user "Kirti Mahalunkar"

  Scenario Outline: Verification of login functionality for invalid username and password
    Given the user navigates to login page
    When  user enters username "<userName>" and password "<password>"
    And   user clicks on SignIn button
    Then  user gets "The username or password is incorrect" error
    And   user gets "Multiple incorrect sign-ins could result in your access being locked" multiple attempt error
    Examples:
    |userName            | password         |
    |invalidUser         | invalidPassword  |
    |Kirti.Mahalunkar77  | invalidPassword  |
    |invalidUser         | Kirti@7276!#     |

  Scenario Outline: Verification of login functionality for mandatory fields username and password
    Given the user navigates to login page
    When  user enters username "<userName>" and password "<password>"
    And user clicks on SignIn button
    Then user gets "This field is required" mandatory field error
    Examples:
      |userName            | password      |
      |                    | Kirti@7276!#  |
      |Kirti.Mahalunkar77  |               |
      |                    |               |

  Scenario Outline: Verify forgot password functionality is working
      Given the user navigates to login page
      When user clicks on forget Password link
      And user enters username "<username>"
      And Clicks on Request reset button
      Then Email sent to user to reset a password
      Examples:
        | username              |
        | 1245643               |
        | jdkn!@#kw#$#@         |
        | kmahalunkar@gmail.com |


  Scenario: Verify username field is mandatory while resetting a password
    Given the user navigates to login page
    When user clicks on forget Password link
    And user enters username ""
    And Clicks on Request reset button
    Then user gets "This field is required" mandatory field error



