package com.blaze.sclc.pages;

import com.blaze.sclc.common.WebDriverUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightsPage {

    public static WebDriver driver;
    By selectFlight= By.xpath("//tbody/tr[1]/td[1]/input");
    By flightNo=By.xpath("");
    By price=By.xpath("");
    By flightPageHeading=By.xpath("//h3[contains(text(),'Flights from Paris to Buenos Aires:')]");
    BookingDetailsPage bookingDetailsPage=new BookingDetailsPage(WebDriverUtilities.driver());
    public FlightsPage(WebDriver driver){
    this.driver=driver;
}

    public BookingDetailsPage chooseFlight() {
        driver.findElement(selectFlight).click();
        return bookingDetailsPage;
    }



}
