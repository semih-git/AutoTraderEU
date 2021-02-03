package com.autotradereu.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchPage extends Base {
    Logger logger = LoggerFactory.getLogger(SearchPage.class);

    @FindBy(xpath = "//button[normalize-space()='Browse by Make']")
    public WebElement browseByMake;

    @FindBy(xpath = "//button[normalize-space()='Browse by Style']")
    public WebElement browseByStyle;

    @FindBy(xpath = "//a[normalize-space()='Advanced Search']")
    public WebElement advanceSearch;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    public WebElement button;

    @FindBy(xpath = "//select[@id='makeCode']")
    public WebElement anyMake;

    @FindBy(xpath = "//select[@id='ModelCode']")
    public WebElement anyModel;

    public void verifytheFields(String value) {
        String actual;
        if (value.equals(browseByMake.getText())) {
            actual = browseByMake.getText();
            Assert.assertEquals(value, actual);
            logger.info("Browse By Make Assertion successful");
        } else if (value.equals(browseByStyle.getText())) {
            actual = browseByStyle.getText();
            Assert.assertEquals(value, actual);
            logger.info("Browse By Style Assertion successful");
        } else if (value.equals(advanceSearch.getText())) {
            actual = advanceSearch.getText();
            Assert.assertEquals(value, actual);
            logger.info("Advance Search Assertion successful");
        }else
            logger.warn("Error");
    }

    public void verifySearchButton() {
        Assert.assertTrue(button.isDisplayed() && button.isEnabled());
        logger.info("Search button Assertion successful");
    }

    public void verifyAnyMakeAndAnyModel(String make, String model) {
        //Any Make
        Assert.assertTrue(anyMake.isDisplayed() &&anyMake.isEnabled());
        logger.info("{} is enabled and visible",make);

        //Any Model
        Assert.assertTrue(anyModel.isDisplayed() && !anyModel.isEnabled());
        logger.info("{} is enabled and not visible",model);
    }
}
