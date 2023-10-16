package core.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class WebDriverFactory {

    protected static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

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
//        String osName = System.getProperty("os.name");
        WebDriverManager.chromedriver().cachePath("MyChromeDriver").avoidOutputTree().setup();
//        if (osName.startsWith("Windows")) {
//            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver-win64/chromedriver.exe");
//        } else if (osName.startsWith("Mac")) {
//            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver-mac-arm64/chromedriver");
//        }
//        ChromeDriverService service = new ChromeDriverService.Builder().build();
        drivers.set(new ChromeDriver());
    }

    public static WebDriver getDriver() {
        return drivers.get();
    }

    public static void setDriver(String browser, boolean remote) {
        setWebDriver(browser, remote);
    }
}
