package com.autotradereu.pages;

import com.autotradereu.utils.MyDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Base {
    public Base() {
        PageFactory.initElements(MyDriver.get(), this);
    }

    public static void waitSomeTime(Long miliseconds)  {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollDown(WebElement str) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) MyDriver.get();

        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",str);
        //javascriptExecutor.executeScript("window.scrollBy(0,50)");

    }
}
