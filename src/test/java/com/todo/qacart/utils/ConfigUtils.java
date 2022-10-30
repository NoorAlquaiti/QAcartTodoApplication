package com.todo.qacart.utils;

import java.util.Properties;

public class ConfigUtils {

    private static Properties properties;
    private  static ConfigUtils configUtils;
    private ConfigUtils(){
        String env=System.getProperty("env","PRODUCTION");
        switch (env){
            case "PRODUCTION":
                properties=PropertiesUtil.loadProperties("src/test/java/com/todo/qacart/config/production.properties");
                break;
                case "LOCAL":
                    properties=PropertiesUtil.loadProperties("src/test/java/com/todo/qacart/config/local.properties");
                    break;
            default:
                throw new RuntimeException("Environment is not supported");




        }
    }
    public static ConfigUtils getInstance(){
        if (configUtils==null){
            configUtils=new ConfigUtils();
        }
        return configUtils;
    }
    public String getBaseUrl(){
        String prop=properties.getProperty("baseUrl");
        if (properties!=null) return prop;
        throw new RuntimeException("Could not find the base url in property file ");
    }
    public String getEmail(){
        String prop=properties.getProperty("email");
        if (properties!=null) return prop;
        throw new RuntimeException("Could not find the email in property file ");
    }
    public String getPassword(){
        String prop=properties.getProperty("password");
        if (properties!=null) return prop;
        throw new RuntimeException("Could not find the password in property file ");
    }
}
