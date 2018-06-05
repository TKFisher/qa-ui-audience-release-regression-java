package com.sinclair.tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class KomoNewsUITest
{
    private static WebDriver driver;


    @BeforeClass
    public static void createDriver()
    {
        System.setProperty("webdriver.chrome.driver","/Users/tfisher/webdrivers/chrome/chromedriver");
        driver = new ChromeDriver();

    }

    @Before
    public void createInstance()
    {
        driver.get("http://komonews.com/");
    }

    @AfterClass
    public static void quitDriver()
    {
        driver.close();
        driver.quit();
    }

    @Test
    public void homePageTest()
    {
        assertThat("Home page title",driver.getTitle(),is("Seattle News, Weather, Sports, Breaking News | KOMO"));

        WebElement homeLocalNewsTitle = driver.findElement(By.cssSelector(".teaser-header"));
        assertThat("LOCAL NEWS title",homeLocalNewsTitle.getText(),is("LOCAL NEWS"));


        // catch all web elements into list.
        List<WebElement> elements = driver.findElements(By.cssSelector("h3[class='teaser-list-title']"));

        // loop through and get text
        List<String> teaser_elements_text = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            teaser_elements_text.add(elements.get(i).getText());
        }

        // TODO: change to an assertThat:
        assertTrue("Error with teaser title.",teaser_elements_text.contains("LOCAL NEWS"));
        assertTrue("Error with teaser title.",teaser_elements_text.contains("NATION & WORLD"));
        assertTrue("Error with teaser title.",teaser_elements_text.contains("SPORTS"));
        assertTrue("Error with teaser title.",teaser_elements_text.contains("ENTERTAINMENT"));
        assertTrue("Error with teaser title.",teaser_elements_text.contains("TRENDING"));
        assertTrue("Error with teaser title.",teaser_elements_text.contains("OFFBEAT"));
        assertTrue("Error with teaser title.",teaser_elements_text.contains("SPONSORED CONTENT"));
        assertTrue("Error with teaser title.",teaser_elements_text.contains("SEATTLE REFINED MORE"));
        assertTrue("Error with teaser title.",teaser_elements_text.contains("CONSUMER"));
        assertTrue("Error with teaser title.",teaser_elements_text.contains("BIZ/HEALTH/TECH"));
        assertTrue("Error with teaser title.",teaser_elements_text.contains("SCOTT'S WEATHER BLOG"));
        assertTrue("Error with teaser title.",teaser_elements_text.contains("DON'T MISS MORE"));

        // TODO: Fix the NullPointerException when uing method from News class for the same above test.
//        News myNews = new News();
//        assertTrue("Error with teaser title.", myNews.getPageTeaserTitles().contains("LOCAL NEWS"));

    }
}
