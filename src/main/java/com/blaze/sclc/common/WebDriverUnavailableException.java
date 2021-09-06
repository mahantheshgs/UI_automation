package com.blaze.sclc.common;

public class WebDriverUnavailableException extends RuntimeException {
    WebDriverUnavailableException(BrowserTypes browserTypes, Exception e)
    {
        super("Failed to establish WebDriver for: " +browserTypes, e);
    }
}
