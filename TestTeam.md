# Introduction #

Will be listing our tasks and now as well as our future plans and Milestone tasks completion based on TestPlan

# Milestone 5 #
> ## Estimates ##
| Task | Estimated Time (hours) |
|:-----|:-----------------------|
| User Evaluation | 15                     |
| Test Suite Update | 10                     |
| Mock Try Again | 10                     |
| Stress | 10                     |

> ### User Evaluation ###
> > The user evaluations were a great success. They are posted on the Wiki by name of UserEvaluationResults, as well a series of graphs showing these results in UserEvaluationGraphs. It has shown that most testers (whether experienced or not) enjoyed the game and averaged an overall rating of about 8.


> ### TestSuite ###
> > It is update as much as possible considering the time and effort.

> ### GUI testing ###
We completed our GUI tests for the current state of Luminance in this milestone. Our GUI tests entail six different test cases though our stress testing was not finished. We had many challenges in using robotium to send click events to the emulator.

  * Since Luminance doesn't use android.widget none of the buttons will be detected by robotium
  * These GUI tests depend on what machine you are running, the emulator may not be responsive if the system is less than i5 M460 2.53Ghz, 3Gigs of memory. Even when running multiple times depending on system resources the emulator could be non responsive and miss one touch input, that would cause the tests to fail.
A usercase test may fail after running many tests the emulator becomes unresponsive.

We also have created tests to play through the first 12 levels of the game.

> ### Mock ###
> > So, the frameworks such as Mockito, jMock, and all the rest were tried and we couldn't get them working. Now, the reason is known. So first, what we did differently was making our own mock objects. These are stored in the testsuite under the mock package. Most of the objects use the interfaces within the main code so that we can use and change whatever methods necessary. That was good. It was tested and seemed to work. The downside to this is that when these objects were needed, the code written to accept these as parameters held and used many different classes within the game. So with this coupling and having then to try and mock those within those classes... It was just a nightmare. For example. If say, class A has a method called setGraph(class B instance). we would pass in a mock of B so that it would at least accept it. The problem is that setGraph itself uses instances of C which is not mockable. ie, the Engine or something to that extent. So the short of it, it has been used when its actually necessary but not as much as we had hoped. The cost of this far outweighs the benefits.


> ### Stress ###
> > Not much can say except for the change in phones. Which couldn't really be changed as we needed what was offered. Beggers can't be choosers.


# End Milestone 5 #

# Milestone 4 #

> ## Estimates ##
| Task | Estimated Time (hours) |
|:-----|:-----------------------|
| Touch up unit testing | 6                      |
| Touch up smoke test | 6                      |
| Touch up mock test | 12                     |
| User play test | 15                     |
| Use-Case Scenarios test | 15                     |
| State test | 12                     |
| Triage | 5                      |

> ## Tasks ##
| Name | Status | TimeSpent |
|:-----|:-------|:----------|
| Touch up unit testing | Done   | 6         |
| Touch up smoke test | Done   | 4         |
| Touch up mock test | Various Errors | 13        |
| User play test | Could not complete | N/A       |
| Trace View/Stress | Done   | 9         |
| Use-Case Scenario | Could not complete | N/A       |
| State test | Could not complete | N/A       |
| GUI test | not completed(partial)| 8         |

> ### Code Coverage ###

> Emma is not implemented within Android nor Eclipse IDE for Android use and many hours were wasted in trying to make it work. Chet spent a long time on this, only to get it working inside the eclipse IDE and what resulted was that there was 0% on code coverage to the source code with a 5% coverage to the junit.jar. We then realize that it might have only used the junit.jar for its methods and thus only tracked it. We never determined why it wouldn't work on the emulator because there is not much documentation on this issue, and we have no experience with using coverage testing on android applications.

> Ultimately, we determined that Emma was only capable of running JUnit tests, not Android JUnit tests. It was never invoking the Android emulator and thus never ran any of the Android-specific code. At this point, using the Emma plugin for Android development is not an option because it simply does not have support for it yet.

> We then discovered Android build-in coverage.  After implementing this, we then ran into issues with filepaths and linking, which takes a long time to debug. We then discovered the libs folder inside the tested project needed the necessary .jars that the test project used. The coverage test then worked and a generated a result file that was placed under the LuminanceTestSuite/coverage path.

> ### GUI Testing ###

