package com.automatedtest.poc.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Offers extends GeneralPage {

    private static final By acceptCookies=By.xpath("//*[contains(text(), 'Ok, zgadzam się')]");
    private static final By locateSearchBar=By.id("form-head-search-q");
    private static final By s23Offer=By.xpath("//*[contains(text(),'Samsung Galaxy S23 Ultra 5G SM-S918 12/512GB Czarny')]/parent::*");
    String rowsOfProducts = "//ul[@class='product-offers__list js_product-offers js_normal-offers js_async-offers-container-standard']/li[%s]";

    String rowsOfPrice="//ul[@class='product-offers__list js_product-offers js_normal-offers js_async-offers-container-standard']/li[%s]/div/div[1]";

    public void clickAccept(){

        clickBySelector(acceptCookies);

    }
    public void searchForProduct(String product) throws InterruptedException{
        setTextBySelector(product, locateSearchBar);
        scrollDownUp();
        clickBySelector(s23Offer);

    }

    public ArrayList<String> giveLowestPriceOffers() throws InterruptedException{
        ArrayList<String> priceList=new ArrayList<String>();
//        ArrayList<String> priceList=new ArrayList<String>();
        scrollDownUp();
        for(int i=1;i<17;i++){

//            String xpathExpressionOffers = String.format(rowsOfProducts, i);

            String xpathExpressionPrice=String.format(rowsOfPrice,i);
//            By offers=By.xpath(xpathExpressionOffers);
//            By prices=By.xpath(xpathExpressionPrice);
           WebElement element= findElementBySelector(By.xpath(xpathExpressionPrice));

           priceList.add(element.getAttribute("data-price"));

            for(int j=priceList.size()-1;j>=0;j--){

                if(priceList.get(j)==null){
                    priceList.remove(j);


                }
            }



        }
        return priceList;
    }



    public List<Double> comparePrices() throws InterruptedException{
        ArrayList<String> priceList=giveLowestPriceOffers();
        ArrayList<Double> prices=new ArrayList<Double>();
        for(int y=0;y< priceList.size();y++){

            prices.add(Double.parseDouble(priceList.get(y)));


        }
        Collections.sort(prices);

//            List<Double> firstThreeOffers = prices.subList(0, 3);

        return prices.size() >= 3 ? prices.subList(0, 3) : new ArrayList<>(prices);
    }

}
