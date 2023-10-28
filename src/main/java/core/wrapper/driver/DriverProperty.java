package core.wrapper.driver;

import java.util.*;

import core.util.enums.BrowserType;
import core.util.enums.ExecuteMode;

/**
 * Selenium Webdriver properties.
 * Load data from file then convert to property object
 */
public class DriverProperty {
    private String browser;
    private String mode;
    private boolean isRemote;
    private String remoteUrl;
    private List<String> arguments = new ArrayList<>();
    private Map<String, String> desiredCapabilities = new HashMap<>();

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean isRemote() {
        return isRemote;
    }

    public void setIsRemote(boolean remote) {
        isRemote = remote;
    }

    public void setRemoteUrl(String url) {
        this.remoteUrl = url;
    }

    public String getRemoteUrl() {
        return this.remoteUrl;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    public Map<String, String> getDesiredCapabilities() {
        return desiredCapabilities;
    }

    public void setDesiredCapabilities(Map<String, String> desiredCapabilities) {
        this.desiredCapabilities = desiredCapabilities;
    }
}
