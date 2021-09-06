package com.blaze.sclc.common;

import com.google.common.io.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private static Properties prop;

    public static Properties getProp(){
        if(prop==null){
            prop =new Properties();
            InputStream input=null;

            try {
                input =new FileInputStream(new File(Resources.getResource("system.properties").toURI()));
            prop.load(input);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return prop;
    }
    public static final BrowserTypes BROWSER = BrowserTypes.valueOf(getProp().getProperty("selenium.browser"));
    public static final String CHROME_WEBDRIVER=getProp().getProperty("webdriver.chrome.driver");
    public static final String EXECUTION_ENVIRONMENT =getProp().getProperty("execution.environment");
    public static final String USERNAME=getProp().getProperty("ui.username");
    public static final String PASSWORD=getProp().getProperty("ui.password");

}
