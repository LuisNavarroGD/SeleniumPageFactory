import Selenium.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        // Inicializa el WebDriver
        WebDriverFactory.initialize();
        driver = WebDriverFactory.get();
        driver.get("https://www.ae.com/us/en");
        driver.navigate().refresh();
    }

    @Test
    public void AcceptCookies() {
        // Espera explícita para asegurarse de que el botón de aceptar cookies esté presente y clickeable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera hasta 10 segundos
        WebElement acceptCookiesButton =
                wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));

        // Verifica si el botón está presente
        assertNotNull(acceptCookiesButton, "Accept cookies button is not present");

        // Realiza clic en el botón
        acceptCookiesButton.click();
    }


    @Test
    public void testClickOnUsername() {
        // Espera explícita para asegurarse de que el enlace esté presente y clickeable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera hasta 10 segundos
        WebElement usernameLink =
                wait.until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//a[@class='clickable qa-show-sidetray-account sidetray-account']")));

        // Verifica si el enlace está presente
        assertNotNull(usernameLink, "Username link is not present");

        // Realiza clic en el enlace
        usernameLink.click();

    }

    @AfterAll
    public static void tearDown() {
        WebDriverFactory.end(); // Cierra el navegador después de cada test
    }

}
