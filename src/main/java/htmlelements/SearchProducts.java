package htmlelements;

import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public interface SearchProducts extends ExtendedWebPage {

    @Description("Search Button")
    @FindBy("//button[@data-test-btn='search-cta']")
    SearchProducts searchButton();

    @Description("Search Input")
    @FindBy("//input[contains(@id,'ember')]")
    SearchProducts searchInput();

    @Description("Search Result")
    @FindBy("//img[@data-test='product-image']")
    List<WebElement> productItems();

    default List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        for (WebElement productItem : productItems()) {
            String productName = productItem.findElement(
                    By.xpath("//div[contains(@class,'product-sale-price')]")).getText();
            String productPrice = productItem.findElement(
                    By.xpath("//h3[contains(@class,'product-name')]")).getText();

            Product product = new Product(productName, productPrice);
            products.add(product);
        }
        return products;
    }

}
