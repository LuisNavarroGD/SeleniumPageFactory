# Creating maven run configurations

One of key features of testing framework (or any program) is ability to run it in convenient way through run configurations. So far we have implemented two ways of configuring our tests to run:

In first assignment you have implemented aeonbits configuration dependency that can enable you to run your tests in various browsers and with various browser window sizes as they are defined in .properties files.

In previous assignment you have seen properties tag option in pom.xml file where we define which set of test cases (Test suite) we want to execute.

Now it is time to put this ability to configure running our application (tests) to use.

For testing purposes first create several more Suites (following steps from previous assignment):

* LoginTestsSuite.class - That will have your login tests test class
* CreateAccountTestsSuite.class - That will have your create account test class

Now click on dropdown menu on upper right corner of IDEA next to play button and click edit configurations button. When popup is opened click on plus icon and choose Maven - It will create empty maven run configuration.

Name first configuration SmokeSuite_Chrome_DesktopSize In command line write:

`-e clean test -Dbrowser.name=chrome -Dbrowser.height=1800 -Dbrowser.width=1300 -DrunSuite=**/SmokeSuite.class`

NOTE: `-Dbrowser.name` value may vary depending how you named your browsers in enum from task 2

When you choose SmokeSuite_Chrome_DesktopSize from run config dropdown and click play your application should run all tests listed in SmokeSuite.class, in Chrome browser with browser size 1800 x 1300 pixels.

Following example from above create several more run configurations:

* SmokeSuite_Firefox_DesktopSize
* LoginSuite_Chrome_DesktopSize
* LoginSuite_Firefox_DesktopSize
* CreateAccountSuite_Chrome_DesktopSize
* CreateAccountSuite_Firefox_DesktopSize

Run each of them and make sure that they are working as expected.
