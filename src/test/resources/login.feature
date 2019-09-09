@login
Feature: Log in page
  Scenario: User can log into saucedemo.com
    Given I am on saucedemo homepage
    When I enter username standard_user
    And password secret_sauce
    And try to Login
    Then I will login into https://www.saucedemo.com/inventory.html

  @contents
  Scenario: Login Page contents
    Given I am on saucedemo homepage
    When I check the homepage
    Then I can see swaglabs login logo
    And I can see the robot logo
    And the tab shows Swag Labs

  @badlogin
  Scenario Outline: User will get error when entering incorrect credentials
    Given I am a standard_user
    And I am on saucedemo homepage
    When I enter username <username>
    And password <password>
    And try to Login
    Then I will remain at the Login page
    And I will get an error message <error>


    Examples:
      |username| password | error|
      |standard_user | password123 |Username and password do not match any user in this service|
      |locked_out_user | secret_sauce |Sorry, this user has been locked out.|
      |locked_out_user | test |Username and password do not match any user in this service|
      |problem_user | test |Username and password do not match any user in this service|
      |invalid_user | secret_sauce |Username and password do not match any user in this service|

