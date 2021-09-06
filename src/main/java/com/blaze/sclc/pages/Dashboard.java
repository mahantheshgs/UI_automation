package com.blaze.sclc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {

    public static WebDriver driver;

    By dashBoardText= By.xpath("//div[contains(text(),'Dashboard')]");
    By regConfirmation=By.xpath("//div[contains(text(),'You are logged in!')]");

    public Dashboard(WebDriver driver) {
        this.driver=driver;
    }
    public String getConfirmationMessage(){
        String message=driver.findElement(regConfirmation).getText();
        return message;
    }



}
