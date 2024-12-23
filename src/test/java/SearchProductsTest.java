import Selenium.WebDriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

public class  SearchProductsTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        // Inicializa el WebDriver
        WebDriverFactory.initialize();
        driver = WebDriverFactory.get();
        driver.manage().window().maximize();
        driver.get("https://www.ae.com/us/en");
        driver.navigate().refresh();
    }

    @Test
    public void searchProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.navigate().refresh();

        // Esperar a que el botón de búsqueda esté listo y hacer clic
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='search-cta']")));
        searchButton.click();

        // Esperar a que el campo de búsqueda sea visible y clickeable
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[contains(@class, 'form-control')]")));
        searchInput.sendKeys("Jacket");
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

    }


    @AfterAll
    public static void tearDown() {
        WebDriverFactory.end(); // Cierra el navegador después de cada test
    }

}
