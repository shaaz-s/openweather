package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class openWeatherHome {

    private WebDriver driver;

    public openWeatherHome(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//*[@id='undefined-sticky-wrapper']/div/div/div/div[1]/a/img")
    private WebElement homeLogo;

    @FindBy(xpath = "//*[text()=' Sign In']")
    private WebElement signInLink;

    @FindBy(xpath = "//*[text()=' Sign Up']")
    private WebElement signUpLink;

    @FindBy(xpath = "//*[text()=' Weather in your city']")
    private WebElement cityWeatherSearchbox;

    @FindBy(linkText = "  Current location")
    private WebElement locationButton;

    @FindBy(css = "input#q.form-control.border-color.col-sm-12")
    private WebElement citySearchBox;

    @FindBy(css = "button.btn.btn-orange")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='weather-widget']/h2")
    private WebElement cityName;

    @FindBy(xpath = "//*[@id='weather-widget']/h3")
    private WebElement tempUnit;

    @FindBy(css="ul.nav.navbar-nav.navbar-right")
    private WebElement menuBar;

    @FindBy(css="table.weather-widget__items")
    private WebElement weatherTable;

    @FindBy(xpath="//*[@id='forecast_list_ul']/div")
    private WebElement invalidCityText;

    @FindBy(xpath="//*[@id='forecast_list_ul']/table/tbody/tr/td[2]/b[1]/a")
    private WebElement cityResult;


    public WebElement getHomeLogo() {
        return homeLogo;
    }

    public WebElement getSignInLink() {
        return signInLink;
    }

    public WebElement getSignUpLink() {
        return signUpLink;
    }

    public WebElement getCityWeatherSearchbox() {
        return cityWeatherSearchbox;
    }

    public WebElement getLocationButton() {
        return locationButton;
    }

    public WebElement getCitySearchBox() {
        return citySearchBox;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getCityName() {
        return cityName;
    }

    public WebElement getTempUnit() {
        return tempUnit;
    }

    public WebElement getMenuBar() {
        return menuBar;
    }

    public WebElement getWeatherTable() {
        return weatherTable;
    }

    public WebElement getInvalidCityText() {
        return invalidCityText;
    }

    public WebElement getCityResult() {
        return cityResult;
    }


}
