package com.ui.automation.website.locator;

import org.openqa.selenium.By;

public interface BooksLocator {

    By SEARCH_BAR = By.xpath("//input[contains(@class, 'form-control')]");
    By LABEL_NO_ROWS_FOUND = By.xpath("//div[contains(@class, 'rt-noData')]");
    String LABEL_BOOK_TITTLE = "//a[contains(text(),'%s')]";
    By ROW_BOOK = By.xpath("//div[contains(@class, 'rt-tr-group')]");
    By BOOK_TITLE = By.xpath("//div[2][contains(@class, 'rt-td')]/div/span/a");
    By BOOK_AUTHOR = By.xpath("//div[3][contains(@class, 'rt-td')]");
    By BOOK_PUBLISHER = By.xpath("//div[4][contains(@class, 'rt-td')]");
    By DETAIL_BOOK_TITLE = By.xpath("//div[@id='title-wrapper']/div[2]/label");
    By DETAIL_BOOK_AUTHOR = By.xpath("//div[@id='author-wrapper']/div[2]/label");
    By DETAIL_BOOK_PUBLISHER = By.xpath("//div[@id='publisher-wrapper']/div[2]/label");
}
