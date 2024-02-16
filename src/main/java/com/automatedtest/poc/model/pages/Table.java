package com.automatedtest.poc.model.pages;


import com.github.dockerjava.api.model.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class Table extends GeneralPage{


    String firstRow="//table[@id='productDetails_techSpec_section_1']//tr[%s]/th[1]";
    String  secondRow="//table[@id='productDetails_techSpec_section_1']//tr[%s]/td[1]";
   private static final By tableLocator=By.xpath("//table[@id='productDetails_techSpec_section_1']//tbody");




    LinkedHashMap<String, String> detailsTable=new LinkedHashMap<>();

//    public void countNumberOfRows(){
//
//
//       List<WebElement> rowsList= findElements(tableLocator);
//
//
////        int c=0;
////        while(findElementBySelector(By.xpath(tableLocator))!=null){
////            String table = String.format(tableLocator, c);
////            findElementBySelector(By.xpath(table));
////            c++;
////
////        }
////
//        System.out.println(rowsList.size());
//        tableSize=rowsList.size();
//    }

    public LinkedHashMap<String, String> HashTable(){
        List<WebElement> rowsList= findElements(tableLocator);

        int tableSize=rowsList.size();

        for(int i=1; i<tableSize; i++){

            String xpathExpressionFirstRow = String.format(firstRow, i);
            String xpathExpressionSecondRow = String.format(secondRow, i);

            By tableElementFirst=By.xpath(xpathExpressionFirstRow);

            By tableElementSecond=By.xpath(xpathExpressionSecondRow);


            detailsTable.put(getText(tableElementFirst), getText(tableElementSecond));

        }
        System.out.println(detailsTable);
        return detailsTable;


    }
}
