package com.autotradereu.stepdef;

import com.autotradereu.pages.SearchPage;
import com.autotradereu.utils.ConfigurationReader;
import com.autotradereu.utils.MyDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyStepdefs {
    Logger logger= LoggerFactory.getLogger(MyStepdefs.class);
    SearchPage searchPage =new SearchPage();

    @ Given ("user test with {string} browser")

    public void user_test_with_browser(String brs){
        if(brs.equals("chrome")){
            //ConfigurationReader.getProperty("browser");
            System.setProperty("browser","chrome");


        }else
            //ConfigurationReader.getProperty("browserfx");
            System.setProperty("browser","firefox");
    }

    @Given("User is in home page")
    public void userIsInHomePage() {
        MyDriver.get().manage().deleteAllCookies();
        MyDriver.get().get(ConfigurationReader.getProperty("baseUrl"));
        MyDriver.get().navigate().refresh();
        String expected="Used and New Car Sales, Review - Autotrader";
        String actual= MyDriver.get().getTitle();
        Assert.assertEquals(expected,actual);
        MyDriver.get().manage().deleteAllCookies();
        logger.info("Assertion successful");
    }

    @Then("Verify that {string} is present")
    public void verifyThatIsPresent(String value) {
        searchPage.verifytheFields(value);

    }

    @And("Verify that Search button is present")
    public void verifyThatSearchButtonIsPresent() {
        searchPage.verifySearchButton();
    }

    @Then("Verify that {string} and {string} is present")
    public void verifyThatAndIsPresent(String make, String model) {
        searchPage.verifyAnyMakeAndAnyModel(make,model);

    }
}

