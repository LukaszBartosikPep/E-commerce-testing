package com.automatedtest.poc.model.pages;


import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class qaPage extends GeneralPage{

        private static final By consent=By.xpath("//*[contains(text(), 'Zgadzam się')]");

        private static final By sliderLocator=By.xpath("//input[@class='range-slider range-slider--primary']");
        private static final By sliderInputField=By.id("sliderValue");

        private static final By monthSelection=By.className("react-datepicker__month-select");

        private static final By calendarDateLocator=By.id("datePickerMonthYearInput");



        String monthPick="//option[contains(text(), '%s')]";

        private static final By dayPick=By.xpath("//div[contains(text(), '10')]");
        public void clickConsent(){
            clickBySelector(consent);
        }
        public void changeSliderValue(){

            changeSliderOffset(sliderLocator, 10);
        }

        public String chooseDateTime(String month){
            String xpathExpressionMonth = String.format(monthPick, month);
            clickBySelector(calendarDateLocator);
            clickBySelector(monthSelection);
            clickBySelector(By.xpath(xpathExpressionMonth));
            clickBySelector(dayPick);
            return getAttribute(calendarDateLocator);
        }

}
