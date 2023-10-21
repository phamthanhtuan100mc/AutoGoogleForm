package testcase;

import core.util.Enum.ItemType;
import core.util.Enum.OSType;
import core.util.Helper;
import core.wrapper.driver.DriverWrapper;
import core.wrapper.driver.DriverProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setupTest() {

        logger.info("Exit all running chromedriver before test");
        Helper.excCommand(OSType.WINDOWS, "taskkill /f /im chromedriver.exe");

        String filePath = Helper.createFilePathByOS(ItemType.FILE, "src", "main", "resources", "browser.setting.json");
        String runConfig = "windows.chrome.local.headless";
        DriverProperty property = Helper.loadBrowserSetting(filePath, runConfig);

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
