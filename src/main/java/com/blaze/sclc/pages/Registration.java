package com.blaze.sclc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Registration {
   public static WebDriver driver;
    By name= By.xpath("//input[@id='name' and @name='name']");
    By company=By.xpath(("//input[@id='company']"));
    By email=By.xpath("//input[@id='email']");
    By password=By.xpath("//input[@id='password' @name='password']");
    By confirmPassword=By.xpath("//input[@id='password-confirm']");
    By RegisterButton=By.xpath("//button[contains(text(),'Register')]");
    By formfields=By.xpath("//*[@class='form-control']");
    By unknownPage=By.xpath("//div[contains(text(),'Page Expired')]");


    public Registration(WebDriver driver){
        this.driver=driver;
    }
    public List<WebElement> fillFormData(){
      List<WebElement> fieldValues=driver.findElements(formfields);
       return fieldValues;
    }
    public void clickRegisterButton(){
     driver.findElement(RegisterButton).click();
    }

 public WebElement getUnknownPage(){
 WebElement element= driver.findElement(unknownPage);
  return element;
 }
}
