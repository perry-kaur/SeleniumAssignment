- Added BasePage file and its subclasses to handle actions in relevant child classes
- Search.feature contains test scenarios with parameters url, product and topic.
- Added TestRunner class which is annotaed with @RunWith which tells JUnit which is the test runner class. 
- Test runner class has @CucumberOptions which tells where to look for .feature file and step definition file.
- .feature file has scenarios which have corresponding steps. Steps map to java functions which do specific funtion.

-- Running test cases was easier from IDE but setting up to run from command line using maven took some time.

Maven commands:

mvn clean test - Runs all tests
mvn clean test -Dbrowser=chrome ( or mvn clean test -Dbrowser=firefox)
