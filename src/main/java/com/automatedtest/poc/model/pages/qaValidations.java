package com.automatedtest.poc.model.pages;


import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class qaValidations extends GeneralPage{

    private static final By link=By.xpath("//a[contains(text(), 'Click Here for Broken Link')]");
    String url="https://demoqa.com/";

    private static final By imgSrc=By.xpath("//p/following-sibling::img[@src='/images/Toolsqa_1.jpg']");

    private static final By dynamicElement=By.xpath("//button[@class='mt-4 text-danger btn btn-primary']");
    public int clickLink() throws IOException {

//        clickBySelector(link);

       int websiteReturnCode= returnResponseCode(url);

       return websiteReturnCode;
    }

    public int checkIfImgLoaded(){
       int width= getWidth(imgSrc);

       System.out.println(width);

       return width;
    }
    public void countTime(){
        timeUntilVisible(dynamicElement);
    }

}
