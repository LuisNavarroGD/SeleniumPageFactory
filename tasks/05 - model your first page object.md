# Model your first page objects

For testing purposes we will use www.ae.com site. Create HomePage, SearchSidebar and SearchResultsPage interfaces in main.java.htmlelements.pages package.

For identifying elements on page under test we will use XPath - Read this [XPath Tutorial](https://www.w3schools.com/xml/xpath_intro.asp) and/or play [Dinner locator game](https://topswagcode.com/xpath/).

You should follow following pattern in your page interfaces:

* HomePage (And every new page you will create) should extend ExtendedWebPage

* Every element from this page should be defined in the following way, see concrete example:

```java
    @Description("Username input")
    @FindBy("//input[@type='email']")
    ExtendedMyWebElement usernameInput();
```

* Go to www.ae.com, when homepage is opened, extract xpath from privacy settings modal (first modal opened) and account icon on header menu following example from above - NOTE: Since privacy settings is UI modal, it would be great to create new interface PrivacySettingsModal and here map "Accept" button (It is first thing you need to do when you open homepage of ae.com - accept privacy settings)

* Now do the same for search header button and cart icon

* When you click search button, search sidebar will open, map search input field and search button in SearchSidebar

* Enter valid product ID in search field - use 0119_5091_851

* SearchResultsPage is opened, map returned product in related interface - Use List structure as element type - since on search results page there can be multiple products returned.
