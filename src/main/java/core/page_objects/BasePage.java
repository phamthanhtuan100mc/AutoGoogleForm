package core.page_objects;

import core.utils.Constant;
import core.wrappers.DriverWrapper;
import core.wrappers.ElementWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected String _form = "//form[@method='POST']";
    protected String _btnSubmit = "//div[@role='button'][span/descendant::span[contains(text(), 'Gửi')]]";
    protected String _listItem = "//div[@class='o3Dpx'][@role='list']/div[@role='listitem']";

    protected ElementWrapper getBtnSubmit(String text) {
        return new ElementWrapper(this._btnSubmit, text);
    }

    public void openPage() {
        final String url = Constant.TEST_URL;
        DriverWrapper.switchToNewTab();
        DriverWrapper.get(url);
    }

}
