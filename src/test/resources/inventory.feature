@inventory
Feature: InventoryPage
  Scenario: User can log into saucedemo.com
    Given I am on saucedemo homepage
    When I enter username standard_user
    And password secret_sauce
    And try to Login
    Then I will login into https://www.saucedemo.com/inventory.html

  @now
  Scenario: Check all links are working
    Given I am login on the inventory page
    When I click on all the links
    Then all links works