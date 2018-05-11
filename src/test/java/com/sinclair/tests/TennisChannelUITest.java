package com.sinclair.tests;


import org.openqa.selenium.WebDriver;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TennisChannelUITest
{
    private static WebDriver driver;


    @BeforeClass
    public static void createDriver(){

        System.setProperty("webdriver.chrome.driver", "/Users/tfisher/webdrivers/chrome/chromedriver");
        driver = new ChromeDriver();

    }

    @Before
    public void createInstance()
    {
        driver.get("https://tennischanneleverywhere.com/");
    }

    @AfterClass
    public static void quitDriver()
    {
        driver.close();
        driver.quit();
    }

    @Test
    public void homePageTest(){

        // page title is different depending on which assert you use:
        assertEquals("Tennis Channel Everywhere", driver.getTitle());
        //or
        assertThat("Verify page title.", driver.getTitle(), is("Home | Tennis Channel Everywhere"));

    }

}
