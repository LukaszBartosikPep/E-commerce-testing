package com.automatedtest.poc.model.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class Product extends GeneralPage{


    private static final By searchInput=By.id("twotabsearchtextbox");
    private static final By legoCheckbox=By.xpath("//li[@id='p_89/LEGO']/span/a/div");

    private static final By lowPrice=By.id("low-price");
    private static final By highPrice=By.id("high-price");

    private static final By ratrakLink=By.xpath("//*[starts-with(text(), 'LEGO 42148 Technic Ratrak Model z Klocków 2w1, Zabawki Inżynieryjne')]");

    //next get number of reviews
    private static final By inputDropDown=By.xpath("//div/div/input[@name='items[0.base][quantity]']");

    private static final By dropdownLocator=By.xpath("//span[@id='a-autoid-0']/span[@class='a-button-inner']");

    private static final By selectDropdownValue=By.xpath("//div[@class='a-popover-inner']//li[@class='a-dropdown-item']/a[@id='quantity_2']");
    public void searchForProduct(){

        clickBySelector(searchInput);
        setTextBySelector("Lego", searchInput);
        clickBySelector(legoCheckbox);
        setTextBySelector("25", lowPrice);
        setTextBySelector("50", highPrice);
        clickBySelector(ratrakLink);
//        sendValue(inputDropDown, "5");
        clickBySelector(dropdownLocator);
        clickBySelector(selectDropdownValue);

    }

}
