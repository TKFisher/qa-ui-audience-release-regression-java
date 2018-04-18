import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest extends TestCase{


        public void test1()
        {


            System.setProperty("webdriver.chrome.driver", "/Users/tfisher/webdrivers/chrome/chromedriver");

            WebDriver driver = new ChromeDriver();
            driver.get("http://komonews.com/");

            WebElement watch = driver.findElement(By.id("nav-watch-live"));
            watch.click();


            //driver.close();
            //driver.quit();

        }

}
