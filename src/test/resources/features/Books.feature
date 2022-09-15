Feature: Books

  @Scenario2
  Scenario: Verify User see label No Rows Found when search unexist book
    Given User go to "https://demoqa.com/books"
    When User in "Book Store" page
    And User search book "qa engineer"
    Then User see "No rows found"

  @Scenario3
  Scenario: Verify User is able to search book and book detail is displayed correctly
    Given User go to "https://demoqa.com/books"
    When User in "Book Store" page
    And User search book "Git Pocket Guide"
    And User click book "Git Pocket Guide"
    Then User see "Git Pocket Guide" details
