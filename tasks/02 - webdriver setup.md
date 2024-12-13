# Create WebDriverFactory.class implementation

Purpose of this class is to provide convenient methods for configurable WebDriver initialization.

* Create this class in new package called selenium in main.java folder
* Public Methods to be exposed:
  * `initialize()`
  * `end()`
  * `get()`

## Create Browser enum class in main.java.enums package - So far we will cover Chrome and Firefox

**`initialize()`** - Will initialize WebDriver instance according to browser (browser.name) that is set in runConfiguration.properties file. Probably it will have switch state according to chosen browser. Create two private methods that return WebDriver object - createChromeDriver() and createFirefoxDriver(). Inside these two methods you will instantiate for the beginning corresponding instances of ChromeDriver and FirefoxDriver.

NOTE: Here you will use **bonigarcia** dependency

If selenium version is stated run config file use this:

`ChromeDriverManager.chromedriver().version(Version from runConfiguration.properties file - selenium.version).setup();`

If selenium version is not stated run config file use this - latest selenium:

`ChromeDriverManager.chromedriver().setup();`

Also use values from runConfiguration.properties file browser.width and browser.height to open browser with given size.

Lines above are actually downloading .exe files for Selenium drivers dynamically.

**`end()`** - Will quit current instance of WebDriver - close browser

**`get()`** - Will simply return instance of WebDriver that is stored as private class variable.

NOTE: Add for now System.out.println("") lines of code on places where something crucial happens - e.g. driver successfully initialized (We will replace all of these with proper logging system later), put `//TODO: Change with log4j logger` comment.

Test your implementation in temporary main class: initialize() should open Chrome or Firefox browser according to values in properties file mentioned with browser size from file also.
