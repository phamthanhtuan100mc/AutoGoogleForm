package core.util.common;

import org.openqa.selenium.WebDriver;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String TEST_URL = "https://forms.gle/UYB2pC4f8YdRRkhL7";
    public static final int WAIT_TIMEOUT = 30;
    public static final String COMMAND_END_RUNNING_CHROMEDRIVER = "taskkill /f /im chromedriver.exe";
}
