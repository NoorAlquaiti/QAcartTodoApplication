package com.todo.qacart.pages;

import com.todo.qacart.base.BasePage;
import com.todo.qacart.config.EndPoint;
import com.todo.qacart.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewToDoPage extends BasePage {

    public NewToDoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="[data-testid=\"new-todo\"]")
    private WebElement newTodoInput;
    @FindBy(css="[data-testid=\"submit-newTask\"]")
    private WebElement newTodoSubmit;
    @Step

    public NewToDoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.NEW_TODO_ENDPOINT);
        return this;
    }
    @Step

    public ToDoPage addNewTask(String item){
        newTodoInput.sendKeys(item);
        newTodoSubmit.click();
        return new ToDoPage(driver);
    }
}
