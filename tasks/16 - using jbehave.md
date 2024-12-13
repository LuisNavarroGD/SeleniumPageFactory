# Using JBehave

So far our tests used JUnit engine and chaining test steps to create test cases. We have also created way of filtering test suits and executing them using maven sure fire plugin through maven run configuration.

This approach is good but there are technologies that can help our test implementation and ways of filtering tests even more convenient.

One way is integrating BDD (Behavior driven development) framework, most popular are Cucumber and JBehave. These frameworks enable us to write tests in so called Gherkin syntax which is written in plain language and makes our test cases readable to non technical people.

Read about Gherkin syntax - https://enginiety.com/knowledge/behaviour-driven-development-in-automated-tests.

There are several steps you need to do in order to implement JBehave in your testing framework.

## Step 1: Install JBehave plugin in your IDEA

It will make .story files that contain test implementation visible to IDE - Go to file, settings, plugins, search for JBehave Syntax support version 1.62 (Version may vary depending on your IDEA version).

## Step 2: Create class JBehaveStoriesRunner in src.main.java.framework package - this class should extend JUnitStories abstract class

You need to implement/override following methods:

* `protected List storyPaths()` - In this method you will define path to your .story files using `StoryFinder().findPaths()`.

NOTE: You will put your story files in src.main.resources.stories folder.

* `public org.jbehave.core.configuration.Configuration configuration()` - Here you should make configurations to JBehave framework - you should return `MostUsefulConfiguration()` object cofigured with methods:

  * useStoryLoader()
  * useStoryReporterBuilder()

Google examples where this code is implemented and integrate into your code.

* `public InjectableStepsFactory stepsFactory()`

Here you should return `new InstanceStepsFactory()` that has as first parameter your `configuration()` method and all steps implemented using JBehave (You will rewrite your existing steps soon).

## Step 3: Rewrite existing steps to use JBehave annotations Given, When and Then

Example:

```java
@Given("I have an empty stack")
public void givenIHaveAnEmptyStack() { stack = new CustomStack(); }

@When("I push an item $item")
public void whenIPushAnItem(@named("item") String item) { stack.push(item); }

@Then("I should count $expected")
public void thenIShouldCount(@named("expected") int expected) {
    int actual = stack.count();

    if (actual != expected)
        throw new RuntimeException("expected:"+expected+";actual:"+actual);
}
```

Given is used when you want to perform some precondition operation - e.g. open homepage.

When is used when you want to perform actions on application under test in order to reach goal of your test.

Then is used for asserting some behavior - like you have been asserting username of logged in user.

## Step 4: Create new .story files in src.main.resources.stories folder

Follow JBehave story syntax - Something like https://jbehave.org/reference/stable/story-syntax.html Implement all tests you have in JUnit

## Step 5: Refactor Before and After JUnit annotations to JBehave compatible annotations

After you have completed with implementing steps and stories, update annotations you have used for opening and closing browser before and after every test to appropriate JBehave annotations - they are similar, take special attention to imports in related class.

## Step 6: Erase all JUnit related code that you no longer need, also erase maven surefire plugin from pom.xml file

## Step 7: For running JBehave stories we will use jbehave-maven-plugin that has same version as jbehave.core dependency in pom.xml

Just copy paste following:

```xml
<plugin>
    <groupId>org.jbehave</groupId>
    <artifactId>jbehave-maven-plugin</artifactId>
    <version>4.6.2</version>
    <executions>
        <execution>
            <id>run-stories-as-embeddables</id>
            <phase>test</phase>
            <configuration>
                <includes>
                    <include>**/JBehaveStoriesRunner.java</include>
                </includes>
                <ignoreFailureInStories>true</ignoreFailureInStories>
                <ignoreFailureInView>false</ignoreFailureInView>
            </configuration>
            <goals>
                <goal>run-stories-as-embeddables</goal>
            </goals>
        </execution>
    </executions>
    <dependencies>
        <dependency>
            <groupId>org.codehaus.groovy</groupId>
            <artifactId>groovy-all</artifactId>
            <version>2.4.15</version>
        </dependency>
    </dependencies>
</plugin>
```

Analyze this plugin xml code a little bit, try to understand what is happening there. org.codehaus.groovy dependency of this plugin is used for managing meta filters on story and scenario level using groovy script - we will cover that soon.

## Step 8: Implement meta filtering ability

Meta filters in JBehave can be added under scenario definition in story file or on the story level. Just write Meta: on desired place - lets use only scenario level for our example.

Implement in RunConfiguration file (From aeonbits.owner dependency) meta.filters with `metaFilters()` method parameter.

In JBehaveStoriesRunner, `storyPaths()` method write `configuredEmbedder().useMetaFilters(asList(runConfig.metaFilters().split(",")))`

`runConfig.metaFilters()` is property from RunConfiguration file.

This will enable you to use metafilters when executing your stories:

In maven run configuration add: "-Dmeta.filters=groovy: debug"

And add Meta: @debug under scenario you want to run, test your implementation now.

Groovy filters will enable you to use various boolean expressions when filtering your scenarios - e.g. if you have set of several scenarios with Meta: @debug annotation and several with Meta: @debug @Skip, with "-Dmeta.filters=groovy: debug && !skip" you will be able to run all scenarios that have debug meta and not skip meta.

## Step 9: Refactor storyPaths() method from step 2

So you can make story paths you want to run configurable also - Notice that you have used relative paths to stories, you can implement another property in RunConfiguration called stories.to.run and use it in generating this path dynamically.
