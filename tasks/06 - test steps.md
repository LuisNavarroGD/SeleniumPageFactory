# Create test steps

One of important things to keep in mind when creating automated tests and developing testing frameworks is to keep modeled pages of application under test and test steps separate - to increase code scalability maintainability and readability.

So every set of steps step you will create you will put in corresponding test step class - since here we will take actions only on homepage and performing search, you should first create OpenPageSteps.class - Steps related to opening pages, HomePageSteps.class - Steps related to homepage actions, SearchSteps.class - Steps related to search functionality - on site sidebar, SearchResultsPageSteps.class - Steps that take place on page where search results are displayed, put it in: main.java.steps package.

To make our final tests more readable we will use simplified "builder" pattern - every public method of steps class will return this (Instance of this class) - therefore we will be able to "chain" step calls in our tests - It will be more clear soon.

In OpenPageSteps.class implementation will look something like this:

```java
private static MyPageFactory pageFactory = MyPageFactoryProvider.getInstance();

private HomePage homePage() { return pageFactory.on(HomePage.class); } // use .on method of MyPageFactoryProvider

public HomePageSteps openHomepage() {
    homePage().open(/* Use homepage value from .properties file */);
    return new HomePageSteps(); // since homepage is opened after opening page, openHomepage() will give you access to HomePageSteps }
```

In HomePageSteps.class you should have:

```java
private static MyPageFactory pageFactory = MyPageFactoryProvider.getInstance();

private HomePage homePage() { return pageFactory.on(HomePage.class); }

public HomePageSteps acceptPrivacyModal() {
    homePage().acceptPrivacyButton().waitUntil(displayed()).click()
    return this;
}
```

So `acceptPrivacyModal()` step waits for acceptPrivacyButton to be displayed and clicks it - first thing you need to do when homepage is opened - such convenient way of writing your steps is coming from html elements dependency.

Following pattern from above implement `clickSearchButton()` step - Note when you click search button you should perform actions on search.

In SearchSteps.class implement methods:

* `inputSearchTerm(String term)` - HINT: Use sendKeys method from html elements.
* `clickSearchIcon()`

When you have performed search using product ID you are presented with search results page. Here you need to verify that only one product is present - use JUnit assertions you have already encountered them in Unit testing part. Step method should have signature:

`public SearchSteps verifyNumberOfProductIsDisplayed(int numProducts);`
