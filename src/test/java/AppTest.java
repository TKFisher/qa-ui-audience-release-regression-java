import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest extends TestCase{


        public void test1()
        {

            System.setProperty("webdriver.chrome.driver", "/Users/tfisher/webdrivers/chrome/chromedriver");

            WebDriver driver = new ChromeDriver();
            driver.get("http://www.google.com");
            driver.close();
            driver.quit();
        }

}
