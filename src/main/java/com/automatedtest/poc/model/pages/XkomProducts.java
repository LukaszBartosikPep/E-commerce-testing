package com.automatedtest.poc.model.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class XkomProducts extends GeneralPage{

    private static final By searchLocator=By.xpath("//input[@placeholder='Czego szukasz?']");
    private static final By adataLocator=By.xpath("//span[text()='ADATA']");

    private static final By nonAvailableProductLocator=By.xpath("//div[text()='Czasowo niedostępny']");
    private static final By numberOfItemsLocator=By.xpath("//div[@class='sc-hqmb1u-7 cLoElV']");
    String disksListLocator="//div[@id='listing-container']/div[%s]";
    public void giveInputText(){

        setTextBySelector("Dysk SSD zewnetrzny", searchLocator);
        clickBySelector(adataLocator);
    }


    public int retrieveNumberOfItems() throws InterruptedException{

        String getNumberOfItems=getText(numberOfItemsLocator);

        scrollDownUp();
//        waitForElementVisible(nonAvailableProductLocator, 2);
        List<WebElement> nonAvailableItemList=getNumberOfElements(nonAvailableProductLocator);
        System.out.println(nonAvailableItemList.size());

//        ArrayList<WebElement> itemList=new ArrayList<WebElement>();
//
//        for(int i=1;i<20;i++) {
//            String xpathExpressionProductItem = String.format(disksListLocator, i);
//
//            WebElement element= findElementBySelector(By.xpath(xpathExpressionProductItem));
//
//            itemList.add(element);
//        }

            return nonAvailableItemList.size();
    }


}
