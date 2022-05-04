
Feature: the user should able to apply open QA position

  Scenario: the user can apply to open position
    Given the user is on the career page
    When the user clicks to open position for the Automation Test Engineer
    And the user enters the necessary information on the info page
    Then the user should able to navigate application page
@wip
  Scenario: the user can not apply to open position with missing information
    Given the user is on the career page
    When the user clicks to open position for the Automation Test Engineer
    And the user does not enter the all necessary information on the info page
    Then the user sould not able to navigate application page