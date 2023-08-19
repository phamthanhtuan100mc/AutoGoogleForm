package page_objects;

import org.openqa.selenium.By;

public abstract class BasePage {

    protected String form = "//form[@method='POST']";
    protected String _btnSubmit = "//div[@role='button'][span/descendant::span[contains(text(), 'Gửi')]]";

    protected By getBtnSubmit(String text) {
        return By.xpath(String.format(this._btnSubmit, text));
    }

}
