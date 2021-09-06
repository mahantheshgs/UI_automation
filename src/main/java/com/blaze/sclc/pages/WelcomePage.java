package com.blaze.sclc.pages;

import com.blaze.sclc.common.WebDriverUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage {
 public static WebDriver driver;
    By pagename= By.xpath("//h1[contains(text(),'Welcome to the Simple Travel Agency!')]");
    By tourSpot= By.xpath("//html/body/div[2]/div/p[2]/a");
    By fromCity=By.xpath("//html/body/div[3]/form/select[1]");
    By toCity=By.xpath("//html/body/div[3]/form/select[2]");
    By findButton=By.xpath("*//[@type=\'submit\')]");
    By homelink= By.xpath("//*[@class='brand' and @href='home']");
    //(For better logs out-put and data hiding we can prefer consuming Objects using getters and setters
   public WelcomePage(WebDriver driver){
        this.driver=driver;
    }
LoginPage loginPage=new LoginPage(driver);
   FlightsPage flightsPage=new FlightsPage(driver);
    
    public void navigateToLoginPage() throws Throwable{
        WebDriverUtilities.driver().findElement(homelink);
        Thread.sleep(500);
    }
public LoginPage clickHome() {
        driver.findElement(homelink).click();
        return loginPage;
}
public WebElement fromCityDropDwon(){
       return driver.findElement(fromCity);
}
    public WebElement toCityDropDwon(){
        return driver.findElement(toCity);
    }
public FlightsPage clickFindFlights() throws Throwable{
    driver.findElement(findButton).click();
    return flightsPage;

}




}
