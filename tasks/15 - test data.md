# Implementing data provider and using test data

One final thing we need to do is to make convenient way of using test data in our tests.

For our purpose we will store our test data as .json files in resources folder.

In create account tests we have a lot of hardcoded values that we input into create account form, our goal is to put them all in .json file and serialize them using gson.

You can reuse DataProvider class from JSON Manipulation task that uses gson to serialize json into map of objects.

Create Account.class data transfer object as you did in JSON Manipulation task Create accounts.json file in resources folder and fill it with several objects with all relevant fields that are used for creating new account.

Since all your test classes extend BaseTest class most convenient way to initialize data provider is in this class - since all tests have access to this class protected methods.

So far we used before test and after test annotations in BaseTest, it will be more efficient to initialize data provider only once at the beginning of test run - not before every separate test - find proper JUnit annotation and implement it.

Google a little bit about using test data in Junit tests and refactor create account test to use form input data from DataProvider.
