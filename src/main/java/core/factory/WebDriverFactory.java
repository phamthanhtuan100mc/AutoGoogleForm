package core.factory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

    private static void setChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }
}
