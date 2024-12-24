package htmlelements;

import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import org.openqa.selenium.WebElement;

public interface HomePage extends ExtendedWebPage {

    @Description("Accept Cookies")
    @FindBy("//button[@id='onetrust-accept-btn-handler']")
    HomePage acceptCookies();

    @Description("Account Icon")
    @FindBy("//a[@class ='clickable qa-show-sidetray-account sidetray-account']")
    HomePage username();

    @Description("Close add")
    @FindBy("//button[contains(@id, 'close-inside')]")
    HomePage closeModal();

    @Description("Search Button")
    @FindBy("//button[@name='search-cta']")
    HomePage searchButton();

    @Description("Search Input")
    @FindBy("//input[contains(@class, 'form-control')]")
    HomePage searchInput();

    @Description("Product Name")
    @FindBy("//h3[contains(@class,'product-name')]")
    HomePage productName();

}
