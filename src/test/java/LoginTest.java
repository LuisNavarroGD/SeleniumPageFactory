import Login.LoginSteps;
import Selenium.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class LoginTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverFactory.initialize();
        driver = WebDriverFactory.get();
        driver.manage().window().maximize();
    }

    @Test
    public void testFunctionality() {
        new LoginSteps()
                .openLoginPage()
                .acceptCookies()
                .closeModal()
                .LogCredentials("xluismariox@gmail.com", "test121@");
    }

    @Test
    public void testFunctionality2() {
        new LoginSteps()
                .openLoginPage()
                .acceptCookies()
                .closeModal()
                .LogCredentials("XXXXXXXXXXXXXXXXXXXXX", "test121@");
    }

    @Test
    public void testFunctionality3() {
        new LoginSteps()
                .openLoginPage()
                .acceptCookies()
                .closeModal()
                .LogCredentials("xluismariox@gmail.com", "XXXXXXXXXXXXXXXXXXXXX");
    }

    @Test
    public void testFunctionality4() {
        new LoginSteps()
                .openLoginPage()
                .acceptCookies()
                .closeModal()
                .LogCredentials("", "test121@");
    }

    @Test
    public void testFunctionality5() {
        new LoginSteps()
                .openLoginPage()
                .acceptCookies()
                .closeModal()
                .LogCredentials("xluismariox@gmail.com", "");
    }

    @Test
    public void testFunctionality6() {
         new  LoginSteps()
                 .openLoginPage()
                .acceptCookies()
                .closeModal()
                .LogCredentials("", "");
    }


    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
