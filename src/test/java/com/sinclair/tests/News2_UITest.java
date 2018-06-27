package com.sinclair.tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class News2_UITest
{
    private static WebDriver driver;
    private final String testNewsKomo = "http://komonews.com/";


    @Before
    public void createInstance()
    {
        System.setProperty("webdriver.chrome.driver","./src/main/resources/drivers/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.get(testNewsKomo);
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
        assertThat("Home page title",driver.getTitle(),is("Seattle News, Weather, Sports, Breaking News | KOMO"));

        WebElement homeLocalNewsTitle = driver.findElement(By.cssSelector(".teaser-header"));
        assertThat("LOCAL NEWS title",homeLocalNewsTitle.getText(),is("LOCAL NEWS"));

    }

    @Test
    public void teaserSectionsTest()
    {
        // catch all web elements into list.
        List<WebElement> elements = driver.findElements(By.cssSelector("h3[class='teaser-list-title']"));

        // loop through and get text
        List<String> teaserText = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            teaserText.add(elements.get(i).getText());
        }

        assertTrue("Error with section title.",teaserText.contains("LOCAL NEWS"));
        assertTrue("Error with section title.",teaserText.contains("NATION & WORLD"));
        assertTrue("Error with section title.",teaserText.contains("SPORTS"));
        assertTrue("Error with section title.",teaserText.contains("ENTERTAINMENT"));
        assertTrue("Error with section title.",teaserText.contains("TRENDING"));
        assertTrue("Error with section title.",teaserText.contains("OFFBEAT"));
        assertTrue("Error with section title.",teaserText.contains("SPONSORED CONTENT"));
        assertTrue("Error with section title.",teaserText.contains("SEATTLE REFINED MORE"));
        assertTrue("Error with section title.",teaserText.contains("CONSUMER"));
        assertTrue("Error with section title.",teaserText.contains("BIZ/HEALTH/TECH"));
        assertTrue("Error with section title.",teaserText.contains("SCOTT'S WEATHER BLOG"));
        assertTrue("Error with section title.",teaserText.contains("DON'T MISS MORE"));

        // TODO: Fix the NullPointerException when uing method from News2 class for the same above test.
//        News2 myNews = new News2();
//        assertTrue("Error with teaser title.", myNews.getPageTeaserTitles().contains("LOCAL NEWS"))
    }

    @Test
    public void menuWeatherTest()
    {
        WebElement weather = (new WebDriverWait(driver,3).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id^='Weather']"))));
        weather.click();
        assertThat("Weather page title",driver.getTitle(),containsString("Seattle Weather"));
    }

    @Test
    public void menuTrafficTest()
    {

        WebElement sport = (new WebDriverWait(driver,3).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id^='Traffic']"))));
        sport.click();

        assertThat("Traffic page title",driver.getTitle(),containsString("Seattle Traffic"));
    }

    @Test
    public void menuSportTest()
    {
        WebElement sport = (new WebDriverWait(driver,3).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id^='Sports']"))));
        sport.click();
        assertThat("Sports page title",driver.getTitle(),containsString("Seattle Sports"));
    }

    @Test
    public void menuHealthWorksTest()
    {
        WebElement sport = (new WebDriverWait(driver,3).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-name='Healthworks']"))));
        sport.click();
        assertThat("Health Works page title",driver.getTitle(),containsString("Seattle HealthWorks"));
    }

    @Test
    public void menuTVTest()
    {
        WebElement sport = (new WebDriverWait(driver,3).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id^='TV']"))));
        sport.click();
        assertThat("Health Works page title",driver.getTitle(),containsString("Seattle About"));
    }

    // This clicks Radio menu and verifies the title
    @Test
    public void menuRadio1Test(){
        WebElement sport = (new WebDriverWait(driver,3).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div a[id^='Radio-']"))));
        sport.click();
        assertThat("Radio page title",driver.getTitle(),containsString("Seattle About KOMO"));
    }

    // Radio2 using the Actions class to do a hover over the Radio menu and then do a click on the submenu "KOMO RADIO EVENTS"
    // BUT - it's not working. For some reason the hover is not working which is needed to expose the sub menu
    @Test
    public void menuRadio2Test()
    {
        // Hover and click
        WebElement elementToHover = (new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div a[id^='Radio-']"))));
        WebElement elementToClick = driver.findElement(By.cssSelector("[data-name='KOMO Radio Events'][class='sd-link']"));

        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).click(elementToClick).build().perform();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(driver.getTitle(), containsString("Radio Events"));
    }

    // Third way that works!
    @Test
    public void menuRadio3Test() {


        //Adding wait class
        WebDriverWait wait = new WebDriverWait(driver, 5);


        //Using XPath which seems to work better & added wait for reliability
        WebElement hoverRadio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'Radio-c78461f9-6da7-4c11-ae01-e6eab1526633\']")));



        Actions action = new Actions(driver);
        action.moveToElement(hoverRadio).build().perform();

        //We cant define and find the radioEvents webElement for the sub menu until we've
        //successfully opened the subnav
        //Using XPath which seems to work better & added wait for reliability
        WebElement radioEvents = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'sd-subnavs\']/div[6]/ul/li[2]/a")));

        radioEvents.click();

        assertThat(driver.getTitle(), containsString("Radio Events"));

    }


}
