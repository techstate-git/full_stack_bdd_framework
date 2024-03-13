Feature: Customer testing
  @Smoke
  Scenario Outline: Boarding new customer
    Given I have the data to create customer with "<firstName>","<lastName>","<phone>","<address1>","<address2>"
    And I use customer header
    When I create post request to create customer
    Then I get status code 201 from database
    And response body should contain
      | firstName |
      | lastName  |
      | phone     |
      | addresses |
      | id        |

    Examples:
      | firstName | lastName | phone | address1 | address2 |
      | Alex      | Kozlov   | 123   | Backer 2 | Union 3  |