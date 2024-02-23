package com.automatedtest.poc.model.pages;


import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class Interactions extends  GeneralPage{

    private static final By box=By.id("resizableBoxWithRestriction");



    public void setSize(){
        sendValue(box);
    }
}
