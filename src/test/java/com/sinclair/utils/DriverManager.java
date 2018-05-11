package com.sinclair.utils;


import org.openqa.selenium.WebDriver;

public class DriverManager
{

    private WebDriver webDriver;

    public DriverManager(WebDriver webDriver){
        this.webDriver = webDriver;
    }


    public WebDriver getWebDriver()
    {
        return webDriver;
    }



}
