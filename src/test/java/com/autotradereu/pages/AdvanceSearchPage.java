package com.autotradereu.pages;

import com.autotradereu.utils.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AdvanceSearchPage extends Base {
    Logger logger = LoggerFactory.getLogger(AdvanceSearchPage.class);

    @FindBy(xpath = "//input[@name='zip']")
    public WebElement zipcode;

    @FindBy(xpath = "//div[contains(text(),'Certified')]")
    public WebElement certified;

    @FindBy(xpath = "//div[normalize-space()='Convertible']")
    public WebElement convertible;

    @FindBy(xpath = "//select[@name='startYear']")
    public WebElement startYear;

    @FindBy(xpath = "//select[@name='endYear']")
    public WebElement endYear;

    @FindBy(xpath = "//select[@name='makeFilter0']")
    public WebElement carModel;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    public WebElement searchButton;

    //@FindBys(xpath = "//div[@data-cmp='inventoryListing']")
    //WebElement numberOfListings;


    public void zipCode(String zipCode) {
        MyDriver.get().manage().deleteAllCookies();
        waitSomeTime(1000L);
        zipcode.clear();
        zipcode.sendKeys(zipCode);
    }

    public void selectCheckBox(String checkBox) {
        if(checkBox.equals(certified.getText())){
            certified.click();
        }else{
            scrollDown(convertible);
            convertible.click();
        }
    }



    public void modelYears(String startYears, String endYears) {
        scrollDown(startYear);
        Select selectfromYear=new Select(startYear);
        selectfromYear.selectByValue("2017");

        Select selectToYear=new Select(endYear);
        selectToYear.selectByValue("2020");
    }

    public void chooseModel(String model) {
        scrollDown(carModel);
        Select carModels=new Select(carModel);
        carModels.selectByValue("BMW");

    }

    public void clickSearchButton() {

        scrollDown(searchButton);
        searchButton.click();
    }

    public void numberOfListingCount(String model) {//BMW
        List<WebElement> list=MyDriver.get().findElements(By.xpath("//h2[@data-cmp='subheading']"));

        for(int i=0;i<list.size();i++){
            if(!list.get(i).getText().contains(model)){
                System.out.println("There is non BMW listing");
                System.out.printf("Listing fount %s : ",list.get(i).getText());
                logger.info("We found non BMW listing {}",list.get(i).getText());
                logger.info("We found non BMW listing "+ list.get(i).getText());

            }

        }
        logger.info("Total BMW listing is {} ",list.size());
        //div[@data-cmp='inventoryListing']
    }

}