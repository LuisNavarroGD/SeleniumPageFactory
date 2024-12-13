# Login tests

Following pattern from before, automate several more tests in LoginTest.java class in java.test:

For debugging purposes run each test independently.

## Negative test

Test: Empty email and password input

* Open homepage and close accept privacy settings modal
* Click on account icon in ae.com header
* Wait for account side tray to open
* On account side tray click sign in button
* When email and password input fields are displayed, leave them empty and click sign in button
* Verify proper error messages are displayed (Use JUnit assertions)

Figure out some more relevant negative scenarios and automate them.

## Positive test

Test: Valid email and password input

Prerequisite: Create manually one account and remember username and password

* Open homepage and close accept privacy settings modal
* Click on account icon in ae.com header
* Wait for account side tray to open
* On account side tray click sign in button
* When email and password input fields are displayed, enter valid credentials and click sign in button
* Verify that user is logged in - e.g. Sign out button is now displayed and user's name is displayed on top of account side tray (Use JUnit assertions)

You will need to add several more page objects with their elements. Add in this test class before and after methods with appropriate annotations for opening and closing browser before and after each test.
