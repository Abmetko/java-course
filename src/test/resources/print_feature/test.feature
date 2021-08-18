Feature: Order history

  Scenario: Get order history
    When get access token
    Then number of closed orders equals to "0"
    And number of open orders equals to "1"