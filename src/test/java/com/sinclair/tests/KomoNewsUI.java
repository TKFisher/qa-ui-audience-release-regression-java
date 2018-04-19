package com.sinclair.tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class KomoNewsUI
{
    private static WebDriver driver;

        @BeforeClass
        public static void createDriver(){
            System.setProperty("webdriver.chrome.driver", "/Users/tfisher/webdrivers/chrome/chromedriver");
            driver = new ChromeDriver();
        }

        @Before
        public  void createInstance(){
            driver.get("http://komonews.com/");
        }

        @AfterClass
        public static void quitDriver(){
            driver.close();
            driver.quit();
        }

        @Test
        public void home(){

        }

        @Test
        public void scratch_1()
        {
            WebElement watch = driver.findElement(By.id("nav-watch-live"));
            assertTrue("Watch menu label not correct", watch.getText().contains("WATCHx"));
            watch.click();
            // if Live Watch assert:
                // title = KOMO LIVE Broadcast
                // LiveThumbnailBadge displays "Live" label
            // if Watch assert
                //
        }


}
