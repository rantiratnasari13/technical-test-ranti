package com.ui.automation.website.stepdefinitions;

import com.ui.automation.website.data.BooksData;
import com.ui.automation.website.data.SelectMenuData;
import com.ui.automation.website.pages.FunctionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class FunctionStepDefs {

    FunctionPage functionPage = new FunctionPage();
    SelectMenuData selectMenuData = new SelectMenuData();

    BooksData booksData = new BooksData();

    @Given("User go to {string}")
    public void userOpenWeb(String websiteURL){
        functionPage.openWebsite(websiteURL);

    }

    @When("User in {string} page")
    public void userIsOnTheRightPage(String pageName){
        Assert.assertEquals("User is on the wrong page", functionPage.isUserOnTheRightPage(), pageName);
    }

    @When("User choose select value {string}")
    public void userChooseGroup(String groupName){
        selectMenuData.setGroupName(groupName);
        functionPage.chooseGroupName(groupName);
    }

    @When("User choose select one {string}")
    public void userChooseTitle(String title){
        selectMenuData.setTitle(title);
        functionPage.chooseTitle(title);
    }

    @When("User choose old style select menu {string}")
    public void userChooseStyle(String style){
        selectMenuData.setStyle(style);
        functionPage.chooseStyle(style);
    }

    @When("User choose multi select drop down {string}")
    public void userChooseColor(String color){
        selectMenuData.setColor(color);
        functionPage.chooseColor(color);
    }

    @Then("User success input all select menu")
    public void userSuccessInputValue(){
        Assert.assertEquals("Value is incorrect", functionPage.getGroupValue(), selectMenuData.getGroupName());
        Assert.assertEquals("One is incorrect", functionPage.getTitleValue(), selectMenuData.getTitle());
        Assert.assertEquals("Old is incorrect", functionPage.getStyle(), "10");
        Assert.assertEquals("Color is incorrect", functionPage.getColor(), selectMenuData.getColor());
        functionPage.closeBrowser();
    }

    @When("User search book {string}")
    public void userSearchBook(String bookName){
        functionPage.searchBook(bookName);
        booksData.setTitle(functionPage.getTitle());
        booksData.setAuthor(functionPage.getAuthor());
        booksData.setPublisher(functionPage.getPublisher());

    }

    @Then("User see {string}")
    public void userSeeBooksNoFound(String labelNoFound){
        Assert.assertEquals("Labe is not the same", functionPage.booksNoFound(), labelNoFound);
        functionPage.closeBrowser();
    }

    @When("User click book {string}")
    public void userClickBook(String bookNames){
        functionPage.clickBook(bookNames);
    }

    @When("User see {string} details")
    public void userSeeBookDetails(String bookTitle){
        Assert.assertEquals("Title is incorrect", functionPage.getTitleDetail(), bookTitle);
        Assert.assertEquals("Title is not the same", functionPage.getTitleDetail(), booksData.getTitle());
        Assert.assertEquals("Author is not the same", functionPage.getAuthorDetail(), booksData.getAuthor());
        Assert.assertEquals("Publisher is not the same", functionPage.getPublisherDetail(), booksData.getPublisher());
        functionPage.closeBrowser();
    }
}
