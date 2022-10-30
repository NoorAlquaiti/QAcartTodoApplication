package com.todo.qacart.utils;

import io.restassured.http.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {
    public static List<org.openqa.selenium.Cookie> convertRestAssuredCookiesToSeleniumCookies(List<Cookie> restAssuredCookies){
        List<org.openqa.selenium.Cookie>seleinumCookies=new ArrayList<>();
        for(io.restassured.http.Cookie cookie:restAssuredCookies){
            org.openqa.selenium.Cookie seleniumCookie=new org.openqa.selenium.Cookie(cookie.getName(),cookie.getValue());
            seleinumCookies.add(seleniumCookie);
        }
        return seleinumCookies;

    }
}
