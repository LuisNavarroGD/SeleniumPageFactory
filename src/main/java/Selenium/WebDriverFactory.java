package Selenium;

import Browsers.EnumBrowsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverFactory {

    private static WebDriver driver;
    private static Properties properties;

    static {
        properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream("src/main/resources/runConfiguration.properties")){
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load runConfiguration.properties file", e);
        }
    }

    public static void initialize() {
        if (driver != null) {
            System.out.println("Webdriver initialized");
        }

        String browserName = properties.getProperty("browser.name").toUpperCase();
        EnumBrowsers.Browsers browser = EnumBrowsers.Browsers.valueOf(browserName);

        switch (browser) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        configureWindowSize(driver);
        ConfigureTimeouts(driver);

        System.out.println("WebDriver successfully initialized: " + browserName);
    }

    public static void end(){
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("WebDriver instance terminated.");
        }
    }

    public static WebDriver get(){
        if (driver == null){
            throw new IllegalStateException("WebDriver is not initialized. Call initialize() first.");
        }
        return driver;
    }

    private static void configureWindowSize(WebDriver driver){
        String width = properties.getProperty("browser.width");
        String height = properties.getProperty("browser.height");
        if (width != null && height != null){
            driver.manage().window().setSize(new org.openqa.selenium.Dimension(
                    Integer.parseInt(width), Integer.parseInt(height)
            ));
        } else {
            driver.manage().window().maximize();
        }
    }

    private static void ConfigureTimeouts(WebDriver driver){
        String timeout = properties.getProperty("browser.timeout");
        if (timeout != null){
            driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(Long.parseLong(timeout)));
        }
    }

}