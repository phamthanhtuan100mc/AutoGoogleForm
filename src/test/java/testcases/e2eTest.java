package testcases;

import core.page_objects.HomePage;
import org.testng.annotations.Test;

public class e2eTest extends BaseTest {

    HomePage homePage;

    @Test()
    public void TC_E2E() {
        homePage = new HomePage();

        homePage.openPage();
    }
}
