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
    private List<String> arguments = new ArrayList<>();
    private Map<String, String> capabilities = new HashMap<>();

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
        setMode(isRemote == true ? "Remote" : "Local");
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    public Map<String, String> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(Map<String, String> capabilities) {
        this.capabilities = capabilities;
    }
}
