package com.blaze.sclc.common;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


abstract class BrowserCapabilities {
    protected DesiredCapabilities capabilities;
    protected MutableCapabilities mutableCapabilities;

    public BrowserCapabilities(){
        setCapability();
        setOptions();
    }

    public DesiredCapabilities getCapability(){
        return capabilities;
    }

    public abstract void setCapability();

    public abstract void setOptions();

    public abstract WebDriver invokeWeDriver();

    public MutableCapabilities getOptions(){
        return mutableCapabilities;
    }
}
