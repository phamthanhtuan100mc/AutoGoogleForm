package core.wrapper;

import core.factory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverWrapper extends WebDriverFactory {
    private static final Logger log = LogManager.getLogger(DriverWrapper.class);
    private static DriverWrapper instance = null;
    private static final long pageTimeout = 30;

    private DriverWrapper() {}

    public static DriverWrapper getInstance() {
        if(instance == null) {
            instance = new DriverWrapper();
        }
        return instance;
    }

    public static void closeBrowser() {
        try {
            driver.get().quit();
            driver.remove();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public static void switchToNewTab() {
        try {
            driver.get().switchTo().newWindow(WindowType.TAB);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public static void get(String url) {
        try {
            driver.get().get(url);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

//    public static void setPageLoadTimeOut(long timeOut) {
//        try {
//            driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
//        } catch (Exception e) {
//              log.error(e.getMessage());
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void setPageLoadTimeOut() {
//        setPageLoadTimeOut(pageTimeout);
//    }

    public static void waitForPageLoad() {
        try {
            WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
            wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver).executeScript("return document.readyState")));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public static void maximize() {

    }


}
