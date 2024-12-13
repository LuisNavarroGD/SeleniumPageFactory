# Internship UI Automation Framework

## What is testing framework

Testing Framework is a layer of abstraction that wraps in convenient user friendly way various libraries - dependencies to provide convenient way of implementing and maintaining test cases.

Web UI Testing framework needs to have:

1. Abstraction - architecture - Page object model - see [Page Object Model (POM) & Page Factory in Selenium Tutorial](https://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html), Driver provider classes and so on ...
2. Configurability - ability to run various tests with various setups from command line (important for running tests in a CI tool)
3. Logging mechanism - convenient way of writing in console and log files what actually took place during test execution
4. Reporting mechanism - way of representing test run results to the user
5. Utilities - e.g. test data providers (from e.g. .json files), various integrations with 3rd party systems - like Jira, Allure, ...
6. Test framework (Engine for running and managing tests) - e.g. JUnit (You have already used this framework for unit tests) or TestNG
7. BDD (Behavior driver layer) optional - JBehave (Comes with JUnit) - Ability to write tests in Gherkin language syntax which is in plain text - see [JBehave Tutorials](https://jbehave.org/reference/stable/tutorials.html)
8. Ability to interact with application under test - in our case Browser - Selenium is used

In this set of exercises you will get various tasks that will help you build UI testing framework from scratch using various dependencies.

Tasks are described in the `tasks` folder. You will take them one by one.

Branching strategy is the same as we did in our first intro exercises - feature branching.

## Running tests

1. ***Maven clean test*** command in terminal
    - Test parameters can be found and changed in the properties tag at the top of **pom.xml** file
    - Only chrome and firefox browsers can be used in tests
    - Only classes whose name ends with **Suite** can be tested with this method; class name must be defined in *runSuite* property (e.g. **/TestSuite.class)

   **warning** : this command works only if `maven --version` shows java version as 1.8 or similar. If it's something like 13 or 15 then some methods will fail to run and all tests will fail.

2. ***Maven configuration*** in IDE
    1. Create a maven configuration with self-explanatory name
    2. Put `-e clean test` in command line of the maven configuration; this will run test with default values from **pom.xml** file

    - If you want to change certain properties, add `-DpropertyName=propertyValue` in command line, based on which property you want to change
    - Example of command line: `-e clean test -Dbrowser.name=Chrome -DrunSuite=**/CreateAccountTestsSuite.class`

**Notes**:

- If you want to test specific classes in your Suite class, add them in @SelectClasses annotation parameter
- LoginTest and SearchTest use specific test parameters so changing them may cause tests to fail.
- CreateAccountAndLoginTest covers only positive test case and its parameters can be changed freely. 
- CreateAccountTest reads its parameters from **accounts.json** file found in resources folder. First test uses specific parameter values, while the second one creates a random email based on a domain found in JSON file.

## Technologies used

1. Selenium for browser connection and interactions

2. Architecture:

   - WebDriverFactory - Convenient class that wraps Selenium (see https://www.selenium.dev/documentation/en/introduction/on_test_automation/) WebDriver and provides it to steps and pages 

   - WebDriverManager - io.github.bonigarcia for dynamical fetching of WebDriver .exe files (see https://github.com/bonigarcia/webdrivermanager)

   - PageObjectModel - Dependency that enables us to define our test pages, components, modals from application under test as interfaces and much more - io.qameta.htmlelements 

   - TestStep classes - Every test step is defined in separate test step class 

   - BDD, JBehave - see https://objectcomputing.com/resources/publications/sett/may-2015-behavioral-driven-design-bdd-with-jbehave

3. Configurability - org.aeonbits.owner - see http://owner.aeonbits.org/docs/welcome/

4. Logging - log4j - see https://logging.apache.org/log4j/2.x/

5. Assertions - from JUnit and org.assertj - see https://assertj.github.io/doc/

6. Reporting - JBehave native reporter - Optional implement allure reporting
