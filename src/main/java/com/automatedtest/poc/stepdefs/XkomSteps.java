package com.automatedtest.poc.stepdefs;

import com.automatedtest.poc.model.pages.GeneralPage;
import com.automatedtest.poc.model.pages.XkomProducts;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class XkomSteps {

    @Autowired
    XkomProducts xkom;

    @Autowired
    GeneralPage generalPage;

    @Given("I open page")
    public void openPage(){
    generalPage.openPage("https://www.x-kom.pl/");
    }

    @Then("I search product")
    public void searchProduct() throws InterruptedException{
    xkom.giveInputText();
    xkom.retrieveNumberOfItems();

    }

}
