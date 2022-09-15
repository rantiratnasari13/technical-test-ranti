package com.ui.automation.website.pages;

import com.ui.automation.website.data.SelectMenuData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.ui.automation.website.locator.BooksLocator.*;
import static com.ui.automation.website.locator.SelectMenuLocator.*;

public class FunctionPage {

    WebDriver driver;

    SelectMenuData selectMenuData = new SelectMenuData();

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)","");
    }

    public void openWebsite(String websiteURL){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(websiteURL);
    }

    public String isUserOnTheRightPage(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LABEL_MAIN_HEADER));
        return driver.findElement(LABEL_MAIN_HEADER).getText().trim();
    }

    public void chooseGroupName(String groupName){
        driver.findElement(DROPDOWN_GROUP).click();
        By chooseGroupName = By.xpath(String.format(SELECT_VALUE, groupName));
        driver.findElement(chooseGroupName).click();
    }

    public void chooseTitle(String title){
        scrollDown();
        driver.findElement(DROPDOWN_TITLE).click();
        By chooseTitle = By.xpath(String.format(SELECT_VALUE, title));
        driver.findElement(chooseTitle).click();
    }

    public void chooseStyle(String style){
        WebElement element = driver.findElement(DROPDOWN_STYLE);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        element.click();
        By chooseStyle = By.xpath(String.format(SELECT_STYLE, style));
        driver.findElement(chooseStyle).click();
    }

    public void chooseColor(String color){
        WebElement element = driver.findElement(DROPDOWN_COLOR);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        element.click();
        if (color.equals("all color")){
            By chooseGreen = By.xpath(String.format(SELECT_VALUE, "Green"));
            driver.findElement(chooseGreen).click();
            By chooseBlue = By.xpath(String.format(SELECT_VALUE, "Blue"));
            driver.findElement(chooseBlue).click();
            By chooseBlack = By.xpath(String.format(SELECT_VALUE, "Black"));
            driver.findElement(chooseBlack).click();
            By chooseRed = By.xpath(String.format(SELECT_VALUE, "Red"));
            driver.findElement(chooseRed).click();
        }else {
            By chooseColor = By.xpath(String.format(SELECT_VALUE, color));
            driver.findElement(chooseColor).click();
        }

    }

    public String getGroupValue(){
        return driver.findElements(DROPDOWN_VALUE).get(0).getText();
    }

    public String getTitleValue(){
        return driver.findElements(DROPDOWN_VALUE).get(1).getText();
    }

    public String getStyle(){
        return driver.findElement(DROPDOWN_STYLE).getAttribute("value");
    }

    public String getColor(){
        String colorValue = selectMenuData.getColor();
        String color = driver.findElements(DROPDOWN_VALUE).get(2).getText();
        if (color.contains("Green") && color.contains("Blue") && color.contains("Black") && color.contains("Red")){
            colorValue = "all color";
        }
        return colorValue;
    }

    public void closeBrowser(){
        driver.close();
    }

    public void searchBook(String bookName){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_BAR));
        WebElement element = driver.findElement(SEARCH_BAR);
        element.click();
        element.sendKeys(bookName);
    }

    public String booksNoFound(){
        return driver.findElement(LABEL_NO_ROWS_FOUND).getText();
    }

    public void clickBook(String bookNames){
        By book = By.xpath(String.format(LABEL_BOOK_TITTLE, bookNames));
        driver.findElement(book).click();
    }

    public String getTitle(){
        String title = "";
        try {
            title = driver.findElements(ROW_BOOK).get(0).findElement(BOOK_TITLE).getText();
        }catch (Exception e){
            System.out.println(e);
        }
        return title;
    }

    public String getAuthor(){
        String author = "";
        try {
            author = driver.findElements(ROW_BOOK).get(0).findElement(BOOK_AUTHOR).getText();
        }catch (Exception e){
            System.out.println(e);
        }
        return author;
    }

    public String getPublisher(){
        String publisher = "";
        try {
            publisher = driver.findElements(ROW_BOOK).get(0).findElement(BOOK_PUBLISHER).getText();
        }catch (Exception e){
            System.out.println(e);
        }
        return publisher;
    }

    public String getTitleDetail(){
        return driver.findElement(DETAIL_BOOK_TITLE).getText();
    }

    public String getAuthorDetail(){
        return driver.findElement(DETAIL_BOOK_AUTHOR).getText();
    }

    public String getPublisherDetail(){
        return driver.findElement(DETAIL_BOOK_PUBLISHER).getText();
    }


}
