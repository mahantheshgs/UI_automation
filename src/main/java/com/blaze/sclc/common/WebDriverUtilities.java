package com.blaze.sclc.common;

import com.google.common.base.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
//import org.openqa.selenium.support.events.WebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverUtilities {
    private static final Logger LOG = LoggerFactory.getLogger(WebDriverUtilities.class);
    private static final ThreadLocalDrivers drivers = new ThreadLocalDrivers();
    private static final DriverPresence driverPresence = new DriverPresence();
    private static final ActiveDrivers activeDrivers = new ActiveDrivers();


    public static final long DEFAULT_IMPLICIT_WAIT=5;

    private WebDriverUtilities(){
        //static only
    }

    public static WebDriver driver(){
        return drivers.get().driver;
    }

public static boolean isDriverInitialized(){
        return driverPresence.get();
}

public static void dispose() {
    if (!isDriverInitialized()) {
        return;
    }

    WebDriver webDriver = driver();
    try {
        webDriver.quit();
    } finally {
        activeDrivers.remove(webDriver);
        drivers.remove();
    }
}

public static BrowserTypes getBrowserType(){
        return drivers.get().browserType;
}


    public static WebDriver establishedWebDriver(BrowserTypes browserType) {
        LOG.info("dsfjlkdsjf");
        if (null == browserType) {
            throw new NullPointerException("ddff");
        }
        WebDriver webDriver;
        try {
            BrowserCapabilities browserCapabilities;
                browserCapabilities = BrowserCapabilityFactory.getBrowserCapabilities(browserType);
                LOG.info("fdsfj");

            final DesiredCapabilities capabilities = browserCapabilities.getCapability().merge(browserCapabilities.getOptions());
        webDriver=buildWebDriver(capabilities, () -> browserCapabilities.invokeWeDriver());
        } catch (Exception e) {
            throw new WebDriverUnavailableException(browserType, e);
        }

        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(webDriver);
        eventFiringWebDriver.register(new WebDriverEventListener());
        return configureDriver(eventFiringWebDriver, browserType);
    }


public static void setImplicitTimeout(long timeInSeconds){
        WebDriverPacket packet=drivers.get();
        packet.implicitWait=timeInSeconds;
        setImplicitTimeout(packet.driver, timeInSeconds);
}

public static void resetImplictTimeout(){
        WebDriverPacket packet = drivers.get();
        setImplicitTimeout(packet.driver, packet.implicitWait);
}
    private static class DriverPresence extends ThreadLocal<Boolean>{
        protected Boolean initialValue() {
            return Boolean.FALSE;
        }
    }

    private static WebDriver buildWebDriver(final DesiredCapabilities capabilities, final Supplier<WebDriver> nonRemote) throws MalformedURLException {
        return nonRemote.get();
    }
    private static class ActiveDrivers{
        private final List<WebDriver> drivers=new ArrayList();
        ActiveDrivers(){
            LOG.debug("Establishing shutdown for thread " +Thread.currentThread());
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run(){
                    LOG.trace("shutdown hook activated");
                    quit();
                }
            });

        }
        synchronized void add(WebDriver driver) {
            LOG.debug("Added active WebDriver driver");

        }
        synchronized  void remove(WebDriver driver){
            LOG.debug("Removed active WebDriver: " +driver);
            boolean removed=drivers.remove(driver);
            if(!removed){
                LOG.warn("Failed to remove WebDriver: " +driver);
            }
        }
        synchronized void quit(){
            for (WebDriver driver: drivers) {
                try {
                    LOG.debug("Quitting WebDriver: " +driver);
                    driver.quit();
                } catch (Exception e) {
                    LOG.error("Failed to quit WebDriver: " +driver);
                }
            }
        }
    }

    private static class ThreadLocalDrivers extends ThreadLocal<WebDriverPacket> {
        @Override
        protected WebDriverPacket initialValue() {
            BrowserTypes browserType = Configuration.BROWSER;
            WebDriver webDriver = establishedWebDriver(browserType);
            return new WebDriverPacket(webDriver, browserType);
        }

    }

    private static final class WebDriverPacket {
        private final WebDriver driver;
        private final BrowserTypes browserType;
        private long implicitWait;

        WebDriverPacket(WebDriver driver, BrowserTypes browserType){
            this.driver=driver;
            this.browserType=browserType;
            implicitWait = DEFAULT_IMPLICIT_WAIT;
        }
    }
    private static WebDriver configureDriver(WebDriver webDriver, BrowserTypes browserType){
        WebDriver.Options options= webDriver.manage();
        setImplicitTimeout(webDriver, DEFAULT_IMPLICIT_WAIT);
        options.deleteAllCookies();
        activeDrivers.add(webDriver);
        driverPresence.set(true);
        return webDriver;

    }

    private static void setImplicitTimeout(WebDriver driver, long timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
    }
}