# Running JUnit tests

You can run tests from an IDE (e.g. IntelliJ IDEA), which is convenient durint test development
and debugging or from command line, which is important for running tests in a CI tool.

## Run tests from IntelliJ IDEA

You can click play icon next to any test method in Test class - then JUnit run configuration is automatically created by IDE and test is executed (Run configurations can be found in small drop down menu next to play icon on upper right part of IDEA)

## Run tests from command line

You can run all your tests by using `mvn test` line from console.

You can run only one test class using `mvn clean test -Dtest=TestClassName.class`.

Other convenient way of running tests is organizing them in test suites. One test suite represents set of test cases that test one logical unit - e.g. we can split them per functionalities, per priority and so on...

## Run tests using maven surefire plugin

This plugin is already present in pom.xml file, it is convenient plugin for running tests during building project. Read about it - https://maven.apache.org/surefire-archives/surefire-3.0.0-M2/maven-surefire-plugin/index.html.

Inside surefire plugin we can manage out test suite execution:

```xml
<configuration>
<includes>
<include>${runSuite}</include>
</includes>
</configuration>
```

`runSuite` variable is part of project properties - see properties tag inside pom.xml file. This variable should contain path to your test suite class.

Create test suite class:

In path test.java create SmokeSuite.class and include login only Test classes inside it - see documentation on how to do it: https://www.tutorialspoint.com/junit/junit_suite_test.htm - Section Create Test Suite Class.

Now put your SmokeSuite.class in runSuite variable in pom.xml.

Test your implementation by typing in command line:

`mvn clean test` - It should run only test classes that are present in SmokeSuite.class file.
