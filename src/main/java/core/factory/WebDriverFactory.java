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
        driver.set(new ChromeDriver());
    }
}
