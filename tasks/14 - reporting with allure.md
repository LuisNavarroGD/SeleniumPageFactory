# Reporting with Allure

When tests are executed we need convenient way for reviewing what are results - when we have thousands of tests having fancy test framework without good reporting is not very useful.

As now you are running tests using maven, maven surefire plugin generates xml file with results in `target/surefire-reports` folder. This xml file is not very useful for human to be analyzed it is not so readable as you can see.

We will use very good reporting tool called allure reporter that will use this xml file and represent it in very nice report.

See: http://allure.qatools.ru/.

Allure documentation is very good so use it for installing allure on your system (Use brew for this purpose since it is most convenient) and for generating first allure report after running some set of test.
