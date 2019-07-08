Feature: To test the basic elements on the OpenWeatherMap homepage

  Background:
    Given an open browser session
    When I navigate to the OpenWeatherMap homepage

  Scenario: Check the important labels and links on website homepage

    Then I check the links on the top for signup and signin along with the searchbox for city
    And I check the website logo whether it redirects back to the homepage after clicking
    And I check the whether the menubar is displayed for different sections of the website
    And I check whether the city searchbox and searchButton is displayed and usable
    And I close all browsers


  Scenario: Check weather for an invalid city name

    Then I enter an invalid city name in the search box and click on the search button
    Then I see an error message saying that the city was not found
    And I close all browsers

  Scenario: Check weather for an valid city name

    Then I enter an valid city name in the search box and click on the search button
    And I check the details of the city weather in the results
    And I close all browsers