package com.academy.techcenture.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class LoginStepDef {
    private WebDriver driver;

    @Given("user launches the {string} browser")
    public void userLaunchesTheBrowser(String browser) {
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver() ;
        }
        else if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver =  new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }


    @Given("user is on log in page")
    public void user_is_on_log_in_page() {

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");

    }


    @When("user enters {string} and {string} credentials")
    public void user_enters_Tester_and_test_credentials(String username, String password) {
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);


    }


    @And("user clicks on login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.id("ctl00_MainContent_login_button"));

    }


    @Then("user should be navigated to the dashboard")
    public void user_should_be_navigated_to_the_dashboard() {
        String title = driver.getTitle();
        Assert.assertEquals("Web Orders Login", title);
       quitDriver();


    }


    @Then("user should not be able to log in")
    public void userShouldNotBeAbleToLogIn() {
        WebElement errorMsg = driver.findElement(By.id("ctl00_MainContent_status"));
        Assert.assertTrue(errorMsg.isDisplayed());
        quitDriver();
    }

    private void quitDriver () {
        if (driver != null){
            driver.quit();
        }
    }
}