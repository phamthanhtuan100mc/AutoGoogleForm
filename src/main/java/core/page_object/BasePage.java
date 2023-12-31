package core.page_object;

import core.util.common.Constant;
import core.wrapper.driver.DriverWrapper;
import core.wrapper.element.ElementWrapper;

public abstract class BasePage {

    protected String _form = "//form[@method='POST']";
    protected String _btnSubmit = "//div[@role='button'][span/descendant::span[contains(text(), 'Gửi')]]";
    protected String _formList = "//div[@class='o3Dpx'][@role='list']";

    protected ElementWrapper getBtnSubmit(String text) {
        return new ElementWrapper(this._btnSubmit, text);
    }

    public void openPage() {
        final String url = Constant.TEST_URL;
        DriverWrapper.get(url);
        DriverWrapper.waitForPageLoad();
    }

}
