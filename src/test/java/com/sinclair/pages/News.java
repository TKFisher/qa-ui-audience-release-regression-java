package com.sinclair.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.sinclair.utils.DriverManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class News
{


    public WebDriver driver;


    // Returns teaser title text headers.
    public List<String> getPageTeaserTitles()
    {
        // catch all web elements into list.
        List<WebElement> elements = driver.findElements(By.cssSelector("h3[class='teaser-list-title']"));

        // loop through and get text
        List<String> teaser_elements_text = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            teaser_elements_text.add(elements.get(i).getText());
        }
        return teaser_elements_text;
    }

}
