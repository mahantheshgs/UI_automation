package com.blaze.sclc.pages;

import com.blaze.sclc.common.WebDriverUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public static WebDriver driver;
    By linkBack2WelcomePage= By.xpath("//a[contains(text(),'BlazeDemo')]");
    By loginLink=By.xpath("//a[contains(text(),'Login')]");
    By loginSumbitButton=By.xpath("//button[contains(text(),'Login')]");
    By email=By.xpath("//input[@id='email']");
    By password=By.xpath("//input[@id='password']");
    By rememberMe=By.xpath("//input[@type='checkbox' and @name='remember']");
    By forgotPW=By.xpath("//a[contains(text(),'Forgot Your Password?')]");
    By RegisterLink=By.xpath("//li/a[contains(text(),'Register')]");
    By validationMessage=By.xpath("//strong[contains(text(),'These credentials do not match our records.')]");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    Registration registration=new Registration(WebDriverUtilities.driver());
    WelcomePage welcome=new WelcomePage((WebDriverUtilities.driver()));

    public Registration clickRegister() {
        driver.findElement(RegisterLink).click();
        return registration;
    }

    public WelcomePage clicklinkBack2WelcomePage(){
        driver.findElement(linkBack2WelcomePage).click();
        return welcome;

    }


}
