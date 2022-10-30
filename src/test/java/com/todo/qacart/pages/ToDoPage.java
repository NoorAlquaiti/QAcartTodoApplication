package com.todo.qacart.pages;

import com.todo.qacart.base.BasePage;
import com.todo.qacart.config.EndPoint;
import com.todo.qacart.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToDoPage extends BasePage {
    public ToDoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="[data-testid=\"welcome\"]")
    private WebElement welcomeMessage;
    @FindBy(css="[data-testid=\"add\"]")
    private WebElement addButton;
    @FindBy(css="[data-testid=\"delete\"]")
    private WebElement deleteButton;
    @FindBy(css="[data-testid=\"no-todos\"]")
    private WebElement noTodosMessage;
    @FindBy(css="[data-testid=\"todo-text\"]")
    private WebElement getTodoMessage;
    @Step
    public ToDoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.TODO_PAGE_ENDPOINT);
        return this;
    }
    @Step

    public boolean isWelcomeMessageDisplayed(){

        return welcomeMessage.isDisplayed();
    }
    @Step

    public NewToDoPage clickOnPlusButton(){
        addButton.click();
       return new NewToDoPage(driver);
    }
    @Step

    public String getTodoText(){
       return getTodoMessage.getText();
    }
    public ToDoPage clickOnDeleteButton(){
        deleteButton.click();
        return this;

    }
    @Step

    public boolean isNoTodosMessageDisplayed(){
       return noTodosMessage.isDisplayed();

    }

}
