package com.autotradereu.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends Base{

    @FindBy(xpath = "//button[contains(text(),'Browse by Make')]")
    public WebElement browseByMake;


    @FindBy(xpath = "//button[contains(text(),'Browse by Style')]")
    public WebElement browseByStyle;


    @FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
    public WebElement advanceSearch;

    @FindBy(xpath = "  //a[contains(text(),'Advanced Search')]")
    public WebElement advenceSearchButton;


    @FindBy(xpath = "//select[@id='makeCode']")
    public WebElement anyMake;

    @FindBy(xpath = "//select[@id='makeModel']")
    public WebElement anyModel;


    // locator lari bulmak icin kolay yollardan biri SelectorsHub plugini chrome indir.
    // piyasada ki en iyi locator finder selectorshub

}
