package htmlelements;

import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;

import java.util.List;

public interface HomePage extends ExtendedWebPage {

    @Description("Username Account")
    @FindBy("//a [@class ='clickable qa-show-sidetray-account sidetray-account']")
    ExtendedMyWebElement username();

    @Description("Search field")
    @FindBy("//input [@id = 'search']")
    ExtendedMyWebElement searchField();

}