> For milestone 4, GUI testing was partially put into place.  Since new development in game structure and changes in the GUI prompted new GUI tests and also made old ones obsolete. Also all but one test case had to be re-written to fit the new levels. Due to time limitation by testers,  mistaken due date by the tester(Amara) who was writing all the test cases into GUI tests, underestimation of the complexity of GUI testing the GUI tests were only partially completed.

> ### Smoke Test ###

> The smoke test script folder is now inside the LuminanceTestSuite package. It now invokes essential packages of the test suite to be run as a smoke test. This is changed because Coverage is needed to be run on the command line and so issues ensued and the best possible solution was just to modify the antscript to run the packages. This brought up the same issues as was in coverage but not new enough that it couldn't be handled within a timely manner.

> ### Monkey Runner ###

> Using monkey runner on the emulator and phone will inject it with psuedo-random events. This will give us an indication that the game at least will not crash on the phone based on such random events.

> This is used as a random stress test on the phone. There is an output file 'stress.log' which showed the intent injected upon the device. It is very useful as it shows what the game can currently handle. A brief overview is that out of 50000 random injections, the game has crashed at around 30000. This could simply mean that some memory clean-up isn't handled well or the hardware couldn't handle the game for a period of time.

> Although this gave us some information of pseudo-random-input at the extended period, it still didn't exactly give us a definite Stress test upon the application. But still, nonetheless, provided some insight as to what other methods need to be looked at.

> The stress.log file is located inside the TestSuite folder in the Luminance project in the repository.

> ### Mock Testing ###

> At first, we tried to use AndroidMock.  When that didn't work, we attempted Mockito.  That was also unsuccessful. PowerMock was also tried and failed.  Further attempts will be made in the last milestone.

> ### Trace View ###

> This, in some ways helped us, and others, gave headaches. It provided the profiled usage on the application under test. Which has many attributes such as usage, calls/time and whatnot. But these results were at a basic level which could not really be parsed unless you specifically knew what to look for.

> After some time with the raw data and the dumped data (human readable data), it became apparent that parsing this into a graph turned out to be quite a predicament. Meaning, no graphical result.

> Although there weren't any graphs to display the results, the traceview provided by Android gave us a good estimation on the usage of our Application. Given the dumped data and screen caps inside the now TestSuite/traceData folder; data shows that the main usage of memory and CPU usage were mainly used on the Initialization and Content Loading of the application. This happened on the loading of the game and smaller on the transition between levels. So those were the only noticeable slowdowns both on the data and playing of the game. In other words, the playing of the game and data shown from the trace view both show results of a very good implementation of the game.

> Note: dmtracedump took way too long to give a proper graphical tree. Ran for 30+ min and laptop's fan was screaming all that time. CPU usage was 95%+ too. So Couldn't use that.

# End Milestone 4 #

# Milestone 3 #
> ## Tasks ##
|Priority| Name | Status | TimeSpent |
|:-------|:-----|:-------|:----------|
| high   |Unit Test suite | Done   | 14        |
| high   |Code Coverage test(Emma)| Done   | 4         |
| high   | Code reviews (test codes) | Done   | .5        |
| high   | Code reviews (source) | Done   | .5        |
| medium | Restructure test suite for Test cases | Done   | .5        |
| medium | Robust smoke test | Half   | 1         |
| medium | Mock testing | Half   | 9         |
| medium | State Mock testing(Game Logic) | Half   | 2         |
| medium | Finish Triage | Done   | 2         |
| low    | Monkey Runner | Done   |3          |
|Total   |      |        | 36.5      |

> ### Code Coverage ###

> Emma is not implemented within Android nor Eclipse IDE for Android use and many hours were wasted in trying to make it work. Chet had spent hours only to get it working inside the eclipse IDE and what resulted was that there was 0% on code coverage to the source code with a 5% coverage to the junit.jar. Which made not much sense. Later it was debated that it might've only used the junit.jar for its methods and thus tracked it. And on why it wouldn't work on the emulator was that not much documentation was found for it and very hard to implement.

> Ultimately, we determined that Emma was only capable of running JUnit tests, not Android JUnit tests. It was never invoking the Android emulator and thus never ran any of the Android-specific code. At this point, using the Emma plugin for Android development is not an option because they simply do not have support for it yet.

