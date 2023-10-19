package core.wrapper.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import java.lang.reflect.Method;

public class DriverFactory {

    private static final Logger log = LogManager.getLogger(DriverFactory.class);
    protected static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static void createWebDriver(String browser, boolean remote) {
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
        String osName = System.getProperty("os.name");
        WebDriverManager.chromedriver().setup();

        WebDriverManager.chromedriver().clearResolutionCache().setup();
        if (osName.startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver-win64/chromedriver.exe");
        } else if (osName.startsWith("Mac")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver-mac-arm64/chromedriver");
        }
        ChromeDriverService service = new ChromeDriverService.Builder().build();
        drivers.set(new ChromeDriver());
    }

    public static WebDriver getDriver() {
        return drivers.get();
    }

    public static void setDriver(DriverProperty property) {
        // Example of className:
        // core.browser.chrome.LocalChromeDriver
        String className = String.format("core.browser.%s.%s%sDriver",
                property.getBrowser(),
                property.getMode(), StringUtils.capitalize(property.getBrowser()));

        // Using Java reflection technique
        try {
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getMethod("createWebDriver", DriverProperty.class);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            WebDriver driver = (WebDriver) method.invoke(instance, property);
            drivers.set(driver);
            System.out.println("Test thread: ");
            drivers.get();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
}
