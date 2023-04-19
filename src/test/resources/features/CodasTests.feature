Feature: Codas Test Journey 1

  @allTest
  Scenario: Verify news article is present and then place an order
    Given user is on the homepage
    When user clicks on "News"
    Then user sees an article dated "March30th,2022"
    And user click on Read More
    And user takes a screenshot of "Article"
    And user navigates to home page
    And user clicks on "CODAS-IQO"
    And user clicks on "IQO Demo"
    And user enters the postcode "M54TP" and Get Quote
    And user selects the "3 Day Delivery" option
    And user takes a screenshot of "Your details"

    @wip
    Scenario: Testing browsers
      Given user is on the homepage

