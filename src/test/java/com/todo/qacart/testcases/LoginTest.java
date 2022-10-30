package com.todo.qacart.testcases;

import com.todo.qacart.base.Base;
import com.todo.qacart.factory.DriverFactory;
import com.todo.qacart.pages.LoginPage;
import com.todo.qacart.pages.ToDoPage;
import com.todo.qacart.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Feature("Auth Feature")
public class LoginTest extends Base {
    @Story("Login with email & password")
    @Description("It will login by filling the email & the password and naviqate to the todo page")
    @Test(description = "Test the login functionality using email & password")
    public void  ShouldBeAbleToLoginWithEmailAndPassword(){
        LoginPage loginPage=new LoginPage(getDriver());
        boolean isDisplayed= loginPage
                                 .load()
                                 .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                                 .isWelcomeMessageDisplayed();
        Assert.assertTrue(isDisplayed);







    }

}
