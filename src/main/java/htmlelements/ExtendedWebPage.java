package htmlelements;

import annotations.IsAtPageMethod;
import io.qameta.htmlelements.WebPage;
import org.hamcrest.Matcher;

/**
 * HtmlElements is not supported for later Selenium versions after 3.10.0, 
 * this is a wrapper class to avoid issues.
 * It can be also used for extending or overriding WebPage behavior
 */
public interface ExtendedWebPage {

    @IsAtPageMethod
    void isAtPage(Matcher<String> url);


    default void isAt(Matcher<String> url) {
        isAtPage(url);
    }

}
