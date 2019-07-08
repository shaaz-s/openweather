package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import pages.openWeatherHome;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class OpenMapSteps {

    private WebDriver driver;
    private Properties prop= new Properties();

    @Given("an open browser session")
    public void an_open_browser_session() {
        System.setProperty("webdriver.chrome.driver","src/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @When("I navigate to the OpenWeatherMap homepage")
    public void i_navigate_to_the_OpenWeatherMap_homepage() throws IOException {
        FileInputStream fis= new FileInputStream("src/data.properties");
        prop.load(fis);
        driver.get(prop.getProperty("url"));
        Assert.assertTrue(driver.getTitle().startsWith("Сurrent weather"),"Website not launched successfully");
        Reporter.log("Website is now launched successfully\n");
        driver.manage().window().maximize();
    }

    @Then("I check the links on the top for signup and signin along with the searchbox for city")
    public void i_check_the_links_on_the_top_for_signup_and_signin_along_with_the_searchbox_for_city() {
        openWeatherHome oh = new openWeatherHome(driver);
        Assert.assertTrue(oh.getSignInLink().isDisplayed(),"Sign in link is not displayed");
        Reporter.log("Sign in link is displayed\n");

        Assert.assertTrue(oh.getCityWeatherSearchbox().isDisplayed(),"City Weather search box is not displayed");
        Reporter.log("City Weather search box is displayed\n");

        Assert.assertTrue(oh.getSignUpLink().isDisplayed(),"Sign Up link is not displayed");
        Reporter.log("Sign Up link is displayed\n");
        oh.getSignUpLink().click();
    }

    @Then("I check the website logo whether it redirects back to the homepage after clicking")
    public void i_check_the_website_logo_whether_it_redirects_back_to_the_homepage_after_clicking() {
        openWeatherHome oh = new openWeatherHome(driver);
        oh.getHomeLogo().click();
        Assert.assertTrue(driver.getTitle().startsWith("Сurrent weather"),"Website homepage redirected successfully");
        Reporter.log("Website homepage redirected successfully\n");

    }

    @Then("I check the whether the menubar is displayed for different sections of the website")
    public void i_check_the_whether_the_menubar_is_displayed_for_different_sections_of_the_website() {
        openWeatherHome oh = new openWeatherHome(driver);

        Assert.assertTrue(oh.getMenuBar().isDisplayed(),"Menu bar is not displayed");
        Reporter.log("Menu bar is displayed\n");

        List <WebElement> ls = oh.getMenuBar().findElements(By.xpath("//li[contains(@class,'nav__item')]"));
        int count = ls.size();
        Assert.assertTrue((count==Integer.parseInt(prop.getProperty("menucount"))),"Number of menu items is not correct");
        Reporter.log("Number of menu items is correct\n");
    }

    @Then("I check whether the city searchbox and searchButton is displayed and usable")
    public void i_check_whether_the_city_searchbox_and_searchButton_is_displayed_and_usable() {
        openWeatherHome oh = new openWeatherHome(driver);
        Assert.assertTrue(oh.getCitySearchBox().isDisplayed(),"City Search Box is not displayed");
        oh.getCitySearchBox().sendKeys(prop.getProperty("city"));
        Reporter.log("City Search Box is displayed\n");
        Assert.assertTrue(oh.getSearchButton().isEnabled(),"City search button is not enabled");
        Reporter.log("City search button is enabled\n");
    }

    @Then("I enter an invalid city name in the search box and click on the search button")
    public void i_enter_an_invalid_city_name_in_the_search_box_and_click_on_the_search_button() {
        openWeatherHome oh = new openWeatherHome(driver);
        oh.getCitySearchBox().sendKeys(prop.getProperty("invalidcity"));
        oh.getSearchButton().click();
    }

    @Then("I see an error message saying that the city was not found")
    public void i_see_an_error_message_saying_that_the_city_was_not_found() {
        openWeatherHome oh = new openWeatherHome(driver);
        Assert.assertTrue(oh.getInvalidCityText().getText().contains("Not found"),"No error message displayed");
        Reporter.log("Error message displayed successfully\n");
    }

    @And("I close all browsers")
    public void iCloseAllBrowsers() {
        driver.quit();
    }

    @Then("I enter an valid city name in the search box and click on the search button")
    public void iEnterAnValidCityNameInTheSearchBoxAndClickOnTheSearchButton() {
        openWeatherHome oh = new openWeatherHome(driver);
        oh.getCitySearchBox().sendKeys(prop.getProperty("city"));
        oh.getSearchButton().click();
        oh.getCityResult().click();
    }

    @And("I check the details of the city weather in the results")
    public void iCheckTheDetailsOfTheCityWeatherInTheResults() {
        openWeatherHome oh = new openWeatherHome(driver);
        Assert.assertTrue(oh.getCityName().getText().contains(prop.getProperty("city")),"Weather not showing for correct city");
        Reporter.log("Weather showing for correct city\n");
    }
}