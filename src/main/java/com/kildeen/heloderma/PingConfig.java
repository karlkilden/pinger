package com.kildeen.heloderma;

/**
 * @author: Kalle
 */
public class PingConfig {

    public static final String CONFIG_PATH_PROPERTY_KEY = "com.kildeen.pingconfig.path";
    private String pingUrl;

    public String getPingUrl() {
        return pingUrl;
    }

    public void setPingUrl(final String pingUrl) {
        this.pingUrl = pingUrl;
    }


}
