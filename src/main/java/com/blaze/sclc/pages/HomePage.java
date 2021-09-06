package com.blaze.sclc.pages;

import com.blaze.sclc.common.Configuration;
import com.blaze.sclc.common.WebDriverUtilities;
import com.blaze.sclc.enums.Environments;
import org.openqa.selenium.WebDriver;

public class HomePage {
public static WebDriver driver;
public HomePage(WebDriver driver){
    this.driver=driver;
}


    public HomePage LaunchSite(){
    String webURL= Environments.valueOf(Configuration.EXECUTION_ENVIRONMENT).getWebUrl();
        System.out.println(webURL);
        WebDriverUtilities.driver().get(webURL);
        return this;
    }


}
