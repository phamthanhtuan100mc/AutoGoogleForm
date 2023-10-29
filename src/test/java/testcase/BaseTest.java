package testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import core.util.enums.ItemType;
import core.util.helper.DataHandler;
import core.util.helper.StringHandler;
import core.wrapper.driver.DriverWrapper;
import core.wrapper.driver.DriverProperty;
import org.testng.annotations.Parameters;


public abstract class BaseTest {
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    DriverProperty property;
//    String runConfig = "windows.chrome.local";
    String filePath = StringHandler.createFilePathByOS(ItemType.FILE, "src", "main", "resources", "data/browser.setting.json");

    @BeforeMethod
    @Parameters("runConfig")
    public void setupTest(String runConfig) {
        logger.info("Load run config: " + runConfig);
        property = DataHandler.loadBrowserSetting(filePath, runConfig);

        logger.info("Setup Webdriver");
        DriverWrapper.setDriver(property);
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Quit Webdriver");
        DriverWrapper.closeBrowser();
    }
}
