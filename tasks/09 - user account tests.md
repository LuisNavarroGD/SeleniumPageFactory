# Create user account tests

Create new CreateAccountTest.class file in test.java and implement test:

Create valid account:

* Open homepage
* Accept privacy setting if displayed
* Click on account icon on header
* Click create account
* Enter valid credentials
* Verify user is created - user is logged in and user name is displayed on account sidebar

You will need to add several more page objects with their elements.

NOTE 1: For step 5 you need to generate unique email for each scenario. Create RandomUtils.class in project path src.main.java.utils and there implement static method `String generateRandomEmail(String domain)`, where domain will be domain that comes after @ character.

NOTE 2: Use hardcoded values in steps that fill input fields.

NOTE 3: Implement in this class also before and after steps for opening and closing browser.
