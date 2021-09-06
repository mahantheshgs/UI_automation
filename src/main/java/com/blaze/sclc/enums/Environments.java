package com.blaze.sclc.enums;

import com.sun.corba.se.spi.ior.EncapsulationFactoryBase;

public enum Environments {

    TEST("STAGE1", "https://blazedemo.com/");

    private String key;
    private String webUrl;

    Environments(String key, String webUrl) {
        this.key = key;
        this.webUrl = webUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public static String getWebUrl(String key) {
        for (Environments value : values()) {
            if (value.getKey().equals(key)) {
                return value.getWebUrl(key);
            }
        }
        throw new IllegalArgumentException("Incorrect value: " + key);
    }

    public static String getkey(String key) {
        for (Environments value : values()) {
            if (value.getKey().equals(key)) {
                return value.getKey();
            }
        }

        throw new IllegalArgumentException("Incorrect value: " + key);
    }
}
