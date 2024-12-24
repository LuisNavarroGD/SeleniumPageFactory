package htmlelements.Factory;

import Selenium.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class MyPageFactory {

    private final WebDriverFactory webDriverFactory;
    private final Properties properties;

    private static MyPageFactory pageFactory = MyPageFactoryProvider.getInstance();

    public MyPageFactory() {
        this.webDriverFactory = new WebDriverFactory();
        this.properties = new Properties();
        loadProperties();
    }

    public <T> T on (Class<T> webpage){
        WebDriver driver = getDriver();
        return PageFactory.initElements(driver, webpage);
    }

    public WebDriver getDriver() {
        return webDriverFactory.get();
    }

    private void loadProperties() {
        try(FileInputStream fis = new FileInputStream("src/main/resources/runConfiguration.properties")) {
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

}