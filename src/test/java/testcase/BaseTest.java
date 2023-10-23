package testcase;

import core.util.enums.ItemType;
import core.util.enums.OSType;
import core.util.helper.Helper;
import core.util.helper.DataHandler;
import core.util.helper.StringHandler;
import core.wrapper.driver.DriverWrapper;
import core.wrapper.driver.DriverProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    DriverProperty property;
    String runConfig = "windows.chrome.local";
    String filePath = StringHandler.createFilePathByOS(ItemType.FILE, "src", "main", "resources", "browser.setting.json");

    @BeforeMethod
    public void setupTest() {

        logger.info("Exit all running chromedriver before test");
        Helper.excCommand(OSType.WINDOWS, "taskkill /f /im chromedriver.exe");

        logger.info("Read run browser config from file");
        property = DataHandler.loadBrowserSetting(filePath, runConfig);

        logger.info("Setup webdriver");
        DriverWrapper.setDriver(property);
//        DriverWrapper.setPageLoadTimeOut();
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Quit webdriver");
        DriverWrapper.closeBrowser();
    }
}
