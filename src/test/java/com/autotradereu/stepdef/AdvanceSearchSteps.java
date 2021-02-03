package com.autotradereu.stepdef;

import com.autotradereu.pages.AdvanceSearchPage;
import com.autotradereu.pages.Base;
import com.autotradereu.utils.ConfigurationReader;
import com.autotradereu.utils.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;

public class AdvanceSearchSteps{
    AdvanceSearchPage advanceSearchPage=new AdvanceSearchPage();
    @Given("User is in Advance Search home page")
    public void userClickAdvanceSearchLinkOnTheHomePage() {
        MyDriver.get().get(ConfigurationReader.getProperty("advanceUrl"));
        String expectedTitle="Search for Cars For Sale Online - Find a Car at Autotrader";
        String actualTitle=MyDriver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Then("User enter {string} in the zip code text box")
    public void userEnterInTheZipCodeTextBox(String zipCode) {
        advanceSearchPage.zipCode(zipCode);

    }

    @Then("User select {string} check box under {string}")
    public void userSelectCheckBoxUnder(String checkBox, String arg1) {
        advanceSearchPage.selectCheckBox(checkBox);
        System.out.println("ddfdsf");

    }

    @Then("user update Year {string} to {string}")
    public void userUpdateYearTo(String startYear, String endYear) {
        advanceSearchPage.modelYears(startYear,endYear);
    }

    @Then("user select {string} car from Make,Model and Trim section")
    public void userSelectCarFromMakeModelAndTrimSection(String model) {
        advanceSearchPage.chooseModel(model);
    }

    @Then("User clicks Search button")
    public void userClicksSearchButton() {
        advanceSearchPage.clickSearchButton();
    }

    @Then("User verifies that he is in result page")
    public void userVerifiesThatHeIsInResultPage() {
        MyDriver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Base.waitSomeTime(3000L);
        String expected="Certified BMW Convertibles for Sale in Alpharetta, GA (with Photos) - Autotrader";
        String actual=MyDriver.get().getTitle();
        Assert.assertEquals(expected,actual);
    }

    @Then("User verifies that he sees only {string} cars in listing")
    public void userVerifiesThatHeSeesOnlyCarsInListing(String model) {
        advanceSearchPage.numberOfListingCount(model);

    }

    @Then("Display in console, the number of cars listed in result page")
    public void displayInConsoleTheNumberOfCarsListedInResultPage() {
    }
}
