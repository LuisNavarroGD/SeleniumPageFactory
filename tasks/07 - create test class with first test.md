# Create test class with first test

Your tests should be present in test.java package. First test you will write is related to testing www.ae.com search functionality. Therefore name your test class: SearchTest.java

Here we will use JUnit testing framework which you already had opportunity to use in Unit testing part.

Basically here you will see advantages of using simplified "builder" pattern in implementing our test steps.

Your first test method implementation should look like this:

```java
new OpenPagesSteps()
    .openHomepage()
    .acceptPrivacyModal()
    .clickSearchButton()
    .inputSearchTerm("0119_5091_851")
    .clickSearchIcon()
    .verifyNumberOfProductIsDisplayed(1)
```

Use JUnit annotations to create your first test. Also notice that selenium web driver instance is getting passed to page objects in method `getDriver()` from MyPageFactory.class - Your TODO assignment asked you to use `WebDriverFactory.get()` method, it will return null to you because you have never actually called `initialize()` method. So other then using `@test` annotation in your test class you need to implement so called precondition and postcondition actions - see [@Before vs @BeforeClass vs @BeforeEach vs @BeforeAll](https://www.baeldung.com/junit-before-beforeclass-beforeeach-beforeall). What we want to achieve is that before every test we call WebDriverFactory `initialize()` method - that will open fresh session of browser and after every test we will call WebDriverFactory `end()` method - that will close browser window. Implement it.

Run this test using maven run command - `mvn test`
Make sure that test is stable.
