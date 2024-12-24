package OpenPage;

import Login.LoginSteps;
import Selenium.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccount {

    private WebDriver driver;
    private WebDriverWait wait;

    public CreateAccount() {
        this.driver = WebDriverFactory.get();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public CreateAccount openPage() {
        driver.get("https://www.ae.com/us/en");
        return this;
    }

    public CreateAccount acceptCookies() {
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

    public CreateAccount closeModal() {
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

    public CreateAccount createAccount() {
        WebElement usernameLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@class='clickable qa-show-sidetray-account sidetray-account']")));
        usernameLink.click();

        WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@data-test='section-actions']//a[@data-test-btn='register-button']")));
        createAccountButton.click();

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("XXXXXXXXXXXXX");

        return this;
    }






}
