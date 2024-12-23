package htmlelements;

/*
 *  Here WebElement methods can be overridden or extended using htmlelements annotations.
 *
 */

import org.openqa.selenium.WebElement;


public class MyWebElement  {

    private WebElement element;

    public MyWebElement(WebElement element) {
        this.element = element;
    }

    public void clickWithMessage() {
        System.out.println("Haz hecho click en este elemento");
        element.click();
    }

    public void clearAndType() {
        element.clear();
        element.sendKeys("Este es un texto de prueba para escribir en este campo");
    }

    public boolean isDisplayedWithMessage() {
        System.out.println("El elemento esta visible");
        element.isDisplayed();
        return true;
    }

    public void submitWithMessage() {
        System.out.println("Haz enviado el formulario");
        element.submit();
    }

    public void typeWithMessage(String text) {
        System.out.println("Haz escrito el texto: " + text);
        element.sendKeys(text);
    }

}