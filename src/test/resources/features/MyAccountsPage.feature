Feature: Account Page Feature

  Background:
    Given user has already logged in to application
      | username                | password     |
      | techsystems@safeboda.com | Safeboda123$ |

  Scenario: Accounts Page Title
    Given user is on Account Page
    When User gets the Title of the Page
    Then Page Title should be "My account - My Store"

  Scenario: Account Section Count
    Given user is on Account Page
    Then user gets account sections
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |
      | Home                      |
    And the Sections should be 6