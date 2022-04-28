Feature: Modulr Account Dashboard

  Background:
  Given user has already logged in to application
    |userName            | password      |
    |Kirti.Mahalunkar77  | Kirti@7276!#  |

  Scenario: Verify Search for an account by user name
    Given user is on account dashboard page
    When user enter account name "Kirti"
    And user clicks on Go button
    Then user account details are displayed for user "Kirti"


  Scenario: Verify App menu on HomePage
    Given user is on account dashboard page
    Then user gets app menu
    | Accounts         |
    | Move Money       |
    | Pending payments |
    | Beneficiaries    |
    | Reports          |
    | Users            |
    | Notifications    |



