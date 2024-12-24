package Login;

import Selenium.WebDriverFactory;
import htmlelements.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class LoginSteps implements HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor para inicializar el WebDriver y WebDriverWait
    public LoginSteps() {
        this.driver = WebDriverFactory.get();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Método para abrir la página de inicio de sesión
    public LoginSteps openLoginPage() {
        driver.get("https://www.ae.com/us/en");
        return this;
    }

    public LoginSteps acceptCookies() {
        // Aceptar cookies
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
            acceptCookiesButton.click();
            System.out.println("Cookies aceptadas.");
        } catch (Exception e) {
            System.out.println("No apareció el botón de aceptar cookies.");
        }
        return this;
    }

    public LoginSteps closeModal() {
        // Intentar cerrar modal de publicidad si aparece
        try {
            WebElement closeModal = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(@id, 'close-inside')]")));
            closeModal.click();
            System.out.println("Modal cerrado.");
        } catch (Exception e) {
            System.out.println("No apareció publicidad para cerrar.");
        }
        return this;
    }

    // Método para iniciar sesión con credenciales válidas
    public LoginSteps LogCredentials(String email, String password) {
        // Navegar al inicio de sesión
        WebElement usernameLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@class='clickable qa-show-sidetray-account sidetray-account']")));
        usernameLink.click();

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@data-test='section-actions']//button[@data-test-btn='signin']")));
        signInButton.click();

        // Llenar el formulario de inicio de sesión
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@class,'form-input-username')]")));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@class, 'form-input-password')]")));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-test-btn='submit']")));

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitButton.click();

        try {
            WebElement errorSign = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@data-test-form-error, 'error.account')]")));
            System.out.println("Error de inicio de sesión: " + errorSign.getText());
        } catch (Exception e) {
            System.out.println("Inicio de sesión exitoso.");
        }

        return this;
    }
}