> What was later used is the Android build-in coverage. This made things much easier! Not really. What ensued were earlier errors back when implementation of the smoke test was in place. Essentially, filepaths, linking and all that fun stuff. After a many hours, a solution came about. The libs folder inside the tested project needed the necessary .jars that the test project used. Lo and behold, the coverage worked and a generated resultant was placed under the LuminanceTestSuite/coverage path.

> Issues on that is that the Vector3f methods used inside the plane and ray test classes were needed to be commented out and is in need of refactoring to make those tests work again in coherence with the code coverage.

> ### GUI Testing ###

> For milestone 3 we weren't able to progress as much in test case based GUI testing as we had planned to in milestone 2. Essentially we have the same GUI test as we had for milestone 2 due to the longer than expected development cycle for the GUI. Currently the GUI state that warrants testing is handled partly by our previous GUI test. Since we have made great progress at the very end of our deliverable, we are making GUI testing top priority for milestone 4.

> ### Smoke Test ###

> The smoke test script folder is now inside the LuminanceTestSuite package. It now invokes essential packages of the testsuite to be run as a smoke test. This is changed because Coverage is needed to be run on the commandline (fun...) and so issues ensued and the best possible solution was just to modify the antscript to run the packages.

> ### Monkey Runner ###

> Using monkey runner on the emulator and phone will inject it with psuedo random events. This will give us an indication that the game at least will not crash on the phone based on such random events.

> This is used as a random stress test on the phone. There is an output file 'stress.log' which showed the intent injected upon the device. It is very useful as it shows what the game can currently handle. A brief overview is that out of 50000 randome injections, the game has crashed at around 30000. This could simply mean that some memory clean-up isn't handled well or the hardware couldn't handle the game for a period of time. Further testing needed.

> The stress.log file is located inside the LuminanceTestSuite.

> ### Mock Testing ###

> AndroidMock - It was tried and could not get to work. Now using Mockito

# End Milestone 3 #


# Milestone 2 #
## Version Control Strategy ##

> The reason LuminanceTestSuite and LuminanceSmokeTest are in two different parts of the svn are as follows:
    * LuminanceTestSuite must be in the same as the main project so that it may be invoked on the eclipse IDE
    * LuminanceSmokeTest is not part of the Main project and, therefore, serves no purpose to be in the same directory and has no need to be invoked by the Eclipse IDE. The Ant script, IDE, Android SDK all trying to change files/links within the SmokeTest and TestSuite somehow affect their paths and was one of the major blockages that held back the implementation of a Smoke Test. This is so that both the SmokeTest and TestSuite are as separate as possible. It will be more work to add core tests from the TestSuite but it will also ensure a clear seperation of what basic testing is compared to a full fledged test suite. Ant and ADB from the android can invoke certain packages, classes, or even methods from the test suite and an ant script is possible to be made that invoke what are supposed to be in a smoke test. But this can give cause to reading a text of an ant script rather than to the possibilites of a nice GUI representation of a SmokeTest, of which, the GUI will be a nice representation of the test as a whole. Also, much better management, even with more work and space consumption. -- Sorry for the rant --

  * Precommit hook is run by ant script on TeamCity server

> #### Notes ####
    * Two members have gone from the team. Chet has agreed to testing. Its now Jeff, Amara, and Chet
    * Jeff is focusing on Smoke Tests, JUnit
    * Amara is focusing on Robotium, Use-case scenarios, User Scenario Play Test
    * Chet is focusing on JUnit
    * Guide on how to get/use LuminanceTestSuite and LuminanceSmokeTest are up on the environment set-up guide

> #### Tasks Completed ####
    * Smoke test ( Three Thumbs Up!)
    * Plan of User-Scenario Test
    * Use-Case Scenarios
    * Template Ready for Use-case scenario to GUI test
    * Start on JUnit Tests
    * Talk with Dr Kevin Stanley
    * Co-operation with Dev established

> #### Tasks Uncompleted ####
    * Tests not all implemented

> #### Estimated Time ####
> > 40 hours

> #### Actual Time ####
> > 60 hours (grabbed from member times as of February 18, 2011)


