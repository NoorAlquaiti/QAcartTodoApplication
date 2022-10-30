package com.todo.qacart.testcases;


import com.todo.qacart.api.RegisterApi;
import com.todo.qacart.api.TasksApi;
import com.todo.qacart.base.Base;
import com.todo.qacart.pages.LoginPage;
import com.todo.qacart.pages.NewToDoPage;
import com.todo.qacart.pages.ToDoPage;
import com.todo.qacart.utils.ConfigUtils;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
@Feature("Todo Feature")
public class ToDoTest extends Base {
 @Story("Add Todo")
 @Test(description = "Should be able to add todo correctly")
    public void ShouldAddNewToDo(){
        RegisterApi registerApi=new RegisterApi();
        registerApi.register();
        NewToDoPage newToDoPage=new NewToDoPage(getDriver());
        newToDoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
       String actualResult= newToDoPage
               .load()
               .addNewTask("Learn Selenium")
               .getTodoText();
        Assert.assertEquals(actualResult,"Learn Selenium");
        }
    @Story("Delete Todo")
    @Test(description = "Should be able to delete todo correctly")
    public void ShouldItemBeDelete(){
        RegisterApi registerApi=new RegisterApi();
        registerApi.register();
        TasksApi tasksApi=new TasksApi();
        tasksApi.addTask(registerApi.accessToken());

    ToDoPage toDoPage=new ToDoPage(getDriver());
        toDoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
        boolean toDoNotDisplayed= toDoPage
                                     .load()
                                     .clickOnDeleteButton()
                                     .isNoTodosMessageDisplayed();

        Assert.assertTrue(toDoNotDisplayed);
    }

    }





