# openweather
New selenium-cucumber project


In order to run this project, please follow the steps below -

Clone this Maven project from the following link -
https://github.com/shaaz-s/openweather.git

To run the selenium cucumber tests, run the java file OpenWeatherRunner.java as Junit test

These tests will run the feature file for following scenarios-


1.  Verifies that all important information is there, e.g.  labels etc. 
2.  End-to-end test that

·         Starts on the https://openweathermap.org/

·         Enters an invalid city name

·         Searches for the weather

·         Verifies that website suggests city is "Not found"

3.   End-to-end test that

·         Starts on the https://openweathermap.org/

·         Enters a valid city name

·         Searches for the weather

·         Verifies that website successfully returns weather details for the city.
