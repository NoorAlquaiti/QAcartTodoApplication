package com.todo.qacart.api;

import com.todo.qacart.config.EndPoint;
import com.todo.qacart.object.User;
import com.todo.qacart.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {
    private List<Cookie> restAssuredCookies;
    private String accessToken;
    private String userID;
    private String firstName;

    public List<Cookie> getCookies(){
       return this.restAssuredCookies;
    }
    public String userID(){
        return this.userID;
    }
    public String accessToken(){
        return this.accessToken;
    }
    public String firstNAme(){
        return this.firstName;
    }


    public void register(){
        User user=UserUtils.generateRandomUser();
        Response response=given()
                            .baseUri("https://qacart-todo.herokuapp.com")
                            .header("Content-Type","application/json")
                            .body(user)
                            .log().all()
                          .when()
                            .post(EndPoint.API_REGISTER_ENDPOINT)
                          .then()
                          .log().all()
                            .extract().response();

        if (response.statusCode()!=201){
            throw new RuntimeException("Something went wrong with request");
        }
        restAssuredCookies=response.getDetailedCookies().asList();
        accessToken=response.path("access_token");
        userID=response.path("userID");
        firstName=response.path("firstName");

    }
}
