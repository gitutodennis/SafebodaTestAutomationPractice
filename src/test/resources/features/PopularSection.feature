Feature: Popular Section
  Background:
    Given User is on the Login Page
    When user enters username "techsystems@safeboda.com"
    And user enter valid password "Safeboda123$"
    And user click the Login Button
    Then User gets the Title of the Page
    And Page Title should be "My account - My Store"


    @popular
  Scenario:  Fetch Apparels List on the POPULAR Category
    Given User is on the Landing Page
    When User clicks on the Popular Category Button
    Then User is able to get the Apparels List
