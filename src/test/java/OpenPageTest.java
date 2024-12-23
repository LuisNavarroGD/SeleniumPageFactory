import Login.LoginSteps;
import OpenPage.OpenPageSteps;
import Selenium.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class OpenPageTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverFactory.initialize();
        driver = WebDriverFactory.get();
        driver.manage().window().maximize();
    }

    @Test
    public void testFunctionality() {
        new OpenPageSteps()
                .openHomePage()
                .acceptCookies()
                .AccountIcon()
                .searchProduct("Jackets");

    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
