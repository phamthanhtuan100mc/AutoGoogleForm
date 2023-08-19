package core.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ElementWrapper {
    private String _xpath;
    private By _by;
    private WebDriver webDriver;
    private Actions action;
}
