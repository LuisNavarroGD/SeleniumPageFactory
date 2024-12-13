# Integrate owner.aeonbits.org dependency and see maven checkstyle plugin

Take a look at [Owner](http://owner.aeonbits.org/) documentation on how to create first Configuration classes.

* For our purposes create two .properties files - put them in resources folder: environment.properties - with one parameter (Follow Java way of naming - e.g. homepage.url) that contains url of www.ae.com, runConfiguration.properties - put parameters - browser.name , browser.width , browser.height, selenium.version

* Implement two classes according to documentation provided above for managing these two properties files.

* Create Configuration class that will have function of providing configuration objects from steps above in convenient way - you will use org.aeonbits.owner.ConfigFactory class inside.

* Test your implementation by creating temporary main class where you will print out values from properties files in console.

In project that is provided to you maven checkstyle plugin is implemented. It is there to force code conventions to this project.
See file checkstyle.xml - There rules are written. So when you build your project using any mvn command - e.g. mvn clean install or mvn test it will check rules from checkstyle.xml in your code and if any of these is corrupted your build will fail with message describing in which file or files which rule is corrupted.

You need to follow next rules:

* Redundant imports are not allowed
* Unused imports are not allowed
* One whitespace character needs to be present after , or ;
* Exactly one empty line needs to be present between two method definitions inside class
* Between variable declarations it is ok not to leave empty line
