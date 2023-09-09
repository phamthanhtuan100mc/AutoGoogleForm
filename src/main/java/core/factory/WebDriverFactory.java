package core.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setWebDriver(String browser, boolean remote) {
        if (remote) {
            switch (browser) {
                case "chrome":
                    break;
                default:
            }
        } else {
            switch (browser) {
                case "chrome":
                    setChromeDriver();
                    break;
            }
        }
    }

    private static void setChromeDriver() {
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver-mac-arm64/chromedriver");
        driver.set(new ChromeDriver());
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(String browser, boolean remote) {
        setWebDriver(browser, remote);
    }
}
