# Implement ScenarioContext class

In create account test you are creating new random email using generate random email utility class. Every time you call this method you will get new random email, therefore for creating e.g. test that creates new account with random email and then you want to use this email for logging in into this account you need to save this email address in order to reuse it in following steps of this long scenario.

This is simple example for data we need to share between scenario steps, usually when tests become complicated and long we want to share a lot of data between steps.

For this purpose we need ScenarioContext.class, it should have private class variable as HasMap<String, Object> type that will store values.

Implement this class in java.main package with following methods:

* Make constructor private, and create this class as singleton - `public ScenarioContext getInstance()` - Will return instance of context.

* Initialize empty class variable HashMap as static block.

* `public T get(String key, Class clazz)` - This method should return T type object from internal HashMap with key

* `public void put(String key, Object value)` - This method will save in internal HashMap context Object as key

* `public void remove(String key)` - Will remove key object in internal HashMap

* `public void removeAll()` - Will erase all data in internal HashMap - usually this will be called when test is completed.

Since context is used in one test run to share data between steps, you want to erase all data when test is completed and initialize context before first scenario is run - implement in appropriate before and after steps this functionality.

For testing purposes, create following scenario:

* Reuse steps for creating new account, put email in context (Put some other data in context if you think it is appropriate)
* Logout after account is created
* Log back in with data from step one - use data from context to login
* Verify user is logged in with proper account

HINT: When putting values in context e.g. email address, it would be good to create new class called ContextConstants that will have all needed key values you are putting in context (It is a good practice to have such approach because when a lot of people are working on same code it will reduce inconsistency and code redundancy)
