package com.todo.qacart.pages;

import com.todo.qacart.base.BasePage;
import com.todo.qacart.utils.ConfigUtils;
import com.todo.qacart.utils.PropertiesUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="[data-testid=\"email\"]")
   private WebElement emailInput;

    @FindBy(css="[data-testid=\"password\"]")
   private WebElement passwordInput;

    @FindBy(css="[data-testid=\"submit\"]")
    private WebElement submit;

    @Step
       public LoginPage load(){
           driver.get(ConfigUtils.getInstance().getBaseUrl());
           return this;

       }



    @Step

    public ToDoPage login(String email,String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submit.click();
        return new ToDoPage(driver);

    }

}
