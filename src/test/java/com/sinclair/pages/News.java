package com.sinclair.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class News
{
    public WebDriver driver;
    public WebDriverWait wait;

    // constructor
    public News(WebDriver driver, WebDriverWait wait)
    {
        //driver.get("http://komonews.com/");
        this.driver = driver;
        this.wait = wait;
    }




    // Returns teaser title text headers.
    public Set<String> getPageTeaserTitles(){

    List<WebElement> elements = driver.findElements(By.cssSelector("h3.teaser-list-title"));
    Set<String> titleText = new HashSet<>();
    for(WebElement e : elements){
        titleText.add(e.getText());

    }
        return titleText;
    }

}
