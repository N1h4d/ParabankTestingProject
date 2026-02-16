Feature: Transfer between my accounts

  Background:
    Given Navigate to Parabank
    And User is logged in
    And User has at least 2 accounts


  @Transfer
  Scenario Outline: Transfer validation scenarios
    And Click on the Element in LeftNav
      | transferFunds |
    When User enters transfer information
      | senderAccount   | <sender> |
      | receiverAccount | <receiver> |
      | amount          | <amount> |
    And User confirms transfer
    Then Result message should be displayed
      | <result> |

    Examples:
      | sender   | receiver | amount | result            |
      | 0        | 1        | 100    | Transfer Complete!|
      | 1        | 0        | 80     | has been transferred|


