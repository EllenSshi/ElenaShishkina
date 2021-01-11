Feature: User Table
  In order to manipulate user list data
  As a user
  I want to check 'Vip' checkboxes

  Scenario: Check 'Vip' checkbox for user 'Sergey Ivan'
    Given I open JDI GitHub site
    And I login as user "Roman" "Jdi1234"
    And I click on "Service" button in Header
    And I click on "User Table" button in Service dropdown
    When I select 'vip' checkbox for "Sergey Ivan"
    Then 1 log row has "Vip: condition changed to true" text in log section