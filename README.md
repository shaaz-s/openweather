# openweather
New selenium-cucumber project


In order to run this project, please follow the steps below -

Clone this Maven project from the following link -
https://github.com/shaaz-s/openweather.git

To run the selenium cucumber tests, run the java file OpenWeatherRunner.java in the following location as Junit test

openweather/src/test/java/runners/


These tests will run the feature file for the following scenarios-


1.  Verifies that all important information is there, e.g.  labels etc. 

2.  End-to-end test that

·Starts on the https://openweathermap.org/

·Enters an invalid city name

·Searches for the weather

·Verifies that website suggests city is "Not found"

3.   End-to-end test that

·Starts on the https://openweathermap.org/

·Enters a valid city name

·Searches for the weather

·Verifies that website successfully returns weather details for the city.


In case I had more time,I would have added a few more detailed checks on the homepage of the website. 

I would also add this to the Jenkins execution so as to run this periodically for regression.

Would like to add some reporting tool so that the results are detailed with logs
