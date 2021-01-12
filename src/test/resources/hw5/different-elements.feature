Feature: Different Elements
  In order to verify Different Elements Page
  As a user
  I want to do some things on it

  Scenario: Different Elements Page Test
    Given I open JDI GitHub site
    And Browser title equals "Home Page"
    And I login as user "Roman" "Jdi1234"
    And User name in the left-top side of screen is displayed and equals to "ROMAN IOVLEV"
    And I open through the header menu Service -> Different Elements Page
    When I select checkboxes
      | Water |
      | Wind |
    And I select radiobutton "Selen"
    And I select dropdown color "Yellow"
    Then There are log records:
      | Colors: value changed to Yellow |
      | metal: value changed to Selen |
      | Wind: condition changed to true |
      | Water: condition changed to true |