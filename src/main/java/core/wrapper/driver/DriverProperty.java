package core.wrapper.driver;

/**
 * Selenium Webdriver properties.
 * Load data from file then convert to property object
 */
public class DriverProperty {
    private String browser = "chrome";
    private String mode = "Remote";
    private boolean isRemote = false;
    private boolean headless = false;

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

    public boolean isHeadless() {
        return headless;
    }

    public void setIsHeadless(boolean headless) {
        this.headless = headless;
    }
}
