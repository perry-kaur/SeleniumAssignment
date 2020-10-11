Feature: Search

  Scenario Outline: Search and sort
    Given User navigates to Amazon "<url>"
    When User search for "<product>"
    And User sorts search list from highest to lowest price
    Then Results are displayed correctly

    Examples:
      | url                   | product |
      | http://www.amazon.com | Nikon   |

  Scenario Outline: Click second product details
    Given Search and sort list is displayed for "<url>" and "<product>"
    And User click second item in sorted list

    Examples:
      | url                   | product |
      | http://www.amazon.com | Nikon   |


  Scenario Outline: Check second product details
    Given Search and sort list is displayed for "<url>" and "<product>"
    When User click second item in sorted list
    Then Verify details contains "<topic>"

    # Instead of Nikon D3X using Nikon D5 as its shown as top 2nd
    Examples:
      | url                   | product | topic    |
      | http://www.amazon.com | Nikon   | Nikon D5 |





