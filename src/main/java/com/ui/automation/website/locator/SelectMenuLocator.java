package com.ui.automation.website.locator;

import org.openqa.selenium.By;

public interface SelectMenuLocator {

    By LABEL_MAIN_HEADER = By.xpath("//div[contains(@class, 'main-header')]");
    By DROPDOWN_GROUP = By.xpath("//div[contains(text(), 'Select Option')]");
    By DROPDOWN_VALUE = By.xpath("//div[contains(@class, ' css-1hwfws3')]");
    String SELECT_VALUE = "//div[contains(text(), '%s')]";
    By DROPDOWN_TITLE = By.xpath("//div[contains(text(), 'Select Title')]");
    By DROPDOWN_STYLE = By.xpath("//select[@id='oldSelectMenu']");
    String SELECT_STYLE = "//option[contains(text(), '%s')]";
    By DROPDOWN_COLOR = By.xpath("//div[contains(text(), 'Select.')]");
    By SCROLL_PAGE = By.xpath("//span[contains(text(), 'Progress Bar')]");


}
