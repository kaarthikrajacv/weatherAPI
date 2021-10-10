  @weather @city
  Feature: Test Open Weather Map API

    Background:
      Given The OpenWeather MAP API end point

    @mumbai
    Scenario: Get Weather API for mumbai and Print Data
      When Required data like API key & City is given
      Then Hit the Weather API and print the response in Console

    @chennai
    Scenario: Get Weather API for Chennai and Print Data
      When Required data like API key & City is given
      Then Hit the Weather API and print the response in Console


#    Scenario Outline: Get Weather Details for Different cities
#      Given The OpenWeather MAP API end point
#      When We parametarise <city> along with API key "345"
#      Then Hit the Weather API and print the response in Console
#
#      Examples:
#      |city|
#      |"chennai"|
#      |"coimbatore"|
#      |"hyderabad"|

