package htmlelements;

import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public interface HomePage extends ExtendedWebPage {

    @Description("Accept Cookies")
    @FindBy("//button[@id='onetrust-accept-btn-handler']")
    HomePage acceptCookies();

    @Description("Username Account")
    @FindBy("//a[@class ='clickable qa-show-sidetray-account sidetray-account']")
    HomePage username();
}
