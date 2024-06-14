@tag
Feature: Esign Document Scenario
  I want to use this template for my feature file

  Background: 
    Given I landed on Esigns Page

  @tag1
  Scenario: Title of your scenario
    Given I want to write a step with precondition
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes

  @tag2
  Scenario Outline: Check Login
    Given Logged in With Username <name> and password <password>
    When I clicked <value> on login
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
