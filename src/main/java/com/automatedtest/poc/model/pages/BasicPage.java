package com.automatedtest.poc.model.pages;


import com.automatedtest.core.utils.repeatable.Repeatable;
import com.automatedtest.poc.config.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static com.automatedtest.core.logger.BFLogger.logDebug;

@Component
public class BasicPage extends GeneralPage {

    private static final By acceptButton=By.id("sp-cc-accept");
    private static final By searchInput=By.id("twotabsearchtextbox");


    public void clickAccept(){

        clickBySelector(acceptButton);


    }
}


