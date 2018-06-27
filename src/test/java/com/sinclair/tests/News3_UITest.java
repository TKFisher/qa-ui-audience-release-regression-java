package com.sinclair.tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class News3_UITest

{
    private final String testNewsWWTE = "http://myfox28columbus.com/";
    private static WebDriver driver;


    @Before
    public void createInstance()
    {
        System.setProperty("webdriver.chrome.driver","./src/main/resources/drivers/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.get(testNewsWWTE);
    }

    @After
    public void quitDriver()
    {
        driver.close();
        driver.quit();
    }


    @Test
    public void homePageTest()
    {
        assertThat("Home page title",driver.getTitle(),containsString("Columbus News"));
    }


    @Test
    public void teaserSectionsTest()
    {
        List<WebElement> elements = driver.findElements(By.cssSelector("h2[class='tfYy3']"));

        Set<String> teaserText = new HashSet<String>();
        for (WebElement e : elements) {
            teaserText.add(e.getText());
        }

        assertTrue("Error with section.",teaserText.contains("LOCAL NEWS"));
        assertTrue("Error with section.",teaserText.contains("NATION & WORLD"));
        assertTrue("Error with section.",teaserText.contains("SPORTS"));
        assertTrue("Error with section.",teaserText.contains("THE FOOTBALL FEVER"));
        assertTrue("Error with section.",teaserText.contains("GOOD DAY COLUMBUS"));
    }

    @Test
    public void menuWeatherTest()
    {

        WebElement weather = (new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='_3EBT0 _1kRm8']"))));
        weather.click();

        assertThat("Weather page title", driver.getTitle(), containsString("Columbus Weather"));
    }

    @Test
    public void menuSportTest ()
    {

        WebElement sport = (new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class^='_3EBT0 uRXhw']"))));
        sport.click();

        assertThat("Sports page title", driver.getTitle(), containsString("Columbus Sports"));
    }

    @Test
    public void menuGoodDayTest ()
    {

        WebElement goodDay = (new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class^='_3EBT0 BLzDL']"))));
        goodDay.click();

        assertThat("Good Day page title", driver.getTitle(), containsString("Columbus Good Day Columbus"));
    }


    //TODO: This page has not been implemented yet.
    @Ignore
    @Test
    public void menuCBusTest ()
    {
        WebElement cBus = (new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class^='_3EBT0 RootLink4']"))));
        cBus.click();

        assertThat("CBUS LIFE page title", driver.getTitle(), containsString("xxxx"));
    }

    @Test
    public void menuWatchTest ()
    {
        WebElement watch = (new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class^='_3EBT0 RootLink5']"))));
        watch.click();

        assertThat("Watch page title", driver.getTitle(), containsString("Columbus Watch"));
    }


}
