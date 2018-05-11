package com.sinclair.tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class KomoNewsUITest
{
    private static WebDriver driver;



    @BeforeClass
    public static void createDriver()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/tfisher/webdrivers/chrome/chromedriver");
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
        assertThat("Home page title", driver.getTitle(), is("Seattle News, Weather, Sports, Breaking News | KOMO"));

        WebElement homeLocalNewsTitle = driver.findElement(By.cssSelector(".teaser-header"));
        assertThat("LOCAL NEWS title", homeLocalNewsTitle.getText(), is("LOCAL NEWS" ));

        //assertTrue("message", news.getPageTeaserTitles().contains("LOCAL NEWS"));

        //assertTrue("message", myNews.getPageTeaserTitles().contains("LOCAL"));

    }




}
