package OpenPage;

import Selenium.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.util.List;

import java.time.Duration;

public class OpenPageSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public OpenPageSteps() {
        this.driver = WebDriverFactory.get();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public OpenPageSteps openHomePage() {
        driver.get("https://www.ae.com/us/en");
        return this;
    }

    public OpenPageSteps acceptCookies() {
        System.out.println("Esperando el botón de cookies...");
        WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
        acceptCookiesButton.click();
        System.out.println("Cookies aceptadas.");
        return this;
    }

    public OpenPageSteps AccountIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        System.out.println("Navegando a la creación de cuenta...");
        WebElement usernameLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@class='clickable qa-show-sidetray-account sidetray-account']")));
        try {
            WebElement closemodal = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(@id, 'close-inside')]")));
            closemodal.click();

        } catch (Exception e) {
            System.out.println("No se encontró el botón de cierre de modal.");
        }
        usernameLink.click();
        return this;
    }

    public OpenPageSteps searchProduct (String searchTerm) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.navigate().refresh();

        // Esperar a que el botón de búsqueda esté listo y hacer clic
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='search-cta']")));
        searchButton.click();

        // Esperar a que el campo de búsqueda sea visible y clickeable
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[contains(@class, 'form-control')]")));
        searchInput.sendKeys(searchTerm);
        searchInput.submit();

        // Esperar a que los productos sean cargados
        List<WebElement> products =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@data-test='product-image']")));
        if (products.size() > 0) {
            System.out.println("Se encontraron " + products.size() + " productos.");
        } else {
            System.out.println("No se encontraron productos.");
        }

        // Obtener los nombres y precios de los productos
        List<WebElement> productNames =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h3[contains(@class,'product-name')]")));
        List<WebElement> productPrices =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'product-list-price')]")));

        double totalPrice = 0.0; // Variable para almacenar la suma total de precios

        if (productNames.size() > 0 && productPrices.size() > 0) {
            System.out.println("Se encontraron " + productNames.size() + "productos: ");

            // Asegurarse de iterar hasta el menor tamaño de las listas
            int productCount = Math.min(productNames.size(), productPrices.size());
            for (int i = 0; i < productCount; i++) {
                String name = productNames.get(i).getText();
                String priceText = productPrices.get(i).getText();

                // Eliminar caracteres no numéricos como "$", "," o "USD" del texto del precio
                String priceCleaned = priceText.replaceAll("[^\\d.]", ""); // Mantener solo dígitos y punto
                double price = 0.0;
                try {
                    price = Double.parseDouble(priceCleaned);
                } catch (NumberFormatException e) {
                    System.out.println("No se pudo convertir el precio: " + priceText);
                }

                // Sumar al total
                totalPrice += price;

                System.out.println(name + " - " + priceText);
            }

            System.out.println("\nResumen:");
            System.out.println("Total de productos encontrados: " + productCount);
            System.out.println("Suma total de precios: $" + String.format("%.2f", totalPrice));
        } else {
            System.out.println("No se encontraron nombres o precios de productos.");
        }

        return this;
    }
}
