package com.blaze.sclc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingDetailsPage {

    public static WebDriver driver;

    By detailsHeading=By.xpath("//h2[contains(text(),'Your flight from TLV to SFO has been reserved.')]");
    By name= By.xpath("");
    By address=By.xpath("");
    By City=By.xpath("");
    By purchebutton=By.xpath("");
    By cardType=By.xpath("");
    By flightno=By.xpath("");



    public BookingDetailsPage(WebDriver driver){
        this.driver=driver;
    }

    public String getBookingDetailsPage(){
        return driver.findElement(detailsHeading).getText();
    }
public void clickPurchage(){
        driver.findElement(purchebutton).click();
}
public String getBookingConfirmation(){
        return driver.findElement(detailsHeading).getText();

}

}
