import Selenium.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class TestTest {

    public static void main (String[] args){
        WebDriverFactory.initialize();

        WebDriver driver = WebDriverFactory.get();

        driver.get("https://www.ae.com/us/en");

        WebDriverFactory.end();
    }
}
