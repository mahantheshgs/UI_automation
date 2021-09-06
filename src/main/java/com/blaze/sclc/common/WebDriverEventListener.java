package com.blaze.sclc.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WebDriverEventListener extends AbstractWebDriverEventListener {
private static final Logger LOG=LoggerFactory.getLogger(WebDriverEventListener.class);


    public void beforeNavigate(String url, WebDriver driver){
    LOG.debug("Navigationg to the URL: " +url);

}

public void afterNavigateTo(String url, WebDriver driver) {
        LOG.debug("Navigated to " +url);
}
public void  beforeClickOn(WebElement element, WebDriver driver){
        LOG.debug("");
}

public  void afterClickOn(WebElement element, WebDriver driver){
LOG.debug("");
}
public void  onException(Throwable error, WebDriver driver) {
        LOG.debug("Error occured " +error);
}
}
