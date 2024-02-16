package com.automatedtest.poc.model.pages;

import com.automatedtest.core.utils.repeatable.Repeatable;
import com.automatedtest.poc.config.SeleniumDriver;
import org.apache.tools.ant.taskdefs.Java;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.automatedtest.core.logger.BFLogger.logDebug;

//TODO Here you write methods that do general operations on the application
//TODO These methods are directly or indirectly used in STEP DEFINITIONS
//TODO Create appropriate page models when implementing test cases for SauceDemo
@Component
public class GeneralPage {

    private final int repeatCount = 15;
    private final int waitTime = 2000;

    @Autowired
    private Repeatable repeatable;


    public WebDriver getDriver() {
        return SeleniumDriver.getDriver();
    }



    public void openPage(String page) {
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        getDriver().get(page);
        getDriver().manage().window().maximize();
    }
    public void setWaitTime(By selector) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }
    public String returnUrl(){
        String currentPageUrl= getDriver().getCurrentUrl();

        return currentPageUrl;


    }

    public List<WebElement> findElements(By selector){


            WebElement element = getDriver().findElement(selector);

            List<WebElement> listOfElements=element.findElements(By.xpath(".//th"));

            return listOfElements;




    }

    public WebElement findElementBySelector(By selector) {
        logDebug("Looking for element by selector " + selector.toString());
        repeatable.repeat(() -> {
            getDriver().findElement(selector);
        }, repeatCount, waitTime);
        return getDriver().findElement(selector);
    }

    public void clickBySelector(By selector) {
        logDebug("Click element by selector " + selector.toString());
        repeatable.repeat(() -> {
            getDriver().findElement(selector).click();
        }, repeatCount, waitTime);
    }



    public void sendValue(By selector, String value) {
//        logDebug("Click element by selector " + selector.toString());
        WebElement input=getDriver().findElement(selector);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value = arguments[1];", input, value);
//            getDriver().findElement(selector).sendKeys(value);

    }

    public void setTextBySelector(String text, By selector) {
        logDebug("Set Text by selector " + selector.toString());
        repeatable.repeat(() -> {
            getDriver().findElement(selector).sendKeys(text + Keys.ENTER);
        }, repeatCount, waitTime);
    }
    String textValue;
    public String getText(By selector) {

        logDebug("Get Text by selector " + selector.toString());
        repeatable.repeat(() -> {
          textValue =getDriver().findElement(selector).getText();
        }, repeatCount, waitTime);

        return textValue;


    }

    public void setTextBySelectorNoEnter(String text, By selector) {
        logDebug("Set Text by selector " + selector.toString());
        repeatable.repeat(() -> {
            getDriver().findElement(selector).sendKeys(text);
        }, repeatCount, waitTime);
    }

    public void scrollDownUp() throws InterruptedException{

        JavascriptExecutor jse=(JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//        Thread.sleep(2000);
        jse.executeScript("window.scrollTo(0, 0)");
//        jse.executeScript("window.scrollBy(0,-1000");
    }

}
