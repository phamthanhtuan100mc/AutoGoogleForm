package core.wrapper.driver;

import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

import core.util.enums.BrowserType;
import core.util.enums.ExecuteMode;

/**
 * Selenium Webdriver properties.
 * Load data from file then convert to property object
 */
public class DriverProperty {
    private String browser = BrowserType.CHROME.toString();
    private String mode = ExecuteMode.LOCAL.toString();
    private boolean isRemote = false;
    private List<String> arguments = Arrays.asList("--headless=new");
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
}
