package com.blaze.sclc.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserCapabilityFactory {

    private static final Logger LOG = LoggerFactory.getLogger(BrowserCapabilityFactory.class);

    private BrowserCapabilityFactory() {

    }

    public static BrowserCapabilities getBrowserCapabilities(final BrowserTypes browserType) {
        try {

            switch (browserType) {
                case CHROME:
                    return getBrowserCapabilities(browserType);
                default:
                    throw new RuntimeException("Browser type not supported: " + browserType);
            }
        }catch(Exception e){
                throw new RuntimeException(e);
            }
        }

    }