> ##### Comments #####
> > Although the tests are not fully implemented, I believe with Amara's scenarios and research into Robotium will help greatly in the coming Milestone 3. Also, with the main smoke test not running, resources (Me and Chet) can fully get into implementing the full suite of tests and will now be maintenance. The estimated time might've been actual if not for the fact of over-estimating the learning curve and integration of the new technologies. As of this Milestone (2); the test team is a little behind in the tests but I believe it shouldn't take more than a day or two of work to get a good coverage of tests, relative to the dev team's work, implemented.

# End Milestone 2 #

## Meeting Times ##
  * Monday, February 28, 2011 at Spinks 371
  * Friday, February 18, 2011 at Spinks 342
  * Wednesday, February 16, 2011 at Spinks 342
  * Monday, February 14, 2011 at Spinks 371
  * Friday, February 11, 2011 at Spinks 341
  * Monday, February 7, 2011 at Spinks 360
  * Friday, February 4, 2011 at Spinks 371
  * Monday, January 31, 2011 at Spinks 371
  * Friday, January 27, 2011 at spinks 342

# Test Team: #

Tasks:

February 16, 2011
  * Chet
    1. Test on ResourceManagement package
  * Amara
    1. Use-Case Scenarios
    1. User Scenario Testing plan
  * Jeff
    1. Ant Script
    1. Smoke Test
  * ALL
    1. Peer/Code review the packages under test.

February 1, 2011

> Since game testing is substantially different from any other software testing, decide between conventional testing vs user hands on testing. Inquire experienced persons(Prof. Stanley, Prof. Osgood) on the best approach to testing game mechanics. Implement ant script on local machine.

  * Ant Script Tutorial: http://ant.apache.org/manual/tutorial-HelloWorldWithAnt.html
  * Developing in other IDEs: http://developer.android.com/guide/developing/other-ide.html
  * Testing in other IDEs: http://developer.android.com/guide/developing/testing/testing_otheride.html

January 28, 2011
> Because the build server does not have Eclipse and teamcity uses ant scripts/builds, I believe these can help us understand how to make an automated smoke test and later, a fully automatic test suite.

  * Ant Script Tutorial: http://ant.apache.org/manual/tutorial-HelloWorldWithAnt.html
  * Developing in other IDEs: http://developer.android.com/guide/developing/other-ide.html
  * Testing in other IDEs: http://developer.android.com/guide/developing/testing/testing_otheride.html


January 27, 2011

> Research testing suites
    * Robotium - UI testing
    * JUnit - Core, smoke test
    * Anything else that you guys might think will be necessary

> If possible, any concept or example of such tests being run (Does not have to use the Luminance
> package) is good.

> Something else to look at is, instead of running eclipse's automatic builds, try and get either ant
> scripting up or command-line build/runs.

> Good site: http://developer.android.com/index.html

January 24, 2011

> Download eclipse
> Code Coverage: http://update.eclemma.org

> Make a Concept smoke test
> Due: by the end of the week or next meeting.

> Create ant script for smoke test,
    * Make it so that it builds a project
    * Upon rejection, don't commit/error
    * Else, run some unit testing/smoke test

> Learn how team city works

> Eclipse Testing with TeamCity http://www.jetbrains.com/teamcity/features/continuous_integration.html#Remote_Build_Run_and_Pre-Tested_Commit

# Triage: #

Tasks:
February 16, 2011
> Regulate issues

January 24, 2011
> Format issue report form
> Accept and assign issues - Continuous

# Links #

Emma

http://groups.google.com/group/android-platform/browse_thread/thread/b5219988c5374369

Android built-in coverage

http://blog.rabidgremlin.com/2010/11/19/android-tips-generating-a-coverage-report-for-your-unit-tests/


# Common Errors #

  * Test run failed: org.junit.Test
    1. First: If there are any annotations with "@Tests"  it screws up the whole testsuite. Get rid of them.
    1. run the android update test-project and android update project command-line functions
    1. Make the manuel installs using ant install inside both the Luminance and LuminanceTestSuite packages
    1. Then try and run the test from the eclipse IDE

  * Getting files/resources during a test
    1. The function this.getContext().getAssets() grabs the items inside the Lumiance package's asset's folder and not the one inside LuminanceTestSuite.

# Testing Matrix #

| | TC#1 | TC#2 | TC#3 |
|:|:-----|:-----|:-----|
| Features |
| #1 | X    |      |      |
| #2 |      | X    | X    |
| Others |
| #1 |      |      | X    |
| #2 |      |      | X    |