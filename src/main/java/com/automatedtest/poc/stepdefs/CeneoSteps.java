package com.automatedtest.poc.stepdefs;

import com.automatedtest.poc.EnvironmentEnums;
import com.automatedtest.poc.model.pages.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;

public class CeneoSteps {

    @Autowired
    GeneralPage generalPage;
    @Autowired
    Offers  offers;
    @Autowired
    ColorsPrice  colorsPrice;

    @Given("Ceneo is opened")
    public void openSaucePage() {
        generalPage.openPage("https://www.ceneo.pl/");
        offers.clickAccept();

    }
    @Then("I search for product")
        public void search() throws InterruptedException{
        offers.searchForProduct(EnvironmentEnums.SamsungS23.getAddress());

        }

    @Then("I select lowest prices")
        public void lowestPrice() throws InterruptedException{

        offers.giveLowestPriceOffers();


        (offers.comparePrices()).forEach(System.out::println);
    }

    @When("I check prices by color")
    public void pricesByColor(){

        colorsPrice.howManyColors();
        colorsPrice.createListOfColors();
        LinkedHashMap<String, String> priceWithColor= colorsPrice.assignColorsToPrice();

        assertEquals(priceWithColor.get("Czerwony"),"7 499" );
        assertEquals(priceWithColor.get("Kremowy"),"4 947" );





    }
}