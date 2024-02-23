package com.automatedtest.poc.model.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class ColorsPrice extends GeneralPage {

    String Colors = "//div[div[contains(text(), 'Wersja kolorystyczna:')]]//div[@class='product-family__options']//a[%s]";

    String colorsContainer="//div[div[contains(text(), 'Wersja kolorystyczna:')]]//div[@class='product-family__options']";
//    private static final By priceSelector=By.xpath("//span[@class='price']/span[@class='value']");
    private static final By getPriceSelector=By.xpath("//div[@class='product-offer-summary']//span[@class='price-format nowrap']/span[@class='price']/span[@class='value']");


    public int howManyColors(){
       List<WebElement> colorsList=getNumberOfElements(By.xpath(colorsContainer + "//*"));
        System.out.println(colorsList.size());

        return colorsList.size();

    }

    public ArrayList<String> createListOfColors() {

        ArrayList<String> colorsList=new ArrayList<String>();
        int colorsLength=howManyColors();
        for(int i=1;i<colorsLength+1;i++){

            String colorsSelector=String.format(Colors,i);
            String getColors=getText(By.xpath(colorsSelector));
//            WebElement element= findElementBySelector(By.xpath(colorsSelector));
            colorsList.add(getColors);
        }

        System.out.println(colorsList);

        return colorsList;


    }



    public LinkedHashMap<String, String> assignColorsToPrice(){

        LinkedHashMap<String, String> colorsWithPrices=new LinkedHashMap<>();
        ArrayList<String> targetListOfColors=createListOfColors();
        int colorsLength=howManyColors();  //8

        for(int i=1;i<colorsLength+1;i++){
//            String priceSelector=String.format(selectorByColor, targetListOfColors.get(i));
            String colorsSelector=String.format(Colors,i);
            clickBySelector(By.xpath(colorsSelector));
            String getPriceByColor=getText(getPriceSelector);
//            WebElement element= findElementBySelector(By.xpath(colorsSelector));
            colorsWithPrices.put(targetListOfColors.get(i-1), getPriceByColor);
        }

        System.out.println(colorsWithPrices);


            return colorsWithPrices;

    }

}