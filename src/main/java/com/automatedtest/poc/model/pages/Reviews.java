package com.automatedtest.poc.model.pages;


import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Reviews extends GeneralPage{


    private static final By reviewsLocator=By.xpath("//div[@id='centerCol']//*[starts-with(text(), 'Liczba ocen:')]");
    private static final By reviewsCountLocator=By.xpath("//span[@data-hook='total-review-count']");
//
    private static final By fiveStarLocator = By.xpath("//table[@id='histogramTable']//*[contains(text(), '5 gwiazdek')]");

    private static final By percentStarLocator = By.xpath("//table[@id='histogramTable']//a[contains(@aria-label,'liczba gwiazdek: 5')]");

    private static final By starsCountSelector= By.xpath("//span[@id='a-autoid-5-announce']/span[@class='a-dropdown-prompt']");
    private static final By starsNumberOption=By.xpath("//a[contains(text(), 'Gwiazdki: 1')]");
    private static final By numberOfComments=By.xpath("//div[contains(text(), ' Łącznie ocen:')]");
    public String giveReviewsNumber(){

        String reviewsCount=getText(reviewsLocator);

//        int number=Integer.parseInt(reviewsCount);

        String reviewsAfterSplit=reviewsCount.replace("Liczba ocen: ", "");

        System.out.println(reviewsAfterSplit);

        return reviewsAfterSplit;


//        Pattern pattern = Pattern.compile("(\\d+ \\d+)");
//        Matcher matcher = pattern.matcher(reviewsCount);
//        for(int i = 0 ; i < matcher.groupCount(); i++) {
//            matcher.find();
//            System.out.println(matcher.group());
//        }
//        System.out.println(number);
    }

    public boolean comparePercentAndNumberOfStars(){

        clickBySelector(reviewsLocator);
        String numberOfStars=getText(fiveStarLocator);
        String percenteOfReviews=getText(percentStarLocator);


        return (numberOfStars.equals("5 gwiazdek") && percenteOfReviews.equals("82%"));

    }
    public void howManyReviewsWithComment() throws InterruptedException{
        clickBySelector(fiveStarLocator);
        clickBySelector(starsCountSelector);
        clickBySelector(starsNumberOption);
       Thread.sleep(2000);

        String totalNumber= getText(numberOfComments);
       String delFirstPart=totalNumber.replace("Łącznie ocen: ", "");
       String delSecondPart=delFirstPart.replaceAll(" z oceną| z ocenami", "") ;
       String removeSpace=delSecondPart.replaceAll("\\s", "");
       String[] split= removeSpace.split(",");
       String allReviewsWithComment=split[1];

       System.out.println(allReviewsWithComment);
    }


}
