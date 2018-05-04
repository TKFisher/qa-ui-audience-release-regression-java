package com.sinclair.tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        assertThat("Verify page title", driver.getTitle(), is("Seattle News, Weather, Sports, Breaking News | KOMO"));

    }





}
