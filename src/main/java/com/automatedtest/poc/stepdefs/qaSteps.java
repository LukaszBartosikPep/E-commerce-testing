package com.automatedtest.poc.stepdefs;

import com.automatedtest.poc.model.pages.GeneralPage;
import com.automatedtest.poc.model.pages.Interactions;
import com.automatedtest.poc.model.pages.qaValidations;
import com.automatedtest.poc.model.pages.qaPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class qaSteps {


    @Autowired
    GeneralPage generalPage;

    @Autowired
    qaPage qapage;

    @Autowired
    qaValidations qalinks;

    @Autowired
    Interactions interact;

    @Given("I open the {string} site")
    public void open(String url){
        generalPage.openPage(url);
        qapage.clickConsent();




    }

//    @Given("I open the dateTime site")
//    public void openDTSite() {
//        generalPage.openPage("https://demoqa.com/date-picker");
//        qapage.clickConsent();
////        qapage.chooseDateTime(month);
//    }

    @Given("I pick and compare date {string}")

        public void compareDate(String month) {

            String dateInInput = qapage.chooseDateTime(month);

            assertEquals("Date not match", dateInInput, "07/10/2024");

        }




    @Then("I change slider value")
    public void sliderValue(){
        qapage.changeSliderValue();
    }

    @Given("I check if URL valid")
    public void urlValidation() throws IOException {
       int httpCode= qalinks.clickLink();

       assertEquals("Link is not valid", httpCode, 200);

    }
    @Given("I check if img valid")
    public void checkImg(){
        int imgWidth=qalinks.checkIfImgLoaded();

        assertTrue("Image is not being loaded",imgWidth>50);
    }
    @Then("I retrieve the time")
    public void giveTime(){
    qalinks.countTime();

    }

    @Given("I change the size of box")
    public void changeSize(){

    }
}
