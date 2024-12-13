# Implement JBehave test suites management functionality

In assignment 12 you have implemented test suite management functionality in core JUnit technology using configuration tag in maven surefire plugin - value of includes tag was parameterized so that exact suites file can be managed through run configuration parameter.

We need to implement same functionality now that we have additional JBehave layer.

For running JBehave tests using maven run commands we are using `<artifactId>jbehave-maven-plugin</artifactId>` plugin, notice that `<include>\*\*/JBehaveStoriesRunner.java</include>` tag inside this plugin from assignment 16 specifies path to our runner which runs stories as paths defined in JBehaveStoriesRunner.java class.

If we want to extend this functionality with creating new Suites classes that will have their own class paths of relevant stories we want to run for specific test suite we need to do the following:

* Create JBehaveStoriesRunner.java to be abstract class

* Write abstract methods in JBehaveStoriesRunner.java abstract class:

  * `protected abstract List<String> includeStories()`
  * `protected abstract List<String> excludeStories()`

* Create new method `protected List<String> storiesForRunning(List<String> includeStories, List<String> excludeStories)`

That will manage lists in includeStories and excludeStories to return final list of stories we want to run

* Reimplement `storyPaths()` method from assignment 16 so it will use method from step 3 to actually list all desired stories

NOTE: Step 3 can be optional, you can perform paths management directly in storyPaths() method.

* Implement SmokeSuite.java and other suites you have used in assignment 12

These suites classes should extend JBehaveStoriesRunner.java abstract class and implement abstract methods so they will include proper sets of stories for related suite.

Same as we did in assignment 12, refactor `<artifactId>jbehave-maven-plugin</artifactId>`, `<include>\*\*/JBehaveStoriesRunner.java</include>` so it will be configurable from command line.

Test your implementation.
